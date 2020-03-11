package com.smh.service;

import com.smh.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog);

    List<SysLog> findAll(Integer page,Integer size);
}
