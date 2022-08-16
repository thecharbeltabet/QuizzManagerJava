package fr.epita.main.datamodel;

public class Question {

    private int id;

    private String question;
    private String topics;
    private Integer difficulty;

    public Question (String question, String[] topics, Integer difficulty) {
        this.id = id;
        this.question = question;
        this.topics = String.valueOf(topics);
        this.difficulty = difficulty;
    }

    public Question() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getTopics() {
        return new String[]{topics};
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    // To string

    public String toString() {
        return "Question [id=" + id + ", question=" + question + ", topics=" + topics + ", difficulty=" + difficulty + "]";
    }

}
