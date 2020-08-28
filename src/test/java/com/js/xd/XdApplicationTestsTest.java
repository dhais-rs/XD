package com.js.xd;

import org.junit.Test;


public class XdApplicationTestsTest {
    @Test
    public void contextLoads() {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        String cc = ",";
        System.out.println("\n ---------------------------"+cc.split(",").length);
    }

    private void sort(int[] arr,int leftIndex,int rightIndex){
        if (leftIndex>=rightIndex)
            return;
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while(left<right){
            while(right>left&&arr[right]>=key){
                right--;
            }
            arr[left] = arr[right];
            while(left<right&&arr[left]<=key){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr,leftIndex,left-1);
        sort(arr,right+1,rightIndex);
    }
}