package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public int getQtyOrdered() {
        return itemsInStore.size();
    }

    public void addMedia(Media medium) {
        if (itemsInStore.contains(medium)) {
            System.out.println("The medium is already existed");
        } else {
            itemsInStore.add(medium);
            System.out.println(medium.getTitle() + " has been added");
        }
    }

    public void removeMedia(Media medium) {
        if (itemsInStore.contains(medium)) {
            itemsInStore.remove(medium);
            System.out.println(medium.getTitle() + " has been removed");
        } else {
            System.out.println("The medium is not existed");
        }
    }

    public void printStore() {
        System.out.println("Store");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public Media searchStore(String st) {
        for (Media media : itemsInStore) {
            if (media.isMatch(st)) {
                return media;
            }
        }
        return null;
    }

}
