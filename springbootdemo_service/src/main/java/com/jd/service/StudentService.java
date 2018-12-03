package com.jd.service;


import com.jd.dao.StudentDao;
import com.jd.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void saveStudent(Student student) {
        studentDao.insertStudent(student);
    }

    public int deleteStudent(String name) {
        studentDao.deleteStudent(name);
        return 1;
    }

    public int updateStudent(String name, String number) {
        studentDao.updateStudent(name, number);
        return 1;
    }

    public Student findStudentByName(@Param("name") String name) {
        Student student = studentDao.findStudentByName(name);
        return student;
    }
}
