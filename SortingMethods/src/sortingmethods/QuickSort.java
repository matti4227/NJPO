package sortingmethods;

public class QuickSort extends SortingAlgorithm {

    private static QuickSort instance = new QuickSort();

    private QuickSort() {}

    public static QuickSort getInstance() { return instance; }

    private int low;
    private int high;
    private long sortingDuration;
    private long sortingDuration10;

    public QuickSort(Tab tabToSort, int low, int high) {
        initializeTab(tabToSort);
        initializeLowHigh(low, high);
    }

    private void initializeLowHigh(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    void initializeTab(Tab tabToSort) { tab = tabToSort.getTab(); }

    @Override
    public void sort(String ile) {

        long startTime = System.nanoTime();
        quickSort(tab, low, high);
        long endTime = System.nanoTime();
        if(ile == "raz")
            sortingDuration = (endTime - startTime);
        if(ile == "dziesięć")
            sortingDuration10 += (endTime - startTime);
    }

    public void quickSort(int tabToSort[], int low, int high) {

        if (low < high)
        {
            int pi = partition(tabToSort, low, high);
            quickSort(tabToSort, low, pi-1);
            quickSort(tabToSort, pi+1, high);
        }
    }

    int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low-1);

        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    @Override
    public String getSortingDuration() {
        StringBuilder sb = new StringBuilder();
        sb.append(sortingDuration);
        sb.append(" ns");
        return String.valueOf(sb);
    }

    @Override
    public String getSortingDuration10() {
        sortingDuration10 /= 10;
        StringBuilder sb = new StringBuilder();
        sb.append(sortingDuration10);
        sb.append(" ns");
        sortingDuration10 = 0;
        return String.valueOf(sb);
    }
}
