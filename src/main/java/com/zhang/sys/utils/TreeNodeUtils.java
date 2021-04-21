package com.zhang.sys.utils;

import com.zhang.sys.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 组装 List<TreeNode> 对象
 */
public class TreeNodeUtils {

    /**
     * 构建树结构
     *
     * @return
     */
    public static List<TreeNode> buildTreeNode(List<TreeNode> treeNodes, Integer topPid) {
        List<TreeNode> nodesOne = new ArrayList<>();
        for (TreeNode n1 : treeNodes) {
//            如果是最外层的,就将它添加到集合当中
            if (n1.getPid() == topPid) {
                nodesOne.add(n1);
            }
            for (TreeNode n2 :treeNodes) {
                if (n2.getPid() == n1.getId()){
                    n1.getChildren().add(n2);
                }
            }

        }
        return nodesOne;
    }

}
