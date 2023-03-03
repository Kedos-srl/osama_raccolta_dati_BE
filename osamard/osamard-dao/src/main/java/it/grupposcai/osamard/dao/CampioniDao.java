package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Campioni;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CampioniDao {

    @Select("select * from campioni")
    public List<Campioni> getAll();

}
