package com.iamlook.response;

import lombok.Data;

/**
 * 原始输入数据.
 *
 * @author yx
 * @version 1.0
 * @since 19-11-4下午5:21
 */
@Data
public class OriginalInput {

    private String topicId;

    /**
     * 属性
     */
    private String prop;

    /**
     * 取值
     */
    private Double value;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * FeedId
     */
    private String feedId;

    /**
     * FeedId
     */
    private String inputId;

    /**
     * 时间
     */
    private Long time;
}