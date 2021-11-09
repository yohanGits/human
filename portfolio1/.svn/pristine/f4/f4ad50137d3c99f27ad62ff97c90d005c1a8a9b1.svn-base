package controller.member;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;
import util.Gmail;
import util.MyFileRenamePolicy;
import vo.Member;

@WebServlet("/findPwd")
public class FindPwd extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/member/findPwd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String from = "thsdygks23@gmail.com";
		String subject = "비밀번호 찾기를 위한 인증 번호입니다.";
		Properties p = System.getProperties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		
		try {
			Authenticator auth = new Gmail();
			Session session = Session.getDefaultInstance(p, auth);
			session.setDebug(true);
			Message msg = new MimeMessage(session);
			
			// 메일 보낸 시간
			msg.setSentDate(new Date());
			// 이메일 제목
			msg.setSubject(subject);
			// 보내는 사람
			InternetAddress fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			// 이메일 수신자 / 사용자가 입력한 이메일
			String email = req.getParameter("email");
			Address toAddr = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, toAddr);
			// 이메일 내용 / 임의로 생성한 코드값
			String code = req.getParameter("codecheck");
			req.setAttribute("code", code);
			msg.setText(code);
			
			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");
			
			// 메일 보내기
			javax.mail.Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String msg = "";
		String redirectUrl = "findPwd";
		
		MemberService service = new MemberServiceImpl();
		Member member = service.findPwd(id, email);
		
		if(member != null) {
			req.setAttribute("id", id);
			req.getRequestDispatcher("WEB-INF/jsp/member/ckCode.jsp").forward(req, resp);
		} else {
			msg="계정을 찾을수 없습니다";
			resp.sendRedirect(redirectUrl + "?msg=" +URLEncoder.encode(msg, "utf-8"));
		}
	}
}
