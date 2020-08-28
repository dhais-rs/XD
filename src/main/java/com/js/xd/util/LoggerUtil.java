package com.js.xd.util;


import java.util.logging.Logger;

public class LoggerUtil {
    private static Logger logger = Logger.getLogger("com.js.xd.util.LoggerUtil");

    public static void info(String info){
        logger.info(info);
    }
}
