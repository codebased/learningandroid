package queues.models;

/**
 * Created by codebased on 19/07/16.
 */
public enum ExtendedCategory {

    MILK("Butter and Milk"),
    VEGETABLES("Fresh Vegetables"),
    FRUITS("Fresh fruits");

    private String friendlyName;

    ExtendedCategory(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }

    public static void main(String[] args) {

        for (ExtendedCategory value : ExtendedCategory.values()) {
            System.out.printf("%s %d\n", value, value.ordinal());
        }
    }
}

// TODO: create a new enum called NewsType that can store title, tags, and relative url.
// TODO: Write test cases against your new class.