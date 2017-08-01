package com.mebitech.Servleteducation.service;

import com.mebitech.Servleteducation.domain.Student;
import com.mebitech.Servleteducation.repository.StudentDaoImpl;

import java.util.List;

public interface StudentService {
    public void createStudent (Student student);
    public void  removeStudent (Long id);
    public Student getStudent (Long id);
    public void  updateStudent(Student student);
    public List<Student>getAll();
}
