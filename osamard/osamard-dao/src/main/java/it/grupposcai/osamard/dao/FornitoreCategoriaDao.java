package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FornitoreCategoriaDao {

    @Select("select * from fornitore_categoria")
    public List<NameId> getAll();

}
