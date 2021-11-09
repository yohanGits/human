package com.rakki.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rakki.domain.BuyVo;
import com.rakki.domain.PriceListVo;
import com.rakki.service.SellBuyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("buy/*")
@AllArgsConstructor
public class BuyController {

	private SellBuyService service;		
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("select")
	//public PriceListVo select(Long product_no, Model model) {
	public void select(Long product_no, Model model) {
//		log.info("sell/select page product_no::" + product_no);
		PriceListVo priceListVo = service.getBuyPriceList(product_no);
		if (priceListVo.getCategory().equals("1")) {  // 1:스니커
			
			priceListVo.getCat1()[0][0] = "230"; priceListVo.getCat1()[0][1] = priceListVo.getP230() == null ? null : ""+priceListVo.getP230(); 
			priceListVo.getCat1()[1][0] = "235"; priceListVo.getCat1()[1][1] = priceListVo.getP235() == null ? null :""+priceListVo.getP235(); 
			priceListVo.getCat1()[2][0] = "240"; priceListVo.getCat1()[2][1] = priceListVo.getP240() == null ? null :""+priceListVo.getP240(); 
			priceListVo.getCat1()[3][0] = "245"; priceListVo.getCat1()[3][1] = priceListVo.getP245() == null ? null :""+priceListVo.getP245(); 
			priceListVo.getCat1()[4][0] = "250"; priceListVo.getCat1()[4][1] = priceListVo.getP250() == null ? null :""+priceListVo.getP250(); 
			priceListVo.getCat1()[5][0] = "255"; priceListVo.getCat1()[5][1] = priceListVo.getP255() == null ? null :""+priceListVo.getP255(); 
			priceListVo.getCat1()[6][0] = "260"; priceListVo.getCat1()[6][1] = priceListVo.getP260() == null ? null :""+priceListVo.getP260(); 
			priceListVo.getCat1()[7][0] = "265"; priceListVo.getCat1()[7][1] = priceListVo.getP265() == null ? null :""+priceListVo.getP265(); 
			priceListVo.getCat1()[8][0] = "270"; priceListVo.getCat1()[8][1] = priceListVo.getP270() == null ? null :""+priceListVo.getP270(); 
			priceListVo.getCat1()[9][0] = "275"; priceListVo.getCat1()[9][1] = priceListVo.getP275() == null ? null :""+priceListVo.getP275(); 
			priceListVo.getCat1()[10][0] = "280"; priceListVo.getCat1()[10][1] = priceListVo.getP280() == null ? null :""+priceListVo.getP280(); 
			priceListVo.getCat1()[11][0] = "285"; priceListVo.getCat1()[11][1] = priceListVo.getP285() == null ? null :""+priceListVo.getP285(); 
			priceListVo.getCat1()[12][0] = "290"; priceListVo.getCat1()[12][1] = priceListVo.getP290() == null ? null :""+priceListVo.getP290(); 
			priceListVo.getCat1()[13][0] = "295"; priceListVo.getCat1()[13][1] = priceListVo.getP295() == null ? null :""+priceListVo.getP295(); 
			priceListVo.getCat1()[14][0] = "300"; priceListVo.getCat1()[14][1] = priceListVo.getP300() == null ? null :""+priceListVo.getP300(); 
			priceListVo.getCat1()[15][0] = "305"; priceListVo.getCat1()[15][1] = priceListVo.getP305() == null ? null :""+priceListVo.getP305(); 
			priceListVo.getCat1()[16][0] = "310"; priceListVo.getCat1()[16][1] = priceListVo.getP310() == null ? null :""+priceListVo.getP310(); 
			priceListVo.getCat1()[17][0] = "315"; priceListVo.getCat1()[17][1] = priceListVo.getP315() == null ? null :""+priceListVo.getP315(); 
			priceListVo.getCat1()[18][0] = "320"; priceListVo.getCat1()[18][1] = priceListVo.getP320() == null ? null :""+priceListVo.getP320(); 

		} else {  // 0:의류
			
			priceListVo.getCat2()[0][0] = "XS"; priceListVo.getCat2()[0][1] = priceListVo.getPXs() == null ? null :""+priceListVo.getPXs(); 
			priceListVo.getCat2()[1][0] = "S";  priceListVo.getCat2()[1][1] = priceListVo.getPS() == null ? null :""+priceListVo.getPS(); 
			priceListVo.getCat2()[2][0] = "M";  priceListVo.getCat2()[2][1] = priceListVo.getPM() == null ? null :""+priceListVo.getPM(); 
			priceListVo.getCat2()[3][0] = "L";  priceListVo.getCat2()[3][1] = priceListVo.getPL() == null ? null :""+priceListVo.getPL(); 
			priceListVo.getCat2()[4][0] = "XL"; priceListVo.getCat2()[4][1] = priceListVo.getPXl() == null ? null :""+priceListVo.getPXl(); 
			
		}

//		System.out.println(priceListVo);
		model.addAttribute("result",priceListVo);
		//return service.getSellPriceList(product_no);
	}

	@PreAuthorize("isAuthenticated()")
	@GetMapping("check")
	public void check(Long product_no, String size_type, Model model) {
		log.info("sell/check page product_no::" + product_no + ",size_type::" + size_type );
		PriceListVo priceListVo = service.getSellCheck(product_no);
		priceListVo.setSize_type(size_type);
		model.addAttribute("result",priceListVo);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("confirm")
	public void confirm(Long product_no, String size_type, Model model) {
		PriceListVo priceListVo = service.getSellConfirm(product_no,size_type);
		priceListVo.setSize_type(size_type);
		model.addAttribute("result",priceListVo);

	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("confirm")
	public String confirmInsert(BuyVo buy, RedirectAttributes rttr) {
		log.info("buy/confirm Post SellVo::" + buy);
		
		String result = service.modify_buy(buy);
		rttr.addFlashAttribute("result", result);
		return "redirect:/product/shop";
	}
	

}
