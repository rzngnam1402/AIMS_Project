package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public static final int STORE_LIMITS = 50;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[STORE_LIMITS];
    private int qtyStore = 0;

    public int getQtyOrdered() {
        return qtyStore;
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyStore == STORE_LIMITS) {
            System.out.println("The store is already full");
        } else {
            this.itemsInStore[qtyStore] = disc;
            qtyStore++;
            System.out.println("The disc has been added to store");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {
        if (qtyStore == 0) {
            System.out.println("The store is null");
        } else {
            for (int i = 0; i < qtyStore; i++) {
                if (this.itemsInStore[i] == disc) {
                    this.itemsInStore[i] = this.itemsInStore[qtyStore - 1];
                    this.itemsInStore[qtyStore - 1] = null;
                    qtyStore--;
                }
            }
            System.out.println("The disc has been deleted from store");
        }
    }
}
