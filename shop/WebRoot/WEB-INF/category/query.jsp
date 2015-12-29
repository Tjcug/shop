<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ include file="/public/head.jspf"%>
<html>
  <head>
    <style type="text/css">
				.searchbox {
					margin: -3;
				}
</style>
	<script type="text/javascript">
		$(function(){
		$('#dg').datagrid({
				url : 'category_queryJoinAccount.action',
				striped:true,
				nowrap:true,
				fitColumns:true,
		/*rowStyler : function(index, row) {
					if (index%2==0) {
						 return 'background-color:#6293BB;color:#ff0000;';
					}else{
						 return 'background-color:#6293BB;color:#00ff00;';
					}
				},*/
				idField:"id",
				toolbar: [{
					iconCls: 'icon-add',
					text:"添加类别",
					handler: function()
						{
							$("#win").window({    
								    width:400,    
								    height:400, 
								    title:'添加类别',   
								    content:'<iframe frameborder="0" width="100%" height="100%" src="send_category_save.action"/>'  
								});  
						}
					},'-',{
					iconCls: 'icon-edit',
					text:"编辑类别",
					handler: function()
					{
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length!=1){
							$.messager.show({
								title : '消息提示',
								msg : '只能编辑一个类别',
								timeout : 2000,
								showType : 'slide'
							});

						} else {
							$("#win").window({    
								    width:320,    
								    height:400, 
								    title:'更新类别',   
								    content:'<iframe frameborder="0" width="100%" height="100%" src="send_category_update.action"/>'  
								});  
						}
					}
				}, '-', {
					iconCls : 'icon-remove',
					text : "删除类别",
					handler : function() 
					{
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length==0){
							$.messager.show({
								title : '消息提示',
								msg : '必须选择一个类别记录',
								timeout : 2000,
								showType : 'slide'
							});

						} else {
								$.messager.confirm('确认对话框', '您想要删除吗？', function(r){
								if (r){
									var ids=""; 
									for(var i=0;i<rows.length;i++){
										ids+=rows[i].id+',';
										}
									ids=ids.substring(0,ids.lastIndexOf(','));
									//发送ajax请求
									$.post("category_deletebyIds.action",{ids:ids},function(result){
										if(result=="true"){
											//让所有选择的选项不选中
											$('#dg').datagrid('uncheckAll'); 
											$('#dg').datagrid('reload');    // 重新载入当前页面数据  
										}else{
											$.messager.show({
											title : '消息提示',
											msg : '删除失败请检查操作',
											timeout : 2000,
											showType : 'slide'
											});
										}
									},"text")
									}
									});
								}
					}
				}, '-', {
					text : "<input id='search' />"
				} ],

				queryParams : {
					type : ''
				},
				pagination : true,
				frozenColumns : [ [ {
					field : 'fdsf',
					checkbox : true
				}, {
					field : 'id',
					title : '编号',
					width : 100
				} ] ],
				columns : [ [ {
					field : 'type',
					title : '类别名称',
					width : 150
				}, {
					field : 'hot',
					title : '热点',
					width : 100,
					formatter : function(value, row, index) {
						if (value)
							return "热点";
						else
							return "不是热点";
					}
				}, {
					field : 'account',
					title : '所属管理员',
					width : 100,
					formatter : function(value, row, index) {
						if (row.account != null ) {
							return row.account.login;
						}
					}

				} ] ]
			});

			$('#search').searchbox({
				searcher : function(value, name) {
					$('#dg').datagrid('load', {
						type : value
					});
				},
				prompt : 'Please Input Value'
			});

		});
	</script>
  </head>
  
 <body >   
 	<table id="dg" ></table>  
 	<div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>
</body>  

</html>
