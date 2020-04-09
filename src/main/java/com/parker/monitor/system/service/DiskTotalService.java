package com.parker.monitor.system.service;

import com.google.common.collect.Lists;
import com.parker.monitor.system.entity.DiskDevInfo;
import com.parker.monitor.system.entity.DiskInfo;
import com.parker.monitor.system.utils.BigDecimalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 获得硬盘信息
 * @author Parker
 */
@Slf4j
@Service
public class DiskTotalService {


    private static final int TYPE = 2;

    /**
     * 获得硬盘信息
     * @return DiskInfo
     */
    public DiskInfo getDiskTotal(String unit) throws Exception{
        DiskInfo diskInfo = new DiskInfo();

        List<DiskDevInfo> diskDevInfos = Lists.newArrayList();

        diskInfo.setDiskDevInfos(diskDevInfos);


        Sigar sigar = new Sigar();
        FileSystem fslist[] = sigar.getFileSystemList();

        // 磁盘总容量
        double diskTotal = 0d;
        // 磁盘剩余容量
        double diskFree = 0d;
        // 磁盘可用容量
        double diskAvail = 0d;
        // 磁盘已使用容量
        double diskUsed = 0d;


        for (int i = 0; i < fslist.length; i++) {

            DiskDevInfo diskDevInfo = new DiskDevInfo();

            FileSystem fs = fslist[i];

            // 分区基本信息
            diskDevInfo.setDevName(fs.getDevName())
                       .setDirName(fs.getDirName())
                       .setFlags(fs.getFlags())
                       .setSysTypeName(fs.getSysTypeName())
                       .setTypeName(fs.getTypeName())
                       .setType(fs.getType());
            // 分区硬盘数据信息
            // 本地硬盘
            if(TYPE == fs.getType()){
                FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());

                diskDevInfo.setTotal(this.getCountByUnit(usage.getTotal(),unit))
                           .setFree(this.getCountByUnit(usage.getFree(),unit))
                           .setAvail(this.getCountByUnit(usage.getAvail(),unit))
                           .setUsed(this.getCountByUnit(usage.getUsed(),unit))
                           .setUsePercent(usage.getUsePercent());

                if(null != diskDevInfo.getTotal()){
                    diskTotal = BigDecimalUtil.add(diskTotal,diskDevInfo.getTotal());
                }
                if(null != diskDevInfo.getFree()){
                    diskFree = BigDecimalUtil.add(diskFree,diskDevInfo.getFree());
                }
                if(null != diskDevInfo.getAvail()){
                    diskAvail = BigDecimalUtil.add(diskAvail,diskDevInfo.getAvail());
                }
                if(null != diskDevInfo.getUsed()){
                    diskUsed = BigDecimalUtil.add(diskUsed,diskDevInfo.getUsed());
                }
            }

            diskDevInfos.add(diskDevInfo);
        }

        diskInfo.setDiskTotal(diskTotal)
                .setDiskFree(diskFree)
                .setDiskAvail(diskAvail)
                .setDiskUsed(diskUsed);

        // 计算比例
        double diskFreeRate = 0d;
        double diskAvailRate = 0d;
        double diskUsedRate = 0d;
        try {
            diskFreeRate = BigDecimalUtil.div(diskFree,diskTotal,2);
            diskAvailRate = BigDecimalUtil.div(diskAvail,diskTotal,2);
            diskUsedRate = BigDecimalUtil.div(diskUsed,diskTotal,2);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }

        diskInfo.setDiskFreeRate(diskFreeRate)
                .setDiskAvailRate(diskAvailRate)
                .setDiskUsedRate(diskUsedRate);

        return diskInfo;
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
