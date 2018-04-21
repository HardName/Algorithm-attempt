package daiwei.test;

import java.util.Arrays;
import java.util.Random;

import daiwei.search.BinarySearch;

/**
 * @author DW
 * @version 1.0.0
 * @since 2018/3/25 13:57
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] arr = new Integer[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
//            if(arr[i] == ) {
//                arr[i] = 1;
//            }
        }
        Arrays.sort(arr);
        int target = 100;
        Integer search = BinarySearch.searchWithRec(arr, target);
        Integer floor = BinarySearch.getFloor(arr, target);
        Integer ceil = BinarySearch.getCeil(arr, target);
        System.out.println(Arrays.toString(arr));
        System.out.println("the index is " + search);
        if(floor == -1) {
            System.out.println("If the target is in the array, target will be the minimal value but the target is not exist in this array!!");
        } else {
            System.out.println("the floor index is " + floor);
        }
        if(ceil == -1) {
            System.out.println("If the target is in the array, target will be the maximal value however the target isn't in the array!!");
        } else {
            System.out.println("the ceil index is " + ceil);
        }
    }
}
