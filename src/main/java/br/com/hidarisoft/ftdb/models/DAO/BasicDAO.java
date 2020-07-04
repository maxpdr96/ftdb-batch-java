package br.com.hidarisoft.ftdb.models.DAO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "basic")
public class BasicDAO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    @XmlElement(type = FunctionsDAO.class)
    private FunctionsDAO functionsDAO;

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

    public FunctionsDAO getFunctionsDAO() {
        return functionsDAO;
    }

    public void setFunctionsDAO(FunctionsDAO functionsDAO) {
        this.functionsDAO = functionsDAO;
    }

    @Override
    public String toString() {
        return "BasicDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", functionsDAO=" + functionsDAO +
                '}';
    }
}
