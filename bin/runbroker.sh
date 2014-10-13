#!/bin/sh

#
# $Id: runbroker.sh 1831 2013-05-16 01:39:51Z shijia.wxr $
#

function_error_exit ()
{
    echo "ERROR: $1 !!"
    exit 1
}

if [ $# -lt 1 ];
then
  function_error_exit "USAGE: $0 classname opts"
fi
CLASSPATH=$CLASSPATH:.:../lib/commons-cli-1.2.jar:../lib/commons-io-2.4.jar:../lib/derby-10.10.2.0.jar:../lib/fastjson-1.1.41.jar:../lib/javassist-3.7.ga.jar:../lib/logback-classic-1.0.13.jar:../lib/logback-core-1.0.13.jar:../lib/mysql-connector-java-5.1.31.jar:../lib/netty-all-4.0.21.Final.jar:../lib/rocketmq-broker-3.1.9.jar:../lib/rocketmq-client-3.1.9.jar:../lib/rocketmq-common-3.1.9.jar:../lib/rocketmq-example-3.1.9.jar:../lib/rocketmq-filtersrv-3.1.9.jar:../lib/rocketmq-namesrv-3.1.9.jar:../lib/rocketmq-remoting-3.1.9.jar:../lib/rocketmq-srvutil-3.1.9.jar:../lib/rocketmq-store-3.1.9.jar:../lib/rocketmq-tools-3.1.9.jar:../lib/slf4j-api-1.7.5.jar
BASE_DIR=$(dirname $0)/..
CLASSPATH=.:${BASE_DIR}/conf:${CLASSPATH}

#JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn2g -XX:PermSize=128m -XX:MaxPermSize=320m"
#Java 8 removes -XX:PermSize and -XX:MaxPermSize otpions
JAVA_OPT="${JAVA_OPT} -server -Xms4g -Xmx4g -Xmn2g"
JAVA_OPT="${JAVA_OPT} -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSParallelRemarkEnabled -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=8 -XX:+DisableExplicitGC"
JAVA_OPT="${JAVA_OPT} -verbose:gc -Xloggc:${HOME}/rmq_bk_gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow"
JAVA_OPT="${JAVA_OPT} -Djava.ext.dirs=${BASE_DIR}/lib"
#JAVA_OPT="${JAVA_OPT} -Xdebug -Xrunjdwp:transport=dt_socket,address=9555,server=y,suspend=n"
JAVA_OPT="${JAVA_OPT} -cp ${CLASSPATH}"

if [ -z "$JAVA_HOME" ]; then
  JAVA_HOME=/opt/taobao/java
fi

JAVA="$JAVA_HOME/bin/java"

[ ! -e "$JAVA" ] && function_error_exit "Please set the JAVA_HOME variable in your environment, We need java!"

numactl --interleave=all pwd > /dev/null 2>&1
if [ $? -eq 0 ]
then
    numactl --interleave=all $JAVA ${JAVA_OPT} $@
else
    $JAVA ${JAVA_OPT} $@
fi
