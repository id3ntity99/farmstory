<%@page import="farmstory.service.OrderService"%>
<%@page import="farmstory.dto.OrderDTO"%>
<%@page import="farmstory.service.CountableDefaultService"%>
<%@page import="farmstory.util.ConnectionHelper"%>
<%@page import="farmstory.dao.OrderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
		String userId = request.getParameter("userId");
		
		// OrderDAO 객체 생성
		OrderDAO orderDAO = new OrderDAO(new ConnectionHelper("jdbc/farmstory"));
		
		// OrderService 객체 생성 시 OrderDAO를 전달해야 함
		OrderService orderService = new OrderService(orderDAO);
		
		// 주문 처리
		//orderService.placeOrder(userId);
		
		// 완료 후 shopbasket.jsp로 리디렉션
		response.sendRedirect("shopbasket.jsp");

%>

