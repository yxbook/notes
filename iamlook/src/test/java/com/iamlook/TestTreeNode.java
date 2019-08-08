package com.iamlook;

import com.google.common.collect.Lists;
import com.iamlook.tree.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递归过滤树节点
 * 参考地址
 * https://blog.csdn.net/neweastsun/article/details/83933810
 *
 *
 *           0
 *        / |  \
 *       1  2   3
 *     /  \ |  / \
 *    4   5 6  7  8
 *
 *    给定条件为：4 和 6，如果所有子节点都不符合条件，对应父节点也不显示。
 *
 *          0
 *        / |
 *       1  2
 *     /    |
 *    4     6
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTreeNode{

    private Logger logger = LoggerFactory.getLogger(TestTreeNode.class);
    private TreeNode node0;
    private List<String> targetNode = Lists.newArrayList("B1","C1");

    @Test
    public void filterTest(){
        node0 = TreeNode.builder().nodeCode("0").nodeName("A").build();
        TreeNode node1 = TreeNode.builder().nodeCode("1").nodeName("B").build();
        TreeNode node2 = TreeNode.builder().nodeCode("2").nodeName("C").build();
        TreeNode node3 = TreeNode.builder().nodeCode("3").nodeName("D").build();

        TreeNode node4 = TreeNode.builder().nodeCode("4").nodeName("B1").build();
        TreeNode node5 = TreeNode.builder().nodeCode("5").nodeName("B2").build();
        TreeNode node6 = TreeNode.builder().nodeCode("6").nodeName("C1").build();
        TreeNode node7 = TreeNode.builder().nodeCode("7").nodeName("D1").build();
        TreeNode node8 = TreeNode.builder().nodeCode("8").nodeName("D2").build();

        Set<TreeNode> set1 = new HashSet<>();
        set1.add(node4);
        set1.add(node5);
        Set<TreeNode> set2 = new HashSet<>();
        set2.add(node6);
        Set<TreeNode> set3 = new HashSet<>();
        set3.add(node7);
        set3.add(node8);
        Set<TreeNode> set4 = new HashSet<>();
        set4.add(node1);
        set4.add(node2);
        set4.add(node3);
        node1.setChildren(set1);
        node2.setChildren(set2);
        node3.setChildren(set3);

        node0.setChildren(set4);

        logger.info("before filter node0: {}",node0);
        TreeNode.filterNode(node0, targetNode);
        if (node0.getChildren().size() == 0){
            node0 = null;
        }
        logger.info("after filter node0: {}",node0);
    }

}