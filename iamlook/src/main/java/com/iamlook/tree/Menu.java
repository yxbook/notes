package com.iamlook.tree;

import cn.com.larunda.enumeration.MenuEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 菜单实体类
 *
 * @author yx
 * @version 1.0
 * @since 19-7-24上午10:02
 */
@Slf4j
@Data
@Entity
@Table(name = "sys_menu")
public class Menu extends BaseEntity {

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String name;

    /**
     * 菜单code
     */
    @Column(name = "menu_code", unique = true)
    private String code;

    /**
     * 菜单类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "menu_type", nullable = false)
    private MenuEnum type;

    /**
     * 平台
     */
    @Column(name = "platform_id")
    private String platformId;

    /**
     * 资源详细说明
     */
    @Column(name = "menu_desc")
    private String desc;

    /**
     * 菜单图标
     */
    @Column(name = "menu_icon")
    private String icon;

    /**
     * 用于排序的序号
     */
    @Column(name = "res_seq")
    private int seq;

    /**
     * 父菜单
     * 转换json时忽略此属性
     */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Menu parent;

    /**
     * 多个子资源
     */
    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @OrderBy(value = "seq ASC")
    private Set<Menu> children = new HashSet<>();

    /**
     *  资源集合
     *  多对多
     *  定义中间表名，字段名
     *  通过关联查询按照seq升序排序
     */
    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="sys_menu_to_res",
            joinColumns={@JoinColumn(name="menu_id")},
            inverseJoinColumns={@JoinColumn(name="res_id")})
    @OrderBy(value="seq ASC")
    private Set<Resource> resources;

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
        Menu menu = (Menu) o;
        if (name == null) {
            if (menu.name != null) {
                return false;
            }
        } else if (!name.equals(menu.name)) {
            return false;
        }

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
        return Objects.hash(name, code);
    }

    @Override
    public String toString() {
        return "Menus{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }


}
