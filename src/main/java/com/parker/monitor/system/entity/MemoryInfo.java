package com.parker.monitor.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 内存信息
 * @author Parker
 */
@ApiModel(value="内存信息", description="该Entity为 检测内存信息 用于Java探针")

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MemoryInfo {

    /** 内存总量 */
    @ApiModelProperty(value = "内存总量")
    private Double total;

    /** 当前内存使用量 */
    @ApiModelProperty(value = "当前内存使用量")
    private Double used;

    /** 当前内存使用率 */
    @ApiModelProperty(value = "当前内存使用率")
    private Double usedRate;

    /** 当前内存剩余量 */
    @ApiModelProperty(value = "当前内存剩余量")
    private Double free;

    /** 当前内存剩余率 */
    @ApiModelProperty(value = "当前内存剩余率")
    private Double freeRate;




    /** 交换区总量 */
    @ApiModelProperty(value = "交换区总量")
    private Double swapTotal;

    /** 当前交换区使用量 */
    @ApiModelProperty(value = "当前交换区使用量")
    private Double swapUsed;

    /** 当前交换区使用率 */
    @ApiModelProperty(value = "当前交换区使用率")
    private Double swapUsedRate;

    /** 当前交换区剩余量 */
    @ApiModelProperty(value = "当前交换区剩余量")
    private Double swapFree;

    /** 当前交换区剩余率 */
    @ApiModelProperty(value = "当前交换区剩余率")
    private Double swapFreeRate;

}
