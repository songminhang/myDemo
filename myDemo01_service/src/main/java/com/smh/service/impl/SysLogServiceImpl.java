package com.smh.service.impl;

import com.github.pagehelper.PageHelper;
import com.smh.dao.ISysLogDao;
import com.smh.domain.SysLog;
import com.smh.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/23 19:01
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    ISysLogDao iSysLogDao;

    @Override
    public void save(SysLog sysLog) {
        iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return iSysLogDao.findAll();
    }
}
