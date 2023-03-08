package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Moq;
import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MoqDao {

    @Select("select * from moq")
    public List<NameId> getAll();

    @Select("select * from moq " +
            " where id = #{id}")
    Moq getMoqById(@Param("id") Long id);
}
