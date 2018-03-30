package com.magicube.framework.upms.dao.mapper;

import com.magicube.framework.upms.dao.model.UpmsLog;
import com.magicube.framework.upms.dao.model.UpmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author justincai
 */
public interface UpmsLogMapper {

    long countByExample(UpmsLogExample example);

    int deleteByExample(UpmsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(UpmsLog record);

    int insertSelective(UpmsLog record);

    List<UpmsLog> selectByExampleWithBLOBs(UpmsLogExample example);

    List<UpmsLog> selectByExample(UpmsLogExample example);

    UpmsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByExampleWithBLOBs(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByExample(@Param("record") UpmsLog record, @Param("example") UpmsLogExample example);

    int updateByPrimaryKeySelective(UpmsLog record);

    int updateByPrimaryKeyWithBLOBs(UpmsLog record);

    int updateByPrimaryKey(UpmsLog record);

}
