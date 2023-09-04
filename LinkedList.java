/*
Vera Warren-Aliff
Junior Kennesaw State University Student
September 4, 2023
*/

// Abstract class inherited by SimpleLinkedList and DoubleLinkedList
public abstract class LinkedList {

    // Instantiates head and tail node objects
    private Node head;
    private Node tail;

    // Sets the head and tail nodes to null when a new list is instantiated
    LinkedList() {
        head = null;
        tail = null;
    }

    // Creates the first node of the empty list
    public abstract void startList(int data);

    // Inserts a node at the beginning of the list
    public abstract void insertAtBeginning (int data);

    // Inserts a node at the end of the list
    public abstract void insertAtEnd (int data);

    // Inserts a node after the node sent in
    public abstract void insertAfter(Node prevNode, int data);

    // Removes the node at the index that is passed in
    public abstract void deleteAtIndex(int index);

    // Deletes the node passed in and connects it to the other nodes
    public abstract void delete(Node toDelete);

    public void printList() {

        // Checks if the list has elements
        if (hasElements()) {
            // Prints the head node
            System.out.println(head.getData());
            Node current = head;
            // If there are more nodes in the list, loops through the list forwards and prints them
            while (current.hasNext()) {
                current = current.getNext();
                System.out.println(current.getData());
            }
        }
        // If the list is empty, notifies the user
        else {
            System.out.println("The list is empty");
        }
    }

    public void removeDuplicates() {

        int duplicates = 0;
        // Ensures the list is not empty
        if (hasElements()) {
            // Sets the node to be examined to the head
            Node examine = head;
            // Loops through each node to be examined for duplicates
            while (examine.hasNext()) {
                Node current = examine;
                // Loops through all following nodes to check if they are equal to the examine node
                while (current.hasNext()) {
                    current = current.getNext();
                    // If a duplicate is found, sets that node to the remove method and increments the duplicates counter
                    if (examine.getData() == current.getData()) {
                        delete(current);
                        duplicates++;
                    }
                }
                // Sets the next node to be examined after checking for duplicates
                if (examine.hasNext())
                    examine = examine.getNext();
            }
            // States how many duplicates were found and removed
            System.out.println(duplicates + " duplicates were removed");
        }
        // If the list is empty, notifies the user
        else {
            System.out.println("The list is empty");
        }
    }

    public abstract void reverse();

    // Returns true if the list is not empty
    public boolean hasElements() {
        return head != null;
    }

    // Outputs the size of the list as an integer
    public int size() {

        int size = 0;
        // Checks if the list has elements
        if (hasElements()) {
            // Increments the size counter and sets the current node
            Node current = head;
            size++;
            // Loops through list and increments the size counter on each loop
            while (current.hasNext()) {
                size++;
                current = current.getNext();
            }
        }
        return size;
    }

    // Returns the node at the index passed in beginning at 1
    public Node get(int index) {

        // Sets the current node to the head
        Node current = head;
        // Sets the counter to 1
        int count = 1;
        // While the counter does not equal the index, the loop will run
        try {
            while (count != index) {
                // If there is a next, sets the current node to the next and increments the counter
                current = current.getNext();
                count++;
            }
            // Throws exception if getdata method cannot be invoked
            current.getData();
        } catch (Exception e) {
            throw new RuntimeException("No node at this index");
        }
        // Returns the node at the index
        return current;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

}