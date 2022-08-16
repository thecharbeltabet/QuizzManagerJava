package fr.epita.main.services.DAO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import fr.epita.main.datamodel.Answer;
import fr.epita.main.datamodel.MCQChoice;
import fr.epita.main.datamodel.Question;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

// This is a reader class for reading questions from an XML file. We then insert them to our database using the DAO classes.


public class QuestionsReader {



        private static final String XML_FILENAME = "C:\\Users\\User\\Desktop\\CharbelTabet-QuizzManager-fund-java-2022\\resources\\questions.xml";

        public static List<Question> getAllQuestions() throws SAXException, IOException, ParserConfigurationException {
            Document doc = parseFile();

            List<Question> listQuestions = new ArrayList<>();
            NodeList list = doc.getElementsByTagName("question");
            for (int i = 0; i < list.getLength(); i++) {
                Question question = new Question();
                Element questionXML = (Element) list.item(i);
                int id = Integer.valueOf(questionXML.getAttribute("order")); // getting id attribute from question element

                String text = questionXML.getElementsByTagName("label").item(0).getTextContent(); // getting label element (then text content) from question element

                int difficulty = Integer.valueOf(questionXML.getElementsByTagName("difficulty").item(0).getTextContent()); // getting question question.setId(id); element
                question.setQuestion(text);
                question.setDifficulty(difficulty);

                String[] topics = getAllTopicsFromQuestion(questionXML);
                question.setTopics(String.valueOf(topics));

                Answer answer = new Answer();
                answer.setText(getAnswerFromQuestion(questionXML));

                listQuestions.add(question);
            }

            return listQuestions;
        }



        public List<String> getAllQuestionLabels()
                throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
            List<String> labelsToReturn = new ArrayList<>();

            Document doc = parseFile();

            // init xpath parser
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            // create expression to get labels
            XPathExpression expression = xpath.compile("//label");
            NodeList listElements = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

            // loop through elements to get labels
            for (int i = 0; i < listElements.getLength(); i++) {
                labelsToReturn.add(listElements.item(i).getTextContent());
            }

            return labelsToReturn;
        }



        private static String[] getAllTopicsFromQuestion(Element question) {
            // get element of tag name "topics"
            Element topicsElement = (Element) question.getElementsByTagName("topics").item(0);

            // extract all elements of tag name "topic" within the last
            NodeList topicsList = topicsElement.getElementsByTagName("topic");

            // init array size with lenght of list of topics
            String[] result = new String[topicsList.getLength()];

            // loop on each topic
            for (int i = 0; i < topicsList.getLength(); i++) {
                Element topic = (Element) topicsList.item(i);
                result[i] = topic.getTextContent(); // add topic text content to array
            }
            return result;
        }





        private static String getAnswerFromQuestion(Element question) {
            // get element of tag name "topics"
            Answer answer = new Answer();
            //System.out.println("-------------------------" + question.getElementsByTagName("answers").getLength());
            if(question.getElementsByTagName("answers").getLength()!=0) {
                Element topicsElement = (Element) question.getElementsByTagName("answers").item(0);
                NodeList topicsList = topicsElement.getElementsByTagName("answer");
                answer.setText(topicsList.item(0).getTextContent());
            }
            return answer.getText();
        }





        private List<MCQChoice> getChoicesFromQuestion(Element question) {
            List<MCQChoice> choices = new ArrayList();
            if(question.getElementsByTagName("choices").getLength()!=0) {
                Element topicsElement = (Element) question.getElementsByTagName("choices").item(0);
                NodeList topicsList = topicsElement.getElementsByTagName("choice");
                for (int i = 0; i < topicsList.getLength(); i++) {
                    Element topic = (Element) topicsList.item(i);
                    choices.add(new MCQChoice(topic.getTextContent(),Boolean.valueOf(topic.getAttribute("valid"))));
                }
            }

            return choices;
        }



        public List<String> getAllTopics() throws ParserConfigurationException, SAXException, IOException {
            List<String> result = new ArrayList();
            Document doc = parseFile();
            NodeList list = doc.getElementsByTagName("topic");
            // loop on each topic
            for (int i = 0; i < list.getLength(); i++) {
                String titre = list.item(i).getTextContent();
                if (!result.contains(titre.trim())) {
                    result.add(titre);
                }
            }
            return result;
        }








        private static Document parseFile() throws ParserConfigurationException, SAXException, IOException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(XML_FILENAME));
            return doc;
        }




        private void transformXMLFile(Document doc)
                throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {

            TransformerFactory fact = TransformerFactory.newInstance();
            Transformer transformer = fact.newTransformer();
            transformer.transform(new DOMSource(doc), new StreamResult(XML_FILENAME));
        }




//
//
//            transformXMLFile(doc);
//        }

        public List<Question> getAllQuestionsByTopic(String topic)
                throws ParserConfigurationException, SAXException, IOException {
            Document doc = parseFile();
            List<Question> listQuestions = new ArrayList<>();
            NodeList list = doc.getElementsByTagName("question");
            for (int i = 0; i < list.getLength(); i++) {
                Question question = new Question();
                Element questionXML = (Element) list.item(i);
                // getting id attribute from question
                // element
                int id = Integer.valueOf(questionXML.getAttribute("order"));
                // getting label element
                // (then text content)
                // from question element
                String label = questionXML.getElementsByTagName("label").item(0).getTextContent();
                int difficulty = Integer.valueOf(questionXML.getElementsByTagName("difficulty").item(0).getTextContent()); // getting
                // question
                question.setId(id); // element
                question.setQuestion(label);
                question.setDifficulty(difficulty);

                String[] topics = getAllTopicsFromQuestion(questionXML);
                question.setTopics(String.valueOf(topics));
//                for (String str : question.getTopics()) {
//                    if (str.equalsIgnoreCase(topic.toLowerCase())) {
//                        listQuestions.add(question);
//
//                }
                Answer answer = new Answer();
                answer.setText(getAnswerFromQuestion(questionXML));
            }
            return listQuestions;
        }

    }


