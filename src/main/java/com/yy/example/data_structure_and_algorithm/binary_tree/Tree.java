package com.yy.example.data_structure_and_algorithm.binary_tree;

import java.util.List;

/**
 * Description:
 * <pre>
 *   树的存储结构有三种不同的表示法:双亲表示法、孩子表示法、孩子兄弟表示法
 *   参考：https://aiden-dong.github.io/2018/04/02/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E4%B9%8B%E6%A0%91%E7%9A%84%E5%AD%98%E5%82%A8%E7%BB%93%E6%9E%84/
 * </pre>
 * NB.
 *
 * @author skyler
 * Created by on 2020/3/24 at 5:25 下午
 */
public class Tree {

    /**
     * 双亲表示法
     * data parent
     * @param <T>
     */
    public static class TreeNode1<T>{
        T data;
        TreeNode1 parent;

    }

    /**
     * 孩子表示法
     * data child1 child2 ... childN
     * @param <T>
     */
    public static class TreeNode2<T>{
        T data;
        List<TreeNode2> childs;
    }

    /**
     * 孩子兄弟表示法
     * data firstChild rightsib
     * @param <T>
     */
    public static class TreeNode3<T>{
        T data;
        TreeNode3 firstChild;
        TreeNode3 rightsib;
    }
}
