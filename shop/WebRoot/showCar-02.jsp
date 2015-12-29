<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
	<%@ include file="/public/head.jspf"%>
<html>
  <head>
    <title>购物商城首页</title>
  </head>
  
  <body>
 		<table>
 			<tr>
 				<td>商品编号</td>
 				<td>商品名称</td>
 				<td>商品数量</td>
 				<td>商品价格</td>
 				<td>小计</td>
 				<td>操作</td>
 			<tr>
 			<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
 				<tr>
 					<td>"${sorder.name}"</td>
 					<td>"${sorder.price}"</td>
 					<td>"${sorder.number}"</td>
 					<td>"${sorder.price}"</td>
 					<td>"${sorder.price}*${sorder.number}"</td>
 					<td>更新，删除</td>
 				<tr>
 			</c:forEach>  
 			
 			<tr>
 				<td>${sessionScope.forder.total}</td>
 			</tr> 
 		</table>
	</body>
</html>
