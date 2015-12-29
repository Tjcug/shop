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
			margin:10px;
		}
	</style>

	<script type="text/javascript">
		
	$(function(){
			
			$('#cc').combobox({
					url : 'category_query.action',
					valueField : 'id',
					textField : 'type',
					panelHeight: 'auto',
					panelWidth: 120,
					editable:false,
					width:120,
					required : true,
					missingMessage:"选择一个类别"
				}
				);
				
		var dg=parent.$("#dg");
		
		var rows = dg.datagrid("getSelections");
			//完整地数据会显示
			
		$('#ff').form('load', {
				id : rows[0].id,
				commend : rows[0].commend,
				open : rows[0].open,
				name : rows[0].name,
				price : rows[0].price,
				remark : rows[0].remark,
				xremark : rows[0].xremark,
				'category.id':rows[0].category.id
			});
			
		//自定义校验方法
		$.extend($.fn.validatebox.defaults.rules, {    
		    format: {    
		        validator: function(value, param){    
		        	var ext=value.substring(value.lastIndexOf('.')+1);
		        	var attr=param[0].split(",");
		        	for(var i=0;i<attr.length;i++){
		        		if(attr[i]==ext)
		        			return true;
		        	}
		            return false;
		        },    
		        message: '请选择图片格式{0}'   
		    }    
		});  
		
		$("input[name='fileImage.upload']").validatebox({
			required : true,
			missingMessage:"请上传一个图片",
			validType: "format['gif,jpg,jpeg,png']"
		});
		
		$("input[name='fileImage.upload']").change(function(){
			//验证文本框是否有效
			$(this).validatebox("validate");
		});
		
		$("input[name=name]").validatebox({
			required : true,
			missingMessage:"请输入一个名称"
		});
		
		$("textarea[name=remark]").validatebox({
			required : true,
			missingMessage:"请输入简单介绍"
		});
		
		$("input[name=price]").numberbox({
			required : true,
			missingMessage:"请输入一个价格",
			precision:2,
			min:0,
			prefix:'￥'
		});
		
		$("#ff").form('disableValidation');
	
		$("#btn").click(function(){
			$("#ff").form("enableValidation");
			if($("#ff").form("validate"))
			{
				$("#ff").form("submit", {
						url: 'product_update.action',
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
	<form id="ff" method="post" enctype="multipart/form-data">
		<div>
			<label for="name">商品名称:</label> <input type="text" name="name"  />
		</div>
		<div>
			<label for="price">商品价格:</label> <input type="text" name="price"  />
		</div>
		<div>
			<label for="upload">图片上传:</label> <input type="file" style="width:180px" name="fileImage.upload"  />
		</div>
		<div>
			<label >所属类别:</label>
			<input id="cc" name="category.id"> </option>   
		</div>
		<div>
			<label for="commend">加入推荐：</label> 
			推荐：<input type="radio" name="commend" value="true"/>
			非推荐<input type="radio" name="commend" value="false" checked="checked"/><br/>
		</div>
		<div>
			<label for="open">是否有效：</label> 
			上架：<input type="radio" name="open" value="true" checked="checked"/>
			非上架<input type="radio" name="open" value="false" /><br/>
		</div>
		
		<div>
			<label for="remark">简单描述:</label> <textarea name="remark" rows="4" cols="40"></textarea>
		</div>
		
		<div>
			<label for="xremark">详细描述:</label> <textarea name="xremark" rows="8" cols="40"></textarea>
		</div>
		<div>
			<input type="hidden" name="id" />
		</div>
	<div>
		<a id="btn"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
		<a id="btn"  href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">重置</a>  
	</div>
	</form>
</body>
</html>
