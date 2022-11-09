package service;

import java.util.List;

import dto.Student;

public interface StudentService {
  public void insert(Student student);

  public void update(Student student);

  public void delete(int id);

  public Student getStudentById(int id);

  public List<Student> getAll();
}
