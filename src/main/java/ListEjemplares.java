import java.util.List;

public class ListEjemplares {
    private ListEjemplares.Node head;
    private int size;

    public ListEjemplares(){
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public ListEjemplares.Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Ejemplar elem) {
        ListEjemplares.Node node = new ListEjemplares.Node(elem);
        if (isEmpty()) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public Ejemplar remove(int index) {
        Ejemplar result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        ListEjemplares.Node node;
        if (index == 0) {
            result = head.getEjemplar();
            head = head.getNext();
        } else {
            ListEjemplares.Node aux1 = head;
            ListEjemplares.Node aux2 = head.getNext();
            while (index > 1) {
                aux1 = aux2;
                aux2 = aux2.getNext();
                index--;
            }
            result = aux2.getEjemplar();
            aux1.setNext(aux2.getNext());
        }
        size--;
        return result;
    }

    @Override
    public String toString() {
        return "{ size: " + size + ", Element: " + ((head == null) ? "}" : head.toString());
    }

    private class Node{
        private Ejemplar ejemplar;
        private ListEjemplares.Node next;

        public Node(Ejemplar ejemplar){
            this.ejemplar = ejemplar;
            this.next = null;
        }

        public Ejemplar getEjemplar() {
            return ejemplar;
        }

        public void setEjemplar(Ejemplar ejemplar) {
            this.ejemplar = ejemplar;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node: " +
                    "ejemplar=" + ejemplar +
                    ", next=" + next;
        }
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListEjemplares.Node))
                return false;
            Node node = (ListEjemplares.Node) obj;
            return (node.getEjemplar().equals(ejemplar));
        }

    }
}
