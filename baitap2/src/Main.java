import ra.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(8);
        bt.insert(3);
        bt.insert(10);
        bt.insert(9);
        bt.insert(15);
        //Duyet cay nhi phan theo postOrder tinh tu node root
        bt.postOder(bt.getRoot());

        boolean checkSearch =  bt.search(bt.getRoot(),10);
        if (checkSearch){
            System.out.println("Yes");
        }else {
            System.out.println("no");
        }
    }
}