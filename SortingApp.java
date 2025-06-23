import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortingApp {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner fileScanner = new Scanner(file);

            int[] numbers = new int[100];
            int count = 0;

            while (fileScanner.hasNextInt()) {
                numbers[count++] = fileScanner.nextInt();
            }

            System.out.println("Original numbers:");
            printArray(numbers, count);

            Scanner inputScanner = new Scanner(System.in);
            System.out.println("\nChoose a sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Insertion Sort");
            System.out.println("3. Selection Sort");
            System.out.print("Enter your choice (1, 2 or 3): ");
            int choice = inputScanner.nextInt();

            SortContext context = new SortContext();

            if (choice == 1) {
                context.setSortStrategy(new BubbleSort());
                System.out.println("\nUsing Bubble Sort:");
            } else if (choice == 2) {
                context.setSortStrategy(new InsertionSort());
                System.out.println("\nUsing Insertion Sort:");
            } else if (choice == 3) {
                context.setSortStrategy(new SelectionSort());
                System.out.println("\nUsing Selection Sort:");
            } else {
                System.out.println("Invalid choice. Exiting.");
                return;
            }

            context.sort(numbers, count);
            printArray(numbers, count);
            writeToFile(numbers, count, "output.txt");

            fileScanner.close();
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(" input.txt file not found.");
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void writeToFile(int[] arr, int size, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < size; i++) {
                writer.write(arr[i] + "\n");  // Each number on a new line
            }
            writer.close();
            System.out.println(" Sorted numbers saved to " + filename);
        } catch (IOException e) {
            System.out.println(" Error writing to file.");
        }
    }
}
