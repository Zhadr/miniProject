package my.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Server {
    private static Connection connection;
    public static void main(String[] args){
        connect();
        try {
            ServerSocket server = new ServerSocket(5151);
            System.out.println("waiting");
            while (true){
                Socket socket = server.accept();
                System.out.println("client connected");
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                PackageData pd1 = new PackageData();
                while ((pd1=(PackageData) inputStream.readObject())!=null){
                    if (pd1.getOperationType().equals("ADD")) {
                        System.out.println(pd1.getStudents().toString());
                    }
                    else if (pd1.getOperationType().equals("ADD"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?useUnicode=true&serverTimezone=UTC", "root", ""
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addStudent (Student student){
        try{
            PreparedStatement statement = connection.prepareStatement(" "+
                    "INSERT INTO student(id, name, surname, age)"+ "VALUES(NULL, ?, ?, ?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
//    public ArrayList<Student> getAllStudents(){
//        ArrayList<Student> studentsList = new ArrayList<>();
//
//        try{
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
//            ResultSet resultSet = statement.executeQuery();
//
//            while(resultSet.next()){
//                Long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//                int age = resultSet.getInt("age");
//                studentsList.add(new Student(id, name, surname, age));
//            }
//            statement.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return studentsList;
//    }

}
