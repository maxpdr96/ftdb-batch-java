package br.com.hidarisoft.ftdb.models;

import java.io.Serializable;

public class Functions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version;
    private String language;
    private String timeStamp;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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