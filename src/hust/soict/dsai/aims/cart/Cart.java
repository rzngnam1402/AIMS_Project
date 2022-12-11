package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemOrdered = new ArrayList<>();

    public void addMedia(Media medium) {
        if (itemOrdered.contains(medium)) {
            System.out.println("The medium is already existed");
        } else {
            itemOrdered.add(medium);
            System.out.println(medium.getTitle() + " has been added");
        }
    }

    public void removeMedia(Media medium) {
        if (itemOrdered.contains(medium)) {
            itemOrdered.remove(medium);
            System.out.println(medium.getTitle() + " has been removed");
        } else {
            System.out.println("The medium is not existed");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media medium : itemOrdered) {
            sum += medium.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("************************CART*************************");
        System.out.println("Ordered Items:");
        for (Media medium : itemOrdered) {
            System.out.println(medium.toString());
        }
        System.out.printf("Total cost: [%f $] \n", totalCost());
        System.out.println("******************************************************");
    }

    //    public void searchById(int id) {
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemOrdered[i].getId() == id) {
//                System.out.println("DVD found : ");
//                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemOrdered[i].getId(), itemOrdered[i].getTitle(), itemOrdered[i].getCategory(), itemOrdered[i].getDirector(), itemOrdered[i].getLength(), itemOrdered[i].getCost());
//                return;
//            }
//        }
//        System.out.println("The DVD is not found");
//    }
//
//    public void searchTitleDVDs(String title) {
//        System.out.println("DVD found: ");
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemOrdered[i].getTitle().equalsIgnoreCase(title)) {
//                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemOrdered[i].getId(), itemOrdered[i].getTitle(), itemOrdered[i].getCategory(), itemOrdered[i].getDirector(), itemOrdered[i].getLength(), itemOrdered[i].getCost());
//                return;
//            }
//        }
//        System.out.println("The DVD is not found");
//    }
//
    public int getQtyOrdered() {
        return itemOrdered.size();
    }
}
