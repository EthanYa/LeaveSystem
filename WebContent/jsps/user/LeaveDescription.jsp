<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/layout/meta.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%if("0".equals( request.getSession().getAttribute("identity"))){  //主管跳轉%>
<jsp:include page="/layout/AdministratorHeader.jsp" />
<%}else if("1".equals( request.getSession().getAttribute("identity"))){  //管理員跳轉%>
<jsp:include page="/layout/ManagerHeader.jsp" />
<%}else if("2".equals( request.getSession().getAttribute("identity"))){// 員工跳轉%>
<jsp:include page="/layout/UserHeader.jsp" />
<%}else{
	response.sendRedirect("/LeaveSystem/LoginServlet?act=logout"); //沒有身分進入網頁，跳回登入頁面
}%>

<title>請假說明</title>
</head>
<body>
<br>
<br>
<br>
<br>
<div class="container col-md-offset-4" >
<h1 >請假說明</h1>
<br>
<h3 >1.請假時數為09:00至18:00</h3>
<h3 >2.12:00~13:00為午休不予計算</h3>
<h3 >3.一天時數上限為8小時</h3>
<h3 >4.請假時數以0.5小時為單位</h3>
<h3 >5.一張假單可以請多種假</h3>
<br>
<br>
</div>
<form  class="form-inline col-md-offset-4"  action="${pageContext.request.contextPath}/UserServlet?act=listLeave" method="post">
  <div class="col-sm-2">
			<button id=apply class="btn btn-primary" type="submit">
				<span style="padding-right: 5px;" class="glyphicon glyphicon-pencil"></span>填寫
			</button>
		</div>
</form>

</body>
</html>