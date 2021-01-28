package com.company.graph.ping;

// 根触点作为连通分量
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
    public void quickUnion(int p, int q) {
        // 点p和点q可能在同一个根触点上
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot)
            return;
        // 将较小的作为根节点
        if (weight[proot] < weight[qroot]) {
            id[qroot] = proot;
            weight[proot] += weight[proot];
        } else {
            id[proot] = qroot;
            weight[qroot] += weight[qroot];
        }

        count--;
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

    // 连通分量的数量
    public int count() {
        return count;
    }


}
