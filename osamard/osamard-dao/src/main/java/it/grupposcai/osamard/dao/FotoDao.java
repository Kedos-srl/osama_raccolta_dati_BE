package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Foto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FotoDao {


    @Select("select * from foto " +
            " where id = #{id}")
    Foto getFotoById(@Param("id") Long id);

    @Select("select * from foto " +
            " where id_oggetto = #{idOggetto} and id_tipo_oggetto = #{idTipoOggetto}")
    List<Foto> getFotoByIdOggettoAndTipoOggetto(@Param("idOggetto") Long idOggetto, @Param("idTipoOggetto") Long idTipoOggetto);

    @Insert("insert into foto (cod_articolo, id_materiale, id_dimensioni, id_moq, id_prezzo, id_fornitore, disabled, dt_inserimento, dt_modifica, last_user_modified, first_user)"
            + " values(#{cod_articolo},#{id_materiale},#{id_dimensioni},#{id_moq},#{id_prezzo},#{id_fornitore}, #{disabled}, #{dt_inserimento}, #{dt_modifica}, #{last_user_modified}, #{first_user})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insert(Foto contatto);
}