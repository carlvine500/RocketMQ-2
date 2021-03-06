package com.alibaba.rocketmq.client;

import com.alibaba.rocketmq.common.UtilAll;


/**
 * 虚拟环境相关 API 封装
 * 
 * @author manhong.yqd<jodie.yqd@gmail.com>
 * @since 2013-8-26
 */
public class VirtualEnvUtil {
    public static final String VIRTUAL_APP_GROUP_PREFIX = "%%PROJECT_%s%%";


    /**
     * 添加虚拟运行环境相关的projectGroupPrefix
     * 
     * @param origin
     * @param projectGroup
     * @return
     */
    public static String buildWithProjectGroup(String origin, String projectGroup) {
        if (!UtilAll.isBlank(projectGroup)) {
            String prefix = String.format(VIRTUAL_APP_GROUP_PREFIX, projectGroup);
            if (!origin.endsWith(prefix)) {
                return origin + prefix;
            }
            else {
                return origin;
            }
        }
        else {
            return origin;
        }
    }


    /**
     * 清除虚拟运行环境相关的projectGroupPrefix
     * 
     * @param origin
     * @param projectGroup
     * @return
     */
    public static String clearProjectGroup(String origin, String projectGroup) {
        String prefix = String.format(VIRTUAL_APP_GROUP_PREFIX, projectGroup);
        if (!UtilAll.isBlank(prefix) && origin.endsWith(prefix)) {
            return origin.substring(0, origin.lastIndexOf(prefix));
        }
        else {
            return origin;
        }
    }


    public static void main(String[] args) {
        String ori = "bbbb";
        String str = buildWithProjectGroup(ori, "AAA");
        System.out.println("build=" + str);
        System.out.println("ori=" + clearProjectGroup(str, "AAA"));
    }
}
