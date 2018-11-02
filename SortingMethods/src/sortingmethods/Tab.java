package sortingmethods;

import java.util.Random;

public class Tab {

    private int tab[];

    void initializeTab(int size) { tab = new int[size]; }

    void fillTheTab(int size) {
        Random random = new Random();
        for(int i = 0; i < size; i++)
            tab[i] = random.nextInt(size);
    }

    public int[] getTab() {
        return tab;
    }

    public String showTab() {
        StringBuilder sb = new StringBuilder();
        for(int t : tab){
            sb.append(tab[t]);
            sb.append(" ");
        }

        return sb.toString();
    }
}
