package com.parker.monitor.system.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 网卡 信息
 * @author Parker
 */
@ApiModel(value="网卡信息", description="该Entity为 检测网卡信息 用于Java探针")

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NetInfo {


    /** 网络设备名 */
    @ApiModelProperty(value = "网络设备名")
    private String netName;

    /** 网卡描述 */
    @ApiModelProperty(value = "网卡描述")
    private String description;

    /** 网卡Mac地址 */
    @ApiModelProperty(value = "网卡Mac地址")
    private String hwAddr;

    /** ip地址 */
    @ApiModelProperty(value = "ip地址")
    private String ipAddr;

    /** 子网掩码 */
    @ApiModelProperty(value = "子网掩码")
    private String netMask;

    /** 网络广播地址 */
    @ApiModelProperty(value = "网络广播地址")
    private String broadcast;

    /** 网卡类型 */
    @ApiModelProperty(value = "网卡类型")
    private String type;


    /** 接收的总包裹数 */
    @ApiModelProperty(value = "接收的总包裹数")
    private Long rxPackets;

    /** 发送的总包裹数 */
    @ApiModelProperty(value = "发送的总包裹数")
    private Long txPackets;

    /** 接收到的总字节数 */
    @ApiModelProperty(value = "接收到的总字节数")
    private Long rxBytes;

    /** 发送的总字节数 */
    @ApiModelProperty(value = "发送的总字节数")
    private Long txBytes;


    /** 接收到的错误包数 */
    @ApiModelProperty(value = "接收到的错误包数")
    private Long rxErrors;


    /** 发送数据包时的错误数 */
    @ApiModelProperty(value = "发送数据包时的错误数")
    private Long txErrors;

    /** 接收时丢弃的包数 */
    @ApiModelProperty(value = "接收时丢弃的包数")
    private Long rxDropped;


    /** 发送时丢弃的包数 */
    @ApiModelProperty(value = "发送时丢弃的包数")
    private Long txDropped;

}
