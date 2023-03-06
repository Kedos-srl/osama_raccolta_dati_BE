package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.NameId;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TradingDao {

    @Select("select * from trading")
    public List<NameId> getAll();

}
