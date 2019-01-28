<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/Parsonaldata.css">
		<title>ログイン</title>
	</head>

	<body class="margin">
		<h1 class="center">ログイン画面</h1>
		<div class="center">

	<c:if test="${errMsg != null}" >
	    <div class="alert">
		  ${errMsg}
		</div>
	</c:if>
		<br>
		<form action="LoginServlet" method="post">
			ログインID <input type="text" name="loginId"required><br>
			<br>
			パスワード <input type="text" name="password"required><br>
			<br>
			<input type="submit" value="ログイン">
		</form>
		</div>
	</body>
</html>