package fr.epita.main.datamodel;

public class Question extends MCQQuestion {

    private String question;
    private String[] topics;
    private Integer difficulty;

    public Question(String question, String[] topics, Integer difficulty) {
        this.question = question;
        this.topics = topics;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public Integer getDifficulty() {
        return difficulty;
    }



}
