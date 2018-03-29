<%--
  Created by IntelliJ IDEA.
  User: Анастасия
  Date: 07.03.2018
  Time: 17:13
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
                <li><a href="/Home/About">О программе</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/Aspirant?command=GetAspirant" id="userAccountLink" name="userEmail"><c:out value="${userEmail}"/></a></li>
                <li><a href="index.jsp" id="loginLink">Выход</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container body-content">
    <h2>Редактирование резюме</h2>
    <form action="/Resume" method="post"><input name="__RequestVerificationToken" type="hidden" value="RjfiaDeksEmAHGtSU-2HgMr1exVppGtfOgrdB4XrXjcUJsg1G9WPQj8lNMQqCzUAnEUufPSMW0im1iVtmSWczIQb9BS6Hvh7q6nFDn1R43c1" />
        <div class="form-horizontal">
            <h4>Желаемая должность</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Position">Желаемая должность</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-required="Поле не должно быть пустым" id="Position" name="Position" type="text" value="<c:out value = "${resume.careerObjective}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Position" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Salary">Зарплата</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" id="Salary" name="Salary" type="text" value="<c:out value = "${resume.salary}"/>" />
                </div>
            </div>

            <br>
            <h4>Персональные данные</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Photo">Фото</label>
                <div class="col-md-10">
                    <input class="input-file" id="Photo" name="Photo" type="file" value="" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Photo" data-valmsg-replace="true"></span>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2" for="Surname">Фамилия</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-required="Поле не должно быть пустым" id="Surname" name="Surname" type="text" value="<c:out value = "${resume.surname}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Surname" data-valmsg-replace="true"></span>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-2" for="Name">Имя</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-required="Поле не должно быть пустым" id="Name" name="Name" type="text" value="<c:out value = "${resume.name}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Name" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Patronymic">Отчество</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" id="Patronymic" name="Patronymic" type="text" value="<c:out value = "${resume.patronymic}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Patronymic" data-valmsg-replace="true"></span>
                </div>
            </div>

            <br>
            <h4>Пол и дата рождения</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Sex">Пол</label>
                <div class="col-md-10">
                    <select class="form-control" id="Sex" name="Sex">
                        <c:choose>
                            <c:when test="${resume.sex != 'Мужской'}">
                                <option value="Мужской">Мужской</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="Мужской">Мужской</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.sex != 'Женский'}">
                                <option value="Женский">Женский</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="Женский">Женский</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Date_of_birth">Дата рождения</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-date="Поле Дата рождения должно содержать дату." id="Date_of_birth" name="Date_of_birth" type="date" value="<c:out value = "${resume.dateOfBirth}"/>"/>
                    <span class="field-validation-valid text-danger" data-valmsg-for="Date_of_birth" data-valmsg-replace="true"></span>
                </div>
            </div>

            <br>
            <h4>Контактная информация</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Email">Адрес электронной почты</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true"  data-val-phone="Адрес электронной почты указан неверно" id="Email" name="Email" type="email" value="<c:out value = "${resume.email}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Email" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Phone_number">Номер телефона</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" data-val="true" data-val-phone="Номер телефона указан неверно" id="Phone_number" name="Phone_number" type="tel" value="<c:out value = "${resume.phoneNumber}"/>" />
                    <span class="field-validation-valid text-danger" data-valmsg-for="Phone_number" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Mailing_address">Почтовый адрес</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" id="Mailing_address" name="Mailing_address" type="text" value="<c:out value = "${resume.mailingAddress}"/>" />
                </div>
            </div>

            <br>
            <h4>Город проживания</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="City_of_residence">Город проживания</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" id="City_of_residence" name="City_of_residence" type="text" value="<c:out value = "${resume.cityOfResidence}"/>" />
                </div>
            </div>

            <br>
            <h4>Образование</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Education">Образование</label>
                <div class="col-md-10">
                    <input class="form-control text-box single-line" id="Education" name="Education" type="text" value="<c:out value = "${resume.education}"/>" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="English_level">Уровень английского языка</label>
                <div class="col-md-10">
                    <select class="form-control" id="English_level" name="English_level">
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'A1'}">
                                <option value="A1">A1 - Beginner, Elementary</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="A1">A1 - Beginner, Elementary</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'A2'}">
                                <option value="A2">A2 - Pre-Intermediate</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="A2">A2 - Pre-Intermediate</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'B1'}">
                                <option value="B1">B1 - Intermediate</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="B1">B1 - Intermediate</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'B2'}">
                                <option value="B2">B2 - Upper-Intermediate</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="B2">B2 - Upper-Intermediate</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'C1'}">
                                <option value="C1">C1 - Advanced</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="C1">C1 - Advanced</option>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${resume.englishLevel != 'C2'}">
                                <option value="C2">C2 - Proficiency</option>
                            </c:when>
                            <c:otherwise>
                                <option selected value="C2">C2 - Proficiency</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>

            <br>
            <h4>Командировки и переезд</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Business_trip">Готовность к командировкам</label>
                <div class="col-md-10">
                    <label class="checkbox">
                        <input id="Business_trip" name="Business_trip" type="checkbox" value="true"
                                <c:if test="${resume.isTripPossible != 'Нет'}">
                                    checked="checked"
                                </c:if>
                        />
                    </label>
                    <span class="field-validation-valid text-danger" data-valmsg-for="Business_trip" data-valmsg-replace="true"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="Relocation">Готовность к переезду</label>
                <div class="col-md-10">
                    <label class="checkbox">
                        <input id="Relocation" name="Relocation" type="checkbox"  value="true"
                            <c:if test="${resume.isRelocationPossible != 'Нет'}">
                                checked="checked"
                            </c:if>
                        />
                    </label>
                </div>
            </div>

            <br>
            <h4>Ключевые навыки</h4>
            <hr />
            <div class="form-group">
                <label class="control-label col-md-2" for="Skills">Ключевые навыки</label>
                <div class="col-md-10">
                    <textarea class="input-xlarge valid" id="Skills" name="Skills" rows="1"><c:out value = "${resume.skills}"/></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-2" for="About_me">Обо мне</label>
                <div class="col-md-10">
                    <textarea class="input-xlarge valid" id="About_me" name="About_me" rows="3"><c:out value = "${resume.aboutMe}"/></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button class="btn" name="command" value="UpdateResume">Обновить резюме</button>
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

