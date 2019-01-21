package cn.test.rpc;

import cn.test.rpc.service.SayHellService;
import cn.test.rpc.service.impl.SayHellServiceImpl;

/**
 * Hello world!
 *
 */
public class RpcBootStrap
{
    public static void main( String[] args )
    {
        SayHellService sayHellService =new SayHellServiceImpl();
        try {
            RpcProvider.publish(12000,sayHellService);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
