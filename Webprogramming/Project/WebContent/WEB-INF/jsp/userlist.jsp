<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
	<link rel="stylesheet" href="css/Parsonaldata.css">
	<link rel="stylesheet" href="css/userlist.css">
	<title>ユーザ一覧</title>
	</head>
	<body>

		<div id="header">
			<p>${userInfo.name}さん　　<span><a href="LogoutServlet">ログアウト</a></span></p>
		</div>
		<h1 class="center">ユーザ一覧</h1>
		<br>
		<div class="right">
			<a href="SignupServlet">新規登録</a><br>
		</div>

		<form action="UserListServlet" method="post">
			<div class="Container">
				<div class="tittle1">ログインID</div><div class="text1"><input type="text" class="size1" name="loginId"></div>
				<div class="tittle2">ユーザ名</div><div class="text2"><input type="text" class="size1" name="userName"></div>
				<div class="tittle3">生年月日</div><div class="text3"><input type="text" class="size2"name="birthday1" placeholder=" 年 / 月 / 日 "></div>
				<div class="tittle4">～</div><div class="text4"><input type="text" class="size2"name="birthday2" placeholder=" 年 / 月 / 日 "></div>
				<div class="button"><input type="submit" id="submit"value="検索" /></div>
			</div>
		</form>

		<hr>

		<table border="1">

			<tr><th>ログインID</th><th>ユーザ名</th><th>生年月日</th><th></th></tr>
				<c:forEach var="user" items="${userList}" >
					<tr>
					<td>${user.loginId}</td>
					<td>${user.name}</td>
					<td>${user.birthDate}</td>
					<!-- ログインボタンの表示制御を行う -->
					<c:choose>
						<c:when test="${userInfo.loginId == 'admin'}">
							<td>
								<input type="button" onclick="location.href='UserDetailServlet?id=${user.id}'"value="詳細">
								<input type="button" onclick="location.href='UserUpdateServlet?id=${user.id}'"value="更新">
								<input type="button" onclick="location.href='UserDeleteServlet?id=${user.id}'"value="削除">
							</td>
						</c:when>
						<c:when test="${userInfo.loginId == user.loginId}">
							<td>
								<input type="button" onclick="location.href='UserDetailServlet?id=${user.id}'"value="詳細">
								<input type="button" onclick="location.href='UserUpdateServlet?id=${user.id}'"value="更新">
							</td>
						</c:when>
						<c:otherwise>
							<td>
								<input type="button" onclick="location.href='UserDetailServlet?id=${user.id}'"value="詳細">
							</td>
						</c:otherwise>
					</c:choose>
                	</tr>
                 </c:forEach>
		</table>
	</body>
</html>