package controller;

import controller.command.Command;
import domain.Invitation;
import viewModel.AspirantInvitation;
import viewModel.AspirantResume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InvitationServlet", urlPatterns = "/Invitation")
public class InvitationServlet extends HttpServlet {

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

        switch(commandName){
            case("SendInvitation"):{

                HttpSession session = request.getSession();
                String email = (String)session.getAttribute("userEmail");
                AspirantResume resume = (AspirantResume)session.getAttribute("resume");
                String resumeCareerObjective = resume.getCareerObjective();
                String aspirantEmail = resume.accountEmail;
                String jobVacancyName = request.getParameter("JobVacancyName");

                String address = request.getParameter("Address");
                String date = request.getParameter("Date");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(email + ";" + aspirantEmail + ";" + resumeCareerObjective + ";" + jobVacancyName
                            + ";" + address + ";" + date);
                } catch (Exception e) { }

                request.getRequestDispatcher("/InvitationList?command=GetInvitationListForHRManager").forward(request, response);

                break;
            }

            case("GetInvitation"):{
                HttpSession session = request.getSession();

                String aspirantEmail = request.getParameter("aspirantEmail");
                String careerObjective = request.getParameter("careerObjective");
                String jobVacancyName = request.getParameter("jobVacancyName");
                String companyName = request.getParameter("companyName");

                Command command = commandProvider.getCommand(commandName);
                try {
                    AspirantInvitation aspirantInvitation = (AspirantInvitation)command.execute(aspirantEmail + ";" + careerObjective + ";" + jobVacancyName
                            + ";" + companyName);
                    session.setAttribute("invitation", aspirantInvitation);
                } catch (Exception e) { }

                request.getRequestDispatcher("/InvitationDisplay.jsp").forward(request, response);

                break;
            }
            case("CreatePdf"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }
            case("CreateCsv"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }
            case("CreateXls"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }

        }
    }

    protected String DocumentCreate(HttpServletRequest request, HttpServletResponse response, String commandName) throws ServletException, IOException {

        String result = "";

        String aspirantEmail = request.getParameter("aspirantEmail");
        String careerObjective = request.getParameter("careerObjective");
        String jobVacancyName = request.getParameter("jobVacancyName");
        String companyName = request.getParameter("companyName");

        Command command = commandProvider.getCommand(commandName);
        try {
            result = (String) command.execute(aspirantEmail + ";" + careerObjective + ";" + jobVacancyName
                    + ";" + companyName + ";Invitation");
        } catch (Exception e) { }

        return result;
    }
}
