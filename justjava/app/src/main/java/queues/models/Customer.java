package queues.models;

public class Customer
{
    public static final Customer RAMA = new Customer("Rama");
    public static final Customer SHYAMA = new Customer("Shyama");
    public static final Customer GHANSHYAMA = new Customer("GhanShyama");

    private final String name;

    public Customer(final String name)
    {
        this.name = name;
    }

    public void reply(final String message, final Category category)
    {
        System.out.printf("%s: %s (%d)\n", name, String.format(message, category.name()), category.ordinal());
    }
}
