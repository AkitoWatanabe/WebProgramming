<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/Parsonaldata.css">
				<link rel="stylesheet" href="css/userdelete.css">
		<title>ユーザ削除確認</title>
	</head>
	<body>
		<div id="header">
			<p>${userInfo.name}さん　　<span><a href="LogoutServlet">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ削除確認</h1>
		<div class="Container">
			<div class="tittle1">ログインID</div><div class="text1">${userData.loginId}</div>
			<div class="tittle2">を本当に削除してもよろしいでしょうか。</div>
			<div class="button1"><input type="button" onclick="location.href='UserListServlet'"value="キャンセル"></div>
			<form action="UserDeleteServlet" method="post">
				<input type="hidden" name="loginId" value="${userData.loginId}">
				<div class="button2"><input type="submit" onclick="location.href='UserDeleteServlet'"value="OK"></div>
			</form>
		</div>
		<!--<footer>
			<a href="UserListServlet">戻る</a><br>
		</footer>
		-->
	</body>
</html>