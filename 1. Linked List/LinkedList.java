public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(Node node) {
        this.head = node;
    }

    public void add(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            Node tem = this.head;
            while (tem.getNext() != null) {
                tem = tem.getNext();
            }
            tem.setNext(node);
        }
    }

    public void delete(int value) {
        if (this.head == null) {
            return;
        } else {
            if (this.head.getValue() == value) {
                this.head = this.head.getNext();
            } else {
                Node tem = this.head;
                while (tem.getNext() != null && tem.getNext().getValue() != value) {
                    tem = tem.getNext();
                }
                if (tem.getNext() != null) {
                    tem.setNext(tem.getNext().getNext());
                }
            }
        }
    }

    public void print() {
        Node tem = this.head;
        while (tem != null) {
            System.out.print(tem.getValue() + " ");
            tem = tem.getNext();
        }
    }
}

class Node{
    private int value;
    private Node next;

    protected Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Node(4));
        list.add(new Node(5));
        list.add(new Node(6));
        list.add(new Node(7));
        list.add(new Node(8));
        list.add(new Node(9));
        list.add(new Node(10));
        list.add(new Node(11));
        list.add(new Node(12));
        list.add(new Node(13));
        list.print();
    }
}