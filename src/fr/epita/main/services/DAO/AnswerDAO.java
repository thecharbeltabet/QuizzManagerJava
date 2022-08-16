package fr.epita.main.services.DAO;

import fr.epita.main.datamodel.Answer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAO {

    private static String SEARCH_QUERY = "select text from ANSWER where text is like ?";
    private static String INSERT_QUERY = "INSERT INTO ANSWER (text) VALUES (?)";
    private static String UPDATE_QUERY = "UPDATE ANSWER SET text=? WHERE text is like ?";
    private static String DELETE_QUERY = "DELETE from ANSWER where text is like ?";

    public static void create(Answer answer) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setString(1, answer.getText());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static List<Answer> AnswerList = new ArrayList<Answer>();

    public static List<Answer> search(Answer answer) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, answer.getText());
            ResultSet searchResult = preparedStatement.executeQuery();

            while (searchResult.next()) {
                Answer newAnswer = new Answer("Text Answer");
                newAnswer.setText(searchResult.getString("text"));
                AnswerList.add(newAnswer);


            }
            searchResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AnswerList;
    }

    public static int update(Answer answer) {
        int textAnswerUpdate = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, answer.getText());
            textAnswerUpdate = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return textAnswerUpdate;
    }

    public static int delete(Answer answer){
        int textAnswerDelete = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);

            preparedStatement.setString(1, answer.getText());
            textAnswerDelete = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Error! " + e.getMessage());
        }
        return textAnswerDelete;
    }
}


