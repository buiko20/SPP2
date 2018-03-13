package controller;

import controller.command.Command;
import domain.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a resume list servlet.
 */
@WebServlet(name = "ResumeListServlet", urlPatterns = "/ResumeList")
public class ResumeListServlet extends HttpServlet {

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

            ArrayList<Resume> resumeList = (ArrayList<Resume>)command.execute(session.getAttribute("userEmail").toString());
            session.setAttribute("resumeList", resumeList);
        } catch (Exception e) { }

        request.getRequestDispatcher("/ResumeListDisplay.jsp").forward(request, response);
    }
}
