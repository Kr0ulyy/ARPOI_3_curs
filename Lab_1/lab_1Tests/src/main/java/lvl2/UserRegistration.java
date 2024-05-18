package lvl2;

public class UserRegistration {
    public static boolean registerUser(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    static void validateLogin(String login) throws WrongLoginException {
        if (!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
            throw new WrongLoginException("Invalid LOGIN format");
        }
    }

    public static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches("[a-zA-Z0-9_]+") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Invalid password format or passwords do not match");
        }
    }

    public static void main(String[] args) {
        boolean result = registerUser("Viktor", "Secret123", "Secret123");
        System.out.println("Registration successful: " + result);
    }
}
