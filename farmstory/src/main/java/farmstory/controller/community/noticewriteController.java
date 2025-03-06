package farmstory.controller.community;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/CommunityWrite.do")
public class writeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public writeController() {

    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Viewport
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/write.jsp");
				dispatcher.forward(req, resp);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}
