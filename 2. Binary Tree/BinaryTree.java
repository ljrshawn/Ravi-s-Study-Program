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
            while (true) {
                if (tem.value < value) {
                    if (tem.right == null) {
                        tem.right = new Node(value);
                        break;
                    } else {
                        tem = tem.right;
                    }
                } else if (tem.value > value) {
                    if (tem.left == null) {
                        tem.left = new Node(value);
                        break;
                    } else {
                        tem = tem.left;
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void delete(int value) {
        if (this.root == null) {
            return;
        }
        if (this.root.value == value) {
            if (this.root.left == null) {
                this.root = this.root.right;
            } else if (this.root.right == null) {
                this.root = this.root.left;
            } else {
                Node tem = this.root.left;
                Node par = tem;
                while (tem.right != null) {
                    par = tem;
                    tem = tem.right;
                }
                this.root.value = tem.value;
                par.right = tem.left;
            }
        }
    }

    public void search(int value) {
        if (this.root == null) {
            System.out.println("Empty");
            return;
        }
        Node tem = this.root;
        while (tem != null) {
            if (tem.value == value) {
                System.out.println("Find it");
                return;
            }
            if (tem.value > value) {
                tem = tem.left;
                continue;
            }
            tem = tem.right;
        }
        System.out.println("Didn't find");
    }

    private void displayNode(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            displayNode(node.left);
            displayNode(node.right);
        }
    }
    public void display() {
        displayNode(this.root);
        System.out.println();
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
        binaryTree.delete(4);
        binaryTree.display();
        binaryTree.search(4);
    }
}