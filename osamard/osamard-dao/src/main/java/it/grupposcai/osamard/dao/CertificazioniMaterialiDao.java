package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.CertificazioniMateriali;
import it.grupposcai.osamard.bean.FornitoreCertificazione;
import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CertificazioniMaterialiDao {

    @Select("select * from certificazioni_materiali")
    List<NameId> getAll();

    @Select("select * from certificazioni_materiali " +
            " where id = #{id}")
    CertificazioniMateriali getCertificazioneMaterialiById(@Param("id") Long id);

    @Insert("insert into fornitore_certificazioni_materiali "
            + " (id_fornitore, id_certificazione)"
            + " values "
            + " (#{id_fornitore}, #{id_certificazione})")
    void insertFornitoreCertificazioniMateriali(FornitoreCertificazione fornitoreCertificazione);

    @Select(" select * from certificazioni_materiali cf" +
            " inner join fornitore_certificazioni_materiali fcf" +
            "   on cf.id = fcf.id_certificazione " +
            " where fcf.id_fornitore = #{idFornitore}")
    List<CertificazioniMateriali> getCertificazioniMaterialiByIdFornitore(@Param("idFornitore") Long idFornitore);

    @Delete("DELETE FROM fornitore_certificazioni_materiali " +
            " WHERE id_fornitore = #{idFornitore}")
    void deleteCertificazioniMaterialiByIdFornitore(Long idFornitore);
}
