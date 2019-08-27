package com.iamlook.tree;

import lombok.Data;

import java.util.Objects;
import java.util.Set;

/**
 * 菜单节点VO.
 *
 * @author yx
 * @version 1.0
 * @since 19-7-30下午12:43
 */
@Data
public class MenuNode {
    /**
     * 菜单ID
     */
    private String id;

    /**
     * 菜单编码
     */
    private String code;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单类型
     */
    private MenuEnum type;

    /**
     * 是否选中
     */
    private Boolean selected;

    /**
     * 菜单子节点
     */
    private Set<MenuNode> children;

    /**
     * 父节点code
     */
    private String parentCode;

    /**
     * 父节点ID
     */
    private String parentId;


    /**
     * 比较
     *
     * @param o 传值
     * @return boolean 返回正误
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuNode menu = (MenuNode) o;
        if (code == null) {
            if (menu.code != null) {
                return false;
            }
        } else if (!code.equals(menu.code)) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "MenuNode{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }



}