package com.dannyhromau.parser.core.config;

public enum ErrorMessages {
    TOO_SHORT_DATA_MESSAGE("Input length cannot be shorter than 1 character"),
    TOO_LONG_DATA_MESSAGE("Input length is too long");

    public final String label;

    ErrorMessages(String label) {
        this.label = label;
    }
}
