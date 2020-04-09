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
 * Jvm 信息
 * @author Parker
 */
@ApiModel(value="Jvm 信息", description="该Entity为 检测Jvm 信息 用于Java探针")

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JvmInfo {

    /** JVM可以使用的总内存 */
    @ApiModelProperty(value = "JVM可以使用的总内存")
    private Double totalMemory;

    /** JVM可以使用的剩余内存 */
    @ApiModelProperty(value = "JVM可以使用的剩余内存")
    private Double freeMemory;

    /** JVM可以使用的处理器个数 */
    @ApiModelProperty(value = "JVM可以使用的处理器个数")
    private Integer availableProcessors;

    /** Java的运行环境版本 */
    @ApiModelProperty(value = "Java的运行环境版本")
    private String javaVersion;

    /** Java的运行环境供应商 */
    @ApiModelProperty(value = "Java的运行环境供应商")
    private String javaVendor;

    /** Java供应商的URL */
    @ApiModelProperty(value = "Java供应商的URL")
    private String javaVendorUrl;

    /** Java的安装路径 */
    @ApiModelProperty(value = "Java的安装路径")
    private String javaHome;

    /** Java的虚拟机规范版本 */
    @ApiModelProperty(value = "Java的虚拟机规范版本")
    private String javaVmSpecificationVersion;

    /** Java的虚拟机规范供应商 */
    @ApiModelProperty(value = "Java的虚拟机规范供应商")
    private String javaVmSpecificationVendor;

    /** Java的虚拟机规范名称 */
    @ApiModelProperty(value = "Java的虚拟机规范名称")
    private String javaVmSpecificationName;

    /** Java的虚拟机实现版本 */
    @ApiModelProperty(value = "Java的虚拟机实现版本")
    private String javaVmVersion;

    /** Java的虚拟机实现供应商 */
    @ApiModelProperty(value = "Java的虚拟机实现供应商")
    private String javaVmVendor;

    /** Java的虚拟机实现名称 */
    @ApiModelProperty(value = "Java的虚拟机实现名称")
    private String javaVmName;

    /** Java运行时环境规范版本 */
    @ApiModelProperty(value = "Java运行时环境规范版本")
    private String javaSpecificationVersion;

    /** Java运行时环境规范供应商 */
    @ApiModelProperty(value = "Java运行时环境规范供应商")
    private String javaSpecificationVender;

    /** Java运行时环境规范名称 */
    @ApiModelProperty(value = "Java运行时环境规范名称")
    private String javaSpecificationName;

    /** Java的类格式版本号 */
    @ApiModelProperty(value = "Java的类格式版本号")
    private String javaClassVersion;

    /** Java的类路径 */
    @ApiModelProperty(value = "Java的类路径")
    private String javaClassPath;

    /** 运行时 jvm配置参数 */
    @ApiModelProperty(value = "运行时 jvm配置参数")
    private List<String> runtimeMXBeans;

}
