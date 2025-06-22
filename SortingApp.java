public class SortingApp {

    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 3};

        System.out.println("Original array:");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("\nSorted array:");
        printArray(numbers);
    }

    public static void bubbleSort(int[] arr) {
        boolean swapped;
        int n = arr.length;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
