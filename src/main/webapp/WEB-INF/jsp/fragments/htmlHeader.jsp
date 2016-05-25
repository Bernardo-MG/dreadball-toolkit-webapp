<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset='utf-8'>

    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- IE Compatibility tag -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Dreadball Toolkit</title>

    <!-- Metadata -->
    <meta name="description"
          content="Dreadball Toolkit">
    <meta name="keywords" content="Dreadball, team builder">
    <meta name="author" content="Bernardo Martínez Garrido">

    <!-- CSS -->
    <spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" var="bootstrapCss"/>
    <link rel="stylesheet" href="${ bootstrapCss }">
    <spring:url value="/webjars/bootswatch-simplex/3.3.5+4/css/bootstrap.min.css" var="bootstrapCss"/>
    <link rel="stylesheet" href="${ bootstrapCss }">
    <spring:url value="/webjars/font-awesome/4.6.2/css/font-awesome.min.css" var="fontAwesomeCss"/>
    <link rel="stylesheet" href="${ fontAwesomeCss }">
    <!-- Docs Template style -->
    <spring:url value="/resources/css/style.css" var="mainCss"/>
    <link rel="stylesheet" href="${ mainCss }">

    <!-- HTML5 Shiv. For IE6-8 support of HTML5 elements -->
    <spring:url value="/webjars/html5shiv/3.7.3/html5shiv.min.js" var="html5shiv"/>
    <!--[if lt IE 9]>
    <script src="${ html5shiv }"></script>
    <![endif]-->
</head>
