package fr.epita.main.datamodel;

public class MCQChoice {

    private String choice;
    private boolean valid;

    public MCQChoice(String choice, boolean valid) {
        this.choice = choice;
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




}

