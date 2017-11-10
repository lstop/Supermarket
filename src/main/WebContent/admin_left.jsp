<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#userlogout").click(function(){
		$.ajax({
			url: "${pageContext.request.contextPath}/userlogout",
			type: "post",
			async : true,
			success: function(data){
				if("success" == data){ 
					window.top.location.href = "${pageContext.request.contextPath}/login.jsp";
				}
			}
		});
	});
})
</script>
</head>
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="admin_bill_list.jsp" target="mainFrame"><img src="${pageContext.request.contextPath}/images/btn_bill.gif" /></a></li>
	<li><a href="providerAdmin.jsp" target="mainFrame"><img src="${pageContext.request.contextPath}/images/btn_suppliers.gif" /></a></li>
	<li><a href="${pageContext.request.contextPath}/listuserbypage" target="mainFrame"><img src="${pageContext.request.contextPath}/images/btn_users.gif" /></a></li>
	<li><a href="#" id="userlogout"><img src="${pageContext.request.contextPath}/images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
