package com.parker.monitor.system.web;

import com.parker.monitor.system.api.vo.Result;
import com.parker.monitor.system.base.BaseController;
import com.parker.monitor.system.constant.CommonConstant;
import com.parker.monitor.system.entity.*;
import com.parker.monitor.system.service.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created Date by 2020/4/9 0009.
 *
 * 探针接口
 * @author Parker
 */
@Slf4j
@RestController
@RequestMapping("/system/monitor")
public class Controller extends BaseController {


    @Autowired
    private SystemTotalService systemTotalService;

    @Autowired
    private JvmTotalService jvmTotalService;

    @Autowired
    private InterCardTotalService interCardTotalService;

    @Autowired
    private NetTotalService netTotalService;

    @Autowired
    private MemoryTotalService memoryTotalService;

    @Autowired
    private DiskTotalService diskTotalService;

    @Autowired
    private CpuTotalService cpuTotalService;



    /**
     * 获得 Jvm信息
     * @return
     */
    @GetMapping("getJvmTotal")
    @ApiOperation(value = "获得 Jvm信息",notes = "包含服务器Jvm基本运行状态、信息、参数等")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "unit", value = "获得硬盘单位 g/m/k ，默认为 m ", required = false, dataType = "String")
    })
    public Result<JvmInfo> getJvmTotal(String unit) throws Exception{
        Result<JvmInfo> re = new Result();

        // 获得信息
        JvmInfo jvmTotal = jvmTotalService.getJvmTotal(unit);

        re.setResult(jvmTotal);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }


    /**
     * 获得 系统信息
     * @return
     */
    @GetMapping("getSystemTotal")
    @ApiOperation(value = "获得 系统信息",notes = "包含服务器基本信息")
    public Result<SystemInfo> getSystemTotal()  throws Exception{
        Result<SystemInfo> re = new Result();

        // 获得信息
        SystemInfo systemTotal = systemTotalService.getSystemTotal();

        re.setResult(systemTotal);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }

    /**
     * 获得 Cpu信息
     * @return
     */
    @GetMapping("getCpuTotal")
    @ApiOperation(value = "获得 CPU信息",notes = "包含服务器CPU基本运行状态、占用率等")
    public Result<CpuInfo> getCpuTotal() throws Exception{
        Result<CpuInfo> re = new Result();

        // 获得信息
        CpuInfo cpuInfo = cpuTotalService.getCpuTotal();

        re.setResult(cpuInfo);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }


    /**
     * 获得 内存信息
     * @return
     */
    @GetMapping("getMemoryTotal")
    @ApiOperation(value = "获得 内存信息",notes = "包含服务器内存信息与交换区内存信息")
    @ApiImplicitParams({
         @ApiImplicitParam(paramType = "query", name = "unit", value = "获得内存单位 g/m/k ，默认为 m ", required = false, dataType = "String")
    })
    public Result<MemoryInfo> getMemoryTotal(String unit)  throws Exception{
        Result<MemoryInfo> re = new Result();

        // 获得信息
        MemoryInfo memoryTotal = memoryTotalService.getMemoryTotal(unit);

        re.setResult(memoryTotal);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }



    /**
     * 获得 硬盘信息
     * @return
     */
    @GetMapping("getDiskInfo")
    @ApiOperation(value = "获得 硬盘信息",notes = "包含服务器硬盘基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "unit", value = "获得硬盘单位 g/m/k ，默认为 m ", required = false, dataType = "String")
    })
    public Result<DiskInfo> getDiskInfo(String unit)  throws Exception{
        Result<DiskInfo> re = new Result();

        // 获得信息
        DiskInfo diskInfo = diskTotalService.getDiskTotal(unit);

        re.setResult(diskInfo);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }


    /**
     * 获得 网卡信息
     * @return
     */
    @GetMapping("getInterCardTotal")
    @ApiOperation(value = "获得 网卡信息",notes = "包含服务器 网卡基本信息 等")
    public Result<List<InterCardInfo>> getInterCardTotal() throws Exception{
        Result<List<InterCardInfo>> re = new Result();

        // 获得信息
        List<InterCardInfo> interCardTotals = interCardTotalService.getInterCardTotal();

        re.setResult(interCardTotals);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }


    /**
     * 获得 网络信息
     * @return
     */
    @GetMapping("getNetWork")
    @ApiOperation(value = "获得 网络信息",notes = "包含服务器 网卡基本信息 接发包、丢包 等")
    public Result<List<NetInfo>> getNetWork()  throws Exception{
        Result<List<NetInfo>> re = new Result();

        // 获得信息
        List<NetInfo> netTotals = netTotalService.getNetTotal();;

        re.setResult(netTotals);
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }


    /**
     * Linux获得libraryPath接口
     * @return
     */
    @GetMapping("getLibraryPath")
    @ApiOperation(value = "获得 Linux libraryPath",notes = "Linux安全服务器很高 需要找到对应的路径 把 sigar 的 so 文件传进去 并且 chmod 777 libsigar* ")
    public Result<String> getLibraryPath()  throws Exception{
        Result<String> re = new Result();
        re.setResult(System.getProperty("java.library.path"));
        re.setCode(CommonConstant.SC_OK_200);
        return re;
    }



}
