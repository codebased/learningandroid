package sets;


import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import models.Quote;

public class TreeQuoteCatalogue implements Iterable<Quote>
{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;

    private SortedSet<Quote> quotes = new TreeSet<>(Quote.BY_AUTHOR_NAME);


    public Iterator<Quote> iterator()
    {
        return quotes.iterator();
    }

    public SortedSet<Quote> lightVanQuotes()
    {
        Quote lightestHeavyVanQuote = findLightestHeavyVanQuote();
        return quotes.headSet(lightestHeavyVanQuote);
    }

    public SortedSet<Quote> heavyVanQuotes()
    {
        Quote lightestHeavyVanQuote = findLightestHeavyVanQuote();
        return quotes.tailSet(lightestHeavyVanQuote);
    }

    private Quote findLightestHeavyVanQuote()
    {
        for (Quote product : quotes)
        {
            if (product.getId() > LIGHT_VAN_MAX_WEIGHT)
            {
                return product;
            }
        }
        return quotes.last();
    }
}
