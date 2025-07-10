// Singly Linked List
package linkedList;

class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    Student head;

    public void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newNode = new Student(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) return;
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    public Student searchByRollNo(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int rollNo, String newGrade) {
        Student temp = searchByRollNo(rollNo);
        if (temp != null) temp.grade = newGrade;
    }

    public void displayAll() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();
        srm.addAtEnd(1, "Alice", 20, "A");
        srm.addAtEnd(2, "Bob", 21, "B");
        srm.displayAll();
        srm.updateGrade(1, "A+");
        srm.deleteByRollNo(2);
        srm.displayAll();
    }
}