package fr.epita.main.launchers;

import fr.epita.main.datamodel.Question;
import fr.epita.main.datamodel.Student;
import fr.epita.main.services.DAO.QuestionDAO;
import fr.epita.main.services.DAO.StudentDAO;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        System.out.println("Welcome to the quizz system:");
        System.out.println("Please enter your name:");
        String name = System.console().readLine();
        System.out.println("Please enter your id number:");
        int id = Integer.parseInt(System.console().readLine());
        Student student = new Student(name,id);
        System.out.println("Welcome " + student.getName() + " with id " + student.getId());

        StudentDAO.create(student);
        String userResponse = "";

        System.out.println("What operation would you like to do?");
        System.out.println("1. Assemble a quiz");
        System.out.println("2. search questions based on topic");
        System.out.println("3. Take a Quizz");
        System.out.println("4. create a question");
        System.out.println("5. update a question");
        System.out.println("6. delete a question");
        System.out.println("q. quit");
        System.out.println("Enter your choice");

        userResponse = System.console().readLine();

        while(!"q".equals(userResponse)) {
            switch (userResponse) {
                case "1":
                   //BL to assemble a quiz
                    // Using the difficulty algo

                    break;
                case "2":
                    //Search question based on topic
                    // Using the DAO

                    break;
                case "3":
                    // Assemble a quizz + correct it + display the result + export to pdf
                    // Using the DAO and queries
                    break;
                case "4":
                    String questionT = "";
                    String[] topics = new String[0];
                    int difficulty = 0;
                    System.out.println("Please enter the question");
                    questionT = System.console().readLine();
                    System.out.println("Please enter the topics");
                    topics = System.console().readLine().split(",");
                    System.out.println("Please enter the difficulty");
                    difficulty = Integer.parseInt(System.console().readLine());
                    Question question = new Question(questionT, topics, difficulty);
                    QuestionDAO.create(question);
                    break;

                case "5":
                    System.out.println("Enter Field to Update: 1. Name \n 2. Difficulty");
                    Scanner scanner = null;
                    String field = scanner.nextLine();

                    switch (field) {
                        case "1":
                            Question q1 = new Question();
                            System.out.println("Enter Question to Update: ");
                            q1.setQuestion(scanner.nextLine());
                            QuestionDAO.SearchbyName(q1);
                            QuestionDAO.update(q1);
                            System.out.println("Question Type Updated Successfully!");
                            break;
                        case "2":
                            Question q2 = new Question();
                            System.out.println("Enter the Question you want to Update: ");
                            q2.setQuestion(scanner.nextLine());
                            QuestionDAO.SearchbyName(q2);
                            System.out.println("Please set the New Question Difficulty: ");
                            q2.setDifficulty(Integer.parseInt(scanner.nextLine()));
                            QuestionDAO.update(q2);
                            System.out.println("Question Difficulty Updated Successfully!");
                            break;
                    }
                case "6":
                    Question q3 = new Question();
                    System.out.println("Enter Question Title You Want to Delete: ");
                    //q3.setQuestion(scanner.nextLine());
                    QuestionDAO.delete(q3);
                    System.out.println("Question Deleted Successfully!");
                    break;

                case "q":
                    System.exit(0);
                    break;

            }

        }
    }


















    }


