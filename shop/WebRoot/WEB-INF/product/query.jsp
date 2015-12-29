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
				url : 'product_queryJoinCategory.action',
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
					text:"添加商品",
					handler: function()
						{
							$("#win").window({    
								    width:450,    
								    height:500, 
								    title:'添加商品',   
								    content:'<iframe frameborder="0" width="100%" height="100%" src="send_product_save.action"/>'  
								});  
						}
					},'-',{
					iconCls: 'icon-edit',
					text:"编辑商品",
					handler: function()
					{
						var rows=$("#dg").datagrid("getSelections");
						if(rows.length!=1){
							$.messager.show({
								title : '消息提示',
								msg : '只能编辑一个商品',
								timeout : 2000,
								showType : 'slide'
							});

						} else {
							$("#win").window({    
								    width:450,    
								    height:500, 
								    title:'更新类别',   
								    content:'<iframe frameborder="0" width="100%" height="100%" src="send_product_update.action"/>'  
								});  
						}
					}
				}, '-', {
					iconCls : 'icon-remove',
					text : "删除商品",
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
									$.post("product_deletebyIds.action",{ids:ids},function(result){
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
									},"text");
									}
									});
								}
					}
				}, '-', {
					text : "<input id='search' />"
				} ],

				queryParams : {
					name : ''
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
					field : 'name',
					title : '商品名称',
					width : 100
				}, 
				{
					field : 'price',
					title : '商品价格',
					width : 100
				},{
					field : 'remark',
					title : '商品简单介绍',
					width : 150,
					formatter : function(value, row, index) {
						return "<span>"+value+"</span>";
					}
				},{
					field : 'xremark',
					title : '商品详细介绍',
					width : 150,
					formatter : function(value, row, index) {
						return "<span>"+value+"</span>";
					}
				},{
					field : 'commend',
					title : '推荐商品',
					width : 100,
					formatter : function(value, row, index) {
						if (value) {
							return "推荐商品";
						}
						else{
							return "不是推荐";
						}
					}
				},{
					field : 'open',
					title : '上架商品',
					width : 100,
					formatter : function(value, row, index) {
						if (value) {
							return "已上架";
						}
						else{
							return "没有上架";
						}
					}
				},{
					field : 'category',
					title : '所属类别',
					width : 100,
					formatter : function(value, row, index) {
						if (row.category != null ) {
							return row.category.type;
						}
					}
				} ] ]
			});

			$('#search').searchbox({
				searcher : function(value, name) {
					$('#dg').datagrid('load', {
						name : value
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
