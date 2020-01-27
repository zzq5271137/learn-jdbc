package com.mycomp.jdbc.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.mycomp.jdbc.dao.IStudentDao;
import com.mycomp.jdbc.domain.Student;
import com.mycomp.jdbc.handler.BeanHandler;
import com.mycomp.jdbc.handler.BeanListHandler;
import com.mycomp.jdbc.handler.IResultSetHandler;
import com.mycomp.jdbc.util.CRUDTemplate;

public class StudentDaoImpl implements IStudentDao {

    @Override
    public void save(Student student) {
        String sql = "insert into student(name, age) values (?,?)";
        CRUDTemplate.executeUpdate(sql, student.getName(), student.getAge());
    }

    @Override
    public void update(Integer id, Student student) {
        String sql = "update student set name = ?, age = ? where id = ?";
        CRUDTemplate.executeUpdate(sql, student.getName(), student.getAge(),
                id);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student where id = ?";
        CRUDTemplate.executeUpdate(sql, id);
    }

    @Override
    public Student get(int id) {
        String sql = "select * from student where id = ?";
        return CRUDTemplate.executeQuery(sql,
                new BeanHandler<Student>(Student.class), id);
    }

    @Override
    public List<Student> getAll() {
        String sql = "select * from student";
        return CRUDTemplate.executeQuery(sql,
                new BeanListHandler<Student>(Student.class));
    }

    @Override
    public Integer getCount() {
        String sql = "select count(*) as count from student";
        IResultSetHandler<Integer> resultSetHandler = new StudentCountHandlerImpl();
        return CRUDTemplate.executeQuery(sql, resultSetHandler);
    }
}

class StudentCountHandlerImpl implements IResultSetHandler<Integer> {
    @Override
    public Integer handle(ResultSet rs) throws Exception {
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }
}