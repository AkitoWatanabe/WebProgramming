<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String gender = request.getParameter("gender");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>入力内容表示</title>
</head>
<body>
<p>名前：<%= name %></p>
<p>性別：<%= gender %></p>
</body>
</html>