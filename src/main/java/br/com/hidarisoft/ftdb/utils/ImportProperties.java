package br.com.hidarisoft.ftdb.utils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ImportProperties {
    public static final String PROPERTIES_PATH = "global.properties";

    public static String getAllFileDir() throws IOException{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(PROPERTIES_PATH);
        Properties properties = new Properties();
        properties.load(stream);

        return properties.getProperty("hidari.file.path.all");
    }

    @PostConstruct
    public void variaveisSistema() throws IOException{
        System.setProperty("hidari.file.path.all", getAllFileDir());
    }
}
