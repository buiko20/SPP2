package controller;

import controller.command.Command;
import viewModel.JobVacancy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "JobVacancyServlet", urlPatterns = "/JobVacancy")
public class JobVacancyServlet extends HttpServlet {

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

        switch (commandName){
            case("GetJobVacancy"): {

                HttpSession session = request.getSession();

                String jobVacancyName = request.getParameter("name");
                String jobVacancyCompanyName = request.getParameter("companyName");
                session.setAttribute("oldJobVacancyName", jobVacancyName);

                Command command = commandProvider.getCommand(commandName);
                try {
                    session.setAttribute("jobVacancy", (JobVacancy)command.execute(jobVacancyName + ";" + jobVacancyCompanyName));
                } catch (Exception e) { }

                request.getRequestDispatcher("/JobVacancyDisplay.jsp").forward(request, response);
                break;
            }
            case("CreateJobVacancy"):{
                Command command = commandProvider.getCommand(commandName);

                try {
                    command.execute(SetNewVacancyData(request, response));
                } catch (Exception e) { }

                request.getRequestDispatcher("/JobVacancyList?command=GetJobVacancyListForHRManager").forward(request, response);
                break;
            }
            case("UpdateJobVacancy"):{

                HttpSession session = request.getSession();

                String oldJobVacancyName = (String)session.getAttribute("oldJobVacancyName");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(oldJobVacancyName +  ";" + SetNewVacancyData(request, response));
                } catch (Exception e) { }

                request.getRequestDispatcher("/JobVacancyList?command=GetJobVacancyListForHRManager").forward(request, response);
                break;
            }
            case("DeleteJobVacancy"):{

                HttpSession session = request.getSession();

                String jobVacancyName = request.getParameter("name");
                String jobVacancyCompanyName = request.getParameter("companyName");

                Command command = commandProvider.getCommand(commandName);
                try {
                    command.execute(jobVacancyName + ";" + jobVacancyCompanyName);
                } catch (Exception e) { }

                request.getRequestDispatcher("/JobVacancyList?command=GetJobVacancyListForHRManager").forward(request, response);
                break;
            }
            default:{

            }
        }
    }

    protected String SetNewVacancyData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = (String)session.getAttribute("userEmail");
        String name = request.getParameter("Name");
        String description = request.getParameter("Description");
        String status = request.getParameter("Status");
        String address = request.getParameter("Address");

        String result = email + ";" + name + ";" + description + ";" + status + ";" + address;

        return result;
    }
}
