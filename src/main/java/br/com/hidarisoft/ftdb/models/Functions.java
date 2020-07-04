package br.com.hidarisoft.ftdb.models;

import br.com.hidarisoft.ftdb.models.DAO.FunctionsDAO;

import java.io.Serializable;

public class Functions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;
    private String language;
    private String timeStamp;

    public Functions() {
    }

    public Functions(String version, String language, String timeStamp) {
        this.version = version;
        this.language = language;
        this.timeStamp = timeStamp;
    }

    public Functions(FunctionsDAO functionsDAO) {
        this.version = functionsDAO.getVersion();
        this.language = functionsDAO.getLanguage();
        this.timeStamp = functionsDAO.getTimeStamp();
    }


    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Functions{" +
                "version='" + version + '\'' +
                ", language='" + language + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
