package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.FornitoreCategoriaSubcategoria;
import it.grupposcai.osamard.bean.FornitoreSubcategoria;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FornitoreSubcategoriaDao {

    @Select("select * from fornitore_subcategoria")
    public List<FornitoreSubcategoria> getAll();

    @Select("select * from fornitore_subcategoria " +
            " where id = #{idSubcategoria}")
    FornitoreSubcategoria getSubcategoriaById(@Param("idSubcategoria") Long idSubcategoria);

    @Select(" select * from fornitore_categoria_subcategoria fcs " +
            " inner join fornitore f " +
            "   on f.id = fcs.id_fornitore " +
            " where fcs.id_fornitore = #{idFornitore} and fcs.id_categoria = #{idCategoria} ")
    List<FornitoreCategoriaSubcategoria> getFornitoreCategoriaSubcategoriaListByIdFornitoreAndIdCategoria(@Param("idFornitore") Long idFornitore,@Param("idCategoria")  Long idCategoria);
}
