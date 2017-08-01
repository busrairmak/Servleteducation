package com.mebitech.Servleteducation.service;

import com.mebitech.Servleteducation.domain.Student;
import com.mebitech.Servleteducation.repository.StudentDao;
import com.mebitech.Servleteducation.repository.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    public StudentServiceImpl(){
        studentDao=new StudentDaoImpl() ;

    }
    @Override
    public void createStudent(Student student) {
        studentDao.save(student);

    }

    @Override
    public void removeStudent(Long id) {
        studentDao.delete(id);

    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.finById(id);
    }

    @Override
    public void updateStudent( Student student) {
        studentDao.update(student);

    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }
}
