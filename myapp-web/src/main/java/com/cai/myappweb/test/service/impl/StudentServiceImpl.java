package com.cai.myappweb.test.service.impl;

import com.cai.myappweb.test.dao.StudentMapper;
import com.cai.myappweb.test.domain.Student;
import com.cai.myappweb.test.service.StudentService;
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

    @Override
    public Student get(Long id) {
        return mapper.get(id);
    }
}
