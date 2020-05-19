package io.github.weechang.leetcode;

/**
 * 打印二叉树的第k层
 *
 * @author zhangwei
 * date 2020/5/19
 * time 10:45
 */
public class PrintTreeK {

    static class Node {
        Integer val;
        Node left;
        Node right;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(Integer val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(Integer val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2l = new Node(2);
        Node n2r = new Node(3);
        root.left = n2l;
        root.right = n2r;

        Node n3l = new Node(4);
        Node n3r = new Node(5);
        n2l.left = n3l;
        n2l.right = n3r;

        Node n3ll = new Node(6);
        n2r.left = n3ll;
        int k = 3;
        printK(root, 7);
    }

    public static void printK(Node root, int k) {
        if (root == null || k < 0) {
            return;
        }
        printK(root, k, 0);
    }

    public static void printK(Node root, int k, int count) {
        if (root == null) {
            return;
        }
        if (k == count) {
            System.out.println(root.val);
        } else {
            printK(root.left, k, count + 1);
            printK(root.right, k, count + 1);
        }
    }

}
