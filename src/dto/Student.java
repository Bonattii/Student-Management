package dto;

public class Student {
  // Fields
  private int id;
  private String name;
  private String email;
  private int studentid;
  private int studentrow;

  // Parametrized Constructor
  public Student(int id, String name, String email, int studentid, int studentrow) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.studentid = studentid;
    this.studentrow = studentrow;
  }

  // Parametrized Constructor without Id
  public Student(String name, String email, int studentid, int studentrow) {
    this.name = name;
    this.email = email;
    this.studentid = studentid;
    this.studentrow = studentrow;
  }

  // Default Constructor
  public Student() {

  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getStudentid() {
    return studentid;
  }

  public void setStudentid(int studentid) {
    this.studentid = studentid;
  }

  public int getStudentrow() {
    return studentrow;
  }

  public void setStudentrow(int studentrow) {
    this.studentrow = studentrow;
  }

  // Function to show the info
  public void showInfo() {
    System.out.println(id + "\t" + name + "\t" + email + "\t" + studentid + "\t" + studentrow + "\t");
  }
}
