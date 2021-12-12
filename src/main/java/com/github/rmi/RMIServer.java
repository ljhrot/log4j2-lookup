package com.github.rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * date 2021/12/12 17:18
 *
 * @author hjl
 */
public class RMIServer {

    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        //创建Registry
        Registry registry = LocateRegistry.createRegistry(1099);
        // 使用 python -m http.server 8080 提供 class 文件下载服务
        String url = "http://127.0.0.1:8080/";
        // 实例化一个Reference尝试为远程对象构造一个引用
        // className 需要全限定名
        Reference reference = new Reference("Task", "Task", url);
        // 强转成ReferenceWrapper，因为Reference并没有继承Remote接口，不能直接注册到Registry中
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("task", referenceWrapper);
        System.out.println("Listening on 0.0.0.0:1099");
    }
}
