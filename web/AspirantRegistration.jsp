<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 23.02.2018
  Time: 0:35
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
        <title>Регистрация</title>
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
                    <li><a href="Login.jsp" id="loginLink">Вход</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container body-content">
        <h2>Регистрация</h2>
        <form action="/Register" method="post">
            <input name="__RequestVerificationToken" type="hidden" value="CMJYaT6JjpXbxzblFFsc_oJ8NxE6G7xP7oJ4sdJk-7WW94O3hMwsOHNVb1zKtaEqxXjrPL1elE93lX0f5v3-ajql1bjAr4KfdUNe9xJBvWo1" /> <div class="form-horizontal">
            <h4>Создайте новую учетную запись</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Email">Адрес электронной почты</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-email="Адрес электронной почты содержит недопустимые символы." data-val-required="Введите адрес электронной почты." id="Email" name="Email" type="email" value="<c:out value="${registrationEmail}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Email" data-valmsg-replace="true"></span>
                    <span class="field-validation-valid text-danger">  <c:out value="${registrationEmailIncorrect}"/> </span>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2" for="Password">Пароль</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line password" data-val="true" data-val-length="Пароль должен содержать не менее 6 символов." data-val-length-max="20" data-val-length-min="6" data-val-required="Введите пароль." id="Password" name="Password" type="password" value="<c:out value="${registrationPassword}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Password" data-valmsg-replace="true"></span>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2" for="ConfirmPassword">Подтверждение пароля</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line password" data-val="true" data-val-equalto="Пароль и его подтверждение не совпадают." data-val-equalto-other="*.Password" id="ConfirmPassword" name="ConfirmPassword" type="password" value="<c:out value="${registrationPassword}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="ConfirmPassword" data-valmsg-replace="true"></span>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button class="btn" name="command" value="Register">Зарегистрироваться</button>
                </div>
            </div>>
        </div>
        </form>
        <hr />
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

