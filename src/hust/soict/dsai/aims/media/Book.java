package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private static int nbBook = 0;
    private int id;
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        nbBook++;
        this.id = nbBook;
    }

    public Book(String title, String category, float cost, String... authors) {
        super(title, category, cost);
        nbBook++;
        this.id = nbBook;
        for (String authorName : authors) {
            this.addAuthor(authorName);
        }
    }

    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("This author already existed");
        } else {
            System.out.println(authorName + " added");
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println(authorName + " removed");
            this.authors.remove(authorName);
        } else {
            System.out.println("The author does not exist");
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("(Book): ").append(this.getTitle()).append(" - ").append(this.getCategory()).append(" - ");
        for (String author : authors) {
            str.append(author).append(", ");
        }
        return str.toString() + ": " + this.getCost() + "$";
    }

    public void play() {
        System.out.println("Book doesn't play");
    }

}
