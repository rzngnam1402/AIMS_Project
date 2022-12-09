package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;

public class Aims {
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();
        System.out.println(anOrder.getQtyOrdered());

        //Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);
        System.out.println(anOrder.getQtyOrdered());

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);
        System.out.println(anOrder.getQtyOrdered());

//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//        anOrder.addMedia(dvd3);
//        System.out.println(anOrder.getQtyOrdered());

        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        //delete DVD from the cart
//        anOrder.removeMedia();(dvd3);
//        System.out.println(anOrder.getQtyOrdered());
//        System.out.println("Total Cost is: ");
//        System.out.println(anOrder.totalCost());

        anOrder.removeMedia(dvd2);
        System.out.println(anOrder.getQtyOrdered());
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeMedia(dvd1);
        System.out.println(anOrder.getQtyOrdered());
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost() + "\n");

        Book newOrder = new Book("Harry Potter and the Order of the phoenix", "fantasy", 10);
        newOrder.addAuthor("J.K.Rowling");
        System.out.println("The book cost is:" + " " + newOrder.getCost());
    }
}
