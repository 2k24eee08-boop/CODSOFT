import java.util.*;

class AcademicRecord {
    private int rollNo;
    private String name;
    private String grade;

    AcademicRecord(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return "Roll No : " + rollNo +
               "\nName    : " + name +
               "\nGrade   : " + grade;
    }
}

public class CampusManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, AcademicRecord> studentMap = new HashMap<>();

        int choice;

        while (true) {

            System.out.println("\n====== CAMPUS MANAGER ======");
            System.out.println("1. Register Student");
            System.out.println("2. Find Student");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Select Option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    studentMap.put(roll,
                            new AcademicRecord(roll, name, grade));

                    System.out.println("Student Registered Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Roll No: ");
                    int search = sc.nextInt();

                    if (studentMap.containsKey(search))
                        System.out.println("\n" + studentMap.get(search));
                    else
                        System.out.println("Record Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Roll No: ");
                    int remove = sc.nextInt();

                    if (studentMap.containsKey(remove)) {
                        studentMap.remove(remove);
                        System.out.println("Student Removed Successfully!");
                    } else {
                        System.out.println("Record Not Found!");
                    }
                    break;

                case 4:
                    if (studentMap.isEmpty()) {
                        System.out.println("No Records Available!");
                    } else {
                        System.out.println("\n===== STUDENT RECORDS =====");
                        for (AcademicRecord s : studentMap.values()) {
                            System.out.println("\n" + s);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}