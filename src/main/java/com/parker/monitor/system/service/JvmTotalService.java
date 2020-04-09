package com.parker.monitor.system.service;

import com.parker.monitor.system.entity.JvmInfo;
import com.parker.monitor.system.utils.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.Properties;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 获得Jvm信息
 * @author Parker
 */
@Slf4j
@Service
public class JvmTotalService {


    /**
     * 获得Jvm信息
     * @return JvmInfo
     */
    public JvmInfo getJvmTotal(String unit) throws Exception{
        JvmInfo jvmInfo = new JvmInfo();

        //获取 运行时设置的JVM参数
        List<String> inputArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();

        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();


        jvmInfo.setTotalMemory(this.getCountByUnit(r.totalMemory(),unit))
                .setFreeMemory(this.getCountByUnit(r.freeMemory(),unit))
                .setAvailableProcessors(r.availableProcessors())
                .setJavaVersion(props.getProperty("java.version"))
                .setJavaVendor(props.getProperty("java.vendor"))
                .setJavaVendorUrl(props.getProperty("java.vendor.url"))
                .setJavaHome(props.getProperty("java.home"))
                .setJavaVmSpecificationVersion(props.getProperty("java.vm.specification.version"))
                .setJavaVmSpecificationVendor(props.getProperty("java.vm.specification.vendor"))
                .setJavaVmSpecificationName(props.getProperty("java.vm.specification.name"))
                .setJavaVmVersion(props.getProperty("java.vm.version"))
                .setJavaVmVendor(props.getProperty("java.vm.vendor"))
                .setJavaVmName(props.getProperty("java.vm.name"))
                .setJavaSpecificationVersion(props.getProperty("java.specification.version"))
                .setJavaSpecificationVender(props.getProperty("java.specification.vendor"))
                .setJavaSpecificationName(props.getProperty("java.specification.name"))
                .setJavaClassVersion(props.getProperty("java.class.version"))
                .setJavaClassPath(props.getProperty("java.class.path"));

        return jvmInfo;
    }

    /**
     * 转化 G M K
     * @param unit
     * @return
     */
    private double getCountByUnit(Long param,String unit){
        double c = 1024d;
        double count = 0d;
        double num = 0d;

        if(StringUtils.isEmpty(unit)){
            unit = "m";
        }

        try {

            if("g".equalsIgnoreCase(unit)){
                count = BigDecimalUtil.mul(c,BigDecimalUtil.mul(c,c));
            }else if("m".equalsIgnoreCase(unit)){
                count = BigDecimalUtil.mul(c,c);
            }else if("k".equalsIgnoreCase(unit)){
                count = c;
            }

            num = BigDecimalUtil.div(param.doubleValue(),count,2);
        }catch (Exception e ){
            log.error(e.getMessage(),e);
        }
        return num;
    }

}
