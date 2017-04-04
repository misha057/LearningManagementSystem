import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
//
//    public List<Student> getStudentList(){
//        return getStudentList();
//    }

    public static void main(String[] args) throws Exception {

        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);

        Pattern patternCourseInfo = Pattern.compile("course info\\s\\d+");
        Pattern patternTransferStudent = Pattern.compile("transfer student\\s\\d+");
        Pattern patternStudentInfo = Pattern.compile("student info\\s\\d+");
        Pattern patternTrainerInfo = Pattern.compile("trainer info\\s\\d+");
        Pattern patternCreateTask = Pattern.compile("create task\\s\\d+");
        Pattern patternStudentsList = Pattern.compile("students list\\s\\d+");
        Pattern patternJournal = Pattern.compile("journal\\s\\d+");
        Pattern patternSaveJournal = Pattern.compile("save journal\\s\\d+");




        //input command
        while (true) {
            System.out.print("Please, enter the command: ");
            String command = scanner.nextLine();

            Matcher matcherCourseInfo = patternCourseInfo.matcher(command);
            Matcher matcherTransferStudent = patternTransferStudent.matcher(command);
            Matcher matcherStudentInfo = patternStudentInfo.matcher(command);
            Matcher matcherTrainerInfo = patternTrainerInfo.matcher(command);
            Matcher matcherCreateTask = patternCreateTask.matcher(command);
            Matcher matcherStudentsList = patternStudentsList.matcher(command);
            Matcher matcherJournal = patternJournal.matcher(command);
            Matcher matcherSaveJournal = patternSaveJournal.matcher(command);


            if (command.equals("create course") ||
                    matcherCourseInfo.matches() ||
                    command.equals("courses list") ||
                    command.equals("create student") ||
                    matcherTransferStudent.matches() ||
                    matcherStudentInfo.matches() ||
                    command.equals("create trainer") ||
                    matcherTrainerInfo.matches() ||
                    matcherCreateTask.matches() ||
                    matcherStudentsList.matches() ||
                    matcherJournal.matches() ||
                    matcherSaveJournal.matches() ||
                    command.equals("?") ||
                    command.equals("help") ||
                    command.equals("exit")) {


                // create course
                if (command.equals("create course")) {
                    Course course = new Course();
                    course.setID(coursesList.size());
                    System.out.print("Course name: ");
                    course.setName(scanner.nextLine());

                    // check uniqueness course name
                    if (coursesList.size() > 0) {
                        for (Course tmp : coursesList) {
                            while (tmp.getName().equals(course.getName())) {
                                System.out.println("Course name should be unique. Please enter another name: ");
                                course.setName(scanner.nextLine());
                            }
                        }
                    }

                    System.out.print("Description: ");
                    course.setDescription(scanner.nextLine());
                    System.out.print("Start date: ");
                    course.setStartDate(scanner.nextLine());
                    System.out.print("End date: ");
                    course.setEndDate(scanner.nextLine());
                    System.out.print("Days of week: ");
                    course.setDaysOfWeek(scanner.nextLine());
                    coursesList.add(course);
                    System.out.println();
                    System.out.println("Course created:");
                    System.out.println(course.toString());
                }


                // course info
                if (matcherCourseInfo.matches()) {
                    int courseId = Integer.parseInt(command.substring(12)); // find ID number from position 12

                    // find course with entered ID
                    for (int i = 0; i < coursesList.size(); i++) {
                        Course tmp = coursesList.get(i);
                        if (courseId == tmp.getID()) {
                            System.out.println(tmp.toString());
                            System.out.println();
                            break;
                        }
                        if (i == coursesList.size() - 1) {
                            System.out.println("Wrong course ID.");
                            System.out.println();
                        }
                    }
                }

                // courses list
                if (command.equals("courses list")) {
                    System.out.println(coursesList.toString()); //TODO normal output

                }

                // create student
                if (command.equals("create student")) {
                    Student student = new Student();
                    student.setID(studentsList.size() + 1);
                    System.out.print("First name: "); //TODO check uniqueness first name and last name
                    student.setFirstName(scanner.nextLine());
                    System.out.print("Last name: ");
                    student.setLastName(scanner.nextLine());
                    System.out.print("Age: ");
                    try {
                        student.setAge(scanner.nextInt());
                    } catch (InputMismatchException e) {
                        System.out.println("Enter the number from 16 to 60.");
                        student = null;
                    }
                    String tmp = scanner.nextLine();


                    // if "Age" is correct
                    if (student != null) {
                        System.out.print("Enroll (course ID divide by ','): ");
                        String tmp1 = scanner.nextLine();

                        // check the Enrollment for integer
                        String[] enrollment = tmp1.split(",", 0);
//                        System.out.println(Arrays.toString(enroll));

                        for (String anEnrollment : enrollment) {
                            try {
                                Integer intNumber = Integer.parseInt(anEnrollment);
                                //TODO check if students > 12
                                student.addEnrollment(intNumber); // TODO check if course ID not exist
                            } catch (NumberFormatException e) {
                                System.out.println("Course ID must be a number.");
                            }
                        }


                        studentsList.add(student);
                        //TODO save to DAO
//                        storage.createStudent(student.getID(), student.getFirstName(), student.getLastName(),student.getAge());
                        System.out.println();
                        System.out.println("Student created:");
                        System.out.println(student.toString());
                    } else {
                        System.out.println("Student not created.");
                    }
                }

                // transfer student
                if (matcherTransferStudent.matches()) {
                    String[] tmp = command.split(" ", 0);
                    int id = Integer.parseInt(tmp[2]);

                    Student tmp1 = studentsList.get(id);
//                    Student tmp2 = studentsList.get(studentID);
                    try {
                        System.out.print("Enter the new enrollment: ");
                        tmp1.clearEnrollment();
                        tmp1.addEnrollment(scanner.nextInt());
                        studentsList.set(id, tmp1);
                        System.out.println("Ok.");
//                        System.out.println(studentsList.get(studentID));
                        String tmp3 = scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Student not exist.");
                    } catch (InputMismatchException e) {
                        System.out.println("Enrollment is cleared. Transfer student again");
                        String tmp3 = scanner.nextLine();
                    }
                }

                // student info
                if (matcherStudentInfo.matches()) {
                    String[] tmp = command.split(" ", 0);
                    int id = Integer.parseInt(tmp[2]);
                    System.out.println(storage.studentInfo(id));
                }

                // create trainer //TODO
                if (command.equals("create trainer")) {
                    System.out.println("create trainer");
                }


                // trainer info //TODO
                if (matcherTrainerInfo.matches()) {
                    System.out.println("trainer info");
                }

                // create task //TODO
                if (matcherCreateTask.matches()) {
                    System.out.println("create task");
                }

                // students list //TODO
                if (matcherStudentsList.matches()) {
                    System.out.println("students list");
                }
                // journal //TODO
                if (matcherJournal.matches()) {
                    System.out.println("journal");
                }
                // save journal //TODO
                if (matcherSaveJournal.matches()) {
                    System.out.println("save journal");
                }

                // ? or help
                if (command.equals("help") || command.equals("?")) {
                    System.out.println("----- Available commands -----");
                    System.out.println("create course");
                    System.out.println("course info (course ID)");
                    System.out.println("courses list");
                    System.out.println("create student");
                    System.out.println("transfer student");
                    System.out.println("student info (student ID)");
                    System.out.println("create trainer");
                    System.out.println("trainer info (trainer ID)");
                    System.out.println("create task (course ID)");
                    System.out.println("students list (course ID)");
                    System.out.println("journal (course ID)");
                    System.out.println("save journal (course ID)");
                    System.out.println("exit");
                    System.out.println();
                }

                // exit
                if (command.equals("exit")) {
                    //TODO save all to DB
                    System.out.println("Goodbye.");
                    break;
                }

                // Invalid command
            } else {
                System.out.println("Invalid command. Try '?' or 'help' (in lowercase).");
                System.out.println();
            }
        }
    }
}
