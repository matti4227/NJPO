package sortingmethods;

public class QuickSort extends SortingAlgorithm {

    private int low;
    private int high;

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
    public int[] sort(){
        quickSort(tab, low, high);
        return tab;
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
}
