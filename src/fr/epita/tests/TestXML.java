package fr.epita.tests;

import fr.epita.main.datamodel.Question;
import fr.epita.main.services.DAO.QuestionsReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestXML {

    public static void test() throws IOException, ParserConfigurationException, SAXException {
        System.out.println("Testing the Reader");
        List<Question> questions = QuestionsReader.getAllQuestions();
        for (Question question : questions) {
            System.out.println(question.getQuestion());
        }

        // Test the other functions




    }
}
