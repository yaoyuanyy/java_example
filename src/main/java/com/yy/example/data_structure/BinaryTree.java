package com.yy.example.data_structure;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * 二叉树
 * <pre>
 *     参考：
 *     <a href="http://blog.csdn.net/u012124438/article/details/77986680">http://blog.csdn.net/u012124438/article/details/77986680</a>
 *     <a href="http://www.jianshu.com/p/e96b1c503c6a">http://www.jianshu.com/p/e96b1c503c6a</a>
 *     <a href="http://www.voidcn.com/article/p-oxgolnrk-mm.html">http://www.voidcn.com/article/p-oxgolnrk-mm.html</a>
 *     <a href="http://blog.csdn.net/lsjseu/article/details/10907037">http://blog.csdn.net/lsjseu/article/details/10907037</a>
 * </pre>
 * NB.
 * Created by skyler on 2017/9/22 at 下午2:58
 */
public class BinaryTree {

    Node root;

    List<Node> childs;

    public BinaryTree() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        new BinaryTree(array);
    }

    public BinaryTree(int[] array) {
        childs = init(array);
        this.root = childs.get(0);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    class Node {
        Node leftChild;
        Node rightChild;
        Object data;

        public Node() {
        }

        public Node(Object data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }

        public Node(Node leftChild, Node rightChild, Object data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /**
     * 数组转换成二叉树
     *
     * @param array
     * @return
     */
    private List<Node> init(int[] array) {

        List<Node> nodes = new LinkedList<>();

        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodes.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodes.get(parentIndex).leftChild = nodes
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodes.get(parentIndex).rightChild = nodes
                    .get(parentIndex * 2 + 2);
        }

        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodes.get(lastParentIndex).leftChild = nodes
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodes.get(lastParentIndex).rightChild = nodes
                    .get(lastParentIndex * 2 + 2);
        }

        return nodes;
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.leftChild) + size(node.rightChild);
        }
    }

    public int size() {
        return size(root);
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        } else {
            int depth1 = depth(node.leftChild);
            int depth2 = depth(node.rightChild);
            return Math.max(depth1, depth2) + 1;
        }
    }

    static int sum = 0;

    // 求二叉树第K层的节点个数
    public void getNumofLevel(Node node, int k, int tmp_k) {
        tmp_k++;
        if (k == 0 || node == null) return;
        if (k == 1 && node != null) sum = 1;
        if (node != null) {
            if (k == tmp_k) {
                sum++;
            }
        }

        getNumofLevel(node.leftChild, k, tmp_k);
        getNumofLevel(node.rightChild, k, tmp_k);

    }

    // 求二叉树中叶子节点的个数
    public int getLeafNodeNum(Node node) {
        if (node == null) return 0;
        if (node.rightChild == null && node.leftChild == null) return 1;

        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        BinaryTree binaryTree = new BinaryTree(array);
        List<Node> nodes = binaryTree.getChilds();
        System.out.println(nodes);


        binaryTree.getNumofLevel(binaryTree.getRoot(), 4, 0);
        System.out.println(sum);
    }
}
