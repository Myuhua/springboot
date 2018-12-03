package com.jd.dao;

import com.jd.entity.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentDao {
    @Insert("INSERT INTO t_student(name, number) VALUES(#{name}, #{number})")
    int insertStudent(Student student);

    @Delete("DELETE FROM t_student WHERE name=#{name}")
    int deleteStudent(@Param("name") String name);

    @Update("UPDATE t_student SET number=#{number} WHERE name = #{name}")
    int updateStudent(@Param("name") String name, @Param("number") String number);

    @Select("SELECT * FROM t_student WHERE name = #{name}")
    Student findStudentByName(@Param("name") String name);
}
