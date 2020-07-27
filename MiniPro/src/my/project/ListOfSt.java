package my.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ListOfSt extends JFrame {



    JTextArea textArea;
     public ListOfSt(){
         PackageData pd = new PackageData();

         setTitle("LIST OF STUDENTS");
         setSize(500, 500);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);




         JButton backButton = new JButton("back");
         backButton.setLocation(200, 300);
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
//    public void getL(){
//        Server pdgui = new Server();
//        ArrayList<Student> student = pdgui.getAllStudents();
//        for (Student s:student){
//            System.out.println(s.toString());
//        }
//    }
//



}
