import java.util.Scanner;

public class SmartGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== SMART STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int total = 0;
        int highest = 0;
        int lowest = 100;
        boolean failed = false;

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter Marks for Subject " + i + " : ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid Marks! Enter between 0 and 100.");
                i--;
                continue;
            }

            total += marks;

            if (marks > highest)
                highest = marks;

            if (marks < lowest)
                lowest = marks;

            if (marks < 35)
                failed = true;
        }

        double average = (double) total / subjects;

        String grade;
        String remark;

        if (average >= 90) {
            grade = "A+";
            remark = "Outstanding";
        } else if (average >= 80) {
            grade = "A";
            remark = "Excellent";
        } else if (average >= 70) {
            grade = "B";
            remark = "Very Good";
        } else if (average >= 60) {
            grade = "C";
            remark = "Good";
        } else if (average >= 50) {
            grade = "D";
            remark = "Average";
        } else {
            grade = "F";
            remark = "Needs Improvement";
        }

        System.out.println("\n========== REPORT CARD ==========");
        System.out.println("Student Name   : " + name);
        System.out.println("Total Marks    : " + total);
        System.out.println("Average        : " + String.format("%.2f", average) + "%");
        System.out.println("Highest Mark   : " + highest);
        System.out.println("Lowest Mark    : " + lowest);
        System.out.println("Grade          : " + grade);
        System.out.println("Remark         : " + remark);

        if (failed) {
            System.out.println("Result         : FAIL");
        } else {
            System.out.println("Result         : PASS");
        }

        System.out.println("=================================");

        sc.close();
    }
}