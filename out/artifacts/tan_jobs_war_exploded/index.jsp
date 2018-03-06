<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.02.2018
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
  <head>
    <link rel="shortcut icon" href="/WEB-INF/images/favicon.png" type="image/png">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TanJobs.by</title>
</head>
<body>
  <style>
    <%@include file="/WEB-INF/styles/bootstrap.css"%>
    <%@include file="/WEB-INF/styles/Site.css"%>
  </style>
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">TanJobs.by</a>
      </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="/Home/About">О программе</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="AspirantRegistration.jsp" id="registerLink">Регистрация</a></li>
          <li><a href="AspirantLogin.jsp" id="loginLink">Вход</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="container body-content">
    <div class="jumbotron">
      <h1>Хочешь найти работу?</h1>
      <div class="col-md-4">
        <h2>1</h2>
        <p>Создай резюме, чтобы работодатель узнал о тебе</p>
        <p><a class="btn btn-success" href="AspirantLogin.jsp">Создать резюме</a></p>
      </div>
      <div class="col-md-4">
        <h2>2</h2>
        <p>Найди вакансию, которая придется тебе по вкусу</p>
        <p><a class="btn btn-success" href="/Home/About">Найти вакансию</a></p>
      </div>
    </div>
    <hr/>
    <footer>
      <p>&copy; 2018 – БГУИР, ПОИТ, 551003</p>
    </footer>
  </div>
  <script type="text/javascript"> <%@include file="/WEB-INF/scripts/snow-fall.js"%></script>
  </body>
</html>
