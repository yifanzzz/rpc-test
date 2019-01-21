package cn.test.rpc;

/**
 * Hello world!
 *
 */
public class RpcTest
{
    public static void main( String[] args )
    {
        SayHelloService batterCakeService=RpcConsumer.getService(SayHelloService.class, "127.0.0.1", 12000);
        String result=batterCakeService.sayHello("hope zz");
        System.out.println(result);
    }
}
