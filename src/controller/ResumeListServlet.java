package controller;

import domain.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Represents an resume list servlet.
 */
@WebServlet(name = "ResumeListServlet", urlPatterns = "/ResumeList")
public class ResumeListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //TODO: получить список резюме
        ArrayList<Resume> resumeList = new ArrayList<>();
        session.setAttribute("resumeList", resumeList);
        request.getRequestDispatcher("/ResumeListDisplay.jsp").forward(request, response);
    }
}
