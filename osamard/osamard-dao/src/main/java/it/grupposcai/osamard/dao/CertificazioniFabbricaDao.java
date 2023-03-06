package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CertificazioniFabbricaDao {

    @Select("select * from certificazioni_fabbrica")
    public List<NameId> getAll();

}
