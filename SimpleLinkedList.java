/*
Vera Warren-Aliff
Junior Kennesaw State University Student
September 4, 2023
*/

// Simple-linked list data structure which only uses the next pointer from class Node
public class SimpleLinkedList extends LinkedList{

    // Calls the LinkedList class constructor
    SimpleLinkedList() {
        super();
    }

    // Creates the first node of the empty list
    @Override
    public void startList(int data) {

        setHead(new Node(data));
        getHead().setNext(null);
        setTail(getHead());
    }

    // Inserts a node at the beginning of the list
    @Override
    public void insertAtBeginning (int data) {

        // Creates the first node if the list is empty
        if (getHead() == null) {
            startList(data);
        }
        // If not empty, adds a node to the beginning of the list and links the nodes
        else {
            Node insert = new Node(data);
            insert.setNext(getHead());
            setHead(insert);
        }
    }

    @Override
    public void insertAtEnd(int data) {

        // Creates the first node if the list is empty
        if (getHead() == null) {
            startList(data);
        }
        // If not empty, adds a node to the end of the list and links the nodes
        else {
            Node insert = new Node(data);
            insert.setNext(null);
            getTail().setNext(insert);
            setTail(insert);
        }
    }

    @Override
    public void insertAfter(Node prevNode, int data) {

        // Checks if the prevNode is null
        if (prevNode != null) {

            // Sets the node to be inserted
            Node insert = new Node(data);

            // If the node to be deleted has a next node, the inserted node is set to point at the next
            if (prevNode.hasNext()) {
                Node next = prevNode.getNext();
                insert.setNext(next);
            }
            // If not, the inserted node will become the tail
            else {
                insert.setNext(null);
                setTail(insert);
            }
            // Either way, the previous node will be set to point to the inserted node
            prevNode.setNext(insert);
        }
        // If the index is a null node, will notify the user
        else {
            System.out.println("Cannot insert at this point");
        }
    }

    // Removes the node at the index that is passed in
    @Override
    public void deleteAtIndex (int index) {

        Node toRemove = get(index);
        delete(toRemove);
    }

    // Deletes the node sent in and connects it to the next node
    @Override
    public void delete(Node toDelete) {

        Node previous = getHead();
        // Checks that the node to be deleted is not the head
        if (toDelete != getHead()) {
            // Locates the node previous to the node to be deleted
            while (previous.hasNext()) {
                if (previous.getNext() == toDelete) {
                    break;
                }
                else {
                    previous = previous.getNext();
                }
            }
            // If the node to delete is the tail, sets the tail to the previous node
            if (toDelete == getTail()) {
                previous.setNext(null);
                setTail(previous);
            }
            // If not, sets the previous node's pointer to the next node after the node to be deleted
            else {
                previous.setNext(toDelete.getNext());
            }
        }
        // Runs if the node to be deleted is the head
        else {
            // If the node to be deleted has a next node, sets the head to the next
            if (getHead().hasNext()){
                setHead(toDelete.getNext());
            }
            // If the node is the head and has no next node, sets head to null
            else {
                setHead(null);
            }
            // Unlinks the node to be deleted
            toDelete.setNext(null);
        }
    }

    /*
    Reverses the elements in the list recursively
    Note that this method is very different from the reverse method in the DoubleLinkedList class
    since reversal of a double-linked list can be done fairly simply without recursion
     */
    @Override
    public void reverse() {

        // Instantiates a new list to hold the reversed nodes
        SimpleLinkedList list = new SimpleLinkedList();
        // Sets the list equal to the recursive method which adds the lists in reverse
        list = recursiveReversal(getHead(), list);
        // Sets the head and tail to the reversed list
        setHead(list.getHead());
        setTail(list.getTail());
    }

    public SimpleLinkedList recursiveReversal(Node current, SimpleLinkedList list) {

        // If the current node is not the last, sends the next node to the recursive method
        if (current.hasNext()) {
            recursiveReversal(current.getNext(), list);
        }
        // Adds the current node to the list and returns the list
        list.insertAtEnd(current.getData());
        return list;
    }

}