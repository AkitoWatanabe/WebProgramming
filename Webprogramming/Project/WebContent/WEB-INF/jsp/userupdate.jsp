<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/Parsonaldata.css">
		<link rel="stylesheet" href="css/userupdate.css">
		<title>ユーザ情報更新</title>
	</head>
	<body>
		<div id="header">
			<p>${userInfo.name}さん　　<span><a href="LogoutServlet">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ情報更新</h1>
		<br>
		<form action="UserUpdateServlet" method="post">
			<div class="Container">
				<div id="tittle1">ログインID</div><div id="text1"><input type="hidden" name="loginId">${userData.loginId}</div>
				<div id="tittle2">パスワード</div><div id="text2"><input type="text" name="password" required></div>
				<div id="tittle3">パスワード（確認）</div><div id="text3"><input type="text" name="spellcheck" required></div>
				<div id="tittle4">ユーザ名</div><div id="text4"><input type="text" name="username" required value=<c:if test="${userData.name != null}" >${userData.name}</c:if>></div>
				<div id="tittle5">生年月日</div><div id="text5"><input type="text" name="birthday" required value=<c:if test="${userData.birthDate != null}" >${userData.birthDate}</c:if>></div>
				<div id="button"><input type="submit" value="更新"></div>
			</div>
		</form>
		<footer>
			<a href="UserListServlet">戻る</a><br>
		</footer>
	</body>
</html>