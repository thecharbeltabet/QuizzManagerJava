package fr.epita.main.datamodel;

public class MCQAnswer {

    private Student student;

    private Quizz quizz;

    private MCQChoice  mcqChoice;

        public MCQAnswer (Student student, Quizz quizz, MCQChoice mcqChoice) {
            this.student = student;
            this.quizz = quizz;
            this.mcqChoice = mcqChoice;
        }

    public MCQAnswer() {

    }

    public Student getStudent() {
        return student;
    }

    public Quizz getQuizz() {
        return quizz;
    }

    public MCQChoice getMcqChoice() {
        return mcqChoice;
    }

    // To string
    public String toString() {
        return "MCQAnswer [student=" + student + ", quizz=" + quizz + ", mcqChoice=" + mcqChoice + "]";
    }



}
