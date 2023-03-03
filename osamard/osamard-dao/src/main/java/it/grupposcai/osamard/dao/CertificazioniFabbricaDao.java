package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.CertificazioniFabbrica;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CertificazioniFabbricaDao {

    @Select("select * from certificazioni_fabbrica")
    public List<CertificazioniFabbrica> getAll();

}
