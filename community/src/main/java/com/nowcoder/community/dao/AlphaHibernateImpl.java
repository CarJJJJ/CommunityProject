package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("Hibernate")
public class AlphaHibernateImpl implements AlphaDao {

    @Override
    public String select() {
        return "Hi！！";
    }
}
