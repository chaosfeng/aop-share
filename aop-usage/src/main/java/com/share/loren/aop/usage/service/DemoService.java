package com.share.loren.aop.usage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lorenl
 * @date 11/30/2020
 */
@Service
public class DemoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void demoInsert(String action) {
        jdbcTemplate.execute("insert into demo_table values ('" + action + "')");
        if ("rollback".equals(action)) {
            int i = 1 / 0;
        }
    }

}
