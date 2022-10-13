package ra;

import ra.Node;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node insertNode(ra.Node current, int value) {
        if (current == null) {
            current = new Node(value);
            return current;
        } else {
            if (value < current.getValue()) {
                current.setLeft(insertNode(current.getLeft(), value));
            } else if (value > current.getValue()) {
                current.setRight(insertNode(current.getRight(), value));
            } else {
                return current;
            }
        }
        return current;
    }

    public void insert(int value) {
        this.root = insertNode(this.root, value);
    }

    public void postOder(ra.Node node) {
        if (node != null) {
            postOder(node.getLeft());
            postOder(node.getRight());
            System.out.println(node.getValue());
        }
    }
    public Node search (Node current, int key){
        if (current == null){
            return null;
        }else if (key == current.getValue()){
            return current;
        }else if (key<current.getValue()){
            return search(current.getRight(),key);
        }else {
            return search(current.getRight(),key);
        }
    }
    public void delete (int key){
        this.root = delete(this.root,key);
    }
    public void deleteNode (Node node,int key){
        search(node,key);
        if(node.getLeft()==null && node.getRight()==null){
            node.
        }
    }
}
