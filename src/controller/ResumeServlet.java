package controller;

import controller.command.Command;
import viewModel.AspirantResume;
import viewModel.ResumeView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a resume creation servlet.
 */
@WebServlet(name = "ResumeServlet", urlPatterns = "/Resume")
public class ResumeServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String commandName = request.getParameter("command");

        switch (commandName)
        {
            case("CreateResume"):
            {
                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(SetNewResumeData(request, response));
                } catch (Exception e) { }

                request.getRequestDispatcher("/ResumeList?command=GetResumeListForAspirant").forward(request, response);
                break;
            }

            case("GetResume"):{
                HttpSession session = request.getSession();

                String email = (String)session.getAttribute("userEmail");
                String aspirantId = request.getParameter("aspirantId");
                String careerObjective = request.getParameter("careerObjective");
                session.setAttribute("oldCareerObjective", careerObjective);

                Command command = commandProvider.getCommand(commandName);
                try {
                    if(session.getAttribute("actor").toString() == "aspirant")
                        session.setAttribute("resume", (AspirantResume)command.execute(email + ";" + careerObjective));
                    else
                        session.setAttribute("resume", (AspirantResume)command.execute(aspirantId + ";" + careerObjective + ";" + email));
                } catch (Exception e) { }

                request.getRequestDispatcher("/ResumeDisplay.jsp").forward(request, response);
                break;
            }

            case("UpdateResume"):{
                HttpSession session = request.getSession();

                String oldCareerObjective = (String)session.getAttribute("oldCareerObjective");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute( oldCareerObjective + ";" + SetNewResumeData(request, response));
                } catch (Exception e) { }

                request.getRequestDispatcher("/ResumeList?command=GetResumeListForAspirant").forward(request, response);
                break;
            }

            case("DeleteResume"):{
                GetAndSetSessionAttributes(request, response,commandName);
                request.getRequestDispatcher("/ResumeList?command=GetResumeListForAspirant").forward(request, response);
                break;
            }

            case("UpdateResumeDate"):{
                GetAndSetSessionAttributes(request, response,commandName);
                request.getRequestDispatcher("/ResumeList?command=GetResumeListForAspirant").forward(request, response);
                break;
            }

            case("GetResumeViewList"):{
                HttpSession session = request.getSession();

                String email = (String)session.getAttribute("userEmail");
                String careerObjective = request.getParameter("careerObjective");

                Command command = commandProvider.getCommand(commandName);
                try {
                    session.setAttribute("viewList", (ArrayList<ResumeView>)command.execute(email + ";" + careerObjective));
                } catch (Exception e) { }

                request.getRequestDispatcher("/ResumeViewList.jsp").forward(request, response);
                break;
            }
            case("CreatePdf"):{

                DocumentCreate(request, response, commandName);

                response.setContentType("text/pdf");
                break;
            }
            case("CreateCsv"):{

                DocumentCreate(request, response, commandName);

                response.setContentType("text/csv");
                break;
            }
            case("CreateXls"):{

                DocumentCreate(request, response, commandName);

                response.setContentType("text/xls");
                break;
            }
            default:{
            }
        }
    }

    protected void GetAndSetSessionAttributes(HttpServletRequest request, HttpServletResponse response, String commandName)
    {
        HttpSession session = request.getSession();

        String email = (String)session.getAttribute("userEmail");
        String careerObjective = request.getParameter("careerObjective");

        Command command = commandProvider.getCommand(commandName);
        try {
            command.execute(email + ";" + careerObjective);
        } catch (Exception e) { }

    }

    protected void DocumentCreate(HttpServletRequest request, HttpServletResponse response, String commandName) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = (String)session.getAttribute("userEmail");
        String aspirantId = request.getParameter("aspirantId");
        String careerObjective = request.getParameter("careerObjective");

        Command command = commandProvider.getCommand(commandName);
        try {
            if(session.getAttribute("actor").toString() == "aspirant")
                command.execute(email + ";" + careerObjective + ";Resume");
            else
                command.execute(aspirantId + ";" + careerObjective + ";" + email + ";Resume");
        } catch (Exception e) { }

        if((String)session.getAttribute("actor") == "aspirant")
            request.getRequestDispatcher("/ResumeList?command=GetResumeListForAspirant").forward(request, response);
        else
            request.getRequestDispatcher("/ResumeList?command=GetResumeListForHRManager").forward(request, response);

    }

    protected String SetNewResumeData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if(salary.equals(""))
            salary = "0.0";

        String result = email + ";" + name + ";" + surname + ";" + feedbackEmail + ";" + patronymic + ";" + sex + ";" + education + ";" +
                dateOfBirth + ";" + phoneNumber + ";" + mailingAddress + ";" +englishLevel + ";" + aboutMe + ";" + cityOfResidence +
                ";" + careerObjective + ";" + isTripPossible + ";" + isRelocationPossible + ";" + skills + ";" + salary;

        return result;
    }
}
