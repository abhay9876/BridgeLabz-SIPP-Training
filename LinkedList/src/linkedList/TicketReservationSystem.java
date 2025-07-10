// Circular Linked List
package linkedList;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int id, String cname, String mname, String seat, String time) {
        this.ticketId = id;
        this.customerName = cname;
        this.movieName = mname;
        this.seatNumber = seat;
        this.bookingTime = time;
    }
}

public class TicketReservationSystem {
    Ticket head = null;

    public void addTicket(int id, String cname, String mname, String seat, String time) {
        Ticket newTicket = new Ticket(id, cname, mname, seat, time);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(int id) {
        if (head == null) return;
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketId == id) {
                if (prev != null) prev.next = curr.next;
                else {
                    Ticket last = head;
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

    public void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketId + " " + temp.customerName + " " + temp.movieName + " " +
                               temp.seatNumber + " " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found: " + temp.ticketId + " " + temp.customerName);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void countTickets() {
        int count = 0;
        if (head == null) {
            System.out.println("0 Tickets Booked");
            return;
        }
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        trs.addTicket(1, "John", "Matrix", "A1", "10:00 AM");
        trs.addTicket(2, "Alice", "Matrix", "A2", "10:00 AM");
        trs.displayTickets();
        trs.searchTicket("Matrix");
        trs.countTickets();
        trs.removeTicket(1);
        trs.displayTickets();
    }
}
