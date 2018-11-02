package sortingmethods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton sortujButton;
    private JButton sortujButton1;
    private JButton sortujButton2;
    private JButton sortujButton3;

    Form(){
        add(jPanel);
        setSize(800, 400);
        setTitle("Program sortujący tablice");
        jLabel1.setText("<HTML>Poniżej wstaw wartości dla wielkości tablic,<BR>które mają zostać stworzone, a wartości<BR> do niej wygenerowane i posortowane</HTML>");
        jLabel2.setText("<HTML>Uśrednione wyniki 10 sortowań dla:</HTML>");

        stwórzTablicęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tablica1.getText();
                int tabSize = Integer.parseInt(text);
                Tab tab1;
                SortingAlgorithm bs;
                if(checkNumber(text)){
                    tab1 = new Tab(tabSize);
                    JOptionPane.showMessageDialog(null, tab1.showTab());
                    bs = new JavaSort(tab1);
                    long startTime = System.nanoTime();
                    bs.sort();
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime);
                    JOptionPane.showMessageDialog(null, tab1.showTab() + duration + " ns");
                }
                else {
                    JOptionPane.showMessageDialog(null, "To nie jest liczba, bądź wykracza poza możliwy zakres");
                }

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
}
