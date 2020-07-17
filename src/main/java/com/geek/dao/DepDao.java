package com.geek.dao;

import com.geek.pojo.Dep;

import java.util.List;

public interface DepDao {
    /**
     * 查询所有的Dep
     * @return
     */
    public List<Dep> findAllDep();

    /**
     * 根据depId查询部门
     * @param depId
     * @return
     */
    public Dep findDepByDepId(int depId);
}
