package com.project.server;

import com.project.entity.Files;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FileService {
    public List<Files> findFiles();
    public Files findFile(long fId);
    public int addFile(Files file);
    public int updateFile(Files file);
    public int removeFile(long fId);
}
