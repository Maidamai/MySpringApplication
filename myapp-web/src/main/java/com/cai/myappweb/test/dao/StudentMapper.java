package com.cai.myappweb.test.dao;

import com.cai.myappweb.test.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cjt
 * @date 2020/2/25 15:57
 */
public interface StudentMapper {
    @Select("select * from Student where id=#{id}")
    public Student get(Long id);
}
