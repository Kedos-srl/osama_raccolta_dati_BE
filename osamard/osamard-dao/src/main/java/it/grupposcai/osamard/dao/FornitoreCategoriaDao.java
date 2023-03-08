package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.bean.FornitoreCategoria;
import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FornitoreCategoriaDao {

    @Select("select * from fornitore_categoria")
    public List<NameId> getAll();

    @Select("select * from fornitore_categoria " +
            " where id = #{idCategoria}")
    FornitoreCategoria getCategoriaById(@Param("idCategoria") Long idCategoria);
}
