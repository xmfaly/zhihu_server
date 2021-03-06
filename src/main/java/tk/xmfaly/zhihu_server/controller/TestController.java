package tk.xmfaly.zhihu_server.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.xmfaly.zhihu_server.dto.Response;
import tk.xmfaly.zhihu_server.heartbeat.HeartRate;
import tk.xmfaly.zhihu_server.heartbeat.HeartRateRepository;
import tk.xmfaly.zhihu_server.heartbeat.HeartbeatProcessService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private HeartbeatProcessService heartbeatProcessService;

    @GetMapping("/initdata")
    public Response fssdfs(int did){
       return heartbeatProcessService.HeartBeatProcess(did);
    }
}
