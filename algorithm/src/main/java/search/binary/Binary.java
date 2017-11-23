package search.binary;

import search.Data;

public class Binary {

    public static void main(String[] args) {
        //
        // 20, 24, 35, 43, 47, 56, 87, 88, 90, 100
        int[] data = Data.createSortedSample();

        // 여기에 알고리즘을 구현합니다.
        System.out.println("search 20 :" + search(0, data.length-1, 20, data));
        System.out.println("search 47 :" + search(0, data.length-1, 47, data));
        System.out.println("search 90 :" + search(0, data.length-1, 90, data));
        System.out.println("search 88 :" + search(0, data.length-1, 88, data));
        System.out.println("search 100 :" + search(0, data.length-1, 100, data));
        System.out.println("search 15 :" + search(0, data.length-1, 15, data));
        System.out.println("search 102 :" + search(0, data.length-1, 102, data));
    }

    private static int search(int start, int end, int target, int[] data) {
        if(start > end){
            return -1;
        }
        int mid = getMiddlePos(start, end);
        if(data[mid] == target){
            return mid;
        } else {
            if(data[mid] > target){
                return search(start, mid-1, target, data);
            } else {
                return search(mid+1, end, target, data);
            }
        }
    }

    private static int getMiddlePos(int start, int end) {
        return (start + end) / 2;
    }
}
