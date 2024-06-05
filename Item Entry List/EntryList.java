package data;

import java.util.ArrayList;
import java.util.Scanner;

class List {
    private String item1;

    public List(String item1) {
        this.item1 = item1;
    }

    public String getItem1() {
        return item1;
    }


    public void setItem1(String item) {
        this.item1 = item;
    }

    @Override
    public String toString() {
        return "Item: " + item1;
    }
}

public class EntryList {
    private static ArrayList<List> items = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
        	
            System.out.println("         Item Entry List          ");
            System.out.println("----------------------------------");
            System.out.println("1. Add item");
            System.out.println("2. View All items");
            System.out.println("3. Delete An item");
            System.out.println("4. Update An item");
            System.out.println("5. Exit");
            System.out.println("----------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    additems();
                    break;
                case 2:
                    viewitems();
                    break;
                case 3:
                    deleteitem();
                    break;
                case 4:
                    updateitem();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void additems() {
        System.out.print("Enter item1: ");
        String item1 = scanner.nextLine();

        List newItem = new List(item1);
        items.add(newItem);

        System.out.println("Items added successfully.");
        System.out.println("----------------------------------");
        
    }

    private static void viewitems() {
        if (items.isEmpty()) {
            System.out.println("No Items available.");
            System.out.println("----------------------------------");
        } else {
            System.out.println("List of Items:");
            System.out.println("--------------");
            for (List item : items) {
                System.out.println(item);
                
            }
            System.out.println("----------------------------------");
        }
    }

    private static void deleteitem() {
        System.out.print("Enter the item to delete: ");
        String item1 = scanner.nextLine();

        List itemToDelete = null;
        for (List item : items) {
            if (item.getItem1().equalsIgnoreCase(item1)) {
            	itemToDelete = item;
                break;
            }
        }

        if (itemToDelete != null) {
        	items.remove(itemToDelete);
            System.out.println("item deleted successfully.");
            System.out.println("----------------------------------");
        } else {
            System.out.println("item not found.");
            System.out.println("----------------------------------");
        }
    }

    private static void updateitem() {
        System.out.print("Enter the item to update: ");
        String item1 = scanner.nextLine();

        for (List item : items) {
            if (item.getItem1().equalsIgnoreCase(item1)) {
                System.out.print("Enter new item: ");
                String newTitle = scanner.nextLine();


                item.setItem1(newTitle);


                System.out.println("item updated successfully.");
                System.out.println("----------------------------------");
                return;
            }
        }

        System.out.println("item not found.");
        System.out.println("----------------------------------");
    }
}