package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Null first_name. Enter real name"),
    TRAINEE_WRONG_LASTNAME("Null last_name. Enter real last_name"),
    TRAINEE_WRONG_RATING("The rating should be in the range from 1 to 5");
    private String message;
    TrainingErrorCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
