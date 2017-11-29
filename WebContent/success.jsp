<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
</body>
<script language="javascript">
	function jump(){
	setTimeout("document.location.href='${ctx}/successLogin.html';",3000);
	}
	jump();
</script>
</head>
<body>
<script> 
	var t=3;//设定跳转的时间 
	setInterval("refer()",1000); //启动1秒定时 
	function refer(){ 
	if(t==0){ 
	location="${ctx}/successLogin.html"; //#设定跳转的链接地址 
	} 
	document.getElementById('show').innerHTML="登录成功"+t+"秒后跳转到主页"; // 显示倒计时 
	t--; // 计数器递减 
	} 
</script> 
<span id="show"></span> 
</html>