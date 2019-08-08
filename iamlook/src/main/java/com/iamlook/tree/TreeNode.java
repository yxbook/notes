package com.iamlook.tree;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class TreeNode {
    private String nodeName;
    private String nodeCode;

    private Set<TreeNode> children;

    public static Set<TreeNode> filterNode(TreeNode treeNode, List<String> targetNode) {

        Set<TreeNode> nodes = treeNode.getChildren();
        Set<TreeNode> newNodes = new HashSet<>();
        Set<TreeNode> tagNodes = new HashSet<>();

        for (TreeNode node : nodes) {
            if (targetNode.contains(node.getNodeName())) {
                newNodes.add(node);
            }
            if (node.getChildren() != null && node.getChildren().size() > 0) {
                Set<TreeNode> retNodes = filterNode(node, targetNode);
                if (retNodes.size() > 0) {
                    node.setChildren(retNodes);
                } else {
                    // 没有子节点情况
                    node.setChildren(null);
                    // 标记,循环结束后删除
                    tagNodes.add(node);
                }
            } else {
                tagNodes.add(node);
            }
        }
        nodes.removeAll(tagNodes);
        return newNodes;
    }

}
