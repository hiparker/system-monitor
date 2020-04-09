package com.parker.monitor.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 分区磁盘信息
 * @author Parker
 */
@ApiModel(value="磁盘分区信息", description="该Entity为 检测磁盘分区信息 用于Java探针")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DiskDevInfo{

    /** 盘符名称 */
    @ApiModelProperty(value = "盘符名称")
    private String devName;

    /** 盘符路径 */
    @ApiModelProperty(value = "盘符路径")
    private String dirName;

    /** 盘符标志 */
    @ApiModelProperty(value = "盘符标志")
    private Long flags;

    /** 盘符类型 */
    @ApiModelProperty(value = "盘符类型")
    private String sysTypeName;

    /** 盘符类型名 */
    @ApiModelProperty(value = "盘符类型名")
    private String typeName;

    /** 盘符文件系统类型 */
    @ApiModelProperty(value = "盘符文件系统类型")
    private Integer type;

    /** 分区磁盘总容量 */
    @ApiModelProperty(value = "分区磁盘总容量")
    private Double total;

    /** 分区磁盘剩余容量 */
    @ApiModelProperty(value = "分区磁盘剩余容量")
    private Double free;

    /** 分区磁盘可用容量 */
    @ApiModelProperty(value = "分区磁盘可用容量")
    private Double avail;

    /** 分区磁盘已使用容量 */
    @ApiModelProperty(value = "分区磁盘已使用容量")
    private Double used;

    /** 分区磁盘资源的利用率 */
    @ApiModelProperty(value = "分区磁盘资源的利用率")
    private Double usePercent;

}