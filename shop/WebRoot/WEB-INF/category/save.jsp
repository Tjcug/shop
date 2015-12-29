<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
	<%@ include file="/public/head.jspf"%>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
	form div {
			margin:5px;
		}
	</style>

	<script type="text/javascript">
		
	$(function(){
	
		var dg=parent.$("#dg");
		//alert(dg.datagrid("getSelections").length);
		$("input[name=type]").validatebox({
			required : true,
			missingMessage:"请输入一个类别"
		});
		
		$("#ff").form('disableValidation');
	
		$("#btn").click(function(){
			$("#ff").form("enableValidation");
			if($("#ff").form("validate"))
			{
				$("#ff").form("submit", {
						url: 'category_save.action',
						success: function(){
							//关闭当前窗口刷新页面
							parent.$("#win").window("close");
							dg.datagrid("reload");
							}
					});					
			}
		});
	});
		
	</script>
  </head>


<body>
	<form id="ff" method="post" >
		<div>
			<label for="type">类别名称:</label> <input type="text" name="type"  />
		</div>
		<div>
			<label for="hot">热点：</label> 
			热点：<input type="radio" name="hot" value="true"/>
			非热点<input type="radio" name="hot" value="false" checked="checked"/>
		</div>
	<div>
		<a id="btn"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a> 
	</div>
	</form>
	
</body>
</html>
