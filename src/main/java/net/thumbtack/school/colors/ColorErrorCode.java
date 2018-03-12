package net.thumbtack.school.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Wrong color name. Use available colors"),
    NULL_COLOR("null color name. Use real color name");
    private String errorStrng;

    ColorErrorCode(String errorString) {
        this.errorStrng = errorString;
    }

    public String getErrorStrng() {
        return errorStrng;
    }


}
