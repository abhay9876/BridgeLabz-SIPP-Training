// Circular Linked List
package linkedList;

class Process {
    int pid;
    int burstTime;
    int priority;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    Process head = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newNode = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void simulate(int quantum) {
        Process curr = head;
        while (head != null) {
            if (curr.burstTime <= quantum) {
                System.out.println("Executing Process: " + curr.pid + " (completed)");
                removeProcess(curr.pid);
                if (head == null) break;
                curr = curr.next;
            } else {
                System.out.println("Executing Process: " + curr.pid + " for quantum");
                curr.burstTime -= quantum;
                curr = curr.next;
            }
        }
    }

    public void removeProcess(int pid) {
        if (head == null) return;
        Process curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (prev != null) prev.next = curr.next;
                else {
                    Process last = head;
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

    public static void main(String[] args) {
        RoundRobinScheduler rrs = new RoundRobinScheduler();
        rrs.addProcess(1, 10, 1);
        rrs.addProcess(2, 5, 2);
        rrs.simulate(4);
    }
}
