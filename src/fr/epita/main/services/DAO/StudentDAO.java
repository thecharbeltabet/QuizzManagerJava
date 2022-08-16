package fr.epita.main.services.DAO;

import fr.epita.main.datamodel.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String SEARCH_QUERY = "SELECT id, name from STUDENT where id = ? or name is like ?";
    private static final String INSERT_QUERY = "INSERT INTO STUDENT (name, id) values(?, ?)";
    private static final String UPDATE_QUERY = "UPDATE STUDENT SET name=? where id= ?";
    private static final String DELETE_QUERY = "DELETE from STUDENT where id= ?";

    public static void create(Student student) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setString(1, student.getName());

            preparedStatement.setInt(2,student.getId());

            preparedStatement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static List<Student> StudentList = new ArrayList<Student>();

    public static List<Student> search(Student student) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setInt(2, student.getId());
            preparedStatement.setString(1, student.getName());
            ResultSet searchResult = preparedStatement.executeQuery();

            while (searchResult.next()) {
                Student newStudent = new Student("Charbel", 001);
                newStudent.setId(searchResult.getInt("Student_id"));
                newStudent.setName(searchResult.getString("Student Name"));
                StudentList.add(newStudent);


            }
            searchResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return StudentList;
    }

    public static int update(Student student) {
        int studentUpdate = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, student.getName());

            preparedStatement.setInt(2, student.getId());
            studentUpdate = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentUpdate;
    }

    public static int delete(Student student){
        int studentDelete = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);

            preparedStatement.setInt(1, student.getId());
            studentDelete = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Error! " + e.getMessage());
        }
        return studentDelete;
    }
}

