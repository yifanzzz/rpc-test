package cn.test.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by hopezzz on 2019/1/21.
 * cn.test.rpc
 */
public class RpcConsumer {

    public static <T> T getService(Class<T> clazz, final String ip, final int port) {
        return (T)Proxy.newProxyInstance(RpcConsumer.class.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket(ip, port);
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                try {
                    output.writeObject(proxy.getClass().getInterfaces()[0]);
                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);
                    output.flush();
                    Object result = input.readObject();
                    if(result instanceof Throwable) {
                        throw (Throwable) result;
                    }
                    return result;
                } finally {
                    socket.shutdownOutput();
                }
            }
        });
    }

}
