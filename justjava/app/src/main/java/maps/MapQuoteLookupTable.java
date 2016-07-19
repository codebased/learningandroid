package maps;


import java.util.HashMap;
import java.util.Map;

import models.Quote;

public class MapQuoteLookupTable implements QuoteLookupTable
{
    private final Map<Integer, Quote> idToQuote = new HashMap<>();

    @Override
    public Quote addQuote(final Quote quote)
    {
        final int id = quote.getId();
        if (idToQuote.containsKey(id))
        {
            throw new IllegalArgumentException(
                "Unable to add quote, duplicate id for: " + quote);
        }

        idToQuote.put(id, quote);

        return quote;
    }

    @Override
    public Quote lookupById(final int id)
    {
        return idToQuote.get(id);
    }

    public void clear()
    {
        idToQuote.clear();
    }
}
