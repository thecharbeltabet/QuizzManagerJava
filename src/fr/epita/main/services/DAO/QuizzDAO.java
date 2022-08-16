package fr.epita.main.services.DAO;

import fr.epita.main.datamodel.Quizz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizzDAO {

    private static String SEARCH_QUERY = "select title from QUIZ where title is like ?";
    private static String INSERT_QUERY = "INSERT into QUIZ (title) VALUES (?)";
    private static String UPDATE_QUERY = "UPDATE QUIZ SET title=? WHERE title is like ?";
    private static String DELETE_QUERY = "DELETE from QUIZ where title is like ?";


    public static void create(Quizz quiz) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);

            preparedStatement.setString(1, quiz.getTitle());
            preparedStatement.setArray(2, (Array) quiz.getQuestions());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    List<Quizz> QuizList = new ArrayList<Quizz>();

    public List<Quizz> search(Quizz quiz) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, quiz.getTitle());

            ResultSet searchResult = preparedStatement.executeQuery();

            while (searchResult.next()) {
                Quizz newQuiz = new Quizz("Quiz Title");
                newQuiz.setTitle(searchResult.getString("Title"));
                QuizList.add(newQuiz);


            }
            searchResult.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return QuizList;
    }

    public static int update(Quizz quiz) {
        int quizUpdate = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, quiz.getTitle());
            preparedStatement.setArray(2, (Array) quiz.getQuestions());


            quizUpdate = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizUpdate;
    }

    public static int delete(Quizz quiz){
        int quizDelete = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EPITAexamdb", "postgres", "03545259");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);

            preparedStatement.setString(1, quiz.getTitle());
            quizDelete = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Delete Error! " + e.getMessage());
        }
        return quizDelete;
    }



}
