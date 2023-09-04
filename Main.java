/*
Vera Warren-Aliff
Junior Kennesaw State University Student
September 4, 2023
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initializes scanner and main menu sentinel variable
        Scanner sc = new Scanner(System.in);
        boolean contPrimary = true;

        // Loops runs until the user enters 3 to quit
        while (contPrimary) {

            System.out.print("""
                    [Main Menu]
                    1. Simple-Linked List
                    2. Double-Linked List
                    3. Quit
                    """);

            // Takes in the user's menu choice and invokes the respective action
            switch (sc.nextInt()) {

                case 1 -> subMenu(sc, 1);
                case 2 -> subMenu(sc, 2);
                case 3 -> contPrimary = false;
            }
        }

        System.out.println("Thank you for checking out my program!");
    }

    public static void subMenu(Scanner sc, int listType) {

        // Declares submenu variables
        LinkedList list;
        String menuTitle;
        boolean contSecondary = true;

        // If list type is 1, initializes list as a SimpleLinkedList
        if (listType == 1) {
            list = new SimpleLinkedList();
            menuTitle = "[Simple Linked List]";
        }
        // If list type is 2, initializes list as a DoubleLinkedList
        else if (listType == 2) {
            list = new DoubleLinkedList();
            menuTitle = "[Double Linked List]";
        }
        // If neither, throws exception
        else {
            throw new RuntimeException("No list type selected");
        }

        // Loops runs until the user enters 7 to go back
        while (contSecondary) {

            System.out.println(menuTitle);
            System.out.print("""
                    1. Add or Remove Node
                    2. Print List
                    3. Remove Duplicates
                    4. Reverse List
                    5. Get Node at Index
                    6. Get List Size
                    7. Go Back
                    """);

            // Takes in the user's submenu choice and invokes the respective action
            switch (sc.nextInt()) {

                case 1 ->
                    // Sends user to the add and remove submenu
                        addOrRemove(sc, list);
                case 2 -> list.printList();
                case 3 -> list.removeDuplicates();
                case 4 -> list.reverse();
                case 5 -> {
                    System.out.print("Enter the index of the node to get: ");
                    // Prints the data of the node at the user's index input
                    try {
                        System.out.println(list.get(sc.nextInt()).getData());
                    }
                    // Catches an exception if the user's index input is out of bounds
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> System.out.println(list.size());
                case 7 -> contSecondary = false;
            }
        }
    }

    // Add and remove node submenu in Simple-Linked List submenu
    public static void addOrRemove(Scanner sc, LinkedList list) {

        // Initializes sentinel variable
        boolean contTertiary = true;

        // Loops runs until the user enters 5 to go back
        while (contTertiary) {

            System.out.print("""
                    1. Insert at Beginning
                    2. Insert at End
                    3. Insert After Node
                    4. Remove Node
                    5. Go back
                    """);

            // Takes in the user's submenu choice and invokes the respective action
            switch (sc.nextInt()) {

                case 1 -> {
                    System.out.print("Enter an integer to add to the list: ");
                    // Sends user's data input to the DoublyLinkedList insertAtBeginning method
                    list.insertAtBeginning(sc.nextInt());
                }
                case 2 -> {
                    System.out.print("Enter an integer to add to the list: ");
                    // Sends user's data input to the DoublyLinkedList insertAtEnd method
                    list.insertAtEnd(sc.nextInt());
                }
                case 3 -> {
                    System.out.print("From 1 to size n, enter the node you want to insert after: ");
                    int index = sc.nextInt();
                    System.out.print("Enter an integer to add to the list: ");
                    try {
                        // Sends user's list index and data inputs to the DoublyLinkedList insertAfter method
                        list.insertAfter((list.get(index)), sc.nextInt());
                    }
                    // Catches an exception if the user's index input is out of bounds
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("From 1 to size n, enter the node you want to remove: ");
                    try {
                        list.deleteAtIndex(sc.nextInt());
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> contTertiary = false;
            }
        }
    }

}
