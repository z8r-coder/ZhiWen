<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>知问</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<body>
	<div id="header">
		<div class="header_main">
			<h1>知问</h1>
			<div class="header_search">
				<input type="text" name="search" class="search" />
			</div>
			<div class="header_button">
				<button id="search_button">查询</button>
			</div>
			<div class="header_member">
				<a href="###" id="reg_a">注册</a> | <a
					href="###" id="login_a">登录</a>
			</div>
		</div>
	</div>

	<form id="reg" title="会员注册">
		<ol class="reg_error"></ol>
		<p>
			<label for="user">账号：</label> <input type="text"
				name="user.userAccount" class="text" id="user" /> <span
				class="star">*</span>
		</p>
		<p>
			<label for="pass">密码：</label> <input type="password"
				name="user.userPassword" class="text" id="pass" /> <span
				class="star">*</span>
		</p>
		<p>
			<label for="email">邮箱：</label> <input type="text"
				name="user.userEmail" class="text" id="email" /> <span class="star">*</span>
		</p>
		<p>
			<label>性别：</label> <input type="radio" name="sex" value="male"
				name="user.userGender" id="male" checked="checked"><label
				for="male">男</label></input><input type="radio" name="sex" value="female"
				name="user.userGender" id="female"><label for="female">女</label></input>
		</p>
		<p>
			<label for="date">生日：</label> <input type="text" name="date"
				name="user.userBirthday" class="text" id="date" readonly="readonly" />
		</p>
	</form>
	<form id="login" method="post" action="user!login.action" title="会员登录">
		<ol class="reg_error"></ol>
		<p>
			<label for="user">账号：</label> <input type="text" name="user.userAccount"
				class="text" id="user" /> <span class="star">*</span>
		</p>
		<p>
			<label for="pass">密码：</label> <input type="password" name="user.userPassword"
				class="text" id="pass" /> <span class="star">*</span>
		</p>
		<p>
			<input type="checkbox" name="expires" id="expires" checked="checked" />
			<label for="expires">登录后有效期一周</label>
		</p>
	</form>
	<div id="loading">
		数据交互中.......
	</div>
</body>
</html>
