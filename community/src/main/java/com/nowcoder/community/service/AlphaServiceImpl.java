package com.nowcoder.community.service;


import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope
public class AlphaServiceImpl implements AlphaService{
    @Autowired
    private AlphaDao alphaDao;
    public AlphaServiceImpl(){
        System.out.println("AlphaBean实例化");
    }
    @PostConstruct
    public void init(){
        System.out.println("AlphaBean初始化");
    }
    @PreDestroy
    public void destory(){
        System.out.println("AlphaBean销毁");
    }
    public String find(){
        return alphaDao.select();
    }
}
