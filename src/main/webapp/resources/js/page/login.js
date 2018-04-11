//更换验证码
function change() {
	var img = document.getElementById("img");
	// 加一个无意义的参数，目的就是让地址每次都发生变化
	img.src = "${pageContext.request.contextPath }/VerificationCodeServlet?" + new Date().getTime();
}