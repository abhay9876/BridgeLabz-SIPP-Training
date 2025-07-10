// Circular Linked List
package linkedList;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {
    Task head = null;

    public void addTask(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void removeTask(int id) {
        if (head == null) return;
        Task curr = head, prev = null;
        do {
            if (curr.id == id) {
                if (prev != null) prev.next = curr.next;
                else {
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayAll() {
        if (head == null) return;
        Task curr = head;
        do {
            System.out.println(curr.id + " " + curr.name + " " + curr.priority + " " + curr.dueDate);
            curr = curr.next;
        } while (curr != head);
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addTask(1, "TaskA", 1, "2025-07-10");
        ts.addTask(2, "TaskB", 2, "2025-07-11");
        ts.displayAll();
        ts.removeTask(1);
        ts.displayAll();
    }
}