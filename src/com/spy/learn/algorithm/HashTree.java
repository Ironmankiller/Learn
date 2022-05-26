package com.spy.learn.algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class HashTree {

    private static Integer[] PRIME_NUMBER = { 2 , 3 , 5 , 7 , 11 , 13 , 17 , 19 , 23 , 29}; //连续11个质数能表示6464693230个数字

    private Node root = new Node(0,PRIME_NUMBER[0]);

    /**
     * 插入一个元素
     * @param data
     * @return
     */
    public boolean insertData(Integer data){
        Integer count = 0;      //当前 要用的质数数组的下标   又可以标识层数   1层为树根 层数从2开始计算所以实际层数要+2
        Integer remain = 0;     //每次计算的余数
        Node point = this.root; //指针从根节点开始走
        while (true){
            remain = data % PRIME_NUMBER[count];        //计算余数
            if (point.next[remain] == null){   //余数位上为空新建一个结点加进去
                point.next[remain] = new Node(data,PRIME_NUMBER[count+1]);
                break;
            }else if(point.next[remain].isDel){ //或者是余数位上元素被逻辑删除了那么就把值给他替换信息然后逻辑恢复
                point.next[remain].data = data;
                point.next[remain].isDel = false;
                break;
            }else {                                //既不为空也不为逻辑删除那么我就继续找位置
                point = point.next[remain];
                count++;
            }
        }
        return true;
    }

    /**
     * 查询一个元素
     * 正常返回的应该是查询到的元素，这里就查个值，元素没有附带的信息也没什么好返回的，就瞎搞一下
     *
     * @param data
     * @return
     */
    public boolean serach(Integer data){
        Integer count = 0;      //当前 要用的质数数组的下标   又可以标识层数   1层为树根 层数从2开始计算所以实际层数要+2
        Integer remain = 0;     //每次计算的余数
        Node temp = null;       //一个引用，用来清晰的表示求余后指针余数位置上的元素
        Node point = this.root; //指针从根节点开始走
        while (true){
            remain = data % PRIME_NUMBER[count];    //计算余数
            temp = point.next[remain];              //描述余数位的结点
            if (temp != null){                      //结点不能为空为空就输出没找到
                if (!temp.isDel && data.equals(temp.data)){ //不为空的话就看相不相等，删没删除
                    System.out.println("层数：" + (count+2) + "         算上根节点的层数，当前结点所在的层数");
                    System.out.println("层数：" + (count+1) + "         不算根节点的层数，当前结点所在的层数");
                    System.out.println("值  ：" + point.next[remain].data);
                    System.out.println("质数：" + PRIME_NUMBER[count]);
                    System.out.println("余数：" + remain);
                    return true;
                }else {
                    point = point.next[remain];
                    count++;
                }
            }else if (point.next[remain] == null){
                System.out.println("没找到！");
                return false;
            }
        }
    }

    /**
     * 删除结点  逻辑删除
     * @param data
     * @return
     */
    public Boolean delData(Integer data){
        Integer count = 0;      //当前 要用的质数数组的下标   又可以标识层数   1层为树根 层数从2开始计算所以实际层数要+2
        Integer remain = 0;     //每次计算的余数
        Node temp = null;       //一个引用，用来清晰的表示求余后指针余数位置上的元素
        Node point = this.root; //指针从根节点开始走
        while (true){
            remain = data % PRIME_NUMBER[count];
            temp = point.next[remain];
            if (temp != null){
                if (!temp.isDel && data.equals(temp.data)){
                    System.out.println("=====结点信息输出======");
                    System.out.println("层数：" + (count+2) + "         算上根节点的层数，当前结点所在的层数");
                    System.out.println("层数：" + (count+1) + "         不算根节点的层数，当前结点所在的层数");
                    System.out.println("值  ：" + temp.data);
                    System.out.println("质数：" + PRIME_NUMBER[count]);
                    System.out.println("余数：" + remain);
                    System.out.println("========正在删除=======");
                    temp.isDel = true;
                    return true;
                }else {
                    point = point.next[remain];
                    count++;
                }
            }else if (point.next[remain] == null){
                System.out.println("没找到要删除的结点！");
                return false;
            }
        }
    }

    /**
     * 层序遍历输出值
     */
    public void showHashTree(){
        System.out.println("=========层序遍历开始=========");
        Node point = this.root; //指针从根节点开始走
        Node temp = null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(point);
        while (queue.size()>0){
            temp = queue.poll();
            if (temp.data == 0)
                System.out.println("根节点：" + temp.data);
            System.out.print(" " + temp.data + " ");
            for (int i = 0; i <temp.next.length ; i++) {
                if (temp.next[i] == null || temp.next[i].isDel )
                    continue;
                else {
                    queue.offer(temp.next[i]);
                }
            }
        }
        System.out.println();
        System.out.println("=========层序遍历结束=========");
    }

    private static class Node{
        public Node[] next = null;
        public Integer data = 0;
        public boolean isDel = false;
        public Node(Integer data,Integer level){
            next = new Node[level];
            this.data = data;
        }
        public Node(Integer data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        HashTree hashTree = new HashTree();

        for (int i = 0; i < 10; i++) {
            hashTree.insertData(i);
        }

        hashTree.showHashTree();

        for (int i = 4; i < 6; i++) {
            hashTree.serach(i);
        }

        for (int i = 4; i < 6; i++) {
            hashTree.delData(i);
        }

        hashTree.showHashTree();

        for (int i = 4; i < 6; i++) {
            hashTree.serach(i);
        }
    }

}
