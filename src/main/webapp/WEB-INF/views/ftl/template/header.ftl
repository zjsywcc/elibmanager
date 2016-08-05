<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<#if Session["SPRING_SECURITY_CONTEXT"]?exists>
    <#assign username = Session["SPRING_SECURITY_CONTEXT"].authentication.name />
</#if>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>eLib manager</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="/resources/css/carousel.css" rel="stylesheet">

    <!-- Custom styles for own page -->
    <link href="/resources/css/main.css" rel="stylesheet">
</head>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">eLib Manager</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/">Home</a></li>
                        <li><a href="/bookList">Booklist</a></li>
                        <li><a href="/admin">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                    <li class="dropdown pull-right">
                    <#if username??>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">${username}<span class="caret"></span></a>
                        <#if username = "admin">
                            <ul class="dropdown-menu">
                                <li><a href="/admin/bookInventory">BookInventory</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="/j_spring_security_logout">Logout</a></li>
                            </ul>
                        </#if>
                    <#else>
                        <li><a href="/login">Login</a></li>
                    </#if>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>