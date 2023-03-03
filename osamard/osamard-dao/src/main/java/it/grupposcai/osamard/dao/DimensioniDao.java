package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Dimensioni;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DimensioniDao {

    @Select("select * from dimensioni")
    public List<Dimensioni> getAll();

}
