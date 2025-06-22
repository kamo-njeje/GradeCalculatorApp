public class SortContext {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr, int size) {
        if (strategy != null) {
            strategy.sort(arr, size);
        } else {
            System.out.println("No sorting strategy set.");
        }
    }
}
