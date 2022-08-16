package fr.epita.main.services.DAO;

import fr.epita.main.datamodel.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionDAO {

    private static String SEARCH_QUERY = "select id, question, question_type_id, topic_id from QUESTION where id=? " +
            "or title like ? or topics=?";
    private static String INSERT_QUERY = "INSERT into QUESTION (question, topics, difficulty)" +
            "VALUES (?, ?, ?, ?)";
    private static String UPDATE_QUERY = "UPDATE QUESTION SET question=?, topics=?, id=?, " +
            "difficulty=? WHERE id=?";
    private static String DELETE_QUERY = "DELETE from QUESTION where id=?";

    private static String SEARCH_BY_NAME_QUERY = "SELECT question from QUESTION where question=?";

    public static void create(Question question) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setString(1, question.getQuestion());
            String[] topics = question.getTopics();
            Array array = connection.createArrayOf("VARCHAR", topics);
            preparedStatement.setArray(2, array);
            preparedStatement.setInt(3,question.getDifficulty());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static List<Question> Questions = new ArrayList<>();

    public List<Question> search(Question question) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, question.getQuestion());
            String[] topics = question.getTopics();
            Array array = connection.createArrayOf("VARCHAR", topics);
            preparedStatement.setArray(2, array);
            preparedStatement.setInt(3,question.getDifficulty());
            ResultSet searchResult = preparedStatement.executeQuery();

            while (searchResult.next()) {
                Question question1 = new Question();
                question1.setQuestion(searchResult.getString("Question"));
                question1.setTopics(searchResult.getString("Topics"));
                question1.setDifficulty(searchResult.getInt("Difficulty"));
                Questions.add(question1);


            }
            searchResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Questions;
    }

    public static int SearchbyName(Question question) {
        int result = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME_QUERY);

            preparedStatement.setString(1,question.getQuestion());
            ResultSet searchResult = preparedStatement.executeQuery();

            while (searchResult.next()) {
                question.setQuestion(searchResult.getString("Question"));

            }
            searchResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int update(Question question) {
        int questionUpdate = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, question.getQuestion());
            String[] topics = question.getTopics();
            Array array = connection.createArrayOf("VARCHAR", topics);
            preparedStatement.setArray(2, array);
            preparedStatement.setInt(3,question.getDifficulty());
            questionUpdate = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionUpdate;
    }

    public static int delete(Question question){
        int questionDelete = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);

            preparedStatement.setString(1, question.getQuestion());
            questionDelete = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Error! " + e.getMessage());
        }
        return questionDelete;
    }

}
