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
 * CPU类
 * @author Parker
 */
@ApiModel(value="CPU信息", description="该Entity为 检测CPU信息 用于Java探针")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CpuSingleInfo {

    /** CPU的总量MHz **/
    @ApiModelProperty(value = "CPU的总量MHz")
    private Integer mhz;

    /** CPU生产商 **/
    @ApiModelProperty(value = "CPU生产商")
    private String vendor;

    /** CPU类别 **/
    @ApiModelProperty(value = "CPU类别")
    private String model;

    /** CPU缓存数量 **/
    @ApiModelProperty(value = "CPU缓存数量")
    private Long cacheSize;

    /** CPU用户使用率 **/
    @ApiModelProperty(value = "CPU用户使用率")
    private Double userRate;

    /** CPU系统使用率 **/
    @ApiModelProperty(value = "CPU系统使用率")
    private Double sysRate;

    /** CPU当前等待率 **/
    @ApiModelProperty(value = "CPU当前等待率")
    private Double waitRate;

    /** CPU当前错误率 **/
    @ApiModelProperty(value = "CPU当前错误率")
    private Double niceRate;

    /** CPU当前空闲率 **/
    @ApiModelProperty(value = "CPU当前空闲率")
    private Double idleRate;

    /** CPU总的使用率 **/
    @ApiModelProperty(value = "CPU总的使用率")
    private Double totalRate;


}
