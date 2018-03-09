<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 23.02.2018
  Time: 0:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="favicon.png" type="image/png">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>
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
    <h2>Выполнить вход</h2>
    <div class="row">
        <div class="col-md-8">
            <section id="loginForm">
                <form action="/Login" class="form-horizontal" method="post" role="form"><input name="__RequestVerificationToken" type="hidden" value="4AoxbWStn7xKrt5MoFKRzHldMWOmvLubey4L-0PRIByJIj4lmRssKcihJnAVD9IW3yOXre1zx3pN7xrLNKud5MuCkOtViF3cN-02ZpoxgkM1" />
                    <h4>Используйте локальную учетную запись для входа</h4>
                    <hr />
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="Email">Адрес электронной почты</label>
                        <div class="col-md-10">
                            <input class="form-control" data-val="true" data-val-email="Поле Адрес электронной почты не содержит допустимый адрес электронной почты." data-val-required="Требуется поле Адрес электронной почты." id="Email" name="Email" type="text" value="<c:out value="${loginEmail}"/>" />
                            <span class="field-validation-valid text-danger" data-valmsg-for="Email" data-valmsg-replace="true"></span>
                            <span class="field-validation-valid text-danger">  <c:out value="${loginEmailIncorrect}"/> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="Password">Пароль</label>
                        <div class="col-md-10">
                            <input class="form-control" data-val="true" data-val-required="Требуется поле Пароль." id="Password" name="Password" type="password" value="<c:out value="${loginPassword}"/>"/>
                            <span class="field-validation-valid text-danger" data-valmsg-for="Password" data-valmsg-replace="true"></span>
                            <span class="field-validation-valid text-danger">  <c:out value="${loginPasswordIncorrect}"/> </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <div class="checkbox">
                                <input data-val="true" data-val-required="Требуется поле Запомнить меня." id="RememberMe" name="RememberMe" type="checkbox" value="true" /><input name="RememberMe" type="hidden" value="false" />
                                <label for="RememberMe">Запомнить меня</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <button class="btn" name="command" value="Login">Выполнить вход</button>
                        </div>
                    </div>
                    <p>
                        <a href="AspirantRegistration.jsp">Регистрация нового пользователя</a>
                    </p>
                    <div class="col-md-2 control-label">
                    </div>
                </form>
            </section>
        </div>
    </div>
    <hr/>
    <footer>
        <p>&copy; 2018 – БГУИР, ПОИТ, 551003</p>
    </footer>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.js"></script>

<script type="text/javascript"> <%@include file="WEB-INF/scripts/respond.js"%> </script>
<script type="text/javascript"> <%@include file="WEB-INF/scripts/jquery.validate.unobtrusive.js"%> </script>
<script type="text/javascript"> <%@include file="WEB-INF/scripts/snow-fall.js"%> </script>
</body>
</html>
