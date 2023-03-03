package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Utente;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UtenteDao {

    @Select("select * from utente where email = #{email} and password = #{password} and disabled = 0")
    public Utente login(Utente utente);

    @Select("select * from utente where id_utente = #{id_utente}")
    public Utente getById(@Param("id_utente") Long id_utente);

    @Select("select * from utente where email = #{email} LIMIT 1")
    public Utente getByEmail(@Param("email") String email);

}
