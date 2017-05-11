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
				<button id="question_button">提问</button>
			</div>
			<div class="header_member">
				<a href="javascript:void(0)" id="reg_a">注册</a> <a
					href="javascript:void(0)" id="member">用户</a> | <a
					href="javascript:void(0)" id="login_a">登录</a> <a
					href="javascript:void(0)" id="logout">退出</a>
			</div>

		</div>
	</div>

	<div id="main">
		<div class="main-left">
			<div id="tabs">
				<ul>
					<li id="tab1"><a href="tab1.html">tab1</a></li>
					<li id="tab2"><a href="tab2.html">tab2</a></li>
					<li id="tab3"><a href="tab3.html">tab3</a></li>
				</ul>
			</div>
		</div>
		<div class="main-right">

			<div id="accordion">
				<h1>菜单1</h1>
				<div>内容1</div>
				<h1>菜单2</h1>
				<div>内容2</div>
				<h1>菜单3</h1>
				<div>内容3</div>
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
	<form id="login" title="会员登录">
		<ol class="reg_error"></ol>
		<p>
			<label for="user">账号：</label> <input type="text"
				name="user.userAccount" class="text" id="user_login" /> <span
				class="star">*</span>
		</p>
		<p>
			<label for="pass">密码：</label> <input type="password"
				name="user.userPassword" class="text" id="pass_login" /> <span
				class="star">*</span>
		</p>
		<p>
			<input type="checkbox" name="expires" id="expires" checked="checked" />
			<label for="expires">登录后有效期一周</label>
		</p>
	</form>
	<form id="question" title="提问">
		<p>
			<label for="title">问题名称：</label> <input type="text"
				name="title" class="text" id="title" /> <span
				class="star">*</span>
		</p>
	</form>
	<div id="loading">数据交互中.......</div>
	<div id="error">请登录后操作.......</div>
</body>
</html>
