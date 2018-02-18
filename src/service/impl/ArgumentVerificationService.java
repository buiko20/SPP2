package service.impl;

class ArgumentVerificationService {

    static void verifyNull(Object argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException(argumentName + " is null.");
        }
    }

    static void verifyString(String argument, String argumentName) {
        if (argument == null || argument.trim().isEmpty()) {
            throw new IllegalArgumentException(argumentName + " is null, empty or white space.");
        }
    }

}
