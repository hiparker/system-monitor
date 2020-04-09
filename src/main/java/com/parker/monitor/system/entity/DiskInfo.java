package com.parker.monitor.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 磁盘信息
 * @author Parker
 */
@ApiModel(value="磁盘信息", description="该Entity为 检测磁盘信息 用于Java探针")

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DiskInfo {

    /** 磁盘总容量 */
    @ApiModelProperty(value = "磁盘总容量")
    private Double diskTotal;

    /** 磁盘剩余容量 */
    @ApiModelProperty(value = "磁盘剩余容量")
    private Double diskFree;

    /** 磁盘剩余容量占比 */
    @ApiModelProperty(value = "磁盘剩余容量占比")
    private Double diskFreeRate;

    /** 磁盘可用容量 */
    @ApiModelProperty(value = "磁盘可用容量")
    private Double diskAvail;

    /** 磁盘可用容量占比 */
    @ApiModelProperty(value = "磁盘可用容量占比")
    private Double diskAvailRate;

    /** 磁盘已使用容量 */
    @ApiModelProperty(value = "磁盘已使用容量")
    private Double diskUsed;

    /** 磁盘已使用容量占比 */
    @ApiModelProperty(value = "磁盘已使用容量占比")
    private Double diskUsedRate;

    /** 磁盘分区信息 */
    @ApiModelProperty(value = "磁盘分区信息")
    private List<DiskDevInfo> diskDevInfos;

}