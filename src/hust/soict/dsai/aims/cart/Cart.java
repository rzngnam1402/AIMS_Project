package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media medium) {
        if (itemsOrdered.contains(medium)) {
            System.out.println("The medium is already existed");
        } else {
            itemsOrdered.add(medium);
            System.out.println(medium.getTitle() + " has been added");
        }
    }

    public void removeMedia(Media medium) {
        if (itemsOrdered.contains(medium)) {
            itemsOrdered.remove(medium);
            System.out.println(medium.getTitle() + " has been removed");
        } else {
            System.out.println("The medium is not existed");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media medium : itemsOrdered) {
            sum += medium.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("************************CART*************************");
        System.out.println("Ordered Items:");
        for (Media medium : itemsOrdered) {
            System.out.println(medium.toString());
        }
        System.out.printf("Total cost: [%f $] \n", totalCost());
        System.out.println("******************************************************");
    }

    public void sortCartByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortCartByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    //    public void searchById(int id) {
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].getId() == id) {
//                System.out.println("DVD found : ");
//                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemsOrdered[i].getId(), itemsOrdered[i].getTitle(), itemsOrdered[i].getCategory(), itemsOrdered[i].getDirector(), itemsOrdered[i].getLength(), itemsOrdered[i].getCost());
//                return;
//            }
//        }
//        System.out.println("The DVD is not found");
//    }
//
//    public void searchTitleDVDs(String title) {
//        System.out.println("DVD found: ");
//        for (int i = 0; i < qtyOrdered; i++) {
//            if (itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
//                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemsOrdered[i].getId(), itemsOrdered[i].getTitle(), itemsOrdered[i].getCategory(), itemsOrdered[i].getDirector(), itemsOrdered[i].getLength(), itemsOrdered[i].getCost());
//                return;
//            }
//        }
//        System.out.println("The DVD is not found");
//    }
//
    public int getQtyOrdered() {
        return itemsOrdered.size();
    }

    public void filterByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media.toString());
            }
        }
    }

    public void clearCart() {
        itemsOrdered.clear();
    }

    public Media searchCart(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }
}
