package maps;


import models.Quote;

public interface QuoteLookupTable
{
    Quote lookupById(int id);

    Quote addQuote(Quote quote);

    void clear();
}
