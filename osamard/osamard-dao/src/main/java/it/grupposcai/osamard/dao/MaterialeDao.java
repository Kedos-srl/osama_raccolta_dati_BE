package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Materiale;
import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialeDao {

    @Select("select * " +
            "    from materiale")
    public List<NameId> getAll();

    @Select("select * from materiale " +
            " where id = #{id}")
    Materiale getMaterialeById(@Param("id") Long id);
}
