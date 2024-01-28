import java.util.Scanner;

public class Fees {
    public static void main(String[] args) {
        double feesPaid,balance, credit;
        Scanner scanner = new Scanner(System.in);

        //Getting the amount of fees paid
        System.out.println("Enter the amount of fees paid :: ");
        feesPaid = scanner.nextInt();

        //exactly 50k
        if (feesPaid == 50000){
            System.out.printf("No fees balance");
        }

        //less than 50k
        else if ( feesPaid < 50000 ){
            balance = 50000 - feesPaid;
            System.out.printf("Fees balance is :: %.2f\n", balance);
        }
        
        //more than 50k
        else if (feesPaid > 50000){
            credit = feesPaid - 50000;
            System.out.printf("There is an over payment of :: %.2f\\n", credit);
        }
    }
}
