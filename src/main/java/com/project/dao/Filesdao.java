package com.project.dao;

import com.project.entity.Files;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface Filesdao {
    @Select("select * from file")
    public List<Files> findFiles();
    @Select("select * from file where fId=#{fId}")
    public Files findFile(String fId);
    @Insert("insert into file values(#{fId},#{fName},#{fDate},#{fSize},#{fPath})")
    public int addFile(Files file);
    @Update("Update file set fId=#{fId},fName=#{fName},fDate=#{fDate},fSize=#{fSize},fPath=#{fPath}")
    public int updateFile(Files file);
    @Delete("delete from file where fId=#{fId}")
    public int removeFile(String fId);
}
