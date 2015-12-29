<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
	<%@ include file="/public/head.jspf"%>
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">

	</style>

	<script type="text/javascript">
		
	$(function(){
			

			$('#cc').combobox({
					url : 'account_query.action',
					valueField : 'id',
					textField : 'login',
					panelHeight: 'auto',
					panelWidth: 120,
					editable:false,
					width:120
				});
				
			var dg = parent.$("#dg");

			var rows = dg.datagrid("getSelections");
			//完整地数据会显示
			//所属管理员没有回显
			$('#ff').form('load', {
				id : rows[0].id,
				type : rows[0].type,
				hot : rows[0].hot,
				'account.id':rows[0].account.id
			});

			$("input[name=type]").validatebox({
				required : true,
				missingMessage : "请输入一个类别"
			});

			$("#ff").form('disableValidation');

			$("#btn").click(function() {
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					$("#ff").form("submit", {
						url : 'category_update.action',
						success : function() {
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
	<form id="ff" method="post">
		<div>
			<label for="type">类别名称:</label> <input 
				type="text" name="type"  />
		</div>
		<div>
			<label for="hot">热点：</label> 
			热点：<input type="radio" name="hot" value="true"/>
			不是热点<input type="radio" name="hot" value="false" checked="checked"/><br/>
		</div>
		<div>
			<label for="type">所属管理员:</label>
			<input id="cc" name="account.id" >  
		</div>
		<div>
			<input type="hidden" name="id" />
		</div>
		<div>
			<a id="btn"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">更新</a>  
		</div>
	</form>
	
</body>
</html>
