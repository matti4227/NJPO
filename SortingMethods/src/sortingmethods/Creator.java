package sortingmethods;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private List<SortingAlgorithm> observers = new ArrayList<>();
    private Tab tab;

    public Creator() { tab = new Tab(); }

    void initializeTab(int tabSize) {
        tab.initializeTab(tabSize);
    }

    void fillTheTab(int tabSize) {
        tab.fillTheTab(tabSize);
    }

    public void addAlgorithm(SortingAlgorithm algorithm) {
        observers.add(algorithm);
    }

    public void removeAlgorithm(SortingAlgorithm algorithm) {
        observers.remove(algorithm);
    }

    void notifyObservers(String ile) {
        if(ile == "raz")
            for(SortingAlgorithm ob1: observers){
                ob1.initializeTab(tab);
                ob1.sort(ile);
            }
        if(ile == "dziesięć")
            for(int i = 0; i < 10; i++)
                for(SortingAlgorithm ob2: observers){
                ob2.initializeTab(tab);
                ob2.sort(ile);
            }
    }
}
