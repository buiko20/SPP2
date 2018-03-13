<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 03.03.2018
  Time: 14:24
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
                <li><a href="index.jsp" id="userAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                <li><a href="index.jsp" id="loginLink">Выход</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container body-content">
    <h2>Ваши резюме</h2>
    <form action="/Resume" method="post"><input name="__RequestVerificationToken" type="hidden" value="RjfiaDeksEmAHGtSU-2HgMr1exVppGtfOgrdB4XrXjcUJsg1G9WPQj8lNMQqCzUAnEUufPSMW0im1iVtmSWczIQb9BS6Hvh7q6nFDn1R43c1" />
        <div class="form-horizontal">
            <h4>Выберите резюме для просмотра</h4>
            <hr />
            <c:if test="${resumeList.size() != 0}">
            <c:forEach var = "i" begin = "0" end = "${resumeList.size()-1}">
            <div class="form-group">
                <div class="col-md-10">
                    <h6>Дата последнего обновления: <c:out value = "${resumeList.get(i).date}"/></h6>
                    <h3><a href="/Resume?careerObjective=${resumeList.get(i).careerObjective}&command=GetResume&aspirantId=${resumeList.get(i).aspirantId}"><c:out value = "${resumeList.get(i).careerObjective}"/></a></h3>
                    <c:if test="${actor != 'hr'}">
                        <h5>Количество просмотров: <a href="/Resume?careerObjective=${resumeList.get(i).careerObjective}&command=GetResumeViewList"><c:out value = "${resumeList.get(i).numberOfViews}"/></a></h5>
                        <h6><a href="/Resume?careerObjective=${resumeList.get(i).careerObjective}&command=UpdateResumeDate">Обновить дату</a></h6>
                    </c:if>
                    <c:if test="${actor != 'aspirant'}">
                        <h5>Соискатель №<c:out value = "${resumeList.get(i).aspirantId}"/></h5>
                    </c:if>
                </div>
            </div>
            <hr/>
            </c:forEach>
            </c:if>

            <c:if test="${actor != 'hr'}">
                <div class="form-group form-right">
                    <a class="btn btn-success resume-btn" href="ResumeCreation.jsp">Создать резюме</a>
                </div>
            </c:if>
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
