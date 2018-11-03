package sortingmethods;

import javax.swing.*;
import java.awt.event.*;

public class Form extends JFrame {
    private JPanel jPanel;
    private JButton stworzTab2;
    private JTextField tablica2;
    private JButton stworzTab1;
    private JTextField tablica1;
    private JLabel jLabel1;
    private JButton infoOProgramieButton;
    private JLabel jLabel2;
    private JButton sortuj1;
    private JButton sortuj2;
    private JLabel bubble1;
    private JLabel quick1;
    private JLabel java1;
    private JCheckBox bubbleCheck;
    private JCheckBox quickCheck;
    private JCheckBox javaCheck;
    private JButton sortuj1_10;
    private JLabel bubble1_10;
    private JLabel quick1_10;
    private JLabel java1_10;
    private JButton wyczyśćWynikiButton;
    private JLabel info;
    private JCheckBox pokazCheck;
    private JLabel infoTablica1;
    private JLabel infoTablica2;
    private JLabel bubble2;
    private JLabel quick2;
    private JLabel java2;
    private JButton sortuj2_10;
    private JLabel bubble2_10;
    private JLabel quick2_10;
    private JLabel java2_10;

    Form(){
        add(jPanel);
        setSize(850, 400);
        setTitle("Program sortujący tablice");
        jLabel1.setText("<HTML>Poniżej wstaw wartości dla wielkości tablic,<BR>które mają zostać stworzone, a wartości<BR> do niej wygenerowane i posortowane</HTML>");
        jLabel2.setText("<HTML>Wyniki sortowań dla:</HTML>");
        info.setText("<HTML>(powyższe na własną <BR>odpowiedzialność)<HTML>");

        creator = new Creator();
        bubbleSort = BubbleSort.getInstance();
        quickSort = QuickSort.getInstance();
        javaSort = JavaSort.getInstance();

        stworzTab1.addActionListener(e -> createTable(tablica1, infoTablica1));
        stworzTab2.addActionListener(e -> createTable(tablica2, infoTablica2));

        sortuj1.addActionListener(e -> sortTable(bubble1, quick1, java1));
        sortuj2.addActionListener(e -> sortTable(bubble2, quick2, java2));

        sortuj1_10.addActionListener(e -> sortTable10(bubble1_10, quick1_10, java1_10));
        sortuj2_10.addActionListener(e -> sortTable10(bubble2_10, quick2_10, java2_10));

        bubbleCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    creator.addAlgorithm(bubbleSort);
                    bubbleFlag = true;
                }
                else {
                    creator.removeAlgorithm(bubbleSort);
                    bubbleFlag = false;
                }
            }
        });
        quickCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    creator.addAlgorithm(quickSort);
                    quickFlag = true;
                }
                else {
                    creator.removeAlgorithm(quickSort);
                    quickFlag = false;
                }
            }
        });
        javaCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    creator.addAlgorithm(javaSort);
                    javaFlag = true;
                }
                else {
                    creator.removeAlgorithm(javaSort);
                    javaFlag = false;
                }
            }
        });
        wyczyśćWynikiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bubble1.setText("0 ns");
                quick1.setText("0 ns");
                java1.setText("0 ns");
                bubble1_10.setText("0 ns");
                quick1_10.setText("0 ns");
                java1_10.setText("0 ns");
                bubble2.setText("0 ns");
                quick2.setText("0 ns");
                java2.setText("0 ns");
                bubble2_10.setText("0 ns");
                quick2_10.setText("0 ns");
                java2_10.setText("0 ns");
            }
        });
        pokazCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1)
                    numbers = true;
                else
                    numbers = false;
            }
        });
    }

    private void sortTable(JLabel bubble, JLabel quick, JLabel java) {
        if(table)
            creator.notifyObservers("raz");
        if(bubbleFlag)
            bubble.setText(bubbleSort.getSortingDuration());
        else
            bubble.setText("0 ns");
        if(quickFlag)
            quick.setText(quickSort.getSortingDuration());
        else
            quick.setText("0 ns");
        if(javaFlag)
            java.setText(javaSort.getSortingDuration());
        else
            java.setText("0 ns");


        if(numbers)
            JOptionPane.showMessageDialog(null, creator.showTab());
    }
    private void sortTable10(JLabel bubble, JLabel quick, JLabel java) {
        if(table)
            creator.notifyObservers("dziesięć");
        if(bubbleFlag)
            bubble.setText(bubbleSort.getSortingDuration10());
        else
            bubble.setText("0 ns");
        if(quickFlag)
            quick.setText(quickSort.getSortingDuration10());
        else
            quick.setText("0 ns");
        if(javaFlag)
            java.setText(javaSort.getSortingDuration10());
        else
            java.setText("0 ns");


        if(numbers)
            JOptionPane.showMessageDialog(null, creator.showTab());
    }
    private void createTable(JTextField tablica, JLabel infotablica) {
        try {
            String text = tablica.getText();
            if(!text.equals("")){
                if(checkNumber(text)){
                    int tabSize = Integer.parseInt(text);
                    if(tabSize <= 200000000){
                        if(tabSize != 0){
                            creator.initializeTab(tabSize);
                            creator.fillTheTab(tabSize);
                            infotablica.setText("Tablica " + tabSize + " - elementowa");
                            table = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Podaj coś, co nie jest zerem");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Podana liczba wykracza poza przyjęty, górny zakres (0 - 200 000 000)");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "To nie jest liczba, bądź wykracza poza dolny zakres");
                }
            } else {
                JOptionPane.showMessageDialog(null, "A może coś wpisz");
            }
        } catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Podana liczba wykracza poza przyjęty, górny zakres (0 - 200 000 000)");
        }
        if(numbers)
            JOptionPane.showMessageDialog(null, creator.showTab());
    }
    private boolean checkNumber(String input){
        boolean flag = true;
        int i = 0;

        while(i < input.length() && flag == true){
            flag = false;
            for(int j = 48; j <= 57; j++) {
                if ((int) input.charAt(i) == j) {
                    flag = true;
                }
            }
            if(flag == false)
                return false;
            i++;
        }
        return true;
    }

    private Creator creator;
    private SortingAlgorithm bubbleSort;
    private SortingAlgorithm quickSort;
    private SortingAlgorithm javaSort;
    private boolean bubbleFlag;
    private boolean quickFlag;
    private boolean javaFlag;
    private boolean table = false;
    private boolean numbers;
}
