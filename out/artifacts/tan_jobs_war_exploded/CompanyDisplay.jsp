<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 12.03.2018
  Time: 20:33
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
            <c:if test="${actor != 'aspirant'}">
                <a class="navbar-brand" href="/HomePageHRManager.jsp">TanJobs.by</a>
            </c:if>
            <c:if test="${actor != 'hr'}">
                <a class="navbar-brand" href="/HomePageAspirant.jsp">TanJobs.by</a>
            </c:if>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <c:if test="${actor != 'hr'}">
                    <li><a href="/ResumeList?command=GetResumeListForAspirant">Резюме</a></li>
                </c:if>
                <c:if test="${actor != 'aspirant'}">
                    <li><a href="/ResumeList?command=GetResumeListForHRManager">Резюме</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav">
                <c:if test="${actor != 'hr'}">
                    <li><a href="/InvitationList?command=GetInvitationListForAspirant">Приглашения</a></li>
                </c:if>
                <c:if test="${actor != 'aspirant'}">
                    <li><a href="/InvitationList?command=GetInvitationListForHRManager">Приглашения</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav">
                <c:if test="${actor != 'hr'}">
                    <li><a href="/JobVacancyList?command=GetJobVacancyListForAspirant">Вакансии</a></li>
                </c:if>
                <c:if test="${actor != 'aspirant'}">
                    <li><a href="/JobVacancyList?command=GetJobVacancyListForHRManager">Вакансии</a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav">
                <li><a href="">О программе</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${actor != 'hr'}">
                    <li><a href="/Aspirant?command=GetAspirant" id="userAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                </c:if>
                <c:if test="${actor != 'aspirant'}">
                    <li><a href="/HRManager?command=GetHRManager" id="HRAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                </c:if>
                <li><a href="index.jsp" id="loginLink">Выход</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container body-content">
    <h2>Данные компании</h2>
    <form action="" method="post"><input name="__RequestVerificationToken" type="hidden" value="RjfiaDeksEmAHGtSU-2HgMr1exVppGtfOgrdB4XrXjcUJsg1G9WPQj8lNMQqCzUAnEUufPSMW0im1iVtmSWczIQb9BS6Hvh7q6nFDn1R43c1" />
        <div class="form-horizontal">
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2">Название</label>
                <div class="col-md-10">
                    <h4><c:out value = "${company.name}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Номер телефона</label>
                <div class="col-md-10">
                    <h4><c:out value = "${company.phoneNumber}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Почтовый адрес</label>
                <div class="col-md-10">
                    <h4><c:out value = "${company.mailingAddress}"/></h4>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2">Адрес электронной почты</label>
                <div class="col-md-10">
                    <h4><c:out value = "${company.email}"/></h4>
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

