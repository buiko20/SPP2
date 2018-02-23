package service.utils;

public class ArgumentVerificationService {

    public static void verifyNull(Object argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException(argumentName + " is null.");
        }
    }

    public static void verifyString(String argument, String argumentName) {
        if (argument == null || argument.trim().isEmpty()) {
            throw new IllegalArgumentException(argumentName + " is null, empty or white space.");
        }
    }

}
