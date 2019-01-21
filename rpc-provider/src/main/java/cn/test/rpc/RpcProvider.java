package cn.test.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class RpcProvider
{
    //服务列表 可以存储到redis
    private static List<Object> serviceList;

    /**
     * 发布rpc服务
     * @param port
     * @param services
     * @throws Exception
     */
    public static void publish(int port,Object... services) throws Exception {
        serviceList= Arrays.asList(services);
        ServerSocket server = new ServerSocket(port);
        Socket client = null;
        while (true) {
            client = server.accept();
            new Thread(new ServerThread(client,serviceList)).start();
        }
    }
}
