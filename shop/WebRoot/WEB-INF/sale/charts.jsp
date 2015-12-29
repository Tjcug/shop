<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>JS Charts</title>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript" src="${shop}/jquery-easyui-1.3.5/jscharts.js"></script>
<script type="text/javascript">

	$(function(){
		var colorArray=['#5C447A','#6C469D','#7B36D1','#8939ED','#964FEF','#B17BF4','#C9A3F7','#C9A3F7','#C9A3F7','#5C447A'];
		$("#submit").click(function(){
			$.post($("#sale").val(),{number:$("#number").val()},function(resultJson){
				var myChart = new JSChart('chart_container', $("#type").val(), '');
				myChart.setDataArray(resultJson);
				myChart.colorize(colorArray.slice(0, resultJson.length));
				myChart.setSize(100*$("#number").val(), 400);
				myChart.setIntervalEndY(70);
				myChart.setTitle('商品销售报表');
				myChart.setTitleFontSize(10);
				myChart.setBarSpacingRatio(50);
				myChart.setBarOpacity(1);
				myChart.setAxisWidth(1);
				myChart.setAxisNameX('商品名称', true);
				myChart.setAxisNameY('销量', false);
				myChart.set3D(true);
				myChart.setBarValues(false);
				myChart.setAxisPaddingLeft(45);
				myChart.setAxisPaddingBottom(35);
				myChart.draw();
			},"json");
		});
	});
	
</script>
</head>
<body style="margin: 10px">
	请选择报表的类型:
	<select id="sale">
		<option value="sorder_querySale.action">年度销售报表</option>
	</select>
	查询的数量：
	<select id="number">
		<option value="5">5</option>
		<option value="7">7</option>
		<option value="10">10</option>
	</select>
	类型：
	<select id="type">
		<option value="bar">柱状型</option>
		<option value="line">线型</option>
		<option value="pie">饼状型</option>
	</select>
	<input type="button" value="查询" id="submit">
	<div id="chart_container"></div>
</body>
</html>