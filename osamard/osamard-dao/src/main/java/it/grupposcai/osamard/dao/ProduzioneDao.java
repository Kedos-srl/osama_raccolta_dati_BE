package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Produzione;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProduzioneDao {

    @Select("select * from produzione")
    public List<Produzione> getAll();

}
