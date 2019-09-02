/*
package com.iamlook.utils;

*/
/**
 * 菜单树工具类.
 *
 * @author yx
 * @version 1.0
 * @since 19-8-26上午9:09
 *//*



import cn.com.larunda.enumeration.MenuEnum;
import cn.com.larunda.vo.MenuNode;
import com.iamlook.tree.Menu;
import com.iamlook.tree.MenuEnum;
import com.iamlook.tree.MenuNode;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuTreeUtils {

    */
/**
     * 插入新结点          输入父结点id进行定位 ，将新结点 插入到父结点的 sonList 中
     * @param changeNode  传入根结点,传入前需判断:若根结点不存在，待插入结点成为根结点，不必进入此方法
     * @param parentCode    新结点的 父结点id
     * @param newNode     新结点
     *//*

    public static void insertNode(Menu changeNode, String parentCode, Menu newNode) {
        if (parentCode.equals(changeNode.getCode())) {
            changeNode.getChildren().add(newNode);
            return;
        }
        Set<Menu> children = changeNode.getChildren();
        //若该结点 的子结点集合为空 返回
        Iterator<Menu> iterator = children.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            insertNode(menu, parentCode, newNode);
        }
    }

    */
/**
     * 遍历结点 并打印. 同时按每个结点所在深度 在结点前打印不同长度的空格
     * @param changeNode    根结点
     * @param depth        结点深度：1
     *//*

    public static void loop(Menu changeNode, int depth, List<MenuNode> list){
        Set<Menu> children = changeNode.getChildren();
        if (children==null||children.isEmpty()){
            return;
        }
        Iterator<Menu> iterator = children.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            Iterator<MenuNode> nodeList = list.iterator();
            while (nodeList.hasNext()) {
                MenuNode node = nodeList.next();
                if(node.getCode().equals(menu.getCode())){
                    if (node.getName().equals(menu.getName())){
                        list.remove(node);
                    }
                    break;
                }

            }
            //结点深度+1，每个for循环仅执行一次。作为子结点sonList.get(i)的深度
            if(i==0){
                depth = depth+1;
            }
            i++;
            loop(menu,depth, list);
        }
    }

    */
/**
     * 删除结点   注意:先判断 是否在删除 根结点. 若删除根结点,不必进入此方法 直接为null即可
     * @param changeNode 根结点
     * @param code         待删除结点id
     *//*

    public static void deleteNode(Menu changeNode, String code) {
        Set<Menu> children = changeNode.getChildren();
        if (children == null || children.isEmpty()) {
            return;
        } else {
            Iterator<Menu> iterator = children.iterator();
            while (iterator.hasNext()) {
                Menu menu = iterator.next();
                if(code.equals(menu.getCode())){
                    menu.setParent(null);
                    menu.setCode(null);
                    break;
                }else{
                    deleteNode(menu, code);
                }
            }
        }

    }

    */
/**
     * 同理可根据结点name修改结点id
     * 根据结点id  修改结点 name
     * @param changeNode 根结点
     * @param code         结点id
     * @param name       修改后的 新name
     *//*

    public static void updateNode(Menu changeNode, String code, String name) {
        if (changeNode.getCode().equals(code)){
            changeNode.setName(name);
            return;
        }
        Set<Menu> children = changeNode.getChildren();
        if (children == null || children.isEmpty()) {
            return;
        } else {
            Iterator<Menu> iterator = children.iterator();
            while (iterator.hasNext()) {
                Menu menu = iterator.next();
                updateNode(menu, menu.getCode(), name);
            }
        }

    }

    */
/**
     * 构造比较对象
     * @param children
     * @param set
     * @param parentCode
     *//*

    public static void getComparingNode(Set<Menu> children, Set<MenuNode> set, String parentCode) {
        children.stream().forEach(a -> {
            MenuNode node = new MenuNode();
            node.setId(a.getId());
            node.setName(a.getName());
            node.setCode(a.getCode());
            node.setType(a.getType());
            node.setParentCode(parentCode);
            set.add(node);
            getComparingNode(a.getChildren(), set, a.getCode());
        });
    }

    */
