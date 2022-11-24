public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full");
        } else {
            this.itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
    }

    void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist) {
        if (dvdlist.length + qtyOrdered > MAX_NUMBERS_ORDERED)
            System.out.println("The cart is full");
        else {
            for (int i = 0; i < dvdlist.length; i++) {
                this.itemOrdered[qtyOrdered] = dvdlist[i];
                qtyOrdered++;
            }
        }
        System.out.println("The disc has been added");
    }

    void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (2 + qtyOrdered > MAX_NUMBERS_ORDERED)
            System.out.println("The cart is full");
        else {
            this.itemOrdered[qtyOrdered] = dvd1;
            this.itemOrdered[qtyOrdered] = dvd2;
            qtyOrdered += 2;

        }
        System.out.println("The disc has been added");
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is null");
        } else {
            for (int i = 0; i < qtyOrdered; i++) {
                if (this.itemOrdered[i] == disc) {
                    this.itemOrdered[i] = this.itemOrdered[qtyOrdered - 1];
                    this.itemOrdered[qtyOrdered - 1] = null;
                    qtyOrdered--;
                }
            }
            System.out.println("The disc has been deleted");
        }
    }

    float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += this.itemOrdered[i].getCost();
        }
        return sum;
    }
}
