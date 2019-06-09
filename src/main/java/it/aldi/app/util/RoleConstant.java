package it.aldi.app.util;

public final class RoleConstant {
    private static final String OWNER = "OWNER";

    private static final String TUTOR = "TUTOR";

    private static final String STUDENT = "STUDENT";

    private RoleConstant() {
    }

    public static String owner() {
        return OWNER;
    }

    public static String tutor() {
        return TUTOR;
    }

    public static String student() {
        return STUDENT;
    }
}
