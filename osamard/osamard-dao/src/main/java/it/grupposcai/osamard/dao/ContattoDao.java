package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Contatto;
import org.apache.ibatis.annotations.*;

public interface ContattoDao {


    @Select("select * from contatto " +
            " where id = #{id}")
    Contatto getContattoById(@Param("id") Long id);

    @Insert("insert into contatto (nome, posizione, disabled, dt_inserimento, dt_modifica, last_user_modified, first_user)"
            + " values(#{nome},#{posizione}, #{disabled}, #{dt_inserimento}, #{dt_modifica}, #{last_user_modified}, #{first_user})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insert(Contatto contatto);

    @Update(" UPDATE contatto" +
            "	SET nome = #{nome}, " +
            "       posizione = #{posizione}, " +
            "       disabled = #{disabled}, " +
            "       dt_modifica = #{dt_modifica}, " +
            "       last_user_modified = #{last_user_modified}" +
            " WHERE id = #{id}")
    void update(Contatto contatto);
}
