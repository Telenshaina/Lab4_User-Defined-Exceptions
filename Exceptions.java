import java.util.*;

public class Exceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxTry = 3;
        int tries = 0;

        while (true) {
            tries = 0; // Reset tries for each new attempt
            while (tries < maxTry) {
                try {
                    System.out.print("Enter Username:   ");
                    String name = scanner.nextLine();

                    System.out.print("Please enter your Password:  ");
                    String pass = scanner.nextLine();

                    String validpass = "password";

                    if (!pass.equals(validpass)) {
                        tries++;
                        if (tries == maxTry) {
                            throw new TryExceededException("Max login attempts reached. Account locked.");
                        } else {
                            throw new InvalidPassException("Password is Invalid!\nAttempts left: " + (maxTry - tries)+ "\n----------------------\n");
                        }
                    } else {
                        System.out.println("Login Successful!");
                        return;
                    }
                } catch (InvalidPassException e) {
                    System.out.println(e.getMessage());
                } catch (TryExceededException e) {
                    System.out.println(e.getMessage());
                    return; 
                }
            }
        }
    }
}