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

    void printCart() {
        float sum = 0;
        System.out.println("************************CART*************************");
        System.out.println("Odered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            float cost = itemOrdered[i].getCost();
            System.out.printf("%d.DVD - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $] \n", i + 1, itemOrdered[i].getTitle(), itemOrdered[i].getCategory(), itemOrdered[i].getDirector(), itemOrdered[i].getLength(), cost);
            sum += cost;
        }
        System.out.printf("Total cost: [%f $] \n", sum);
        System.out.println("******************************************************");
    }

    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getId() == id) {
                System.out.println("DVD found : ");
                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemOrdered[i].getId(), itemOrdered[i].getTitle(), itemOrdered[i].getCategory(), itemOrdered[i].getDirector(), itemOrdered[i].getLength(), itemOrdered[i].getCost());
                return;
            }
        }
        System.out.println("The DVD is not found");
    }

    public void searchTitleDVDs(String title) {
        System.out.println("DVD found: ");
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i].getTitle().equalsIgnoreCase(title)) {
                System.out.printf("[Id: %d] - [Title: %s] - [Category: %s] - [Director: %s] - [Length: %d] - [Price: %f $]\n", itemOrdered[i].getId(), itemOrdered[i].getTitle(), itemOrdered[i].getCategory(), itemOrdered[i].getDirector(), itemOrdered[i].getLength(), itemOrdered[i].getCost());
                return;
            }
        }
        System.out.println("The DVD is not found");
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
