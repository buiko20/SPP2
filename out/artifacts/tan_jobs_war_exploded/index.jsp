<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.02.2018
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>

  <head>
    <title>Resume view</title>
  </head>

  <body>

  <left><H2>Aspirant profile</H2></left>

  <form action = "control" method = "GET">
    <table border = "0">
      <tr>
        <td><b>Name:</b></td>
        <td><c:out value = "${aspirantInfo.name}"/></td>
      </tr>

      <tr>
        <td><b>Surname: </b></td>
        <td><c:out value = "${aspirantInfo.surname}"/></td>
      </tr>

      <tr>
        <td><b>Patronymic: </b></td>
        <td><c:out value = "${aspirantInfo.patronymic}"/></td>
      </tr>

      <tr>
        <td><b>Sex: </b></td>
        <td><c:out value = "${aspirantInfo.sex}"/></td>
      </tr>
      <tr>
        <td><b>Education: </b></td>
        <td><c:out value = "${aspirantInfo.education}"/></td>
      </tr>

      <tr>
        <td><b>Date of birth: </b></td>
        <td><c:out value = "${aspirantInfo.dateOfBirth}"/></td>
      </tr>

      <tr>
        <td><b>Phone number: </b></td>
        <td><c:out value = "${aspirantInfo.phoneNumber}"/></td>
      </tr>

      <tr>
        <td><b>Email: </b></td>
        <td><c:out value = "${aspirantInfo.email}"/></td>
      </tr>

      <tr>
        <td><b>Mailing address: </b></td>
        <td><c:out value = "${aspirantInfo.mailingAddress}"/></td>
      </tr>

      <tr>
        <td><b>English level: </b></td>
        <td><c:out value = "${aspirantInfo.englishLevel}"/></td>
      </tr>

      <tr>
        <td><b>About aspirant: </b></td>
        <td><c:out value = "${aspirantInfo.aboutMe}"/></td>
      </tr>

      <tr>
        <td><b>City of residence: </b></td>
        <td><c:out value = "${aspirantInfo.cityOfResidence}"/></td>
      </tr>


      <tr>
        <td></td>
        <td><input type = "submit" name="command" align="center" value = "Get aspirant info"/></td>
      </tr>

    </table>
  </form>
  </body>
</html>
