import controller.CommandProvider;
import viewModel.Aspirant;

public class Main {

    public static void main(String args[])
    {
        CommandProvider commandProvider = new CommandProvider();
        Aspirant aspirant = (Aspirant)commandProvider.getCommand("Get aspirant info").execute("user@gmail.com");
    }
}
