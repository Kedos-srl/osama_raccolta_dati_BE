package it.grupposcai.osamard.bean;

public class Contatto extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String posizione;

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

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }
}
