package sortingmethods;

import java.util.Arrays;

public class JavaSort extends SortingAlgorithm {

    public JavaSort(Tab tabToSort) {
        initializeTab(tabToSort);
    }

    @Override
    void initializeTab(Tab tabToSort) {
        tab = tabToSort.getTab();
    }

    @Override
    public int[] sort() {
        Arrays.sort(tab);
        return tab;
    }
}
