/*
package com.iamlook.jpa;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

*/
/**
 * Base Entity
 * 声明各实体类的公共属性
 *
 * @author 胡荆陵
 * @version 1.0
 * @since 2019-04-12
 *//*

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
public class BaseEntity implements Serializable {

    private static final int ID_LENGTH = 36;

    @Id
    @Column(length = ID_LENGTH, nullable = false)
    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")  //生成器名称，uuid生成类
    @GenericGenerator(name = "uuid", strategy = "uuid2")  //生成器名称，uuid生成类
    @TableId(value = "id", type = IdType.UUID)
    private String id; //ID

    @CreatedDate
    @Column(name = "create_time", updatable = false)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 创建时间

    @LastModifiedDate
    @Column(name = "modify_time")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyTime; // 修改时间

    @Version
    @com.baomidou.mybatisplus.annotation.Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version; //版本锁

    */
/**
     * 清除 baseEntity 各基础属性
     *//*

    public void clearProps() {
        this.setId(null);
        this.setCreateTime(null);
        this.setModifyTime(null);
        this.setVersion(null);
    }


    */
/**
     * 是否已删除
     *//*

    @TableLogic
    @Column(name = "is_del", nullable = false)
    @TableField("is_del")
    @JsonIgnore
    private Byte isDel = 0;

}
*/
