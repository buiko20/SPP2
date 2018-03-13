package controller;

import controller.command.Command;
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
                String jobVacancyName = request.getParameter("jobVacancyName");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(email + ";" + aspirantEmail + ";" + resumeCareerObjective + ";" + jobVacancyName);
                } catch (Exception e) { }

                request.getRequestDispatcher("/InvitationList?command=GetInvitationListForHRManager").forward(request, response);

                break;
            }

            case("GetInvitation"):{
                break;
            }
        }
    }
}
