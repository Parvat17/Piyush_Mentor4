package com.epam.rd.autotasks.collections.map;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksCatalog {
    private static final String EOL = "\n";
    private Map<Author, List<Book>> catalog;

    public BooksCatalog() {
        catalog = new TreeMap<>();
    }

    public BooksCatalog(Map<Author, List<Book>> catalog) {
        this.catalog = Map.copyOf(catalog);
    }

    /**
     * Returns a List of books of the specified author.
     *
     * @param author the author of books to search for.
     * @return a list of books or {@code null}
     * if there is no such author in the catalog.
     */
    public List<Book> findByAuthor(Author author) {
        if(author == null)
            throw new NullPointerException();
        return catalog.get(author);
    }

    /**
     * @return the string representation of all authors
     * separated by the current operating system {@code lineSeparator}.
     */
    public String getAllAuthors() {
        Set<Author> authors = new TreeSet<>(catalog.keySet());
        List<String> authorString = new ArrayList<>();
        for(Author author : authors)
            authorString.add(author.toString());
        return String.join(EOL,authorString);
    }

    /**
     * Searches for pairs of (author, book) by the book title.
     * The pair must be included in the resulting map if the
     * book title contains the specified string matched ignore case.
     * All authors of the book must be specified in the
     * book authors list.
     *
     * @param pattern the string to search for in the book title.
     * @return the map which contains all found books and their authors.
     * It must be sorted by titles of books, if the titles match,
     * by increasing cost.
     */
    public Map<Book, List<Author>> findAuthorsByBookTitle(String pattern) {
        Map<Book,List<Author>> result = new TreeMap<>();

        for(Map.Entry<Author,List<Book>> entity : catalog.entrySet()){
            for(Book book : entity.getValue()){
                Pattern patternCheck = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
                Matcher matcher = patternCheck.matcher(book.getTitle());
                if(matcher.find()){
                    if(result.containsKey(book)){
                        TreeSet<Author> authorList = new TreeSet<>(result.get(book));
                        authorList.add(entity.getKey());
                        result.put(book, new ArrayList<>(authorList));
                    }
                    else {
                        ArrayList<Author> authorArrayList = new ArrayList<>();
                        authorArrayList.add(entity.getKey());
                        result.put(book, authorArrayList);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Searches for all books whose genre list contains the specified string.
     * The book must be included in the resulting list if at least
     * one genre of the book contains the specified pattern ignoring case.
     *
     * @param pattern the string to search for in the book genre list.
     * @return a set of books sorted using natural ordering.
     * @see Book class.
     */
    public Set<Book> findBooksByGenre(String pattern) {
        Set<Book> result = new TreeSet<>();
        Set<Book> books = new TreeSet<>();

        for(Map.Entry<Author,List<Book>> entity : catalog.entrySet()){
            books.addAll(entity.getValue());
        }
        String escapedPattern = Pattern.quote(pattern);
        for(Book book : books){
            for (String genre : book.getGenres()) {
                System.out.println(genre);
                Pattern match = Pattern.compile(escapedPattern, Pattern.CASE_INSENSITIVE);
                Matcher matcher = match.matcher(genre);
                if (matcher.find()) {
                    System.out.println(book);
                    result.add(book);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Searches for authors of the specified book.
     *
     * @param book the book.
     * @return a list of authors of the specified book.
     * @throws NullPointerException if the parameter is {@code null}
     */
    public List<Author> findAuthorsByBook(Book book) {
        if(book == null)
            throw new NullPointerException();
        Set<Author> result = new TreeSet<>();
        for(Map.Entry<Author, List<Book>> entity : catalog.entrySet()){
            for (Book bookEntity : entity.getValue()){
                if(bookEntity.equals(book)) {
                    result.add(entity.getKey());
                    break;
                }
            }
        }
        return List.copyOf(result);
    }

    @Override
    public String toString() {
        Map<Author,List<Book>> stringMap = new TreeMap<>(catalog);
        return stringMap.toString();
    }
}