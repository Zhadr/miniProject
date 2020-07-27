package my.project;

import javax.swing.text.Style;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static  StApp app;
    public static Socket socket;
    public static ObjectOutputStream objectOutputStream;

    public static void main(String[] args) {
        Server server = new Server();
        server.connect();
        Scanner in = new Scanner(System.in);
//        ArrayList<Student> student = server.getAllStudents();
//        for (Student s:student){
//            System.out.println(s.toString());
//        }

        ListOfSt list = new ListOfSt();
        AddStud addStud = new AddStud();
        app=new StApp(addStud, list);
        app.setVisible(true);
        String name = in.next();
        String surname = in.next();
        int age = in.nextInt();
        Student student1 = new Student(null, name, surname, age);
        addStud(student1);


        try{
            Socket socket = new Socket("127.0.0.1", 5151);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            //ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            socket.close();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    public static boolean connectToServer(String ip, int port){
        boolean check = false;
        try {
            socket = new Socket(ip, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            check=true;
        }catch (Exception e){
            e.printStackTrace();
            check=false;
        }
        return check;
    }

    public static void addStud(Student student1){
        Server sr= new Server();
        PackageData pd = new PackageData();
        pd.setOperationType("add");
        pd.setStudents(student1);

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("jdbc:mysql://localhost:3306/student?useUnicode=true&serverTimezone=UTC"));

            outputStream.writeObject(sr);
            outputStream.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
