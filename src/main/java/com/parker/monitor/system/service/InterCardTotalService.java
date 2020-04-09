package com.parker.monitor.system.service;

import com.google.common.collect.Lists;
import com.parker.monitor.system.entity.InterCardInfo;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 网卡信息接口
 * @author Parker
 */
@Slf4j
@Service
public class InterCardTotalService {

    /**
     * 获得网卡信息
     * @return List<InterCardInfo>
     */
    public List<InterCardInfo> getInterCardTotal() throws Exception{
        List<InterCardInfo> list = Lists.newArrayList();

        Sigar sigar = new Sigar();
        String[] ifNames = sigar.getNetInterfaceList();
        for (int i = 0; i < ifNames.length; i++) {

            NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(ifNames[i]);
            if (NetFlags.LOOPBACK_ADDRESS.equals(ifconfig.getAddress()) || (ifconfig.getFlags() & NetFlags.IFF_LOOPBACK) != 0
                    || NetFlags.NULL_HWADDR.equals(ifconfig.getHwaddr())) {
                continue;
            }

            // 网络设备名
            String name = ifNames[i];

            InterCardInfo interCardInfo = new InterCardInfo();
            interCardInfo.setNetName(name)
                         .setDescription(ifconfig.getDescription())
                         .setIpAddr(ifconfig.getAddress())
                         .setNetMask(ifconfig.getNetmask())
                         .setHwAddr(ifconfig.getHwaddr())
                         .setBroadcast(ifconfig.getBroadcast())
                         .setType(ifconfig.getType());

            list.add(interCardInfo);
        }
        return list;
    }

}
