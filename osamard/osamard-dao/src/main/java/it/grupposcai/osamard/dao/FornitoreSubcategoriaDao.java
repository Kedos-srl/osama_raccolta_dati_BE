package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FornitoreSubcategoriaDao {

    @Select("select * from fornitore_subcategoria")
    public List<FornitoreSubcategoria> getAll();

}
