package com.parker.monitor.system.service;

import com.google.common.collect.Lists;
import com.parker.monitor.system.entity.CpuInfo;
import com.parker.monitor.system.entity.CpuSingleInfo;
import com.parker.monitor.system.utils.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 获得Cpu信息
 * @author Parker
 */
@Slf4j
@Service
public class CpuTotalService {


    /**
     * 获得cpu信息
     * @return CpuInfo
     */
    public CpuInfo getCpuTotal() throws Exception{
        CpuInfo cpuInfo = new CpuInfo();
        Sigar sigar = new Sigar();
        List<CpuSingleInfo> list = Lists.newArrayList();

        Runtime r = Runtime.getRuntime();
        CpuPerc cpuBasePerc = sigar.getCpuPerc();

        // CPU总指数
        cpuInfo.setCount(r.availableProcessors())
                // 保留两位小数
                .setUserRate(BigDecimalUtil.div(cpuBasePerc.getUser(),1d,2))
                .setSysRate(BigDecimalUtil.div(cpuBasePerc.getSys(),1d,2))
                .setWaitRate(BigDecimalUtil.div(cpuBasePerc.getWait(),1d,2))
                .setNiceRate(BigDecimalUtil.div(cpuBasePerc.getNice(),1d,2))
                .setIdleRate(BigDecimalUtil.div(cpuBasePerc.getIdle(),1d,2))
                .setTotalRate(BigDecimalUtil.div(cpuBasePerc.getCombined(),1d,2));

        cpuInfo.setCpuSingleInfos(list);


        // 获得 各个核CPU具体指数
        org.hyperic.sigar.CpuInfo[] infos = sigar.getCpuInfoList();
        CpuPerc[] cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuSingleInfo cpuSingleInfo = new CpuSingleInfo();
            CpuPerc cpu = cpuList[i];

            org.hyperic.sigar.CpuInfo info = infos[i];

            cpuSingleInfo.setMhz(info.getMhz())
                   .setVendor(info.getVendor())
                   .setModel(info.getModel())
                   .setCacheSize(info.getCacheSize())
                    // 保留两位小数
                   .setUserRate(BigDecimalUtil.div(cpu.getUser(),1d,2))
                   .setSysRate(BigDecimalUtil.div(cpu.getSys(),1d,2))
                   .setWaitRate(BigDecimalUtil.div(cpu.getWait(),1d,2))
                   .setNiceRate(BigDecimalUtil.div(cpu.getNice(),1d,2))
                   .setIdleRate(BigDecimalUtil.div(cpu.getIdle(),1d,2))
                   .setTotalRate(BigDecimalUtil.div(cpu.getCombined(),1d,2));

            list.add(cpuSingleInfo);
        }

        return cpuInfo;
    }


}
