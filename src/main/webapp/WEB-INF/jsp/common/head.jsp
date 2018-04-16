<meta name="author" content="lewis">

<!-- charset是HTML5中的新属性，替换了：<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- 也可以选择使用 http-equiv 属性来规定字符集，但是使用charset可以减少代码量 -->
<!-- 这里的编码是服务端发送给客户端使用的内容编码，如果浏览器的默认编码与该编码不同则会乱码 -->
<meta charset="utf-8">

<!-- 让IE使用最新的渲染模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- 针对移动设备,网站显示宽度等于设备屏幕显示宽度,内容缩放比例为1:1 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 让部分国产浏览器默认采用高速模式渲染页面 -->
<meta name="renderer" content="webkit">

<!-- 将所有相对路径的基础路径设为项目根路径，将所有超链的打开方式设为另起空白页 -->
<base href="${pageContext.request.contextPath}/" target="_blank">

<!-- 在页面地址栏左边显示图标 -->
<link rel="shortcut icon" href="resources/images/em.ico" />

<!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
