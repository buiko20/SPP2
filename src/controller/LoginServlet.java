package controller;

import controller.command.Command;
import service.exception.AspirantNotRegisteredException;
import viewModel.Aspirant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents an aspirant login servlet.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String commandName = request.getParameter("command");

        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        Command command = commandProvider.getCommand(commandName);

        try {
            if(command.execute(email + ";" + password) != null) {
                HttpSession userSession = request.getSession();

                userSession.setAttribute("userEmail", email);

                request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
            }
            else{
                HttpSession userSession = request.getSession();

                userSession.setAttribute("loginEmail", email);
                userSession.setAttribute("loginPasswordIncorrect", "Неправильный пароль. Повторите ввод.");

                request.getRequestDispatcher("/AspirantLogin.jsp").forward(request, response);

                userSession.invalidate();
            }
        }
        catch (Exception incorrectEmailException)
        {
            HttpSession userSession = request.getSession();

            userSession.setAttribute("loginEmailIncorrect", "Неправильный Email. Повторите ввод.");
            userSession.setAttribute("loginEmail", email);

            request.getRequestDispatcher("/AspirantLogin.jsp").forward(request, response);

            userSession.invalidate();
        }
    }
}
