<%@ page language="java" contentType="text/html;charset=gb2312" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Orders Web</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="content/static/css/bootstrap/3.2.0/bootstrap.min.css" />
    <link rel="stylesheet" href="content/static/css/bootstrap/3.2.0/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="content/static/css/common/sticky-footer-navbar.css" />
    <link rel="stylesheet" href="content/static/css/common/bootstrap-customized.css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>