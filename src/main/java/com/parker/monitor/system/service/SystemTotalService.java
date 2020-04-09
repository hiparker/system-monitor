package com.parker.monitor.system.service;

import com.parker.monitor.system.entity.SystemInfo;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.OperatingSystem;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 系统信息接口
 * @author Parker
 */
@Slf4j
@Service
public class SystemTotalService {

    /**
     * 获得系统信息
     * @return SystemInfo
     */
    public SystemInfo getSystemTotal() throws Exception{
        SystemInfo systemInfo = new SystemInfo();

        Properties props = System.getProperties();
        OperatingSystem os = OperatingSystem.getInstance();

        systemInfo.setOsName(props.getProperty("os.name"))
                    .setOsArch(props.getProperty("os.arch"))
                    .setOsVersion(os.getVersion())
                    .setDescription(os.getDescription())
                    .setCpuEndian(os.getCpuEndian())
                    .setDataModel(os.getDataModel());

        return systemInfo;
    }

}
