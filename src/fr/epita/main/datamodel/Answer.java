package fr.epita.main.datamodel;

public class Answer {

    private String text;

    private Student student;
    private Question question;

    private Quizz quizz;


    public Answer (String text, Student student, Question question,Quizz quizz) {
        this.text = text;
        this.student = student;
        this.question = question;
        this.quizz = quizz;
    }

    public Answer() {

    }

    public Answer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Student getStudent() {
        return student;
    }

    public Question getQuestion() {
        return question;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setQuizz(Quizz quizz) {
        this.quizz = quizz;
    }

    // To string
    public String toString() {
        return "Answer [text=" + text + ", student=" + student + ", question=" + question + ", quizz=" + quizz + "]";
    }




}
