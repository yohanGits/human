package controller.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ReplyService;
import service.ReplyServiceImpl;
import vo.Reply;

@WebServlet("/reply")
public class ReplyController extends HttpServlet{
	private ReplyService service = new ReplyServiceImpl();
	private Gson gson = new Gson();
	@Override
	// 댓글 단일 조회
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		Reply reply = service.get(rno);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().print(gson.toJson(reply));
	}

	@Override
	// 댓글 작성
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonData = req.getParameter("jsonData");
		Reply reply = gson.fromJson(jsonData, Reply.class);
		System.out.println(reply);
		service.write(reply);
	}

	@Override
	
	// 댓글 수정
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Reply reply = new Reply(rno, title, content);
		System.out.println(reply);
		service.modifyReply(reply);
	}
	
	@Override
	// 댓글 삭제
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rno = Long.parseLong(req.getParameter("rno"));
		System.out.println(rno);
		service.remove(rno);
	}
}
