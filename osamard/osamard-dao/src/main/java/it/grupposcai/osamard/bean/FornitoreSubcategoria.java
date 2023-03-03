package it.grupposcai.osamard.bean;

public class FornitoreSubcategoria extends CommonsAttribute {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long id_categoria;
    private Long nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Long getNome() {
        return nome;
    }

    public void setNome(Long nome) {
        this.nome = nome;
    }
}
