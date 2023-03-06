package it.grupposcai.osamard.bean;

public class NameId extends CommonsAttribute {

    private static final long serialVersionUID = -4822617367801876161L;

    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}