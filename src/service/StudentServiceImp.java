package service;

import java.util.List;

import dao.StudentDAO;
import dao.StudentMySQLImp;
import dto.Student;

public class StudentServiceImp implements StudentService {
  private StudentDAO studentDAO = new StudentMySQLImp();

  @Override
  public void insert(Student student) {
    studentDAO.insert(student);
  }

  @Override
  public void update(Student student) {
    studentDAO.update(student);
  }

  @Override
  public void delete(int id) {
    studentDAO.delete(id);
  }

  @Override
  public Student getStudentById(int id) {
    return studentDAO.getStudentById(id);
  }

  @Override
  public List<Student> getAll() {
    return studentDAO.getAll();
  }
}
