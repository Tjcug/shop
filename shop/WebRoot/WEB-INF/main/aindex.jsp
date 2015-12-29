<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
	<%@ include file="/public/head.jspf"%>
    <title>My JSP 'index.jsp' starting page</title>
    <style type="text/css">
#menu {
	width: 200px;
	height: 500px;
}

#menu ul {
	list-style: none;
	padding: 0px;
	margin: 0px;
	
}

#menu ul li {
	border-bottom: 1px solid #fff;
}

#menu ul li a{
	display: block;
	text-decoration: none;
	color: #fff;
	padding: 5px;
	background-color: #008792;
}
	#menu ul li a:hover{
		background-color: #00a6ac;
	}
	
</style>

	<script type="text/javascript">
		$(function(){
			$("a[title]").click(function(){
				var text=$(this).text();
				var href=$(this).attr("title");
				if($("#tt").tabs("exists",text)){
					$("#tt").tabs("select",text);
				}else{
					$("#tt").tabs("add",{
						title:text,
						//content:正文内容
						closable:true,
						content:'<iframe title ='+text+' frameborder="0" width="100%" height="100%" src='+ href +'/>'
					});
				}
			});
		});
	</script>
  </head>
  

 <body class="easyui-layout">   
    <div data-options="region:'north',title:'欢迎来到后台管理界面',split:true" style="height:80px;"></div>
    <!-- 此处显示系统菜单 -->
	<div data-options="region:'west',title:'系统菜单',split:true" data-options="fit:true" style="width:250px;" >
	    <!-- 此处显示系统菜单 -->
		<div id="menu" class="easyui-accordion"  data-options="fit:true">
			<div title="基本操作" >
				<ul>
					<li><a title="send_category_query.action">类别管理</a></li>
					<li><a title="send_product_query.action">商品管理</a></li>
				</ul>
			</div>
			<div title="其他操作" >
				<ul>
					<li><a title="send_sale_charts.action">销售管理</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div data-options="region:'center',title:'基本视图'" style="padding:1px;background:#fff;">
	
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="后台操作界面" style="padding:50px;" >
				 此处添加系统的默认信息
			</div>
		</div>

	</div>
	
</body>  

</html>
