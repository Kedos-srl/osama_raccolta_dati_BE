package it.grupposcai.osamard.bean;

public class FornitoreCategoria extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNome() {
        return nome;
    }

    public void setNome(Long nome) {
        this.nome = nome;
    }
}
