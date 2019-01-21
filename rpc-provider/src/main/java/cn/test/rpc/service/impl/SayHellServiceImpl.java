package cn.test.rpc.service.impl;

import cn.test.rpc.service.SayHellService;

/**
 * Created by hopezzz on 2019/1/21.
 * cn.test.rpc.service.impl
 */
public class SayHellServiceImpl implements SayHellService {
    @Override
    public String sayHello(String name) {
        return "say hello to :"+name;
    }
}
