package controller;

import controller.command.Command;
import domain.Resume;
import service.exception.AspirantAlreadyExistsException;
import service.exception.AspirantNotRegisteredException;
import service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an resume creation servlet.
 */
@WebServlet(name = "ResumeServlet", urlPatterns = "/Resume")
public class ResumeServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String commandName = request.getParameter("command");

        switch (commandName)
        {
            case("CreateResume"):
            {
                HttpSession session = request.getSession();
                String email = (String)session.getAttribute("userEmail");
                String name = request.getParameter("Name");
                String surname = request.getParameter("Surname");
                String feedbackEmail = request.getParameter("Email");
                String patronymic = request.getParameter("Patronymic");
                String sex = request.getParameter("Sex");
                String education = request.getParameter("Education");
                String dateOfBirth = request.getParameter("Date_of_birth");
                String phoneNumber = request.getParameter("Phone_number");
                String mailingAddress= request.getParameter("Mailing_address");
                String englishLevel = request.getParameter("English_level");
                String aboutMe = request.getParameter("About_me");
                String cityOfResidence = request.getParameter("City_of_residence");
                String careerObjective = request.getParameter("Position");
                String isTripPossible = request.getParameter("Business_trip");
                if(isTripPossible == null)
                    isTripPossible = "false";
                String isRelocationPossible= request.getParameter("Relocation");
                if(isRelocationPossible == null)
                    isRelocationPossible = "false";
                String skills = request.getParameter("Skills");
                String salary = request.getParameter("Salary");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(email + ";" + name + ";" + surname + ";" + feedbackEmail + ";" + patronymic + ";" + sex + ";" + education + ";" +
                            dateOfBirth + ";" + phoneNumber + ";" + mailingAddress + ";" +englishLevel + ";" + aboutMe + ";" + cityOfResidence +
                            ";" + careerObjective + ";" + isTripPossible + ";" + isRelocationPossible + ";" + skills + ";" + salary);
                } catch (Exception e) {

                }
                break;
            }
            case("EditResume"):{
                break;
            }
            case("DeleteResume"):{
                break;
            }
            case("UpdateResumeDate"):{
                break;
            }
            default:{
                //TODO: отображение конкретного резюме
            }
        }
    }
}
