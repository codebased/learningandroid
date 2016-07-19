package lists;

import java.util.Arrays;

import models.Quote;
import models.QuoteFixtures;

public class FirstTheArrayProblem {
    public static void main(String[] args) {

        Quote[] quotes = {QuoteFixtures.q1, QuoteFixtures.q2, QuoteFixtures.q3};

        System.out.println(Arrays.toString(quotes));

        quotes = add(QuoteFixtures.q4, quotes);

        System.out.println(Arrays.toString(quotes));
    }

    private static Quote[] add(Quote newQuote, Quote[] array) {
        int length = array.length;
        Quote[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = newQuote;
        return newArray;
    }
}
