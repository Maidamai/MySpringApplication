package com.cai.myappweb.test.service.impl;

import com.cai.myappweb.test.dao.StudentMapper;
import com.cai.myappweb.test.domain.Student;
import com.cai.myappweb.test.service.StudentService;
import com.cai.myappweb.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cjt
 * @date 2020/2/25 15:58
 *
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper mapper;
    @Autowired
    SnowflakeIdWorker snowflakeIdWorker;

    @Override
    public Student get(Long id) {
        return mapper.get(id);
    }

    @Override
    public Integer insert(Student s) {
        s.setId(snowflakeIdWorker.nextId());
        return mapper.addUser(s);
    }
}
