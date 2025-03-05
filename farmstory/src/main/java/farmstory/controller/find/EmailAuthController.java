package farmstory.controller.find;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import farmstory.dao.UserDAO;
import farmstory.dto.UserDTO;
import farmstory.service.UserService;
import farmstory.util.ConnectionHelper;
import farmstory.util.ResponseBodyWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/find/emailauth.do")
public class EmailAuthController extends HttpServlet {

	private static final long serialVersionUID = 12545621463L;
	private final Properties props = new Properties();
    private final Properties gmailConf = new Properties();
    
	private UserDAO dao;
	private UserService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.dao = new UserDAO(new ConnectionHelper("jdbc/farmstory"));
		this.service = new UserService(dao);
		try (
		        InputStream in = config.getServletContext()
		            .getResourceAsStream("/WEB-INF/resources/application.properties");
		        InputStream gmailConfIn = config.getServletContext()
		            .getResourceAsStream("/WEB-INF/resources/gmailconf.properties")) {
		      props.load(in);
		      gmailConf.load(gmailConfIn);
		    } catch (IOException e) {
		      throw new ServletException("Properties 로드 중 문제가 발생했습니다.", e);
		    }
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int code = ThreadLocalRandom.current().nextInt(100000, 1000000);
	    String email = req.getParameter("address");
	    String sender = (String) props.get("gmail.sender");
	    String appPassword = (String) props.get("gmail.password");
	    String title = (String) props.get("gmail.title");
	    String content = String.format("<h3>팜스토리 인증 코드: %d</h3>", code);

	    Session mailSession = Session.getInstance(gmailConf, new Authenticator() {
	      @Override
	      protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(sender, appPassword);
	      }
	    });

	    Message message = new MimeMessage(mailSession);

	    try {
	      message.setFrom(new InternetAddress(sender, "보내는 사람", "UTF-8"));
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	      message.setSubject(title);
	      message.setContent(content, "text/html;charset=utf-8");
	      Transport.send(message);
	      ResponseBodyWriter.write(true, "", HttpServletResponse.SC_OK, resp);
	      String msg = String.format("%s로 인증코드를 전송하였음", email);
	      logger.debug(msg);
	    } catch (MessagingException e) {
	      ResponseBodyWriter.write(false, "인증번호 전송 실패", HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
	          resp);
	    }
	    HttpSession session = req.getSession();
	    session.setAttribute("emailAuthCode", code);

	    resp.flushBuffer();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
    
    
    
    
    
    
    
    
    
    
    