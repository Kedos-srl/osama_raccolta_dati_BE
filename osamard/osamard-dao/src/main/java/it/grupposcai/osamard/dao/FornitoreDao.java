package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Fornitore;
import it.grupposcai.osamard.bean.FornitoreCategoriaSubcategoria;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface FornitoreDao {
    @Insert("insert into fornitore "
            + " (ragione_sociale, tempo_mercato, fat_tot, fat_it, numero_dipendenti, rd_interno, id_trading, id_contatto, disabled, last_user_modified, first_user)"
            + " values "
            + " (#{ragione_sociale}, #{tempo_mercato}, #{fat_tot}, #{fat_it}, #{numero_dipendenti}, #{rd_interno}, #{id_trading}, #{id_contatto}, #{disabled}, #{last_user_modified}, #{first_user}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Fornitore fornitore);

    @Select("select * from fornitore where id = #{id}")
    public Fornitore getById(@Param("id") Long id);

    @Update("update fornitore set nome =  #{nome}, cognome = #{cognome}, id_profilo = #{id_profilo}, disabled = #{disabled}, last_user_modified = #{last_user_modified}  where id_fornitore = #{id_fornitore}")
    public void update(Fornitore fornitore);

    @Select("select * from fornitore")
    public List<Fornitore> getAll();

    @Insert("insert into fornitore_categoria_subcategoria "
            + " (id_fornitore, id_categoria, id_subcategoria)"
            + " values "
            + " (#{id_fornitore}, #{id_categoria}, #{id_subcategoria}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertFornitoreCategoriaSubcategoria(FornitoreCategoriaSubcategoria fornitoreCategoriaSubcategoria2);

    @Select(" select * from fornitore_categoria_subcategoria fcs " +
            " inner join fornitore f " +
            "   on f.id = fcs.id_fornitore " +
            " where fcs.id_fornitore = #{id} ")
    List<FornitoreCategoriaSubcategoria> getFornitoreCategoriaSubcategoriaByIdForniotre(Long id);

    @Select(" select fcs.id_fornitore, fcs.id_categoria from fornitore_categoria_subcategoria fcs " +
            " inner join fornitore f " +
            "   on f.id = fcs.id_fornitore " +
            " where fcs.id_fornitore = #{id} " +
            " group by fcs.id_categoria, fcs.id_fornitore ")
    List<FornitoreCategoriaSubcategoria> getFornitoreCategoriaByIdFornitoreGroupByIdCategoria(Long id);

    List<Fornitore> getFornitoriBySearchCriteria(Map<String, Object> searchCriteria);

    Long countFornitoriBySearchCriteria(Map<String, Object> searchCriteria);
}
