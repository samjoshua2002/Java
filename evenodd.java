import java.util.Scanner;

public class evenodd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: \n");
        System.out.println("here:");int number = sc.nextInt();
        

// Find out if the number above is even or odd
if (number % 2 == 0) {
  System.out.println(number + " is even.");
} else {
  System.out.println(number + " is odd.");
    }
    sc.close();
}
}