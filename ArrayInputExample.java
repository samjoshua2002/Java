import java.util.Scanner;

public class ArrayInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] array = new String[size];

        System.out.println("Enter " + size + " values:");

        for (int i = 0; i < size; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            String input = scanner.nextLine();
            array[i] = input;
        }

        System.out.println("Array values: ");
        for (String x : array) {
            System.out.print(x+" ");

        }

        scanner.close();
    }
}