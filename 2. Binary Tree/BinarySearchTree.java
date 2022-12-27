public class BinarySearchTree {
    protected Node root;

    BinarySearchTree() {
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

    public Node deleteIm(Node node, int value) {
        if (node.value == value) {
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node tem = node.left;
                Node par = tem;
                while (tem.right != null) {
                    par = tem;
                    tem = tem.right;
                }
                deleteIm(node, tem.value);
                node.value = tem.value;
                par.right = tem.left;
            }
        } else if (node.value > value) {
            if (node.left.value == value) {
                node.left = deleteIm(node.left, value);
            }
            else deleteIm(node.left, value);
        }
        else {
            if (node.right.value == value) {
                node.right = deleteIm(node.right, value);
            }
            else deleteIm(node.right, value);
        }
        return node;
    }

    public void delete(int value) {
        if (this.root == null) {
            return;
        }
        deleteIm(this.root, value);
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

    // Preorder
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
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.insert(17);
        binaryTree.insert(7);
        binaryTree.insert(19);
        binaryTree.insert(3);
        binaryTree.insert(13);
        binaryTree.insert(18);
        binaryTree.insert(22);
        binaryTree.insert(2);
        binaryTree.insert(5);
        binaryTree.insert(11);
        binaryTree.insert(14);
        binaryTree.insert(12);
        binaryTree.display();
        binaryTree.delete(22);
        binaryTree.display();
        binaryTree.search(13);
    }
}