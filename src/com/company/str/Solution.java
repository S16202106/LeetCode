package com.company.str;

import java.util.Map;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // 如果当前的数相较于之前的(res[i-1])的平均值大 那么可以加入
        // 如果小 那么可以加入
        // 如果当前的数为正数 那么可以以当前的数为起点 先加入一个队列
        // List<Integer> list=new ArrayList<>();
        // list.add(nums[i]);
        // Map<List<Integer>,Integer> resMap=new HashMap<>();
        // resMap.put(list,nums[i]);
        // for(List<Integer> list: resMap){
        //     // 在遍历的同时 需要移除一些不合适的
        // }

        // 理论上来说 当遍历到现在的i 时 都需要之前以j(j<i)  开始的情况
        double res = Double.NEGATIVE_INFINITY;
        // 滑动窗口
        int start=0;
        int end=start+k-1;
        double temp=0;
        for(int i=start;i<=end;i++)
            temp+=nums[i];
        res=Math.max(res,temp);
        while(true){
            end++;
            if(end==nums.length)
                break;
            temp=temp-nums[start];
            start++;
            temp=temp+nums[end];
            res=Math.max(temp,res);

        }
        res =res /k;
        return res;
    }

    //    public int back(String s, int k, Map<Integer,Integer[]> road, int now) {
//        for(int start: road.keySet())  不能用开始结束 作为字符串的状态
//    }
    public static void main(String[] args) {
        Solution s=new Solution();
        double res=s.findMaxAverage(new int[]{1,12,-5,-6,50,3}
        ,4);
        System.out.println(res);
    }
}
