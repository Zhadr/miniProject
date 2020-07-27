package my.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StApp extends JFrame {

    private AddStud general;
    private ListOfSt secondPage;

    private JButton firstPageButton;
    private JButton secondPageButton;
    private JButton exitButton;

    public StApp(AddStud general, ListOfSt secondPage){
        this.general=general;
        this.secondPage=secondPage;


        setSize(500, 500);
        setLayout(null);

        firstPageButton = new JButton("ADD STUDENT");
        firstPageButton.setSize(300,30);
        firstPageButton.setLocation(100,100);
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                general.setVisible(true);
                setVisible(false);
            }
        });
        add(firstPageButton);

        secondPageButton = new JButton("LIST STUDENT");
        secondPageButton.setSize(300,30);
        secondPageButton.setLocation(100,150);
        secondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                secondPage.setVisible(true);
                //secondPage.getL();
                setVisible(false);
            }
        });
        add(secondPageButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);
    }

}
