package daiwei.test;

import java.util.Random;

import daiwei.search.BST;

/**
 * 二分搜索树有关测试
 * @author DW
 * @version 1.0.0
 * @since 2018/4/7 14:43
 */
public class BSTTest {

    public static void main(String[] args) {
        Random random = new Random();
        BST<Integer, String> bst = new BST<Integer, String>();
        String[] letters = new String[7];
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            String letter = String.valueOf((char) (65 + i));
            letters[i] = letter;
            nums[i] = i;
        }
        for (int i = 0; i < 15; i++) {
            int r1 = random.nextInt(7);
            int r2 = random.nextInt(7);
            String temp = letters[r1];
            letters[r1] = letters[r2];
            letters[r2] = temp;

            int numTemp = nums[r1];
            nums[r1] = nums[r2];
            nums[r2] = numTemp;
        }

        for (int i = 0; i < letters.length; i++) {
            bst.insert(nums[i] ,letters[i]);
        }


////      中序遍历
//        List<BST<Integer, String>.Node> nodes = bst.innerOrder();
////      前序遍历
//        List<BST<Integer, String>.Node> nodes1 = bst.preOrder();
////      后序遍历
//        List<BST<Integer, String>.Node> nodes2 = bst.afterOrder();
//
////      深度优先遍历(DFS)
//        List<BST<Integer, String>.Node> nodes3 = bst.deepFirstSearch();
//
////      广度优先遍历(BFS)
//        List<BST<Integer, String>.Node> nodes4 = bst.breadthFirstSearch();

//        Integer target = 0;
//        BST<Integer, String>.Node res = bst.search(target);
//        String valueByNode = bst.getValueByNode(res);
//        Integer keyByNode = bst.getKeyByNode(res);
//
//        System.out.println(target + " " + valueByNode+" "+keyByNode);
//        BST<Integer, String>.Node min = bst.getMin();
//        System.out.println(bst.getKeyByNode(min));
//        System.out.println(bst.getValueByNode(min));

//        BST<Integer, String>.Node min = bst.getMin();
//        System.out.println(bst.getValueByNode(min));
//        BST<Integer, String>.Node max = bst.getMax();
//        System.out.println(bst.getValueByNode(max));
//        bst.removeMin();
//        bst.removeMin();
//        BST<Integer, String>.Node min1 = bst.getMin();
//        System.out.println(bst.getValueByNode(min1));
//        bst.removeMax();
//        BST<Integer, String>.Node max1 = bst.getMax();
//        System.out.println(bst.getValueByNode(max1));
//        bst.removeNode(4);
        bst.getNodesSuccessor(bst.search(4));
        bst.getNodesPredecessor(bst.search(4));
        bst.removeNode(4);
        bst.getFloorByNode(bst.newNode(4, "E"));
        bst.getCeilByNode(bst.newNode(4, "E"));


    }
}
