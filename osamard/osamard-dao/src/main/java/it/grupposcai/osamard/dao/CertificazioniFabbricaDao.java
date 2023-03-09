package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.CertificazioniFabbrica;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CertificazioniFabbricaDao {

    @Select("select * from certificazioni_fabbrica")
    List<NameId> getAll();

    @Select("select * from certificazioni_fabbrica " +
            " where id = #{id}")
    CertificazioniFabbrica getCertificazioneFabbricaById(@Param("id") Long id);

    @Insert("insert into fornitore_certificazioni_fabbrica "
            + " (id_fornitore, id_certificazione)"
            + " values "
            + " (#{id_fornitore}, #{id_certificazione})")
    void insertFornitoreCertificazioniFabbrica(FornitoreCertificazione fornitoreCertificazione);

    @Select(" select * from certificazioni_fabbrica cf" +
            " inner join fornitore_certificazioni_fabbrica fcf" +
            "   on cf.id = fcf.id_certificazione " +
            " where fcf.id_fornitore = #{idFornitore}")
    List<CertificazioniFabbrica> getCertificazioniFabbricaByIdFornitore(@Param("idFornitore") Long idFornitore);

}
