package controller;

import controller.command.Command;
import viewModel.Aspirant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents an aspirant information servlet.
 */
@WebServlet(name = "ShowAspirantInfoServlet", urlPatterns = "/control")
public class ShowAspirantInfoServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    // TODO: Read about Post-Redirect-Get pattern in general then in java servlets.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter("command");
        Command command = commandProvider.getCommand(commandName);

        HttpSession userSession = request.getSession();
        userSession.setAttribute("aspirantInfo", (Aspirant)command.execute("user@gmail.com"));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
