interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[@#$%^&+=!].*");
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Weak123"));
        System.out.println(SecurityUtils.isStrongPassword("Str0ng@Pass"));
    }
}
