import java.util.Scanner;
public class grade{
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);

        //Getting the grade pont 1-4
        System.out.println  ("Enter the grade points :: ");
        int Grade = scanner.nextInt();
        switch(Grade){
        case 1:
            System.out.println("Distinction");
            break;
        case 2:
            System.out.println("Credit");
            break;
        case 3:
            System.out.println("Pass");
            break;
        case 4:
            System.out.println("Fail");
            break;
        default:
            System.out.println("Invalid");
            break;
        }
    }
}