/**
     * 初始化结构菜单
     * @param platformId
     * @param code
     * @param name
     * @param childrenNode
     * @return
     *//*

    public static Menu initMenu(String platformId, String code, String name, Set<MenuDto> childrenNode) {
        //初始化菜单
        Set<Menu> children = new HashSet<>();
        Menu parentMenu = new Menu();
        parentMenu.setName(name);
        parentMenu.setPlatformId(platformId);
        parentMenu.setCode(code);
        parentMenu.setType(MenuEnum.NODE);
        if (null != childrenNode) {
            init(platformId, parentMenu, childrenNode, children);
            parentMenu.setChildren(children);
        }
        return parentMenu;
    }

    */
/**
     * 菜单初始化子节点
     * @param platformId
     * @param parentMenu
     * @param childrenNode
     * @param children
     *//*

    public static void init(String platformId, Menu parentMenu, Set<MenuDto> childrenNode, Set<Menu> children) {
        childrenNode.stream().forEach(m -> {
            if (MenuEnum.NODE == m.getType()) {
                Menu menu = new Menu();
                menu.setType(MenuEnum.NODE);
                menu.setPlatformId(platformId);
                String code = parentMenu.getCode() + IConst.JOINT + m.getPath();
                menu.setCode(code);
                menu.setName(m.getName());
                Set<MenuDto> nextChildrenNode = m.getChildren();
                if (null != nextChildrenNode && nextChildrenNode.size() > 0) {
                    Set<Menu> nextChildren = new HashSet<>();
                    init(platformId, menu, nextChildrenNode, nextChildren);
                    menu.setChildren(nextChildren);
                }
                children.add(menu);
            } else {
                //初始化菜单按钮
                Menu actionMenu = new Menu();
                actionMenu.setType(MenuEnum.ACTION);
                actionMenu.setPlatformId(platformId);
                String actionCode = parentMenu.getCode() +
                        IConst.JOINT_CHAR + m.getPath();
                actionMenu.setCode(actionCode);
                actionMenu.setName(m.getName());
                children.add(actionMenu);
            }

        });
    }

    */
/**
     * 查询 某个结点 到根结点的路径
     * @param changeNode 根结点
     * @param name       待查找的结点 name
     * @param wayList    路径
     *//*

    public static void queryWayById(Menu changeNode, String name, List<String> wayList) {
        List<Menu> sonList = new ArrayList<>(changeNode.getChildren());
        wayList.add(changeNode.getName());
        for (int i = 0; i < sonList.size(); i++) {

            if(name.equals(sonList.get(i).getName())){
                for (int j = 0; j < wayList.size(); j++) {
                    System.out.print(wayList.get(j)+"->");
                }
                System.out.println(sonList.get(i).getName());
                break;
            }
            queryWayById(sonList.get(i), name, wayList);
        }
    }


    */
/**
     * 说明方法描述：将list转为树tree结构
     *
     * @param allMenuSet
     * @return
     *//*

    public static Set<MenuNode> listToTree(Set<MenuNode> allMenuSet) {

        Set<MenuNode> listParentRecord = new HashSet<>();
        Set<MenuNode> listNotParentRecord = new HashSet<>();
        // 第一步：遍历allMenuSet保存所有数据的uuid用于判断是不是根节点
        Map<String, String> mapAllUuid = new HashMap<String, String>();
        for (MenuNode record : allMenuSet) {
            mapAllUuid.put(record.getId(), record.getId());
        }
        // 第二步：遍历allRrecords找出所有的根节点和非根节点
        if (allMenuSet.size() > 0) {
            for (MenuNode record : allMenuSet) {
                if (StringUtils.isBlank(record.getParentId())
                        || !mapAllUuid.containsKey(record.getParentId())) {
                    listParentRecord.add(record);
                } else {
                    listNotParentRecord.add(record);
                }
            }
        }

        // 第三步： 递归获取所有子节点
        if (listParentRecord.size() > 0) {
            for (MenuNode record : listParentRecord) {
                // 添加所有子级
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getId()));

            }
        }
        return listParentRecord;
    }


    */
