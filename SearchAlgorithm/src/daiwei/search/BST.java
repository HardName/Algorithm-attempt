package daiwei.search;

import java.util.*;

/**
 * binary Search Tree
 * 二分搜索树
 *
 * @author DW
 * @version 1.0.0
 * @since 2018/3/26 22:29
 */
public class BST<Key extends Comparable<Key>, Value> {

    public class Node {

        private Key key;
        private Value value;

        private Node leftChild;
        private Node rightChild;

        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        private Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.leftChild = node.leftChild;
            this.rightChild = node.rightChild;

        }
    }

    private Node root;
    private int count;

    public BST() {
        this.root = null;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(Key key, Value value) {
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node root, Key key, Value value) {

        if (root == null) {
            count++;
            return new Node(key, value);
        }

        if (key.equals(root.key)) {
            root.value = value;
        } else if (root.key.compareTo(key) > 0) {
            root.leftChild = insert(root.leftChild, key, value);
        } else {
            root.rightChild = insert(root.rightChild, key, value);
        }
        return root;
    }

    /**
     * 在树中是否包含目标key
     *
     * @param key
     * @return
     */
    public boolean contain(Key key) {
        return contain(this.root, key);
    }

    private boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }
        if (root.key.equals(key)) {
            return true;
        } else if (root.key.compareTo(key) < 0) {
            return contain(root.rightChild, key);
        } else {
            return contain(root.leftChild, key);
        }
    }


    /**
     * 通过 key 搜索节点
     *
     * @param key
     * @return
     */
    public Node search(Key key) {
        return search(this.root, key);
    }

    private Node search(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return search(node.leftChild, key);
        } else {
            return search(node.rightChild, key);
        }
    }

    //  前序遍历
    public List<Node> preOrder() {
        List<Node> list = new ArrayList();
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Node> list, Node node) {
        list.add(node);
        if (node.leftChild != null) {
            preOrder(list, node.leftChild);
        }
        if (node.rightChild != null) {
            preOrder(list, node.rightChild);
        }
    }

    //中序遍历
    public List<Node> innerOrder() {
        List<Node> list = new ArrayList<>();
        innerOrder(list, root);
        return list;
    }

    private void innerOrder(List<Node> list, Node node) {
        if (node.leftChild != null) {
            innerOrder(list, node.leftChild);
        }
        list.add(node);
        if (node.rightChild != null) {
            innerOrder(list, node.rightChild);
        }
    }


    //    后序遍历
    public List<Node> afterOrder() {
        List<Node> list = new ArrayList<>();
        afterOrder(list, root);
        return list;
    }

    private void afterOrder(List<Node> list, Node node) {
        if (node.leftChild != null) {
            afterOrder(list, node.leftChild);
        }
        if (node.rightChild != null) {
            afterOrder(list, node.rightChild);
        }
        list.add(node);
    }

    //广度优先遍历算法
    public List<Node> breadthFirstSearch() {
        ArrayList<Node> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            Node node = queue.poll();
            nodes.add(node);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        return nodes;
    }

    //   深度优先算法
    public List<Node> deepFirstSearch() {
        List<Node> res = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (nodeStack.size() > 0) {
            Node pop = nodeStack.pop();
            res.add(pop);
            if (pop.rightChild != null) {
                nodeStack.push(pop.rightChild);
            }
            if (pop.leftChild != null) {
                nodeStack.push(pop.leftChild);
            }
        }
        return res;
    }

    //  获取搜索树中的最小Node
    public Node getMin() {
        return getMin(root);
    }

    private Node getMin(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node;
    }

    //    获取搜索二叉树中的最大Node
    public Node getMax() {
        return getMax(root);
    }

    private Node getMax(Node node) {
        while (node.rightChild != null) {
            node = node.rightChild;
        }
        return node;
    }


    public void removeMin() {
        if (root != null) {
            removeMin(root);
        }
    }

    //    被移除的最小节点
    private Node removeMin(Node node) {
        if (node.leftChild == null) {
            return removeNodeWithLeftEmpty(node);
        }
        node.leftChild = removeMin(node.leftChild);
        return node;
    }

    //    移除搜索树中的最小值
    public void removeMax() {
        if (root != null) {
            removeMax(root);
        }
    }

    private Node removeMax(Node node) {
        if (node.rightChild == null) {
            return removeNodeWithRightEmpty(node);
        }
        node.rightChild = removeMax(node.rightChild);
        return node;
    }

    /**
     * 删除搜索二叉树中任意节点
     *
     * @param node 根节点
     * @param key  要删除的key
     * @return
     */
    public Node removeNode(Node node, Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) < 0) {
            node.rightChild = removeNode(node.rightChild, key);
            return node;
        } else if (node.key.compareTo(key) > 0) {
            node.leftChild = removeNode(node.leftChild, key);
            return node;
        } else {
            if (node.leftChild == null) {
                return removeNodeWithLeftEmpty(node);
            }
            if (node.rightChild == null) {
                return removeNodeWithRightEmpty(node);
            }
            Node tempMinNode = getMin(node.rightChild);
            Node successor = new Node(tempMinNode.key, tempMinNode.value);
            count++;
            successor.rightChild = removeMin(node.rightChild);
            successor.leftChild = node.leftChild;
            count--;
            return successor;
        }
    }

    public void removeNode(Key key) {
        root = removeNode(root, key);
    }

    /**
     * 删除没有左孩子的节点
     *
     * @param node
     * @return
     */
    private Node removeNodeWithLeftEmpty(Node node) {
        Node rightChild = node.rightChild;
        node.rightChild = null;
        count--;
        return rightChild;
    }

    /**
     * 删除没有右孩子的节点
     *
     * @param node
     * @return
     */
    private Node removeNodeWithRightEmpty(Node node) {
        Node leftChild = node.leftChild;
        node.leftChild = null;
        count--;
        return leftChild;
    }

    /**
     * 通过 Node 获取这个node 的floor
     *
     * @param node
     * @return
     */
    public Node getFloorByNode(Node node) {
        if (contain(node.key)) {
            return search(node.key);
        }
        if (getMin().key.compareTo(node.key) > 0) {
            return null;
        }
        Node max = getMax();
        if (max.key.compareTo(node.key) < 0) {
            return max;
        }
        return getFloorWithNodeNoExits(root, node.key, null);
//        List<Node> nodes = innerOrder();
//        for (int i = 1; i < nodes.size(); i++) {
//            if (node.key.compareTo(nodes.get(i).key) < 0) {
//                return nodes.get(i - 1);
//            }
//        }
//        return null;
    }

    /**
     * 获取某个节点的Ceil
     *
     * @param node
     * @return
     */
    public Node getCeilByNode(Node node) {
        if (contain(node.key)) {
            return search(node.key);
        }
        Node min = getMin();
        if (min.key.compareTo(node.key) > 0) {
            return min;
        }
        if (getMax().key.compareTo(node.key) < 0) {
            return null;
        }
        return getCeilWithNodeNoExits(root, node.key, null);
//        List<Node> nodes = innerOrder();
//        for (int i = 0; i < nodes.size(); i++) {
//            if (node.key.compareTo(nodes.get(i).key) < 0) {
//                return nodes.get(i);
//            }
//        }
//        return null;
    }

    /**
     * 从所有的父节点当中获取后继节点
     *
     * @param node     所有祖先节点的根节点
     * @param key      要寻找的 key 值
     * @param tempNode 上一个转折节点
     * @return
     */
    private Node getSuccessorFromAncestor(Node node, Key key, Node tempNode) {
        if (node.key.compareTo(key) > 0) {
            return getSuccessorFromAncestor(node.leftChild, key, node);
        }
        if (node.key.compareTo(key) < 0) {
            return getSuccessorFromAncestor(node.rightChild, key, tempNode);
        }
        if (node.key.equals(key)) {
            return node;
        }
        return null;
    }


    /**
     * 从所有的父节点中寻找前驱
     *
     * @param node     所有父节点的根节点
     * @param key      要查找的目标key
     * @param tempNode 上一次的转折节点
     * @return
     */
    private Node getPredecessorFromAncestor(Node node, Key key, Node tempNode) {
        if (node.key.compareTo(key) > 0) {
            return getPredecessorFromAncestor(node.leftChild, key, tempNode);
        }
        if (node.key.compareTo(key) < 0) {
            return getPredecessorFromAncestor(node.rightChild, key, node);
        }
        if (node.key.equals(key)) {
            return tempNode;
        }
        return null;
    }


    /**
     * 获取某个节点的后继
     *
     * @param node
     * @return
     */
    public Node getNodesSuccessor(Node node) {
        if (!contain(node.key)) {
            return null;
        }
        if (getMax().key.equals(node.key)) {
            return null;
        }

        if (node.rightChild != null) {
            return getMin(node.rightChild);
        }

        return getSuccessorFromAncestor(root, node.key, null);
//        List<Node> nodes = innerOrder();
//        for (int i = 0; i < nodes.size(); i++) {
//            if (nodes.get(i).equals(node)) {
//                return nodes.get(i + 1);
//            }
//        }
    }

    /**
     * 获取某个节点的前驱
     *
     * @param node
     * @return
     */
    public Node getNodesPredecessor(Node node) {
        if (!contain(node.key)) {
            return null;
        }
        if (getMin().equals(node)) {
            return null;
        }
        if (node.leftChild != null) {
            return getMax(node.leftChild);
        }

//        List<Node> nodes = innerOrder();
//        for (int i = 0; i < nodes.size(); i++) {
//            if (nodes.get(i).equals(node)) {
//                return nodes.get(i - 1);
//            }
//        }
        return getPredecessorFromAncestor(root, node.key, null);
    }

    /**
     * 查找一个节点的Floor，当这个节点的不存在这颗树中
     *
     * @param node     根节点
     * @param key      要查找的key
     * @param tempNode 已找到目前合适节点
     * @return
     */
    private Node getFloorWithNodeNoExits(Node node, Key key, Node tempNode) {
        if (node.key.compareTo(key) > 0) {
            if (node.leftChild != null) {
                return getFloorWithNodeNoExits(node.leftChild, key, tempNode);
            }
            return tempNode;
        } else if (node.key.compareTo(key) < 0) {
            if (node.rightChild != null) {
                return getFloorWithNodeNoExits(node.rightChild, key, node);
            }
            return node;
        }
        return null;
    }

    private Node getCeilWithNodeNoExits(Node node, Key key, Node tempNode) {
        if (node.key.compareTo(key) < 0) {
            if (node.rightChild != null) {
                return getCeilWithNodeNoExits(node.rightChild, key, tempNode);
            }
            return tempNode;
        }
        if (node.key.compareTo(key) > 0) {
            if(node.leftChild != null) {
                return getCeilWithNodeNoExits(node.leftChild, key, node);
            }
            return node;
        }
        return null;
    }

    /**
     * 判断某个节点是否有子节点
     *
     * @param node
     * @return
     */
    private boolean hasChildren(Node node) {
        if (node.leftChild != null || node.rightChild != null) {
            return true;
        }
        return false;
    }

    /******************************辅助方法**********************************/

    public Value getValueByNode(Node node) {
        return node.value;
    }

    public Key getKeyByNode(Node node) {
        return node.key;
    }

    public Node newNode(Key key, Value value) {
        return new Node(key, value);
    }


}
