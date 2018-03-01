package controller;

import controller.command.Command;
import service.exception.AspirantAlreadyExistsException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents an aspirant registration servlet.
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = "/Register")
public class RegistrationServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String commandName = request.getParameter("command");

        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        Command command = commandProvider.getCommand(commandName);
        try{
            command.execute(email + ";" + password);

            HttpSession userSession = request.getSession();

            userSession.setAttribute("userEmail", email);

            request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
        }
        catch(Exception incorrectEmail)
        {
            HttpSession userSession = request.getSession();

            userSession.setAttribute("registrationEmailIncorrect", "Аккаунт с таким Email уже существует.");
            userSession.setAttribute("registrationEmail", email);
            userSession.setAttribute("registrationPassword", password);

            request.getRequestDispatcher("/AspirantRegistration.jsp").forward(request, response);

            userSession.invalidate();
        }
    }
}
