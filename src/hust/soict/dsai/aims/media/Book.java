package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private static int nbBook = 0;
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }

    public Book(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbBook++;
        this.id = nbBook;
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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
}
