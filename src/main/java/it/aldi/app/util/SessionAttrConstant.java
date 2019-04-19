package it.aldi.app.util;

public final class SessionAttrConstant {
    private static final String SEARCH_QUERY = "searchQuery";

    private SessionAttrConstant() {
    }

    public static String getSearchQuery() {
        return SEARCH_QUERY;
    }
}
