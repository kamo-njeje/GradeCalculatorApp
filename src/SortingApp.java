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

            bubbleSort(numbers, count);

            System.out.println("\nSorted numbers:");
            printArray(numbers, count);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("input.txt file not found.");
        }
    }

    public static void bubbleSort(int[] arr, int size) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

