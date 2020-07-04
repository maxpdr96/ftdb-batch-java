package br.com.hidarisoft.ftdb;

import org.h2.tools.Console;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        String[] springConfig = {"/spring/batch/configs/context.xml", "/spring/batch/configs/database.xml", "/spring/batch/jobs/job-ftdb.xml"};

        @SuppressWarnings({"resource", "unused"})
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springConfig);

        Console.main("-web", "-browser");
    }
}
