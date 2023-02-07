//package listas;
//
//public class ListAbonados {
//    private ListAbonados.Node head;
//    private int size;
//
//    public ListAbonados(){
//        this.head = null;
//        this.size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public ListAbonados.Node getHead() {
//        return head;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public void add(Abonado elem) {
//        ListAbonados.Node node = new ListAbonados.Node(elem);
//        if (isEmpty()) {
//            head = node;
//        } else {
//            node.setNext(head);
//            head = node;
//        }
//        size++;
//    }
//
//    public Abonado remove(int index) {
//        Abonado result = null;
//        if (isEmpty() || index < 0 || index >= size)
//            return result;
//        ListAbonados.Node node;
//        if (index == 0) {
//            result = head.getAbonado();
//            head = head.getNext();
//        } else {
//            ListAbonados.Node aux1 = head;
//            ListAbonados.Node aux2 = head.getNext();
//            while (index > 1) {
//                aux1 = aux2;
//                aux2 = aux2.getNext();
//                index--;
//            }
//            result = aux2.getAbonado();
//            aux1.setNext(aux2.getNext());
//        }
//        size--;
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "{ size: " + size + ", Element: " + ((head == null) ? "}" : head.toString());
//    }
//
//    private class Node{
//        private Abonado abonado;
//        private ListAbonados.Node next;
//
//        public Node(Abonado abonado){
//            this.abonado = abonado;
//            this.next = null;
//        }
//
//        public Abonado getAbonado() {
//            return abonado;
//        }
//
//        public void setAbonado(Abonado abonado) {
//            this.abonado = abonado;
//        }
//
//        public ListAbonados.Node getNext() {
//            return next;
//        }
//
//        public void setNext(ListAbonados.Node next) {
//            this.next = next;
//        }
//
//        @Override
//        public String toString() {
//            return "Node: " +
//                    "ejemplar=" + abonado +
//                    ", next=" + next;
//        }
//        @Override
//        public boolean equals(Object obj) {
//            if (!(obj instanceof ListAbonados.Node))
//                return false;
//            ListAbonados.Node node = (ListAbonados.Node) obj;
//            return (node.getAbonado().equals(abonado));
//        }
//
//    }
//}
