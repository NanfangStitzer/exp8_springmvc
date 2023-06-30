package org.controller;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;
import java.util.List;

public interface ClassMapper {
    @Insert("insert into exp_stu values(#{stuno},#{name},#{sex},#{score})")
    public void insertStudent(@Param("stuno") int stuno, @Param("name") String name,
                              @Param("sex") String sex, @Param("score") int score);

    @Select("select * from exp_stu where stuno = #{stuno}")
    public Map<String,Object> getStudent(int stuno);

    @Select("select * from exp_stu")
    public List<Map<String, Object>> getAllStudents();

}
