<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String[] luckList = {"大吉","中吉","小吉","凶"};

int index =(int)(Math.random()*4);
String luck = luckList[index];
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>おみくじプログラム</title>
</head>
<body>
<p>あなたの運勢は<%= luck %>です。</p>
</body>
</html>