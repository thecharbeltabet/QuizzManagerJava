package fr.epita.tests;

import fr.epita.main.datamodel.*;

import java.util.LinkedList;
import java.util.List;

public class Test1 {


        public static void test()  {

                // Testing student Class
                Student s = new Student("John", 1);
                System.out.println(s);
                s.setName("John Doe");
                System.out.println(s);
                s.setId(2);
                System.out.println(s);

                // Testing Question class
                Question q = new Question("What is the capital of France?", new String[]{"geography", "world"}, 1);
                System.out.println(q);
                q.setQuestion("What is OOP?");
                System.out.println(q);
                q.setTopics(String.valueOf(new String[]{"Programming", "Languages", "Software"}));
                System.out.println(q);
                q.setDifficulty(2);
                System.out.println(q);


                // Testing Quizz class
                Question q2 = new Question("What is the capital of Lebanon?", new String[]{"geography", "world"}, 2);

                List<Question> QList = new LinkedList<Question>();
                QList.add(q);
                Quizz quizz = new Quizz("Quizz 1", QList);
                System.out.println(quizz);
                quizz.setTitle("Quizz 2");
                System.out.println(quizz);
                QList.add(q2);
                quizz.setQuestions(QList);
                System.out.println(quizz);


                // Testing MCQChoice class
                MCQChoice mcq = new MCQChoice("Paris", true);
                System.out.println(mcq);
                mcq.setChoice("London");
                System.out.println(mcq);
                mcq.setValid(false);
                System.out.println(mcq);


                // Testing MCQAnswer class
                MCQAnswer mcqAnswer = new MCQAnswer(s, quizz, mcq);
                System.out.println(mcqAnswer);


        }
}



