package it.grupposcai.osamard.bean;

public class FornitoreCategoriaSubcategoria {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long id_fornitore;
    private Long id_categoria;
    private Long id_subcategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(Long id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Long getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(Long id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }
}
