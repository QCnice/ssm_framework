package com.geek.service;

import com.geek.dao.DepDao;
import com.geek.pojo.Dep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepService {
    @Autowired
    private DepDao depDao;

    /**
     * 查询所有的dep
     * @return
     */
    @Transactional
    public List<Dep> findAllDep(){
        return depDao.findAllDep();
    }

    /**
     * 根据编号查询部门
     * @param depId
     * @return
     */
    public Dep findDepByDepId(int depId){
        return depDao.findDepByDepId(depId);
    }
}
