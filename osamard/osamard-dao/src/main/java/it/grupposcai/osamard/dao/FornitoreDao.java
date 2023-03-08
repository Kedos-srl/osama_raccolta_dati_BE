package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Fornitore;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FornitoreDao {
    @Insert("insert into fornitore "
            + " (ragione_sociale, tempo_mercato, id_categoria, id_subcategoria,  fat_tot, fat_it, numero_dipendenti, rd_interno, id_trading, id_contatto, disabled, last_user_modified, first_user)"
            + " values "
            + " (#{ragione_sociale}, #{tempo_mercato}, #{id_categoria}, #{id_subcategoria}, #{fat_tot}, #{fat_it}, #{numero_dipendenti}, #{rd_interno}, #{id_trading}, #{id_contatto}, #{disabled}, #{last_user_modified}, #{first_user}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Fornitore fornitore);

    @Select("select * from fornitore where id_fornitore = #{id_fornitore}")
    public Fornitore getById(@Param("id_fornitore") Long id_fornitore);

    @Update("update fornitore set nome =  #{nome}, cognome = #{cognome}, id_profilo = #{id_profilo}, disabled = #{disabled}, last_user_modified = #{last_user_modified}  where id_fornitore = #{id_fornitore}")
    public void update(Fornitore fornitore);

    @Select("select * from fornitore")
    public List<Fornitore> getAll();

}
