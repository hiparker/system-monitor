package com.parker.monitor.system.service;

import com.google.common.collect.Lists;
import com.parker.monitor.system.entity.MemoryInfo;
import com.parker.monitor.system.entity.NetInfo;
import com.parker.monitor.system.utils.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 内存信息接口
 * @author Parker
 */
@Slf4j
@Service
public class MemoryTotalService {

    /**
     * 获得内存信息
     * @return MemoryInfo
     */
    public MemoryInfo getMemoryTotal(String unit) throws Exception{

        if(StringUtils.isEmpty(unit)){
            unit = "m";
        }

        MemoryInfo memoryInfo = new MemoryInfo();
        Sigar sigar = new Sigar();

        // 内存
        Mem mem = sigar.getMem();
        // 交换区
        Swap swap = sigar.getSwap();


        memoryInfo.setTotal(this.getCountByUnit(mem.getTotal(),unit))
                  .setUsed(this.getCountByUnit(mem.getUsed(),unit))
                  .setFree(this.getCountByUnit(mem.getFree(),unit))
                  .setSwapTotal(this.getCountByUnit(swap.getTotal(),unit))
                  .setSwapUsed(this.getCountByUnit(swap.getUsed(),unit))
                  .setSwapFree(this.getCountByUnit(swap.getFree(),unit));

        double usedRate = 0d;
        double freeRate = 0d;
        double swapUsedRate = 0d;
        double swapFreeRate = 0d;
        try {
            // 计算 使用/剩余率
            usedRate = BigDecimalUtil.div(memoryInfo.getUsed(),memoryInfo.getTotal(),2);
            freeRate = BigDecimalUtil.div(memoryInfo.getFree(),memoryInfo.getTotal(),2);
            swapUsedRate = BigDecimalUtil.div(memoryInfo.getSwapUsed(),memoryInfo.getSwapTotal(),2);
            swapFreeRate = BigDecimalUtil.div(memoryInfo.getSwapFree(),memoryInfo.getSwapTotal(),2);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        memoryInfo.setUsedRate(usedRate)
                  .setFreeRate(freeRate)
                  .setSwapUsedRate(swapUsedRate)
                  .setSwapFreeRate(swapFreeRate);

        return memoryInfo;
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
