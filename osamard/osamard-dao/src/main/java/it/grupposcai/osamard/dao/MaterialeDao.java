package it.grupposcai.osamard.dao;

import it.grupposcai.osamard.bean.Materiale;
import it.grupposcai.osamard.bean.NameId;
import it.grupposcai.osamard.bean.Prodotto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MaterialeDao {

    @Select("select id, " +
            "   nome, " +
            "   disabled, " +
            "   dt_inserimento as dtInserimento, " +
            "   dt_modifica as dtModifica, " +
            "   last_user_modified as lastUserModified, " +
            "   first_user as firstUser" +
            "    from materiale")
    public List<NameId> getAll();

    @Select("select * from materiale " +
            " where id = #{id}")
    Materiale getMaterialeById(@Param("id") Long id);
}
