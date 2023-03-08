package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Prodotto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProdottoDao {


    @Select("select * from prodotto " +
            " where id = #{id}")
    Prodotto getProdottoById(@Param("id") Long id);

    @Select("select * from prodotto " +
            " where id_fornitore = #{idFornitore}")
    List<Prodotto> getProdottoByIdFornitore(@Param("idFornitore") Long idFornitore);

    @Insert("insert into prodotto (cod_articolo, id_materiale, id_dimensioni, id_moq, id_prezzo, id_fornitore, disabled, dt_inserimento, dt_modifica, last_user_modified, first_user)"
            + " values(#{cod_articolo},#{id_materiale},#{id_dimensioni},#{id_moq},#{id_prezzo},#{id_fornitore}, #{disabled}, #{dt_inserimento}, #{dt_modifica}, #{last_user_modified}, #{first_user})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insert(Prodotto contatto);
}
