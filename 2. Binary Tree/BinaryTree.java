public class BinaryTree {
    protected Node root;

    BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            Node tem = this.root;
            while (tem != null) {
                if (tem.value < value) {
                    if (tem.right == null) {
                        tem.right = new Node(value);
                        tem = null;
                    } else {
                        tem = tem.right;
                    }
                } else if (tem.value > value) {
                    if (tem.left == null) {
                        tem.left = new Node(value);
                        tem = null;
                    } else {
                        tem = tem.left;
                    }
                }
            }
        }
    }

    private void displayNode(Node node) {
        if (node.left == null && node.right == null) {
            System.out.print(node.value + " ");
        } else {
            if (node.left != null){
                displayNode(node.left);
            }
            System.out.print(node.value + " ");
            if (node.left != null) {
                displayNode(node.right);
            }
        }
    }

    public void display() {
        Node tem = this.root;
        if (tem != null){
            displayNode(tem);
        }
        System.out.print("\n");
    }
}

class Node{
    protected int value;
    protected Node left;
    protected Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class Main{
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(4);
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.display();
    }
}