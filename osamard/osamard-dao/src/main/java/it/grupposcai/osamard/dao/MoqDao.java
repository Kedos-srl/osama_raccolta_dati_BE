package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoqDao {

    @Select("select * from moq")
    public List<NameId> getAll();

}
