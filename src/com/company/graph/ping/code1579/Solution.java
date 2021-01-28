package com.company.graph.ping.code1579;


public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // 如果一个点有两个连通的点 那么可以删除其中一条边
        // 遍历方式 1、 遍历边集 先删除当前边 如果alice 和 bob中不连通 则取消操作
        // 2、 遍历 alice和 bob 如果点存在多条边 删除任意一条边
        QuickUnion ua = new QuickUnion(n);
        QuickUnion ub = new QuickUnion(n);
        int resCount = 0;
        // 先遍历 公共边 同时是因为公共边-> 其实ua 和ub其实是完全一样的
        for (int[] temp : edges) {
            // 公共边替换 原先存在的 i-j
            if (temp[0] == 3) {
                // 如果alice 的图中不能合并 则说明temp[1],temp[2]在同一个连通分量中 包含了公共边
                if (!ua.quickUnion(temp[1] - 1, temp[2] - 1)) {
                    resCount++;
                } else {
                    // 公共边能用
                    ub.quickUnion(temp[1] - 1, temp[2] - 1);
                }
            }
        }
        for (int[] temp : edges) {
            if(temp[0]==2){
                if(!ub.quickUnion(temp[1]-1,temp[2]-1)){
                    resCount++;
                }
            }
            if(temp[0]==1){
                if(!ua.quickUnion(temp[1]-1,temp[2]-1)){
                    resCount++;
                }
            }
        }
        return resCount;
    }

    // 1、添加边的思想完成 如果当前边和已经存在连通图不是同一个连通分量 则合并
    // 2、如果当前边和已经存在的连通图是同一个连通分量 则将公共边替换私有边,若为私有边 则删除此边
    public class QuickUnion {
        // id[i] 表示连通分量的编号
        public int[] weight;
        public int[] id;
        public int count;

        // 初始化n个触点
        public QuickUnion(int n) {
            id = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                weight[i] = 1;
            }

        }

        // 在点p和q之间添加一条连接 在图中如果点p和点q连接 同时合并p和q的连通分量 quick-union 算法 快速链接
        // 将点p 当做q的上一个节点 类似p->q
        public boolean quickUnion(int p, int q) {
            // 点p和点q可能在同一个根触点上
            int proot = find(p);
            int qroot = find(q);

            if (proot == qroot)
                return false;
            // 将较多的作为根节点
            if (weight[proot] < weight[qroot]) {
                id[proot] = qroot;
                weight[qroot] += weight[proot];
            } else {
                id[qroot] = proot;
                weight[proot] += weight[qroot];
            }

            count--;
            return true;
        }

        // p(0,n-1)所在分量的标识符 也就是根触点
        public int find(int p) {
            int temp = p;
            while (temp != id[temp]) temp = id[temp];
            return temp;
        }

        // 判断p和q是否存在于同一个分量中
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

    }
}