package sortingmethods;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(Tab tabToSort) {
        initializeTab(tabToSort);
    }

    @Override
    void initializeTab(Tab tabToSort) {
        tab = tabToSort.getTab();
    }

    @Override
    public int[] sort(){

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

        return tab;
    }
}
