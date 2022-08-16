package fr.epita.main.datamodel;

public class MCQChoice {

    private String choice;
    private boolean valid;


    private MCQQuestion mcqQuestion;


    public MCQChoice (String choice, boolean valid, MCQQuestion mcqQuestion) {
        this.choice = choice;
        this.valid = valid;
        this.mcqQuestion = mcqQuestion;
    }

    public MCQChoice() {

    }

    public MCQChoice(String Choice, Boolean valid) {
        this.choice = Choice;
        this.valid = valid;
    }


    public String getChoice() {
        return choice;
    }

    public boolean isValid() {
        return valid;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    // To string
    public String toString() {
        return "MCQChoice [choice=" + choice + ", valid=" + valid + "]";
    }



}

