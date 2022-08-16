package fr.epita.main.datamodel;

import java.util.List;

public class Quizz {

    private String title;

    private List<Question> questions;



    public Quizz(String title, List<Question> questions) {
        this.title = title;
        this.questions = questions;
    }

    public Quizz(String title) {
        this.title = title;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // To string
    public String toString() {
        return "Quizz [title=" + title + ", questions=" + questions + "]";
    }



}
