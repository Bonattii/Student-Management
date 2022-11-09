package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dto.Student;

public class StudentMySQLImp implements StudentDAO {
  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;

  // Querys to be used
  private static final String INSERT = "INSERT INTO STUDENT_TABLE (name, email, studentid, studentrow) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE STUDENT_TABLE SET name = ?, email = ?, studentid = ?, studentrow = ? WHERE id = ?";
  private static final String DELETE = "DELETE FROM STUDENT_TABLE WHERE id = ?";
  private static final String GET_BY_ID = "SELECT * FROM STUDENT_TABLE WHERE id = ?";
  private static final String GET_ALL = "SELECT * FROM STUDENT_TABLE";

  // Make the connection with the db
  public StudentMySQLImp() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(StudentDAO.URL, StudentDAO.USER, StudentDAO.PASSWORD);
      System.out.println("Connected!");
    } catch (SQLException e) {
      System.out.println("Unable to Connect!");
      e.printStackTrace();
    } catch (ClassNotFoundException err) {
      err.printStackTrace();
    }
  }

  // Handle the insert on the table using the INSERT query above
  @Override
  public void insert(Student student) {
    int rowAffected = 0;

    try {
      preparedStatement = connection.prepareStatement(INSERT);
      preparedStatement.setString(1, student.getName());
      preparedStatement.setString(2, student.getEmail());
      preparedStatement.setInt(3, student.getStudentid());
      preparedStatement.setInt(4, student.getStudentrow());

      rowAffected = preparedStatement.executeUpdate();
      System.out.println(rowAffected + " row(s) affected");

    } catch (SQLException e) {
      System.out.println("Unable to insert data.");
      e.printStackTrace();

    } finally {
      try {
        preparedStatement.close();

      } catch (SQLException e) {
        System.out.println("Unable to close the statement.");
        e.printStackTrace();
      }
    }

    if (rowAffected > 0) {
      System.out.println("Successfully inserted.");
    }
  }

  // Handle the update on the table using the UPDATE query above
  @Override
  public void update(Student student) {
    int rowAffected = 0;

    try {
      preparedStatement = connection.prepareStatement(UPDATE);
      preparedStatement.setString(1, student.getName());
      preparedStatement.setString(2, student.getEmail());
      preparedStatement.setInt(3, student.getStudentid());
      preparedStatement.setInt(4, student.getStudentrow());
      preparedStatement.setInt(5, student.getId());

      rowAffected = preparedStatement.executeUpdate();
      System.out.println(rowAffected + " row(s) affected.");

    } catch (SQLException e) {
      System.out.println("Unable to update data.");
      e.printStackTrace();

    } finally {
      try {
        preparedStatement.close();

      } catch (SQLException e) {
        System.out.println("Unable to close the statement.");
        e.printStackTrace();
      }
    }

    if (rowAffected > 0) {
      System.out.println("Succesfully updated.");
    }
  }

  // Handle the delete on the table using the DELETE query above
  @Override
  public void delete(int id) {
    int rowAffected = 0;

    try {
      preparedStatement = connection.prepareStatement(DELETE);
      preparedStatement.setInt(1, id);

      rowAffected = preparedStatement.executeUpdate();
      System.out.println(rowAffected + " row(s) affected.");

    } catch (SQLException e) {
      System.out.println("Unable to delete data");
      e.printStackTrace();

    } finally {
      try {
        preparedStatement.close();

      } catch (SQLException e) {
        System.out.println("Unable to close statement.");
        e.printStackTrace();
      }
    }

    if (rowAffected > 0) {
      System.out.println("Successfully deleted.");
    }
  }

  // Handle the select * based on id on the tale using the GET_BY_ID query above
  @Override
  public Student getStudentById(int id) {
    Student student = null;

    try {
      preparedStatement = connection.prepareStatement(GET_BY_ID);
      preparedStatement.setInt(1, id);

      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setStudentid(resultSet.getInt("studentid"));
        student.setStudentrow(resultSet.getInt("studentrow"));
      }

    } catch (SQLException e) {
      System.out.println("Unable to find user for giver id.");
      e.printStackTrace();

    } finally {
      try {
        preparedStatement.close();

      } catch (Exception e) {
        System.out.println("Unable to close the statement.");
        e.printStackTrace();
      }
    }

    return student;
  }

  // Handle the select * on the table using the GET_ALL query above
  @Override
  public List<Student> getAll() {
    List<Student> studentList = new LinkedList<>();

    try {
      preparedStatement = connection.prepareStatement(GET_ALL);
      resultSet = preparedStatement.executeQuery();

      // Get the info that came as a result of the query and create a new user
      // Take this new user and add on the linked list
      while (resultSet.next()) {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setStudentid(resultSet.getInt("studentid"));
        student.setStudentrow(resultSet.getInt("studentrow"));
        studentList.add(student);
      }

    } catch (SQLException e) {
      System.out.println("Unable to find a list of all users");
      e.printStackTrace();

    } finally {
      try {
        preparedStatement.close();

      } catch (SQLException e) {
        System.out.println("Unable to close the statement");
        e.printStackTrace();
      }
    }

    return studentList;
  }
}
