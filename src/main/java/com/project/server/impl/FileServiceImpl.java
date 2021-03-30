package com.project.server.impl;

import com.project.dao.Filesdao;
import com.project.entity.Files;
import com.project.server.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    @Resource
    private Filesdao filesdao;
    @Override
    public List<Files> findFiles() {
        return filesdao.findFiles();
    }

    @Override
    public Files findFile(long fId) {
        return filesdao.findFile(fId+"");
    }

    @Override
    public int addFile(Files file) {
        return filesdao.addFile(file);
    }

    @Override
    public int updateFile(Files file) {
        return filesdao.updateFile(file);
    }

    @Override
    public int removeFile(long fId) {
        return filesdao.removeFile(fId+"");
    }
}
