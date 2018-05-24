<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 15.03.2018
  Time: 15:38
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
            <a class="navbar-brand" href="/HomePageHRManager.jsp">TanJobs.by</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/ResumeList?command=GetResumeListForHRManager">Резюме</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="/InvitationList?command=GetInvitationListForHRManager">Приглашения</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="/JobVacancyList?command=GetJobVacancyListForHRManager">Вакансии</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="/Home/About">О программе</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/HRManager?command=GetHRManager" id="userAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                <li><a href="index.jsp" id="loginLink">Выход</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container body-content">
    <h2>Редактирование вакансии</h2>
    <form action="/JobVacancy" method="post"><input name="__RequestVerificationToken" type="hidden" value="RjfiaDeksEmAHGtSU-2HgMr1exVppGtfOgrdB4XrXjcUJsg1G9WPQj8lNMQqCzUAnEUufPSMW0im1iVtmSWczIQb9BS6Hvh7q6nFDn1R43c1" />
        <div class="form-horizontal">
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Name">Название вакансии</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-required="Поле не должно быть пустым" id="Name" name="Name" type="text" value="<c:out value = "${jobVacancy.name}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Position" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Status">Статус</label>
                <div class="col-md-10">
                    <select class="form-control" id="Status" name="Status">
                        <c:choose>
                            <c:when test="${jobVacancy.status != 'Активно'}">
                                <option value="Активно">Активно</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="Активно">Активно</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${jobVacancy.status != 'В архиве'}">
                                <option value="В архиве">В архиве</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="В архиве">В архиве</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Address">Адрес</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line"  id="Address" name="Address" type="text" value="<c:out value = "${jobVacancy.address}"/>"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Description">Описание</label>
                <div class="col-md-10">
                    <textarea class="input-xlarge valid" id="Description" name="Description" rows="3"><c:out value = "${jobVacancy.description}"/></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button class="btn btn-default" name="command" id="command" value="UpdateJobVacancy">Обновить резюме</button>
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

