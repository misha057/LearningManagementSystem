import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Course> coursesList;
    private static List<Student> studentsList;

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    Storage() throws Exception {
        coursesList = new ArrayList<>();
        studentsList = Storage.loadStudents();
    }


    private static List<Student> loadStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM StudentList";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lms.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setID(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("firstName"));
                student.setLastName(resultSet.getString("lastName"));
                student.setAge(resultSet.getInt("age"));
                String enrollment = resultSet.getString("enrollment");
                if (enrollment != null) {
                    for (String courseId : enrollment.split(", ", 0)) {
                        student.addEnrollment(Integer.parseInt(courseId));
                    }
                }
                students.add(student);
            }
            return students;
        }
    }

//    public Student studentInfo(int id) throws ClassNotFoundException {
//        Class.forName("org.sqlite.JDBC");
//        String query = "SELECT * FROM StudentList WHERE id = " + id;
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lms.db");
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(query)) {
//
//            Student student = new Student();
//            student.setID(resultSet.getInt("id"));
//            student.setFirstName(resultSet.getString("firstName"));
//            student.setLastName(resultSet.getString("lastName"));
//            student.setAge(resultSet.getInt("age"));
//            String enrollment = resultSet.getString("enrollment");
//            if (enrollment != null) {
//                String[] tmp = enrollment.split(", ", 0);
//                for (int i = 0; i <= tmp.length - 1; i++) {
//                    student.addEnrollment(Integer.parseInt(tmp[i]));
//                }
//            }
//            return student;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    public void createStudent(int id, String firstName, String lastName, int age) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String query = "INSERT INTO StudentList (id, firstName, lastName, age, enrollment) VALUES (id, firstName, lastName, age, enrollment)";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:lms.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

//            resultSet.updateInt("id", id);
//            resultSet.updateString("firstName", firstName);
//            resultSet.updateString("lastName", lastName);
//            resultSet.updateInt("age", age);
//            resultSet.updateString("enrollment", enrollment);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
