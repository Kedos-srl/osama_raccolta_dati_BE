package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Foto;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FotoDao {


    @Select("select * from foto " +
            " where id = #{id}")
    Foto getFotoById(@Param("id") Long id);

    @Select("select * from foto " +
            " where id_oggetto = #{idOggetto} and id_tipo_oggetto = #{idTipoOggetto}")
    List<Foto> getFotoByIdOggettoAndTipoOggetto(@Param("idOggetto") Long idOggetto, @Param("idTipoOggetto") Long idTipoOggetto);

    @Insert("insert into foto (titolo, path_file, id_oggetto, id_tipo_oggetto, disabled, dt_inserimento, dt_modifica, last_user_modified, first_user)"
            + " values(#{titolo},#{path_file},#{id_oggetto},#{id_tipo_oggetto}, #{disabled}, #{dt_inserimento}, #{dt_modifica}, #{last_user_modified}, #{first_user})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insert(Foto contatto);

    @Select("select * from foto " +
            " where id = #{id} and id_oggetto = #{idOggetto} and id_tipo_oggetto = #{idTipoOggetto}")
    Foto getFotoByIdAndIdOggettoAndIdTipoOggetto(@Param("id") Long id, @Param("idOggetto") Long idOggetto, @Param("idTipoOggetto") Long idTipoOggetto);

    @Delete("DELETE FROM foto WHERE id = #{id}")
    void deleteFotoById(@Param("id") Long id);

}
