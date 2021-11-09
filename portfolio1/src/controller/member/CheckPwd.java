package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardServiceImpl;
import service.MemberServiceImpl;

@WebServlet("/checkPwd")
public class CheckPwd extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		req.setAttribute("member", new MemberServiceImpl().findBy(id));
		req.getRequestDispatcher("/WEB-INF/jsp/member/checkPwd.jsp").forward(req, resp);
	}
	
	
}
