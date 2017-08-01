package com.mebitech.Servleteducation.repository;

import com.mebitech.Servleteducation.domain.Student;

import java.util.List;

public interface StudentDao {
    public void save(Student student);
    public void delete(Long id);
    public Student finById(Long id);
    public void  update(Student student);
    public List<Student>findAll();


}
