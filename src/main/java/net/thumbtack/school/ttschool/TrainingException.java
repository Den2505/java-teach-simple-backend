package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    private TrainingErrorCode errorCode;
    public TrainingException(TrainingErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
