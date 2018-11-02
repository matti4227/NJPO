package sortingmethods;

import javax.swing.*;
import java.awt.event.*;

public class Form extends JFrame {
    private JPanel jPanel;
    private JButton stwórzTablicęButton3;
    private JTextField textField1;
    private JButton stwórzTablicęButton2;
    private JTextField textField2;
    private JButton stwórzTablicęButton1;
    private JTextField textField3;
    private JButton stwórzTablicęButton;
    private JTextField tablica1;
    private JLabel jLabel1;
    private JButton infoOProgramieButton;
    private JLabel jLabel2;
    private JButton sortuj1;
    private JButton sortujButton1;
    private JButton sortujButton2;
    private JButton sortujButton3;
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

        stwórzTablicęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = tablica1.getText();

                if(!text.equals("")){
                    if(checkNumber(text)){
                        int tabSize = Integer.parseInt(text);
                        if(tabSize != 0){
                            creator.initializeTab(tabSize);
                            creator.fillTheTab(tabSize);
                            table = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Podaj coś, co nie jest zerem");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "To nie jest liczba, bądź wykracza poza możliwy zakres");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A może coś wpisz");
                }

                if(numbers)
                    JOptionPane.showMessageDialog(null, creator.showTab());

//                    JOptionPane.showMessageDialog(null, tab1.showTab() + duration + " ns");
//                }
//                else {
//                    JOptionPane.showMessageDialog(null, "To nie jest liczba, bądź wykracza poza możliwy zakres");

            }
        });
        sortuj1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table)
                    creator.notifyObservers("raz");
                if(bubbleFlag)
                    bubble1.setText(bubbleSort.getSortingDuration());
                else
                    bubble1.setText("0 ns");
                if(quickFlag)
                    quick1.setText(quickSort.getSortingDuration());
                else
                    quick1.setText("0 ns");
                if(javaFlag)
                    java1.setText(javaSort.getSortingDuration());
                else
                    java1.setText("0 ns");

                if(numbers)
                    JOptionPane.showMessageDialog(null, creator.showTab());
            }
        });
        sortuj1_10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table)
                    creator.notifyObservers("dziesięć");
                if(bubbleFlag)
                    bubble1_10.setText(bubbleSort.getSortingDuration10());
                else
                    bubble1_10.setText("0 ns");
                if(quickFlag)
                    quick1_10.setText(quickSort.getSortingDuration10());
                else
                    quick1_10.setText("0 ns");
                if(javaFlag)
                    java1_10.setText(javaSort.getSortingDuration10());
                else
                    java1_10.setText("0 ns");

                if(numbers)
                    JOptionPane.showMessageDialog(null, creator.showTab());
            }
        });
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
            }
        });
        pokazCheck.addItemListener(new ItemListener() {///////////////////////////////////////////////////////////////TODO: może to dodać, a może nie
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1)
                    numbers = true;
                else
                    numbers = false;
            }
        });
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
