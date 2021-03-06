package controller.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/findID")
public class FindId extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/member/findID.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String msg = "";
		String redirectUrl = "findID";
		
		MemberService service = new MemberServiceImpl();
		Member member = service.findId(name, email);
		req.setAttribute("member", member);
		
		
		if(member != null) {
			req.getRequestDispatcher("WEB-INF/jsp/member/findID1.jsp").forward(req, resp);
		} else {
			msg="계정을 찾을수 없습니다";
			resp.sendRedirect(redirectUrl + "?msg=" +URLEncoder.encode(msg, "utf-8"));
		}
		
	}
	
}
