package site.johnco.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import site.johnco.domain.SampleDTO;
import site.johnco.domain.SampleDTOList;
import site.johnco.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping(value="basic", method={RequestMethod.GET, RequestMethod.POST})
	public void basicGet(){
		log.info("saple.basicGet()");
	}
	
	@GetMapping("basicOnlyGet")
	public void basicGet2(){
		log.info("sample.basicGet2()");
	}
	@GetMapping("ex01")
	public String ex01(@ModelAttribute("dto") SampleDTO dto){
		log.info(dto);
		return "sample/test";
	}
	
//	@GetMapping("service") 서블릿으로 위에것을 그대로 하면 이렇게 됨ㅋㅋㅋ
//	public void service(HttpServletRequest req, HttpServletResponse resp){
//		log.info(req);
//		log.info(resp);
//		log.info(req.getParameter("name"));
//		SampleDTO dto = new SampleDTO();
//		dto.setName(req.getParameter("name"));
//		dto.setAge(Integer.parseInt(req.getParameter("age")));
//		log.info(dto);
//	}
	
	@GetMapping("ex02")
	public String ex02(String name, int age, @RequestParam(value="addr", required=false, defaultValue="여의도")String address){
		log.info("name :: " + name);
		log.info("age :: " + age);
		log.info("address :: " + address);
		return "sample/test";
	}
	
	@GetMapping("ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids){
		log.info("ids :: " + ids);
		return "sample/test";
	}
	
	@GetMapping("ex02Arrays")
	public String ex02List(@RequestParam("ids") String[] ids){
		log.info("ids :: " + Arrays.toString(ids));
		return "sample/test";
	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list){
		log.info("list dtos :: " + list);
		log.info(list.getList().getClass().getName());
		return "sample/test";
		// list[0].name=aaa&list[0].age=10 이런식
	}
	
	@GetMapping("ex03")
	public String ex03(TodoDTO dto){
		log.info("dto :: " + dto);
		return "sample/test";
	}
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
//	}
	
	@GetMapping("ex04")
	public String ex04(@ModelAttribute("dto") SampleDTO sampleDTO, @ModelAttribute Integer page, Model model){
		log.info("dto :: " + sampleDTO);
		log.info("page :: " + page);
		
//		model.addAttribute("dto", sampleDTO); // forward시 requestScope에 데이터 바인딩
//		model.addAttribute("page", page);  
		return "sample/ex04";
	}
	
	@GetMapping("ex04flash")
	public String ex04flash(RedirectAttributes rttr){
		rttr.addFlashAttribute("test", "1234");
		rttr.addAttribute("test2", "1234");
		return "redirect:/";
	}
	
	@GetMapping("mav")
	public ModelAndView mav(ModelAndView mav, String name){
		mav.addObject("test", name);
		mav.setViewName("sample/test");
		return mav;
	}
	
	@GetMapping("ex06")
	public @ResponseBody SampleDTO ex06(){
		SampleDTO dto = new SampleDTO();
		dto.setAge(30);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("ex07")
	public ResponseEntity<SampleDTO> ex07(){
		SampleDTO dto = new SampleDTO();
		dto.setAge(30);
		dto.setName("홍길동");
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Type", "application/jason;charset=utf-8");
		return new ResponseEntity<SampleDTO>(dto, headers, HttpStatus.OK);
		
	}
	@GetMapping("exUpload")
	public void exUpload(){
		log.info("sample.exUpload");
	}
	
	@PostMapping("exUpload")
	public void exUploadPost(List<MultipartFile> files){
		log.info("sample.exUploadPost");
		files.forEach(f -> {
			log.info("------------------");
			log.info("name :: " + f.getOriginalFilename());
			log.info("size :: " + f.getSize());
			
			try {
				f.transferTo(new File("c:/upload/"+f.getOriginalFilename()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
	}
}
