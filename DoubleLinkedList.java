/*
Vera Warren-Aliff
Junior Kennesaw State University Student
September 4, 2023
*/

// Double-linked list data structure which uses both the next pointer and prev pointer from class Node
public class DoubleLinkedList extends LinkedList {

    // Calls the LinkedList class constructor
    DoubleLinkedList() {
        super();
    }

    // Creates the first node of the empty list
    @Override
    public void startList(int data) {

        setHead(new Node(data));
        getHead().setNext(null);
        getHead().setPrev(null);
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
            insert.setPrev(null);
            insert.setNext(getHead());
            getHead().setPrev(insert);
            setHead(insert);
        }
    }

    // Inserts a node at the end of the list
    @Override
    public void insertAtEnd (int data) {

        // Creates the first node if the list is empty
        if (getHead() == null) {
            startList(data);
        }
        // If not empty, adds a node to the end of the list and links the nodes
        else {
            Node insert = new Node(data);
            insert.setNext(null);
            insert.setPrev(getTail());
            getTail().setNext(insert);
            setTail(insert);
        }
    }

    // Inserts a node after the node sent in
    @Override
    public void insertAfter(Node prevNode, int data) {

        // Checks if the prevNode is null
        if (prevNode != null) {

            // Sets the node to be inserted
            Node insert = new Node(data);

            // If the node to be deleted has a next node, the inserted node is set to point at the next and vice versa
            if (prevNode.hasNext()) {
                Node next = prevNode.getNext();
                next.setPrev(insert);
                insert.setNext(next);
            }
            // If not, the inserted node will become the tail
            else {
                insert.setNext(null);
                setTail(insert);
            }
            // Either way, the previous node will be set to point to the inserted node and vice versa
            prevNode.setNext(insert);
            insert.setPrev(prevNode);
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

    // Deletes the node passed in and connects it to the other nodes
    @Override
    public void delete(Node toDelete) {

        // Sets prev and next to null in case the node to be deleted is the head and/or tail
        Node prev = null;
        Node next = null;

        // Sets prev to the node's prev value
        if (toDelete.hasPrev())
            prev = toDelete.getPrev();
        // Sets next to the node's next value
        if (toDelete.hasNext())
            next = toDelete.getNext();

        // If there is a prev node, will set prev to point at next
        if (prev != null)
            prev.setNext(next);
        // If not, will set head to next
        else {
            if (next != null) {
                setHead(next);
                getHead().setPrev(null);
            }
        }

        // If there is a next node, will set next to point at prev
        if (next != null)
            next.setPrev(prev);
        // If not, will set tail to prev
        else {
            if (prev != null) {
                setTail(prev);
                getTail().setNext(null);
            }
        }
    }

    @Override
    public void reverse() {

        // Checks if the list has elements
        if (hasElements()) {

            // Sets the current node to the tail of the list
            Node current = getTail();
            setHead(current);

            // Loops through the list backwards and links the previous node to point forwards to the current
            while(current.hasPrev()) {

                current.setNext(current.getPrev());
                current = current.getPrev();
            }

            // Sets the tail to the current node
            setTail(current);
            current = getHead();
            // Sets the pointers for the tail and head
            getTail().setNext(null);
            getHead().setPrev(null);

            // Loops through the list forwards and links the next node to point backwards to the current
            while(current.hasNext()) {

                current.getNext().setPrev(current);
                current = current.getNext();
            }
        }
        // If the list is empty, notifies the user
        else {
            System.out.println("The list is empty");
        }
    }

}