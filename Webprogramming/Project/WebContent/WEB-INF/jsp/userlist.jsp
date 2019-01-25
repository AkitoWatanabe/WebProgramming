<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<html>
	<head>
		<meta charset="UTF-8">
	<link rel="stylesheet" href="css/Parsonaldata.css">
	<link rel="stylesheet" href="css/userlist.css">
	<title>ユーザ一覧</title>
	</head>
	<body>
		<div id="header">
			<p>ユーザ名さん　　<span><a href="./login.html">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ一覧</h1>
		<br>
		<div class="right">
			<a href="./signup.html">新規登録</a><br>
		</div>

		<form action="/WebPrograming/" method="post">
			<div class="Container">
				<div class="tittle1">ログインID</div><div class="text1"><input type="text" class="size1" name="userid"></div>
				<div class="tittle2">ユーザ名</div><div class="text2"><input type="text" class="size1" name="username"></div>
				<div class="tittle3">生年月日</div><div class="text3"><input type="text" class="size2"name="birthday1" placeholder=" 年 / 月 / 日 "></div>
				<div class="tittle4">～</div><div class="text4"><input type="text" class="size2"name="birthday2" placeholder=" 年 / 月 / 日 "></div>
				<div class="button"><input type="submit" id="submit"value="検索" /></div>
			</div>
		</form>

		<hr>

		<table border="1">

			  <tr><th>ログインID</th><th>ユーザ名</th><th>生年月日</th><th></th></tr>

			  <tr><td>id0001</td><td>田中太郎</td><td>1989年04月26日</td><td><input type="button" onclick="location.href='./userdetail.html'"value="詳細"><input type="button" onclick="location.href='./userupdate.html'"value="更新"><input type="button" onclick="location.href='./userdelete.html'"value="削除"></td></tr>

			  <tr><td>id0002</td><td>佐藤二郎</td><td>2001年11月12日</td><td><input type="button" onclick="location.href='./userdetail.html'"value="詳細"><input type="button" onclick="location.href='./userupdate.html'"value="更新"><input type="button" onclick="location.href='./userdelete.html'"value="削除"></td></tr>
	  		<tr><td>id0003</td><td>佐川真司</td><td>2000年01月01日</td><td><input type="button" onclick="location.href='./userdetail.html'"value="詳細"><input type="button" onclick="location.href='./userupdate.html'"value="更新"><input type="button" onclick="location.href='./userdelete.html'"value="削除"></td></tr>
		</table>
	</body>
</html>