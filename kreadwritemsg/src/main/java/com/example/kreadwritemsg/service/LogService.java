package com.example.kreadwritemsg.service;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LogService {

    public static void createLogs(String message) throws InterruptedException {
//        int k = 0;
//        boolean b = true;
//        while (b) {
            log.info("Message: "+message+"was sent at " +
                    DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
//            log.error("Hello this is logError");
//            log.warn("This is Warn log");
//            k++;
//            b = k < 10;
//            Thread.sleep(1000);
//        }
    }
}