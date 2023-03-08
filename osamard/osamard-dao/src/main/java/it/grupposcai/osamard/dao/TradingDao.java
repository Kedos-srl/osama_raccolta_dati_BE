package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.bean.Trading;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TradingDao {

    @Select("select * from trading")
    public List<NameId> getAll();

    @Select("select * from trading " +
            " where id = #{id}")
    Trading getTradingById(Long id);
}
