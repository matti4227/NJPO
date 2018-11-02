package sortingmethods;

import java.util.Arrays;

public class JavaSort extends SortingAlgorithm {

    private static JavaSort instance = new JavaSort();

    private JavaSort() {}

    public static JavaSort getInstance() { return instance; }

    private long sortingDuration;
    private long sortingDuration10;

    public JavaSort(Tab tabToSort) {
        initializeTab(tabToSort);
    }

    @Override
    void initializeTab(Tab tabToSort) {
        tab = tabToSort.getTab();
    }

    @Override
    public void sort(String ile) {

        long startTime = System.nanoTime();
        Arrays.sort(tab);
        long endTime = System.nanoTime();
        if(ile == "raz")
            sortingDuration = (endTime - startTime);
        if(ile == "dziesięć")
            sortingDuration10 += (endTime - startTime);
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
