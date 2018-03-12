package net.thumbtack.school.colors;

public class ColorException extends Exception {
    private ColorErrorCode colorErrorCode;

    public ColorException() {
        super();
    }

    public ColorException(ColorErrorCode message, Throwable cause) {
        super(message.getErrorStrng(), cause);
        colorErrorCode = message;
    }

    public ColorException(ColorErrorCode message) {
        super(message.getErrorStrng());
        colorErrorCode = message;
    }

    public ColorException(Throwable cause) {
        super(cause);
    }


    public ColorErrorCode getErrorCode() {
        return colorErrorCode;
    }


}
