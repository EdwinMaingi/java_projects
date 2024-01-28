import java.util.Scanner;

public class employee {

    public static void main(String[] args) {
        double basicPay,hoursWorked,ratePerHour, tax, netPay;
        Scanner scanner = new Scanner(System.in);
        //Getting the name of the employee
        System.out.println("Please put in the name of the employee :: ");
        String Name = scanner.nextLine();

        //Getting the number of hours worked
        System.out.println("Please enter hours worked by the employee :: ");
        hoursWorked = scanner.nextInt();

        //Getting the rate of pay per hour of the employee
        System.out.println("Please enter rate per hour of the employee :: ");
        ratePerHour = scanner.nextInt();

        //Calculating the basic pay
        basicPay = hoursWorked * ratePerHour;
        
        //Calculating for more than 50k
        if (basicPay > 50000){
            tax = basicPay * 0.2;
            netPay = basicPay - tax;
            System.out.printf("Employee name is :: %s\n", Name);
            System.out.printf("The basic salary is :: Ksh %.2f\n", basicPay);
            System.out.printf("The tax is :: Ksh %.2f\n ", tax);
            System.out.printf("The netpay is :: Ksh %.2f\n", netPay);
        }

        //Calculating for between 20k-50k
        else if ((basicPay >= 20000 ) && (basicPay == 50000)){
            tax = basicPay * 0.1;
            netPay = basicPay - tax;
            System.out.printf("Employee name is :: %s\n", Name);
            System.out.printf("The basic salary is :: Ksh %.2f\n", basicPay);
            System.out.printf("The tax is :: Ksh %.2f\n ", tax);
            System.out.printf("The netpay is :: Ksh %.2f\n", netPay);
        }

        //Calculating for less than 20k
        else if (basicPay < 20000 ) {
            tax = basicPay * 0;
            netPay = basicPay - tax;
            System.out.printf("Employee name is :: %s\n", Name);
            System.out.printf("The basic salary is :: Ksh %.2f\n", basicPay);
            System.out.printf("No tax will be applied at your pay level.\n");
            System.out.printf("The netpay is :: Ksh %.2f\n", netPay);
        }


    }
}

