<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">

<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="Parsonaldata.css">
		<link rel="stylesheet" href="signup.css">
		<title>ユーザ新規登録</title>
	</head>
	<body>
		<div id="header">
			<p>ユーザ名さん　　<span><a href="./login.html">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ新規登録</h1>
		<br>
		<form action="/WebPrograming/" method="post">
			<div class="Container">
				<div id="tittle1">ログインID</div><div id="text1"><input type="text" name="userid"></div>
				<div id="tittle2">パスワード</div><div id="text2"><input type="text" name="password"></div>
				<div id="tittle3">パスワード（確認）</div><div id="text3"><input type="text" name="spellcheck"></div>
				<div id="tittle4">ユーザ名</div><div id="text4"><input type="text" name="username"></div>
				<div id="tittle5">生年月日</div><div id="text5"><input type="text" name="birthday"></div>
				<div id="button"><input type="submit" id="submit"value="登録" /></div>
			</div>
		</form>
		<footer>
			<a href="./userlist.html">戻る</a><br>
		</footer>
	</body>
</html>