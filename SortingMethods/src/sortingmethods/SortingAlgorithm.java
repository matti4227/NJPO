package sortingmethods;

public abstract class SortingAlgorithm {
    protected int tab[];
    abstract void initializeTab(Tab tabToSort);
    public abstract void sort(String ile);
    public abstract String getSortingDuration();
    public abstract String getSortingDuration10();
}
