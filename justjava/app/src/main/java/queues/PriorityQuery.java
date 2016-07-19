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

        helpDesk.enquire(Customer.RAMA, Category.JOBS);
        helpDesk.enquire(Customer.SHYAMA, Category.MILK);
        helpDesk.enquire(Customer.GHANSHYAMA, Category.VEGETABLES);

        helpDesk.processAllEnquiries();
    }

    @Override
    public Queue<Enquiry> getQueue() {
        return new PriorityQueue<>(10, BY_CATEGORY);
    }
}

// TODO: 19/07/16 Instead of using a default priority for category type, which is from 0 to X,
// can you redefine the category enum which take an integer as a priority
// and use the same for defining the priority for your queue.
// hint: create a new comparator called BY_CATEGORY_PRIORITY.
