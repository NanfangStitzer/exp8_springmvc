package org.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.util.MyBatisUtil;

import java.util.Map;
import java.util.List;

@Controller
public class ClassController {
    @RequestMapping(value = "q.action", method = {RequestMethod.POST})
    @ResponseBody
    public List<Map<String, Object>> queryclass(){
        List<Map<String, Object>> c_list = null;
        SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
// 实现MyBatis对数据库的访问
        try {
            ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
            c_list = classMapper.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        return c_list;
    }
}