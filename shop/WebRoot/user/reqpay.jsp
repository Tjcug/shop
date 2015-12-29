<%@page language="java" contentType="text/html;charset=gbk"%>
<html>
	<head>
	<%@include file="/public/head.jspf" %>	
		<title>To YeePay Page
		</title>
	</head>
	<body>
		<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--ͷ����ʼ-->
				<div class="top_bar clear">
					<!--ͷ��С����-->
					<div class="welcom fl">��ӭ����LEISUPET SHOP!</div>
					<ul class="top_links fr">
						<li class="highlight"><a href="#">��ҳ</a></li>
						<li><a href="#">�ҵ��˻�</a></li>
						<li><a href="#">���ﳵ</a></li>
						<li><a href="#">ע��</a></li>
						<li><a href="#">��¼</a></li>
					</ul>
					<!--ͷ��С��������-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" /> </a>
					</h1>
					<!-- С���ﳵ -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								<b>2</b> ��/ </span> <span class="price"> <b>��199.80</b> </span> </a>
					</div>
					<!-- С���ﳵ���� -->
					<!-- ������ -->
					<div class="header_search">
						<div class="form-search ">
							<input value="��������Ʒ����" class="input-text" type="text" />
							<button type="submit" title="Search"></button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ͷ������ -->
		<!-- ������ -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#">Ůװ</a> <!--�����˵�-->
						<ul class="sub_menu">
							<li><a href="#">ȹװ</a>
								<ul>
									<li><a href="#">��ȹ</a></li>
									<li><a href="#">�̿�</a></li>
									<li><a href="#">����</a></li>
									<li><a href="#">�����</a></li>
									<li><a href="#">���п�</a></li>
									<li><a href="#">ţ�п�</a></li>
									<li><a href="#">���� & �˶��п�</a></li>
								</ul></li>
							<li><a href="#">װ��Ʒ</a>
								<ul>
									<li><a href="#">̫����</a></li>
									<li><a href="#">Χ��</a></li>
									<li><a href="#">����Ʒ</a></li>
									<li><a href="#">ñ�Ӻ�����</a></li>
									<li><a href="#">����ʱ��</a></li>
									<li><a href="#">ţ��ϵ��</a></li>
									<li><a href="#">���� & ����</a></li>
								</ul></li>
						</ul></li>
					<!--�����˵�����-->
					<li><a href="#">��װ</a> <!--�����˵�-->
						<ul class="sub_menu">
							<li><a href="#">��ʿ��װ</a>
								<ul>
									<li><a href="#">����</a></li>
									<li><a href="#">���п�</a></li>
									<li><a href="#">�����</a></li>
									<li><a href="#">ţ�п�</a></li>
									<li><a href="#">���� & �˶��п�</a></li>
								</ul></li>
							<li><a href="#">װ��Ʒ</a>
								<ul>
									<li><a href="#">̫����</a></li>
									<li><a href="#">Χ��</a></li>
									<li><a href="#">����Ʒ</a></li>
									<li><a href="#">ñ�Ӻ�����</a></li>
									<li><a href="#">����ʱ��</a></li>
									<li><a href="#">ţ��ϵ��</a></li>
									<li><a href="#">���� & ����</a></li>
								</ul></li>
						</ul> <!--�����˵�����--></li>
					<li><a href="#">��ͯ</a></li>
					<li><a href="#">ʱ��</a></li>
					<li><a href="#">װ��Ʒ</a></li>
				</ul>
			</div>
		</div>
		
	<!-- ���������� -->
			<div class="selection_container">
				<div class="pay-skip">
					<h1>��л���ڱ��̳ǹ���</h1>
					<div class="payskip-inner">
						<div>
							<span>�����ţ�</span><strong>${requestScope.p2_Order}</strong><span>���ס������룬��Ҫ�ڸ���Ͳ�ѯ��ʹ��</span>
						</div>
						<div>
							<span>֧����</span><strong>${requestScope.p4_Amt}</strong>
						</div>
						<div>
							<span>֧����ʽ��</span><img class="zffs" src="${shop}/images/yibao.jpg"/>
						</div>
						<div>
							<span>֧�����У�</span><img class="zfyh" src="${shop}/images/bank/${requestScope.pd_FrpId}.gif"/>
						</div>
						  <div>
							<form name="yeepay" action='https://www.yeepay.com/app-merchant-proxy/node' method='POST' target="_blank">
									<input type='hidden' name='p0_Cmd'   value='${requestScope.p0_Cmd}'>
									<input type='hidden' name='p1_MerId' value='${requestScope.p1_MerId}'>
									<input type='hidden' name='p2_Order' value='${requestScope.p2_Order}'>
									<input type='hidden' name='p3_Amt'   value='${requestScope.p3_Amt}'>
									<input type='hidden' name='p4_Cur'   value='${requestScope.p4_Cur}'>
									<input type='hidden' name='p5_Pid'   value='${requestScope.p5_Pid}'>
									<input type='hidden' name='p6_Pcat'  value='${requestScope.p6_Pcat}'>
									<input type='hidden' name='p7_Pdesc' value='${requestScope.p7_Pdesc}'>
									<input type='hidden' name='p8_Url'   value='${requestScope.p8_Url}'>
									<input type='hidden' name='p9_SAF'   value='${requestScope.p9_SAF}'>
									<input type='hidden' name='pa_MP'    value='${requestScope.pa_MP}'>
									<input type='hidden' name='pd_FrpId' value='${requestScope.pd_FrpId}'>
									<input type="hidden" name="pr_NeedResponse"  value="${requestScope.pr_NeedResponse}">
									<input type='hidden' name='hmac' value='${requestScope.hmac}'>
									<div class="pay-sub">
										<input type='submit' value="��¼������������֧��"/>
									</div>
								</form>
						 </div>
					</div>
				</div>
			</div>
			
			<!-- ���������� -->
			<div class="footer_container">
				<div class="footer">
					<ul class="footer_links">
						<li><span>�ղر���</span>
							<ul>
								<li><a href="#">��װ</a></li>
								<li><a href="#">Ь��</a></li>
								<li><a href="#">����</a></li>
								<li><a href="#">װ��Ʒ</a></li>
								<li><a href="#">channel</a></li>
								<li><a href="#">prada</a></li>
								<li><a href="#">LV</a></li>
							</ul></li>
						<li class="seperator"><span>���۵�Ʒ��</span>
							<ul>
								<li><a href="#">Elle</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
								<li><a href="#">Mayflower</a></li>
								<li><a href="#">Levis Strauss</a></li>
								<li><a href="#">Anzonica</a></li>
								<li><a href="#">Reallxe</a></li>
								<li><a href="#">Fabric</a></li>
							</ul></li>
						<li><span>�ͻ�����</span>
							<ul>
								<li><a href="#">����</a></li>
								<li><a href="#">�ٵ�</a></li>
								<li><a href="#">�˻���</a></li>
								<li><a href="#">���ʽ</a></li>
								<li><a href="#">��������</a></li>
								<li><a href="#">�����ѡ��</a></li>
								<li><a href="#">���ʷ���</a></li>
								<li><a href="#">������</a></li>
							</ul></li>
						<li><span>�����˻�</span>
							<ul>
								<li><a href="#">�����˻���Ϣ</a></li>
								<li><a href="#">�û�����</a></li>
								<li><a href="#">������ʷ</a></li>
								<li><a href="#">���ʽ</a></li>
								<li><a href="#">�ҵ��ջ���ַ</a></li>
								<li><a href="#">�ҵ�֪ͨ</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		
	</body>
</html>
