package com.mebitech.Servleteducation.repository;

import com.mebitech.Servleteducation.domain.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private DatabaseOperation databaseOperation;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public StudentDaoImpl() {
        databaseOperation = new DatabaseOperation();
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student (name,no) VALUES(?,?)";
        try {
            databaseOperation.connect();
            preparedStatement = databaseOperation.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getNo());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Studentv is saved");

            } else if (preparedStatement.executeUpdate() == 0) {
                System.out.println("Student is not saved ");
            }
            preparedStatement.close();
            databaseOperation.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM student WHERE id=?";
        try {
            databaseOperation.connect();
            preparedStatement = databaseOperation.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Student is deleted");
            } else if (preparedStatement.executeUpdate() == 0) {
                System.out.println("Student isnt deleted");
            }
            preparedStatement.close();
            databaseOperation.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student finById(Long id) {
        String sql = "SELECT * FROM student WHERE id=?";
        try {
            databaseOperation.connect();
            preparedStatement = databaseOperation.getConnection().prepareStatement(sql);

            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                String name = resultSet.getString("name");
                Integer no = resultSet.getInt("no");

                resultSet.close();
                preparedStatement.close();
                databaseOperation.disconnect();
                return new Student(id, name, no);
            }
            resultSet.close();
            preparedStatement.close();
            databaseOperation.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }


    @Override
    public void update(Student student) {

        String sql = "UPDATE student SET name=?,no=? WHERE id=?";
        try {
            databaseOperation.connect();
            preparedStatement = databaseOperation.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getNo());
            preparedStatement.setLong(3, student.getId());


            preparedStatement.execute();
            preparedStatement.close();
            databaseOperation.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<Student>();
        String sql = "SELECT * FROM student";
        try {
            databaseOperation.connect();
            preparedStatement = databaseOperation.getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer no = resultSet.getInt("no");
                Student student = new Student(id, name, no);
                list.add(student);
            }
            resultSet.close();
            preparedStatement.close();
            databaseOperation.disconnect();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
