package controller;

import controller.command.Command;
import domain.HRManager;
import viewModel.Aspirant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents a HR manager servlets.
 */
@WebServlet(name = "HRManagerServlet", urlPatterns = "/HRManager")
public class HRManagerServlet extends HttpServlet {

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

        switch (commandName) {

            case("GetHRManager"):{

                HttpSession session = request.getSession();

                String email = (String)session.getAttribute("userEmail");

                Command command = commandProvider.getCommand(commandName);
                try {
                    session.setAttribute("hr", (HRManager)command.execute(email));
                } catch (Exception e) { }

                request.getRequestDispatcher("/HRManagerDisplay.jsp").forward(request, response);

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
        }
    }

    protected void DocumentCreate(HttpServletRequest request, HttpServletResponse response, String commandName) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = (String)session.getAttribute("userEmail");

        Command command = commandProvider.getCommand(commandName);
        try {
            command.execute(email + ";HRManager");
        } catch (Exception e) { }

        request.getRequestDispatcher("/HRManagerDisplay.jsp").forward(request, response);
    }
}
