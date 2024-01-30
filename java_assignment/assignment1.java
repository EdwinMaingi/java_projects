import java.util.Scanner;

public class assignment1 {

    public static void main(String[] args) {
        String userName, passWord, newUsername, newPassword;
        int initialTries, totalTries;
        Scanner scanner = new Scanner(System.in);
        userName = "Eddie";
        passWord = "password1234";
        initialTries = 0;
        totalTries = 3;

        while (initialTries < totalTries){
            System.out.println("Enter your name :: ");
            newUsername = scanner.nextLine();

            System.err.println("Enter your password :: ");
            newPassword = scanner.nextLine();

            if(newUsername.equals(userName) && newPassword.equals(passWord)){
                System.out.println("Correct login");
                break;
            } else if(newUsername.equals(userName) && !newPassword.equals(passWord)){
                System.out.println("Wrong password");
                initialTries++;
            } else if (!newUsername.equals("Wrong username") && newPassword.equals(passWord)){
                System.out.println(("Wrong username"));
                initialTries++;
            } else if (!newUsername.equals(userName) && !newPassword.equals(passWord)){
                System.out.println("Wrong username and wrong password");
                initialTries++;
            }

        }

        if (initialTries == totalTries){
            System.out.println("Max tries reached");
        }

        scanner.close();

    }
    
}
