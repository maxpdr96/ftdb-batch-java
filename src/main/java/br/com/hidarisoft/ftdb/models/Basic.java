package br.com.hidarisoft.ftdb.models;

import br.com.hidarisoft.ftdb.models.DAO.BasicDAO;

import java.io.Serializable;

public class Basic implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Basic(BasicDAO basicDAO) {
        this.id = basicDAO.getId();
        this.name = basicDAO.getName();
    }

    public Basic(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
