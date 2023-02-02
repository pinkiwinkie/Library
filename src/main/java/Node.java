import java.util.Objects;

public class Node {
    private int element;
    private Node next;

    public Node(){

    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int element) {
        this.element = element;
        this.next = null;
    }

    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public String toString() {
        return element + ((next!=null)?", ":"}");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node))
            return false;
        Node node = (Node) obj;
        return  (node.getElement() == element);
    }
}

