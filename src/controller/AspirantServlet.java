package controller;

import controller.command.Command;
import viewModel.Aspirant;
import viewModel.AspirantResume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Represents an aspirant servlet.
 */
@WebServlet(name = "AspirantServlet", urlPatterns = "/Aspirant")
public class AspirantServlet extends HttpServlet {

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

            case("GetAspirant"):{

                HttpSession session = request.getSession();

                String email = (String)session.getAttribute("userEmail");

                Command command = commandProvider.getCommand(commandName);
                try {
                    session.setAttribute("aspirant", (Aspirant)command.execute(email));
                } catch (Exception e) { }

                request.getRequestDispatcher("/AspirantDisplay.jsp").forward(request, response);

                break;
            }

            case("CreatePdf"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }
            case("CreateCsv"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }
            case("CreateXls"):{

                Downloader downloader = new Downloader();
                downloader.DownloadFile(request, response, DocumentCreate(request, response, commandName));
                break;
            }
        }
    }

    protected String DocumentCreate(HttpServletRequest request, HttpServletResponse response, String commandName) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String email = (String)session.getAttribute("userEmail");

        String result = "";

        Command command = commandProvider.getCommand(commandName);
        try {
            result = (String)command.execute(email + ";Aspirant");
        } catch (Exception e) { }

        request.getRequestDispatcher("/Aspirant?command=GetAspirant").forward(request, response);

        return result;
    }
}
