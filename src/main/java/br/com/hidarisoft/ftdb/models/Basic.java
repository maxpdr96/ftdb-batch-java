package br.com.hidarisoft.ftdb.models;

import java.io.Serializable;

public class Basic implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Basic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
