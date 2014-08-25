package com.alibaba.rocketmq.common;

import java.io.InputStream;

import sun.tools.attach.HotSpotVirtualMachine;

import com.alibaba.rocketmq.remoting.common.RemotingHelper;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;


public class PrintStack {
    // Returns sun.jvm.hotspot.tools.JStack if available, otherwise null.
    private static Class loadSAClass() {
        //
        // Attempt to load JStack class - we specify the system class
        // loader so as to cater for development environments where
        // this class is on the boot class path but sa-jdi.jar is on
        // the system class path. Once the JDK is deployed then both
        // tools.jar and sa-jdi.jar are on the system class path.
        //
        try {
            return Class.forName("sun.jvm.hotspot.tools.JStack", true, ClassLoader.getSystemClassLoader());
        }
        catch (Exception x) {
        }
        return null;
    }


    public static String jstack() {
        return jstack(UtilAll.getPid());
    }


    public static String jstack(int pid) {
        try {
            return runThreadDump(String.valueOf(pid), new String[0]);
        }
        catch (Throwable e) {
            return RemotingHelper.exceptionSimpleDesc(e);
        }
    }


    // Attach to pid and perform a thread dump
    private static String runThreadDump(String pid, String args[]) throws Exception {
        VirtualMachine vm = null;
        try {
            vm = VirtualMachine.attach(pid);
        }
        catch (Exception x) {
            String msg = x.getMessage();
            if (msg != null) {
                System.err.println(pid + ": " + msg);
            }
            else {
                x.printStackTrace();
            }
            if ((x instanceof AttachNotSupportedException) && (loadSAClass() != null)) {
                System.err
                    .println("The -F option can be used when the target " + "process is not responding");
            }
            // System.exit(1);
            throw x;
        }

        // Cast to HotSpotVirtualMachine as this is implementation specific
        // method.
        InputStream in = ((HotSpotVirtualMachine) vm).remoteDataDump((Object[]) args);

        StringBuilder result = new StringBuilder();
        // read to EOF and just print output
        byte b[] = new byte[256];
        int n;
        do {
            n = in.read(b);
            if (n > 0) {
                String s = new String(b, 0, n, "UTF-8");
                result.append(s);
            }
        } while (n > 0);
        in.close();
        vm.detach();

        return result.toString();
    }

}
