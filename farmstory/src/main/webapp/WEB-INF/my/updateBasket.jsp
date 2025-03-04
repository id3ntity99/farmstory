<%@page import="farmstory.dto.OrderDTO"%>
<%@page import="farmstory.util.ConnectionHelper"%>
<%@page import="farmstory.dao.OrderDAO"%>
<%@page import="farmstory.service.CountableDefaultService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int orderId = Integer.parseInt(request.getParameter("orderId"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	
	// CountableDefaultService와 OrderDAO 객체 생성
    OrderDAO orderDAO = new OrderDAO(new ConnectionHelper("jdbc/farmstory"));
    CountableDefaultService<OrderDTO> orderService = new CountableDefaultService<OrderDTO>(orderDAO);

    // OrderDTO 생성 후 데이터 설정
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setId(orderId);
    orderDTO.setAmount(amount);

    // 장바구니 아이템 업데이트
    orderService.update(orderDTO);

    // 업데이트 후 shopbasket.jsp로 리디렉션
    response.sendRedirect("shopbasket.jsp");
	%>