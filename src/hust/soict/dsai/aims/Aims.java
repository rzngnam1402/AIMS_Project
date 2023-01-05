package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.screen.StoreScreen;

import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("---------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        Cart cart = new Cart();
        Store store = new Store();
        initializeData(store);

        StoreScreen newScreen = new StoreScreen(store, cart);

//        while (true) {
//            showMenu();
//            Scanner input = new Scanner(System.in);
//            int choice = input.nextInt();
//            if (choice == 1) {
//                viewStore(store, cart);
//            }
//            if (choice == 2) {
//                updateStore(store);
//            }
//            if (choice == 3) {
//                cart.printCart();
//                handleCartMenu(cart);
//            }
//            if (choice == 0) {
//                break;
//            }
//        }
    }

    private static void updateStore(Store store) {
        System.out.println("Delete a media from store");
        System.out.print("Enter title of media: ");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        Media result = store.searchStore(title);
        if (result != null) {
            store.removeMedia(result);
            System.out.println(result.getTitle() + " deleted");
        } else {
            System.out.println("Not found");
        }
    }

    private static void initializeData(Store store) {
        Book book1 = new Book("Harry Potter and the Order of the phoenix", "fantasy", 26f);
        book1.addAuthor("J.K Rowling");
        Book book2 = new Book("The lord of the rings", "fantasy", 75f);
        book2.addAuthor("J. R. R. Tolkien");
        book2.addAuthor("C.S Lewis");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Pulp fiction", "drama", "Quentin Tarantino", 90, 190f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion king", "Animation", "A. Pepter", 120, 20.0f);

        CompactDisc cd1 = new CompactDisc("Midnights", "Pop", "Taylor Swift", 60, 180f, "Taylor Swift");
        cd1.addTrack(new Track("Midnight rain", 20));
        cd1.addTrack(new Track("Snow on the beach", 15));

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
    }

    private static void handleDetailsMenu(Media medium, Cart cart) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            cart.addMedia(medium);
            System.out.println(medium.getTitle() + " added to cart");
        }
        if (choice == 2) {
            medium.play();
        }
        if (choice == 0) {
            System.out.println("Exit media details view");
        }
    }

    private static void handleCartMenu(Cart cart) {
        while (true) {
            cartMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Filter medias in cart by id/title ? (0:1): ");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.print("Enter title: ");
                    input.nextLine();
                    String title = input.nextLine();
                    cart.filterByTitle(title);
                }
            }
            if (choice == 2) {
                System.out.print("Sort medias in cart by title/cost ? (0:1): ");
                int option = input.nextInt();
                if (option == 1) {
                    cart.sortCartByCost();
                    cart.printCart();
                } else {
                    cart.sortCartByTitle();
                    cart.printCart();
                }
            }
            if (choice == 3) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = cart.searchCart(title);
                if (result != null) {
                    cart.removeMedia(result);
                    System.out.println("Deleted " + result.getTitle());
                    cart.printCart();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 4) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = cart.searchCart(title);
                if (result != null) {
                    result.play();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 5) {
                System.out.println("An order is created!");
                cart.clearCart();
            }
            if (choice == 0) {
                System.out.println("Exit cart view");
                break;
            }
        }
    }

    private static void viewStore(Store store, Cart cart) {
        store.printStore();
        while (true) {
            storeMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);

                if (result == null) {
                    System.out.println("Can not found media");
                } else {
                    System.out.println(result.toString());
                    mediaDetailsMenu();
                    handleDetailsMenu(result, cart);
                }
            }
            if (choice == 2) {
                System.out.println("Enter title of media");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);
                if (result != null) {
                    cart.addMedia(result);
                    System.out.println(result.getTitle() + " added to cart");
                    System.out.println("Quantity ordered: " + cart.getQtyOrdered() + " media");
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 3) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String title = input.nextLine();
                Media result = store.searchStore(title);
                if (result != null) {
                    result.play();
                } else {
                    System.out.println("Can not found media");
                }
            }
            if (choice == 4) {
                cart.printCart();
            }
            if (choice == 0) {
                System.out.println("Exit Store view");
                break;
            }
        }
    }
}

