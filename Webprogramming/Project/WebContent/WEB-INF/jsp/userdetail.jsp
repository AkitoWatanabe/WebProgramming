<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/Parsonaldata.css">
		<link rel="stylesheet" href="css/userdetail.css">
		<title>ユーザ情報詳細参照</title>
	</head>
	<body>
		<div id="header">
			<p>${userInfo.name}さん　　<span><a href="LogoutServlet">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ情報詳細参照</h1>
		<div class="Container">
			<div class="tittle1">ログインID</div><div class="text1">${userData.loginId}</div>
			<div class="tittle2">ユーザ名</div><div class="text2">${userData.name}</div>
			<div class="tittle3">生年月日</div><div class="text3">${userData.birthDate}</div>
			<div class="tittle4">登録日時</div><div class="text4">${userData.createDate}</div>
			<div class="tittle5">更新日時</div><div class="text5">${userData.updateDate}</div>
		</div>
		<footer>
			<a href="UserListServlet">戻る</a><br>
		</footer>
	</body>
</html>