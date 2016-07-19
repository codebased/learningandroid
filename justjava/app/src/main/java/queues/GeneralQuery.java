package queues;


import java.util.ArrayDeque;
import java.util.Queue;

import queues.models.Category;
import queues.models.Customer;
import queues.models.Enquiry;

public class GeneralQuery {

    private final Queue<Enquiry> enquiries = getQueue();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;

        do {
            enquiry = getNextItem();
            if (enquiry != null) {
                enquiry.getCustomer().reply("I can solve your %s problem.", enquiry.getCategory());
            }
        } while (enquiry != null);
    }

    private Enquiry getNextItem() {
        return enquiries.poll();
    }

    public void processJobEnquiries() {
        // TODO: 19/07/16 write a code to process any query related with Jobs.
    }

    public void processOtherEnquiries() {
        // TODO: 19/07/16 write a code to process any query other than the Jobs.
    }

    public static void main(String[] args) {
        GeneralQuery helpDesk = new GeneralQuery();

        helpDesk.enquire(Customer.RAMA, Category.VEGETABLES);
        helpDesk.enquire(Customer.SHYAMA, Category.FRUITS);
        helpDesk.enquire(Customer.GHANSHYAMA, Category.MILK);
        helpDesk.enquire(Customer.RAMA, Category.JOBS);

        helpDesk.processAllEnquiries();
    }

    public Queue<Enquiry> getQueue() {
        return new ArrayDeque<>();
    }
}
