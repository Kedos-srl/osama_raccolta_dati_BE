package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Moq;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoqDao {

    @Select("select * from moq")
    public List<Moq> getAll();

}
