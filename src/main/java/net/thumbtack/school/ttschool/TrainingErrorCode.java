package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Null first_name. Enter real name"),
    TRAINEE_WRONG_LASTNAME("Null last_name. Enter real last_name"),
    TRAINEE_WRONG_RATING("The rating should be in the range from 1 to 5"),
    GROUP_WRONG_NAME("Null group_name. Enter real name"),
    GROUP_WRONG_ROOM("Null room_name. Enter real name"),
    TRAINEE_NOT_FOUND("TRAINEE_NOT_FOUND"),
    SCHOOL_WRONG_NAME("Null school_name. Enter real name"),
    GROUP_NOT_FOUND("GROUP_NOT_FOUND"),
    DUPLICATE_GROUP_NAME("Group with this name already exists"),
    DUPLICATE_TRAINEE("Trainee already exists"),
    EMPTY_TRAINEE_QUEUE("Queue is empty");
    private String message;
    TrainingErrorCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
