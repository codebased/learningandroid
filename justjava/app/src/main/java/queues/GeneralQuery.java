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
                enquiry.getCustomer().reply("Please try restarting your", enquiry.getCategory());
            }
        } while (enquiry != null);
    }

    private Enquiry getNextItem() {
        return enquiries.poll();
    }

    public static void main(String[] args) {
        GeneralQuery helpDesk = new GeneralQuery();

        helpDesk.enquire(Customer.RAMA, Category.PHONE);
        helpDesk.enquire(Customer.SHYAMA, Category.PRINTER);
        helpDesk.enquire(Customer.GHANSHYAMA, Category.COMPUTER);

        helpDesk.processAllEnquiries();
    }

    public Queue<Enquiry> getQueue(){
        return new ArrayDeque<>();
    }
}
