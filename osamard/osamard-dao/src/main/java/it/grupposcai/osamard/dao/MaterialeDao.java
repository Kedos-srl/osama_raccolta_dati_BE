package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Materiale;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialeDao {

    @Select("select * from materiale")
    public List<Materiale> getAll();

}
