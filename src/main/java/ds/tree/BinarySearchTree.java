package ds.tree;


import java.util.Iterator;
import java.util.PrimitiveIterator;

/**
 * 二叉搜索树， 基于递归实现
 *
 * @author Gray
 * @date 2020/11/18 0:52
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    Node root;

    int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int N;      // 以该结点为根的子树中的结点总数

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.N = 1;
        }

        public Node(K key, V val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }


    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public V get(K key) {
        if (root == null || key == null) return null;

        return get(key, root);
    }

    public V get(K key, Node root) {

        int cmp = key.compareTo(root.key);
        V val;
        if (cmp > 0) {
            val = get(key, root.right);
        } else if (cmp < 0) {
            val = get(key, root.left);
        } else {
            val = root.val;
        }
        return val;
    }

    public void put(K key, V val) {
        if (key == null || val == null) return;

        if (root == null) {
            root = new Node(key, val, 1);
            return;
        }

        insert(key, val, root);
    }

    private Node insert(K key, V val, Node root) {
        if (root == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(root.key);

        if (cmp > 0) {
            root.right = insert(key, val, root.right);
        } else if (cmp < 0) {
            root.left = insert(key, val, root.left);
        } else {
            root.val = val;
        }
        root.N = size(root.left) + size(root.right) + 1;

        return root;
    }

    public V max() {
        if (root == null) return null;
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }

        return node.val;
    }

    public V min() {
        if (root == null) return null;
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }

        return node.val;
    }

    public V delete(K key) {
        return null;
    }

    private V delete(K key, Node root, Node parent) {
        if (root == null) return null;

        int cmp = key.compareTo(root.key);
        if (cmp > 0) {
            return delete(key, root.right, parent);
        } else if (cmp < 0) {
            return delete(key, root.left, parent);
        } else {
            return deleteNode(root, parent);
        }
    }

    private V deleteNode(Node root, Node parent) {
        Node up = null;
        if (root.left == null && root.right == null) return root.val;

        if (root.left == null || root.right == null) {
            up = root.left == null? root.right : root.left;
        }else{
            Node r = root.right;
            while (r.left != null){
                r = r.left;
            }

        }

        return root.val;
    }

    public V deleteMin() {
        return null;
    }

    public V deleteMax() {
        return null;
    }

    public Iterator<K> keys() {
        return null;
    }

    public K floor(K key){
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Node x, K key){
        if (x == null)  return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)   return x;
        if (cmp < 0)    return floor(x.left, key);
        Node t= floor(x.right,key);
        if (t != null)  return t;
        else return x;
    }
}
