import java.util.Scanner;

public class athletes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Getting the country code 
        System.out.println("Please enter a country code (K,k,I,i,U,u,N,n) :: ");
        char code = scanner.next().charAt(0);
        //Operation & conditions
        if( code == 'K' || code == 'k'){
            System.out.println("The country is Kenya and the rating is of highly talented sportsmen");
        }
        else if( code == 'I' || code == 'i'){
            System.out.println("The country is India and the rating is Sporting affected by their culture");
        }
        else if( code == 'U' || code == 'u'){
            System.out.println("The country is United States and the rating is Good in short races");
        }
        else if( code == 'N' || code == 'n'){
            System.out.println("The country is Nigeria and the rating is Give a good attempt in short races");
        }
        else{
            System.out.println("Invalid input");
        }
    }
}
