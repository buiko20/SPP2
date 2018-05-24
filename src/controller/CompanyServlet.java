package controller;

import controller.command.Command;
import domain.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents a company servlet.
 */
@WebServlet(name = "CompanyServlet", urlPatterns = "/Company")
public class CompanyServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String commandName = request.getParameter("command");

        Command command = commandProvider.getCommand(commandName);
        try {
            Company company = (Company)command.execute(request.getParameter("companyName"));
            session.setAttribute("company", company);
        } catch (Exception e) { }

        request.getRequestDispatcher("/CompanyDisplay.jsp").forward(request, response);
    }
}
