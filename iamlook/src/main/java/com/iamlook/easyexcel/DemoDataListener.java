package com.iamlook.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 描述.
 *
 * @author yx
 * @version 1.0
 * @since 19-11-25下午1:18
 */

public class DemoDataListener extends AnalysisEventListener<ExcelDemo> {

    // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去


    private static final Logger LOGGER = LoggerFactory.getLogger(DemoDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    List<ExcelDemo> list = new ArrayList<>();

    Set<ExcelDemo> allSet = new HashSet<>();

    @Override
    public void invoke(ExcelDemo data, AnalysisContext analysisContext) {

        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        allSet.addAll(list);
        System.out.println();
        LOGGER.info("存储数据库成功！" + allSet.size());
        if (allSet.size() == 1772) {
            Set<ExcelDemo> tree = listToTree(allSet);
            System.out.println(JSON.toJSONString(tree));
        }
    }

    /**
     * 说明方法描述：将list转为树tree结构
     *
     * @param allMenuSet
     * @return
     */
    private Set<ExcelDemo> listToTree(Set<ExcelDemo> allMenuSet) {

        Set<ExcelDemo> listParentRecord = new HashSet<>();
        Set<ExcelDemo> listNotParentRecord = new HashSet<>();
        // 第一步：遍历allMenuSet保存所有数据的uuid用于判断是不是根节点
        Map<String, String> mapAllUuid = new HashMap<String, String>();
        for (ExcelDemo record : allMenuSet) {
            mapAllUuid.put(record.getCode(), record.getCode());
        }
        // 第二步：遍历allRrecords找出所有的根节点和非根节点
        if (allMenuSet.size() > 0) {
            for (ExcelDemo record : allMenuSet) {
                if (StringUtils.isBlank(record.getPcode())
                        || !mapAllUuid.containsKey(record.getPcode())) {
                    listParentRecord.add(record);
                } else {
                    listNotParentRecord.add(record);
                }
            }
        }

        // 第三步： 递归获取所有子节点
        if (listParentRecord.size() > 0) {
            for (ExcelDemo record : listParentRecord) {
                // 添加所有子级
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getCode()));

            }
        }
        return listParentRecord;
    }

    private  Set<ExcelDemo> getTreeChildRecord(Set<ExcelDemo> childList, String parentUuid) {
        Set<ExcelDemo> listParentRecord = new HashSet<>();
        Set<ExcelDemo> listNotParentRecord = new HashSet<>();
        // 遍历tmpList，找出所有的根节点和非根节点
        if (childList != null && childList.size() > 0) {
            for (ExcelDemo record : childList) {
                // 对比找出父节点
                if (StringUtils.equals(record.getPcode(), parentUuid)) {
                    listParentRecord.add(record);
                } else {
                    listNotParentRecord.add(record);
                }

            }
        }
        // 查询子节点
        if (listParentRecord.size() > 0) {
            for (ExcelDemo record : listParentRecord) {
                // 递归查询子节点
                record.setChildren(getTreeChildRecord(listNotParentRecord, record.getCode()));
            }
        }
        return listParentRecord;
    }
}