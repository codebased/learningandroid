package models;

import java.util.Comparator;

public class Quote {


    public static final Comparator<Quote> BY_AUTHOR_NAME = new Comparator<Quote>() {
        @Override
        public int compare(Quote lhs, Quote rhs) {
            return lhs.getAuthor().compareToIgnoreCase(rhs.getAuthor());
        }
    };

    public static final Comparator<Quote> BY_GENRE = new Comparator<Quote>() {
        @Override
        public int compare(Quote lhs, Quote rhs) {
            return lhs.getGenre().compareToIgnoreCase(rhs.getGenre());
        }
    };

    protected int id;
    protected String quote;
    protected String author;
    protected String genre;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d : %s by %s on %s", id, quote, author, genre);
    }

    public Quote() {
    }

    public Quote(int id, String quote, String author, String genre) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.genre = genre;
    }
}
