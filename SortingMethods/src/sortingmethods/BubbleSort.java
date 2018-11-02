package sortingmethods;

public class BubbleSort extends SortingAlgorithm {

    private static BubbleSort instance = new BubbleSort();

    private BubbleSort() {}

    public static BubbleSort getInstance() { return instance; }

    private long sortingDuration;
    private long sortingDuration10;

    @Override
    void initializeTab(Tab tabToSort) {
        tab = tabToSort.getTab();
    }

    @Override
    public void sort(String ile) {

        long startTime = System.nanoTime();
        int n = tab.length;
        int temp = 0;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(tab[j-1] > tab[j]){
                    temp = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        if(ile == "raz")
            sortingDuration = (endTime - startTime);
        if(ile == "dziesięć")
            sortingDuration10 += (endTime - startTime);
    }

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
