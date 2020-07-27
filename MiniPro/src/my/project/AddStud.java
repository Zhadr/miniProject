package my.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStud extends JFrame {
    PackageData pd= new PackageData();


    public AddStud(){
        setSize(500, 500);
        setLayout(null);

        JLabel label1 = new JLabel("SURNAME");
        label1.setSize(100, 30);
        label1.setLocation(100, 90);
        add(label1);

        JLabel label2 = new JLabel("NAME");
        label2.setSize(100, 30);
        label2.setLocation(100, 50);
        add(label2);

        JLabel label3 = new JLabel("AGE");
        label3.setSize(100, 30);
        label3.setLocation(100, 140);
        add(label3);


        JTextField field2 = new JTextField();
        field2.setSize(100, 30);
        field2.setLocation(210, 50);
        add(field2);

        JTextField field1 = new JTextField();
        field1.setSize(100, 30);
        field1.setLocation(210, 90);
        add(field1);

        JTextField field3 = new JTextField();
        field3.setSize(100, 30);
        field3.setLocation(210, 140);
        add(field3);

        JButton button = new JButton("add");
        button.setSize(80, 30);
        button.setLocation(100, 250);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = field1.getText();
                String surname = field2.getText();
                int age = field3.getColumns();
                Student student = new Student(null, name, surname, age);
            }
        });
        add(button);

        JButton backButton = new JButton("back");
        backButton.setLocation(280, 250);
        backButton.setSize(80, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Main.app.setVisible(true);
            }
        });
        add(backButton);


    }
}
