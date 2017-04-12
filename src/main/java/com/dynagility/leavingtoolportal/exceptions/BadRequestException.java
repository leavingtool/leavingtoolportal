package com.dynagility.leavingtoolportal.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadRequestException extends RuntimeException {
    /**
     * Bad Request Exception
     */
    private static final long serialVersionUID = 5177229803384183423L;
    private List<String> missing = new ArrayList<>();
    private List<String> badFormat = new ArrayList<>();
    public Map<String, Object> getAllMessages() {
        if (!missing.isEmpty() || !badFormat.isEmpty()) {
            Map<String, Object> messages = new HashMap<>();
            messages.put("missing", this.missing);
            messages.put("badFormat", this.badFormat);
            return messages;
        } else {
            return null;
        }
        
    }
    public void addMissing(String mes) {
        missing.add(mes);
    }
    public void addBadFormat(String mes) {
        badFormat.add(mes);
    }
}
