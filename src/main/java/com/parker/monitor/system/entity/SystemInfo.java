package com.parker.monitor.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 系统信息
 * @author Parker
 */
@ApiModel(value="系统信息", description="该Entity为 检测服务系统信息 用于Java探针")

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemInfo {



    /** 操作系统名称 */
    @ApiModelProperty(value = "操作系统名称")
    private String osName;

    /** 操作系统架构 */
    @ApiModelProperty(value = "操作系统架构")
    private String osArch;


    /** 操作系统描述 */
    @ApiModelProperty(value = "操作系统描述")
    private String description;

    /** CPU端 */
    @ApiModelProperty(value = "CPU端")
    private String cpuEndian;

    /** 数据模型 */
    @ApiModelProperty(value = "数据模型")
    private String dataModel;


    /** 操作系统版本 */
    @ApiModelProperty(value = "操作系统版本")
    private String osVersion;


}
