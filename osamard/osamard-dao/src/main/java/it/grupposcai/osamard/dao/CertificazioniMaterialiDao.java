package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CertificazioniMaterialiDao {

    @Select("select * from certificazioni_materiali")
    public List<NameId> getAll();

}
