package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;
import vo.Member;

@WebServlet("/changeInfo")
public class ChangeInfo extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/member/changeInfo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = ((Member)req.getSession().getAttribute("member")).getId();
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		Member member = new Member(id, pwd, email, name);
		MemberService service = new MemberServiceImpl();
		req.setAttribute("member", service.findBy(id));
		service.modify(member);
		
		resp.sendRedirect("login");
	}
	
}
