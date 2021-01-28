package com.company.graph.ping;

public class Union {
    // id[i] 表示连通分量的编号
    public int [] id;
    public int count;

    // 初始化n个触点
    public Union(int n){
        id=new int[n];
        for(int i=0;i<n;i++)
            id[i]=i;
    }
    // 在点p和q之间添加一条连接 在图中如果点p和点q连接 同时合并p和q的连通分量 quick-union 算法 快速链接
    void union(int p,int q){
        id[q]=id[p];
    }
    // p(0,n-1)所在分量的标识符
    int find(int p){
        return id[p];
    }
    // 判断p和q是否存在于同一个分量中
    boolean connected(int p,int q){
        return id[p] ==id[q];
    }
    // 连通分量的数量
    int count(){
        return count;
    }
}
