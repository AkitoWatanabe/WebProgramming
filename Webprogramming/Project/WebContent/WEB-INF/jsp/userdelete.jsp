<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="Parsonaldata.css">
				<link rel="stylesheet" href="userdelete.css">
		<title>ユーザ削除確認</title>
	</head>
	<body>
		<div id="header">
			<p>ユーザ名さん　　<font color="#ff0000"><a href="./login.html">ログアウト</a></font></p>
		</div>
		<h1 class="center">ユーザ削除確認</h1>
		<div class="Container">
			<div class="tittle1">ログインID</div><div class="text1">id0001</div>
			<div class="tittle2">を本当に削除してもよろしいでしょうか。</div>
			<div class="button1"><input type="button" onclick="location.href='./userlist.html'"value="キャンセル"></div>
			<div class="button2"><input type="button" onclick="location.href='./userlist.html'"value="OK"></div>
		</div>
		<footer>
			<a href="./userlist.html">戻る</a><br>
		</footer>
	</body>
</html>