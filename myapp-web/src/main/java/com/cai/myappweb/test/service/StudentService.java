package com.cai.myappweb.test.service;

import com.cai.myappweb.test.dao.StudentMapper;
import com.cai.myappweb.test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author cjt
 * @date 2020/2/25 15:57
 */

public interface StudentService {
    public Student get(Long id);
}
