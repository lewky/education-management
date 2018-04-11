<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎登陆教务管理系统!</title>
<link rel="stylesheet" type="text/css" href="resources/css/login.css" charset="utf-8">
<style type="text/css">
.login_bg {
    background-image: url(resources/images/login_bg.jpg);
}

.login_right {
    background-image: url(resources/images/login_right.png);
}
</style>
</head>
<body class="login_bg">
    <form action="${pageContext.request.contextPath }/Controller?op=login" method="post">
        <input type="hidden" name="validate" value="">
        <div class="login_main">
            <div>
                <img src="resources/images/school_logo.png" width="30%" align="top"> <img
                    src="resources/images/project_logo.png" width="37%" align="top" style="margin-left: 20px">
            </div>
            <div class="login_left">
                <img src="resources/images/login_left.png">
            </div>
            <div class="login_right">
                <img src="resources/images/login_right2.png" width="60%"
                    style="margin-left: 110px; margin-top: 20px; margin-bottom: 20px"><br> <label
                    style="margin-left: 55px">用户名：</label><input type="text" name="username"
                    style="width: 45%; margin-top: 10px; color: gray"
                    value="${sessionScope.username == null?'请输入学号或工号':sessionScope.username }"
                    onfocus="if(this.value=='请输入学号或工号'){this.value='';this.style.color='black';}else{this.style.color='black'}"
                    onblur="if(this.value==''){this.style.color='gray';this.value='请输入学号或工号';}else{this.style.color='gray'}">
                <br> <label style="margin-left: 55px">密&ensp;&ensp;码：</label><input type="text" name="password"
                    style="width: 45%; margin-top: 10px; color: gray" value="请输入密码"
                    onfocus="if(this.value=='请输入密码'){this.value='';this.style.color='black';this.type='password';}"
                    onblur="if(this.value==''){this.style.color='gray';this.value='请输入密码';this.type='text';}"> <br>
                <label style="margin-left: 55px">验证码：</label><input type="text" name="code"
                    style="width: 20%; margin-top: 10px; vertical-align: bottom; color: gray" value="请输入验证码"
                    onfocus="if(this.value=='请输入验证码'){this.value='';this.style.color='black';}"
                    onblur="if(this.value==''){this.style.color='gray';this.value='请输入验证码';}"> <img
                    src="${pageContext.request.contextPath }/VerificationCodeServlet" id="img" title="看不清楚，换一张"
                    style="padding-bottom: 0px; vertical-align: bottom" onclick="javascript:change()">&nbsp;&nbsp;<a
                    href="javascript:change()">换一张</a> <br> <label style="margin-left: 55px">用户类型:</label>&nbsp;&nbsp;
                <select name="usertype" style="margin-top: 10px">
                    <option value="student">学生</option>
                    <option value="teacher">教师</option>
                    <option value="manager">管理员</option>
                </select> <input type="submit" value="登陆" style="margin-left: 10px"> <span style="color: red">${sessionScope.error}</span>
            </div>
        </div>
    </form>
    <script src="resources/js/page/login.js" charset="utf-8"></script>
</body>
</html>