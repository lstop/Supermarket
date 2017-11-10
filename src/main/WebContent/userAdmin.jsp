<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/list.js"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript">
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
	}
</script>
</head>
<body>




	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="user.do">
							<input name="flag" value="search" class="input-text"
								type="hidden"> 用户名称：<input name="userName"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='${pageContext.request.contextPath}/main/userAdd.jsp'"
				type="button"></em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">用户名称</div></td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>

						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">地址</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>
					<c:forEach items="${users}" var="user">

						<tr>
							<td height="23"><span class="STYLE1">${user.uid }</span></td>
							<td><span class="STYLE1"><a
									href="main/reshow?uid=${user.uid }">${user.uname }</a></span></td>

							<td><span class="STYLE1"> <c:if
										test="${user.usex==1}">男</c:if> <c:if test="${user.usex==0}">女</c:if>
							</span></td>
							<td><span class="STYLE1">${user.uage }</span></td>
							<td><span class="STYLE1">${user.utel }</span></td>
							<td><span class="STYLE1">${user.uaddress }</span></td>
							<td><span class="STYLE1"> <c:if
										test="${user.uissupper==1}">经理</c:if> <c:if
										test="${user.uissupper==0}">普通用户</c:if>
							</span></td>

						</tr>
					</c:forEach>
					<TR
						style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
						<TD colspan="7"><SPAN id="pagelink"> <span class="row-selector"
								style="padding-left: 50px;"> <select
									class="form-control perpage" id="perpage">
										<option value="2">2</option>
										<option value="5">5</option>
										<option value="10">10</option>
								</select> <!-- react-text: 635 -->rows per page.<!-- /react-text -->
							</span> <span class="pagination-buttons"> 
							<input type="hidden" id="pagehide" value="${pagehide }"> 
							<input type="hidden" id="perpagehide" value="${perpagehide }">
							<input type="hidden" id="sizehide" value="${sizehide }">
							<button type="button" id="previous" name="page" value="previous" class="button_prev">Previous</button>
							<button type="button" id="1" name="page" value="1" class="button_page">1</button>
							<button type="button" id="2" name="page" value="2" class="button_page">2</button>
							<button type="button" id="3" name="page" value="3" class="button_page">3</button>
							<button type="button" id="4" name="page" value="4" class="button_page">4</button>
							<button type="button" id="5" name="page" value="5" class="button_page">5</button>
							<button type="button" id="next" name="page" value="next" class="button_next">Next</button>

							</span>

						</SPAN></TD>
					</TR>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>