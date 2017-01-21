package datastructure;

/**
 * Created by codebased on 25/09/16.
 */
public class MyLinkList {

    public Node head;
    public Node tail;

    public class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void add(int data){
        add(new Node(data));
    }

    public void add(Node node){
        if ( head == null){
            head = tail = node;
        } else {
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void traverse(){

        Node traverseHead = head;
        while(traverseHead != null){
            System.out.println(traverseHead.data);
            traverseHead = traverseHead.next;
        }
    }
}
