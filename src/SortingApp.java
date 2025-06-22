import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingApp {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            int[] numbers = new int[100];
            int count = 0;

            while (scanner.hasNextInt()) {
                numbers[count++] = scanner.nextInt();
            }

            System.out.println("Original numbers:");
            printArray(numbers, count);

            // Use strategy pattern
            SortContext context = new SortContext();

            // Choose strategy at runtime
            context.setSortStrategy(new BubbleSort()); // or new InsertionSort()
            context.sort(numbers, count);

            System.out.println("\nSorted numbers:");
            printArray(numbers, count);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("input.txt file not found.");
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
