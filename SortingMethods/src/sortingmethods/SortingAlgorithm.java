package sortingmethods;

public abstract class SortingAlgorithm {
    protected int tab[];
    abstract void initializeTab(Tab tabToSort);
    public abstract int[] sort();
}
