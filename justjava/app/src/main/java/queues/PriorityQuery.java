package queues;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import queues.models.Category;
import queues.models.Customer;
import queues.models.Enquiry;

public class PriorityQuery extends GeneralQuery {
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        public int compare(final Enquiry o1, final Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    public static void main(String[] args) {
        PriorityQuery helpDesk = new PriorityQuery();

        helpDesk.enquire(Customer.RAMA, Category.PHONE);
        helpDesk.enquire(Customer.SHYAMA, Category.PRINTER);
        helpDesk.enquire(Customer.GHANSHYAMA, Category.COMPUTER);

        helpDesk.processAllEnquiries();
    }

    @Override
    public Queue<Enquiry> getQueue() {
        return new PriorityQueue<>(10, BY_CATEGORY);
    }
}
