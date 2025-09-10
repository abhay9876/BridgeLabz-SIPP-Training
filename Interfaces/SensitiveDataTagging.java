interface SensitiveData {}

class UserCredentials implements SensitiveData {
    String username;
    String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {
        UserCredentials creds = new UserCredentials("admin", "secret123");

        if (creds instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data before saving...");
        } else {
            System.out.println("Normal data, no encryption needed.");
        }
    }
}
