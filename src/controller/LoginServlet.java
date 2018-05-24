package controller;

import controller.command.Command;
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
            String actor = (String)command.execute(email + ";" + password);

            if( actor == "") {
                HttpSession userSession = request.getSession();

                userSession.setAttribute("loginEmailIncorrect", "Неправильный Email. Повторите ввод.");
                userSession.setAttribute("loginEmail", email);

                request.getRequestDispatcher("/Login.jsp").forward(request, response);

                userSession.invalidate();
            }

            if(actor == "error"){
                HttpSession userSession = request.getSession();

                userSession.setAttribute("loginEmail", email);
                userSession.setAttribute("loginPasswordIncorrect", "Неправильный пароль. Повторите ввод.");

                request.getRequestDispatcher("/Login.jsp").forward(request, response);

                userSession.invalidate();
            }

            if( actor == "hr" || actor == "aspirant") {
                HttpSession userSession = request.getSession();

                userSession.setAttribute("userEmail", email);
                userSession.setAttribute("actor", actor);

                if(actor == "aspirant")
                    request.getRequestDispatcher("/HomePageAspirant.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("/HomePageHRManager.jsp").forward(request, response);
            }
        }
        catch (Exception incorrectEmailException) { }
    }
}
