//package listas;
//
//public class ListPublicaciones {
//    private ListPublicaciones.Node head;
//    private int size;
//
//    public ListPublicaciones(){
//        this.head = null;
//        this.size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public ListPublicaciones.Node getHead() {
//        return head;
//    }
//
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    public void add(Publicacion publicacion) {
//        ListPublicaciones.Node node = new ListPublicaciones.Node(publicacion);
//        if (isEmpty()) {
//            head = node;
//        } else {
//            node.setNext(head);
//            head = node;
//        }
//        size++;
//    }
//
//    public Publicacion remove(int index) {
//        Publicacion result = null;
//        if (isEmpty() || index < 0 || index >= size)
//            return result;
//        ListPublicaciones.Node node;
//        if (index == 0) {
//            result = head.getPublicacion();
//            head = head.getNext();
//        } else {
//            ListPublicaciones.Node aux1 = head;
//            ListPublicaciones.Node aux2 = head.getNext();
//            while (index > 1) {
//                aux1 = aux2;
//                aux2 = aux2.getNext();
//                index--;
//            }
//            result = aux2.getPublicacion();
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
//        private Publicacion publicacion;
//        private ListPublicaciones.Node next;
//
//        public Node(Publicacion publicacion){
//            this.publicacion = publicacion;
//            this.next = null;
//        }
//
//        public Publicacion getPublicacion() {
//            return publicacion;
//        }
//
//        public void setPublicacion(Publicacion publicacion) {
//            this.publicacion = publicacion;
//        }
//
//        public ListPublicaciones.Node getNext() {
//            return next;
//        }
//
//        public void setNext(ListPublicaciones.Node next) {
//            this.next = next;
//        }
//
//        @Override
//        public String toString() {
//            return "Node: " +
//                    "publicacion=" + publicacion +
//                    ", next=" + next;
//        }
//        @Override
//        public boolean equals(Object obj) {
//            if (!(obj instanceof ListPublicaciones.Node))
//                return false;
//            ListPublicaciones.Node node = (ListPublicaciones.Node) obj;
//            return (node.getPublicacion().equals(publicacion));
//        }
//
//    }
//}
