package dao;

import java.util.List;

import dto.Student;

public interface StudentDAO {
  public static final String URL = "jdbc:mysql://localhost:3306/STUDENT_DB";
  public static final String USER = "root";
  public static final String PASSWORD = "Rodrigo225588!";

  public void insert(Student student);

  public void update(Student student);

  public void delete(int id);

  public Student getStudentById(int id);

  public List<Student> getAll();

}
