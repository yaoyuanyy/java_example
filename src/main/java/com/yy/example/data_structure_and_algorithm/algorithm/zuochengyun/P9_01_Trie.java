package com.yy.example.data_structure_and_algorithm.algorithm.zuochengyun;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * Description: trie/前缀数/字典树
 * <pre>
 * trie又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。
 * 与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的边(路)上。
 * 一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串
 *
 * 特点：
 * a. 专门处理字符串匹配问题，解决在一组字符串集合中快速查找某个字符串的问题
 * b. 典型用于统计、排序、保存大量字符
 * 串，尤其是用于搜索引擎系统文本词频统计。如google前缀搜索
 * c. 时间复杂度为O(k)，k为字符串长度
 *
 * https://www.bilibili.com/video/BV13g41157hK?p=9
 *
 * </pre>
 * NB.
 *
 * @author skyler_11@163.com
 * Created by on 2022-04-30 at 23:38
 */
public class P9_01_Trie {

    /// 数据结构
    public static class TrieNode {
        int path; // 字符串以路过此节点的数量
        int end; // 字符串以此节点结尾的数量
        TrieNode[] children;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.children = new TrieNode[26]; // 这里假定字符串是小写字母，数组长度为 2626，即小写英文字母的数量。
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "path=" + path +
                    ", end=" + end +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    /// 算法: 前缀树
    public static class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String value) {
            if (null == value) {
                return;
            }
            // 只要进入方法，根节点一定会路过
            root.path++;
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < value.length(); i++) {
                // 定位 children 的下标位置
                index = value.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                // 路过的节点path + 1
                node.children[index].path++;
                // 操作的节点进行转换
                node = node.children[index];
            }
            node.end++;
        }

        /**
         * 是否加入过
         *
         * @param value
         * @return
         */
        public boolean search(String value) {
            if (null == value) {
                return false;
            }
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < value.length(); i++) {
                index = value.charAt(i) - 'a';
                if(node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }

        /**
         * 查找字符串加入过次数
         *
         * @param value
         * @return
         */
        public int searchCount(String value) {
            if (null == value) {
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < value.length(); i++) {
                index = value.charAt(i) - 'a';
                if(node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return node.end;
        }

        /**
         * 以 value 开头的字符串的个数
         * @param value
         * @return
         */
        public int startWith(String value) {
            if (null == value) {
                return 0;
            }
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < value.length(); i++) {
                index = value.charAt(i) - 'a';
                if(node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return node.path;
        }

        // 删除时的前提是 value 是在树里的
        public boolean delete(String value) {
            if(null == value) {
                return false;
            }
            if(!search(value)) {
                return false;
            }
            root.path--;
            int index = 0;
            TrieNode node = root;
            for (int i = 0; i < value.length(); i++) {
                index = value.charAt(i) - 'a';
                if(--node.children[index].path == 0) {
                    node.children[index] = null;
                    return true;
                }
                node = node.children[index];
            }
            node.end--;
            return true;
        }

        public void out() {
            System.out.println(root);
        }
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "abc"};
        Trie trie = new Trie();
        for (String s : strings) {
            trie.insert(s);
        }
        System.out.println(trie.search("abc"));
        System.out.println(trie.searchCount("abc"));
        trie.out();
    }
}
