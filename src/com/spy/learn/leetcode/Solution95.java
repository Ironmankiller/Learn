package com.spy.learn.leetcode;

import javax.swing.event.TreeExpansionEvent;
import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public static void main(String[] args) {

        List<TreeNode> list = new Solution95().generateTrees(50);
        System.out.println(list.size());
    }

//    List<List<TreeNode>> result;
//    public List<TreeNode> generateTrees(int n) {
//        result = new ArrayList<>();
//
//        if(n==0){
//            return new ArrayList<TreeNode>();
//        }
//        List<TreeNode> l1 = new ArrayList<>();
//        l1.add(null);
//        result.add(l1);
//
//        for(int i=1;i<=n;i++) {
//            List<TreeNode> nn = new ArrayList<>();
//            for(int j=1;j<=i;j++) {
//                for(TreeNode temp1: result.get(j-1)) {
//                    for (TreeNode temp2 : result.get(i-j)) {
//                        TreeNode l = copyTree(temp1);
//                        TreeNode r = copyTreeadd(temp2,j);
//                        TreeNode node = new TreeNode(j);
//                        node.left = l;
//                        node.right = r;
//                        //node.val+=j;
//                        nn.add(node);
//                    }
//                }
//            }
//            result.add(nn);
//        }
//        return result.get(n);
//    }
//
//    //实现树的复制
//    public TreeNode copyTree(TreeNode treeNode){
//        if(treeNode==null) {
//            return null;
//        }
//        TreeNode tree;
//        tree = new TreeNode(treeNode.val);
//        if (treeNode.right!=null)
//            tree.right = copyTree(treeNode.right);
//        if (treeNode.left!=null)
//            tree.left = copyTree(treeNode.left);
//        return tree;
//    }
//
//    //实现树的复制
//    public TreeNode copyTreeadd(TreeNode treeNode,int add){
//        if(treeNode==null) {
//            return null;
//        }
//        TreeNode tree;
//        tree = new TreeNode(treeNode.val+add);
//        if (treeNode.right!=null)
//            tree.right = copyTreeadd(treeNode.right,add);
//        if (treeNode.left!=null)
//            tree.left = copyTreeadd(treeNode.left,add);
//        return tree;
//    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;

        }
        return pre;
    }


    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }
}
