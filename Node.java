/*
Vera Warren-Aliff
Junior Kennesaw State University Student
September 4, 2023
*/

// Node class which is used by both SimpleLinkedList and DoubleLinkedList classes
public class Node {

    private int data;
    // prev value is not used in the SimpleLinkedList class
    private Node prev;
    private Node next;

    // Constructor which sets data variable to the value passed in and sets prev and next to null
    Node(int dataIn) {

        this.data = dataIn;
        prev = null;
        next = null;
    }

    public int getData() {
        return data;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int dataIn) {
        this.data = dataIn;
    }

    public void setPrev(Node prevIn) {
        this.prev = prevIn;
    }

    public void setNext(Node nextIn) {
        this.next= nextIn;
    }

    // Returns false if the prev variable is null
    public boolean hasPrev() {
        return this.prev != null;
    }

    // Returns false if the next variable is null
    public boolean hasNext() {
        return this.next != null;
    }
}
