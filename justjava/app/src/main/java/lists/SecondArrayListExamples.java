package lists;

import java.util.ArrayList;
import java.util.List;

import models.Quote;
import models.QuoteFixtures;

public class SecondArrayListExamples {
    public static void main(String[] args) {


        List<Quote> quotes = new ArrayList<>();
        quotes.add(QuoteFixtures.q1);
        quotes.add(QuoteFixtures.q2);

        System.out.println(quotes);

        // Lists auto-resize, with add method
        quotes.add(QuoteFixtures.q3);

        System.out.println(quotes);

        // We can query for size
        System.out.println(quotes.size());

        // Lists have order, we retrieve elements by index
        for (int i = 0; i < quotes.size(); i++) {
            // Generic get method
            Quote quote = quotes.get(i);
            System.out.println(quote);
        }

        // can loop over them with a for loop
        for (Quote quote : quotes) {
            System.out.println(quote);
        }
    }
}
