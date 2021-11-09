package controller.notice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import service.BoardServiceImpl;
import util.MyFileRenamePolicy;
import vo.Attach;
import vo.Board;
import vo.Member;

@WebServlet("/notice/modify")
public class Modify extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long bno = Long.parseLong(req.getParameter("bno"));
		req.setAttribute("board", new BoardServiceImpl().read(bno));
		req.getRequestDispatcher("/WEB-INF/jsp/notice/modify.jsp").forward(req, resp);
	}
	
	// 글 수정 후 프로세스
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글 제목
		// 글 내용
		// 작성자
		
		// 선행 작업
		// session의 member이 null에 대한 예외처리 필요. 하지만 시간상 안한다..
		String saveDirectory = "c:\\upload";
		int maxPostSize = 10 * 1024 * 1024;
		String encoding = "utf-8";
		FileRenamePolicy policy = new MyFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, policy);
		
		Enumeration<String> files = multi.getFileNames();
		List<Attach> attachs = new ArrayList<>();
		while(files.hasMoreElements()) {
			String file = files.nextElement();
			String uuid = multi.getFilesystemName(file);
			if(uuid == null) continue;
			String origin = multi.getOriginalFileName(file);
			
//			Attach attach = new Attach(uuid, origin, null);
//			attachs.add(attach);
		}
		attachs.forEach(System.out::println);
		
		Long bno = Long.parseLong(req.getParameter("bno"));
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
	
		Board board = new Board(bno, title, content);
		board.setAttachs(attachs);
		
		
		new BoardServiceImpl().modify(board);
		
		resp.sendRedirect("list");
	}
	
}
