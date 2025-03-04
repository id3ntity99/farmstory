package farmstory.controller.admin;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.dao.OrderDAO;
import farmstory.dto.OrderDTO;
import farmstory.service.OrderService;
import farmstory.util.ConnectionHelper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/order-list.do")
public class Order_listController extends HttpServlet {

  private static final long serialVersionUID = 161266416260600026L;
  private static final Logger logger =
      LoggerFactory.getLogger(Order_listController.class.getName());

  private OrderService service;

  @Override
  public void init() throws ServletException {
    try {
      ConnectionHelper helper = new ConnectionHelper("jdbc/farmstory");
      OrderDAO dao = new OrderDAO(helper);
      this.service = new OrderService(dao);
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      String pg = req.getParameter("pg");
      int currentPage = (pg != null) ? Integer.parseInt(pg) : 1;
      int pageSize = 10;
      int offset = (currentPage - 1) * pageSize;

      // 주문 데이터 가져오기
      List<OrderDTO> orders = service.getAll(offset, pageSize);

      // 총 데이터 개수
      int total = orders.size();
      int lastPageNum = (int) Math.ceil((double) total / pageSize);

      req.setAttribute("articles", orders);
      req.setAttribute("currentPage", currentPage);
      req.setAttribute("lastPageNum", lastPageNum);

      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/order-list.jsp");
      dispatcher.forward(req, resp);

    } catch (Exception e) {
      logger.error("게시글 목록 조회 중 오류 발생", e);
      resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "서버 오류 발생");
    }
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {}

}
