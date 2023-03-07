package com.xub.model.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//该类作用在于提出表公共字段
@Data
public class BaseEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableLogic //逻辑删除，查询会自动默认查询 is_deleted = 0 的数据
    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField(exist = false) // 标记在表中可不存在对应字段
    private Map<String,Object> param = new HashMap<>();
}
