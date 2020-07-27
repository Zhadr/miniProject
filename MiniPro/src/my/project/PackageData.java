package my.project;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Student> student;
    private Student students;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Student> student, Student students) {
        this.operationType = operationType;
        this.student = student;
        this.students = students;
    }

    public String getOperationType() {
        return this.operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Student> getStudent() {
        return this.student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public Student getStudents() {
        return students;
    }

    public void setStudents(Student students) {
        this.students = students;
    }



}
