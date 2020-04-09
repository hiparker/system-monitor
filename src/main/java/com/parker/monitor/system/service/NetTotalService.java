package com.parker.monitor.system.service;

import com.google.common.collect.Lists;
import com.parker.monitor.system.entity.NetInfo;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.Sigar;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 网络信息接口
 * @author Parker
 */
@Slf4j
@Service
public class NetTotalService {

    /**
     * 获得网络信息
     * @return List<NetInfo>
     */
    public List<NetInfo> getNetTotal() throws Exception{
        List<NetInfo> list = Lists.newArrayList();

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
            NetInfo netInfo = new NetInfo();
            netInfo.setNetName(name)
                         .setDescription(ifconfig.getDescription())
                         .setIpAddr(ifconfig.getAddress())
                         .setNetMask(ifconfig.getNetmask())
                         .setHwAddr(ifconfig.getHwaddr())
                         .setBroadcast(ifconfig.getBroadcast())
                         .setType(ifconfig.getType());

            if ((ifconfig.getFlags() & 1L) <= 0L) {
                log.warn("!IFF_UP...skipping getNetInterfaceStat");
                continue;
            }


            // 发包状态
            NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);

            netInfo.setRxPackets(ifstat.getRxPackets())
                    .setTxPackets(ifstat.getTxPackets())
                    .setRxBytes(ifstat.getRxBytes())
                    .setTxBytes(ifstat.getTxBytes())
                    .setRxErrors(ifstat.getRxErrors())
                    .setTxBytes(ifstat.getTxErrors())
                    .setRxDropped(ifstat.getRxDropped())
                    .setTxDropped(ifstat.getTxDropped());

            list.add(netInfo);
        }
        return list;
    }

}
