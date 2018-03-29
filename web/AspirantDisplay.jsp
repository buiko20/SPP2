<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 29.03.2018
  Time: 10:39
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
            <a class="navbar-brand" href="/HomePageAspirant.jsp">TanJobs.by</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/ResumeList?command=GetResumeListForAspirant">Резюме</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="/InvitationList?command=GetInvitationListForAspirant">Приглашения</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="/JobVacancyList?command=GetJobVacancyListForAspirant">Вакансии</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="">О программе</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/Aspirant?command=GetAspirant" id="userAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                <li><a href="index.jsp" id="loginLink">Выход</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container body-content">
    <h2>Ваши данные</h2>
    <form action="/Aspirant" method="post"><input name="__RequestVerificationToken" type="hidden" value="RjfiaDeksEmAHGtSU-2HgMr1exVppGtfOgrdB4XrXjcUJsg1G9WPQj8lNMQqCzUAnEUufPSMW0im1iVtmSWczIQb9BS6Hvh7q6nFDn1R43c1" />
        <div class="form-horizontal">
            <br>
            <h4>Персональные данные</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Фамилия</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.surname}"/></h4>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2">Имя</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.name}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Отчество</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.patronymic}"/></h4>
                </div>
            </div>

            <br>
            <h4>Пол и дата рождения</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Пол</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.sex}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Дата рождения</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.dateOfBirth}"/></h4>
                </div>
            </div>

            <br>
            <h4>Контактная информация</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Адрес электронной почты</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.email}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Номер телефона</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.phoneNumber}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Почтовый адрес</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.mailingAddress}"/></h4>
                </div>
            </div>

            <br>
            <h4>Город проживания</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Город проживания</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.cityOfResidence}"/></h4>
                </div>
            </div>

            <br>
            <h4>Образование</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Образование</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.education}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Уровень английского языка</label>
                <div class="col-md-10">
                    <h4><c:out value = "${aspirant.englishLevel}"/></h4>
                </div>
            </div>

            <br>
            <h4>Ключевые навыки</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="About_me">Обо мне</label>
                <div class="col-md-10">
                    <textarea class="input-xlarge valid" id="About_me" name="About_me" rows="3"><c:out value = "${aspirant.aboutMe}"/></textarea>
                </div>
            </div>
                <div class="form-group">

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <a class="btn btn-default resume-btn" href="/Aspirant?command=CreatePdf">PDF</a>
                        <a class="btn btn-default resume-btn" href="/Aspirant?command=CreateCsv">CSV</a>
                        <a class="btn btn-default resume-btn" href="/Aspirant?command=CreateXls">XLS</a>
                    </div>
                </div>
        </div>
    </form>
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
