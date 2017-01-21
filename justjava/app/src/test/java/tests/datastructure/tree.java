//package tests.datastructure;
//
//import java.io.Serializable;
//
//public class Tree<E> implements Serializable {
//
//    Node<E> root;
//
//    public Tree() {
//        root = null;
//    }
//
//    protected Tree(Node<E> root){
//        this.root = root;
//    }
//
//    public void add(Node<E> n) {
//        if (root == null) {
//            root = n;
//        } else {
//            if (n.data < root.data) {
//                root.right = n;
//            } else {
//                root.left = n;
//            }
//        }
//    }
//
//    protected class Node<DType> {
//        protected DType data;
//        protected Node left;
//        protected Node right;
//        protected Node parent;
//
//        public Node(DType data) {
//            this.left = null;
//            this.right = null;
//            this.parent = null;
//            this.data = data;
//        }
//    }
//
////    public static void main(String[] args) {
////
////        tree t = new tree();
////        node n = new node(10);
////        t.add(n);
////        n = new node(1);
////        t.add(n);
////    }
//}
