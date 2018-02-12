package controller;

import controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Note: you can use only domain and service.

/**
 * Represents my super cool controller.
 */
@WebServlet(name = "MyServletController")
public class MyServletController extends HttpServlet {

    private final CommandProvider commandProvider = new CommandProvider();

    // Note: use @WebServlet to make our lives easier. (do not forget to read about @WebServlet).
    // TODO: Read about Post-Redirect-Get pattern in general then in java servlets.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doAction(request.toString());
    }

    private void doAction(String request) {

        String commandName = this.getCommandNameSomehow();

        Command command = commandProvider.getCommand(commandName);

        String something = command.execute(request);

        // ...
    }

    private String getCommandNameSomehow(){
        return null;
    }
}
