package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        //Create a new store
        Store newStore = new Store();
        System.out.println("Dvd numbers is:" + newStore.getQtyOrdered());

        //Create new DVD objects and add them to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        newStore.addDVD(dvd1);
        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        newStore.addDVD(dvd2);
        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());

//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        newStore.addDVD(dvd3);
//        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());

//        //delete DVD from the store
//        newStore.removeDVD(dvd3);
//        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());

        newStore.removeDVD(dvd2);
        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());

        newStore.removeDVD(dvd1);
        System.out.println("Dvd numbers is: " + newStore.getQtyOrdered());
    }
}
