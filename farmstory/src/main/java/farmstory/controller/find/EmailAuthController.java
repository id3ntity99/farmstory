package farmstory.controller.find;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/find/emailauth.do")
public class EmailAuthController extends HttpServlet {

	private static final long serialVersionUID = 12545621463L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=UTF-8");

        String receiver = req.getParameter("email");
        JsonObject json = new JsonObject();

        if (receiver == null || receiver.trim().isEmpty()) {
        	json.addProperty("status", "error");
        	json.addProperty("message", "이메일을 입력하세요.");
        } else {
            try {
                // 인증번호 생성 (6자리 난수)
                int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
                String authCode = String.valueOf(code);

                // 세션에 인증번호 저장 (5분 유지)
                HttpSession session = req.getSession();
                session.setAttribute("authCode", authCode);
                session.setMaxInactiveInterval(300); // 5분

                // 이메일 발송 메서드 호출
                sendEmail(receiver, authCode);

                json.addProperty("status", "success");
                json.addProperty("message", "인증번호가 이메일로 전송되었습니다.");
            } catch (Exception e) {
                e.printStackTrace();
                json.addProperty("status", "error");
                json.addProperty("message", "이메일 전송 실패. 다시 시도해주세요.");
            }
        }

        resp.getWriter().write(json.toString());
        
	}
	


    // 이메일 발송 메서드
    private void sendEmail(String receiver, String code) throws MessagingException, UnsupportedEncodingException {
        // Gmail 계정 정보
        final String sender = "wnstj050505@gmail.com";
        final String appPassword = "gupr ruqg cbmj eiud";

        // Gmail SMTP 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // 세션 생성
        Session gmailSession = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, appPassword);
            }
        });
     // 이메일 작성 및 발송
        Message message = new MimeMessage(gmailSession);
        message.setFrom(new InternetAddress(sender, "팜스토리", "UTF-8"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
        message.setSubject("팜스토리에서 인증코드를 발급해드립니다.");
        message.setContent("<h2>인증코드: <strong>" + code + "</strong></h2>", "text/html;charset=UTF-8");

        Transport.send(message);
    }
}
    
    
    
    
    
    
    
    
    
    
    