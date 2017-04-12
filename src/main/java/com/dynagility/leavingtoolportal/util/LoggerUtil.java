package com.dynagility.leavingtoolportal.util;

import org.slf4j.Logger;

public class LoggerUtil {
    public static void debug(Logger logger, String className, String function, String message)
    {
        logger.debug(className + "." + function + " : " + message);
    }
}