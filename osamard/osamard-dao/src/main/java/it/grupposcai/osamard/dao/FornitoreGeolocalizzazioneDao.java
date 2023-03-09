package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.FornitoreGeolocalizzazione;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface FornitoreGeolocalizzazioneDao {

    @Insert("insert into fornitore_geolocalizzazione "
            + " (id_fornitore, area, citta, disabled, last_user_modified, first_user)"
            + " values "
            + " (#{id_fornitore}, #{area}, #{citta}, #{disabled}, #{last_user_modified}, #{first_user})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(FornitoreGeolocalizzazione fornitore);

    @Select("select * from fornitore_geolocalizzazione " +
            " where id = #{idGeolocalizzazione}")
    FornitoreGeolocalizzazione getGeolocalizzazioneById(@Param("idGeolocalizzazione") Long idGeolocalizzazione);

    @Select("select * from fornitore_geolocalizzazione " +
            " where id_fornitore = #{idFornitore}")
    FornitoreGeolocalizzazione getGeolocalizzazioneByIdFornitore(@Param("idFornitore") Long idFornitore);

}