/**
     * 说明方法描述：使list转换为树并根据关键字和节点名称过滤
     *
     * @param allMenuList 所有节点
     * @param name 要过滤的关键字
     * @param code 要过滤的字段
     * @return
     *//*

    public static Set<MenuNode> filterMenuTree(Set<MenuNode> allMenuList, String name, String code) {
        Set<MenuNode> menuNodeSet = new HashSet<>();
        Map<String, MenuNode> allRecordMap = new HashMap<>();
        for (MenuNode record : allMenuList) {
            allRecordMap.put(record.getId(), record);
        }
        // 遍历allMenuList找出所有的过滤条件相关的数据
        if (allMenuList.size() > 0) {
            for (MenuNode record : allMenuList) {
                // 过滤条件
                if (!StringUtils.isEmpty(name) && record.getName().toLowerCase().indexOf(name.toLowerCase()) != -1) {
                    menuNodeSet.add(record);
                }
                if (!StringUtils.isEmpty(code) && record.getCode().toLowerCase().indexOf(code.toLowerCase()) != -1) {
                    menuNodeSet.add(record);
                }
            }
        }
        // 查找过滤出来的节点和他们的父节点
        menuNodeSet = getSelfAndTheirParentMenu(menuNodeSet, new HashSet<>(),
                new HashMap<>(), allRecordMap);
        // 将过滤出来的数据变成树tree结构
        menuNodeSet = listToTree(menuNodeSet);
        return menuNodeSet;
    }

    */
/**
     * 说明方法描述：递归查询子节点
     *
     * @param childList 子节点
     * @param parentUuid 父节点id
     * @return
     *//*

    public static Set<MenuNode> getTreeChildRecord(Set<MenuNode> childList, String parentUuid) {
        Set<MenuNode> listParentRecord = new HashSet<>();
        Set<MenuNode> listNotParentRecord = new HashSet<>();
        // 遍历tmpList，找出所有的根节点和非根节点
        if (childList != null && childList.size() > 0) {
            for (MenuNode record : childList) {
                // 对比找出父节点
                if (StringUtils.equals(record.getParentId(), parentUuid)) {
                    listParentRecord.add(record);
                } else {
                    listNotParentRecord.add(record);
                }

            }
        }
        // 查询子节点
        if (listParentRecord.size() > 0) {
            for (MenuNode record : listParentRecord) {
                // 递归查询子节点
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getId()));
            }
        }
        return listParentRecord;
    }

    */
/**
     * 说明方法描述：递归找出本节点和他们的父节点
     *
     * @param parentList 根据关键字过滤出来的相关节点的父节点
     * @param resultList 返回的过滤出来的节点
     * @param filterMap 已经过滤出来的节点
     * @param allMap 所有节点
     * @return
     *//*

    public static Set<MenuNode> getSelfAndTheirParentMenu(Set<MenuNode> parentList, Set<MenuNode> resultList,
                                                            Map<String, MenuNode> filterMap,
                                                            Map<String, MenuNode> allMap) {
        // 当父节点为null或者节点数量为0时返回结果，退出递归
        if (parentList == null || parentList.size() == 0) {
            return resultList;
        }
        // 重新创建父节点集合
        Set<MenuNode> listParentMenu = new HashSet<>();
        // 遍历已经过滤出来的节点
        for (MenuNode record : parentList) {

            String uuid = record.getId();
            String parentId = record.getParentId();

            // 如果已经过滤出来的节点不存在则添加到list中
            if (!filterMap.containsKey(uuid)) {
                // 添加到父节点中
                listParentMenu.add(record);
                // 添加到已过滤的map中
                filterMap.put(uuid, record);
                // 移除集合中相应的元素
                allMap.remove(uuid);
                // 添加到结果集中
                resultList.add(record);
            }

            // 找出本节点的父节点并添加到listParentRecord父节点集合中，并移除集合中相应的元素
            if (StringUtils.isNotBlank(parentId)) {
                MenuNode parentRecord = allMap.get(parentId);
                if (parentRecord != null) {
                    listParentMenu.add(parentRecord);
                    allMap.remove(parentId);
                }
            }

        }
        // 递归调用
        getSelfAndTheirParentMenu(listParentMenu, resultList, filterMap, allMap);

        return resultList;
    }

}
*/
