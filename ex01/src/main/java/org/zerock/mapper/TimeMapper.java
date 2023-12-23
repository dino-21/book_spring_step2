package org.zerock.mapper;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
}
