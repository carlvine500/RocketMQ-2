#!/bin/sh
git pull

rm -rf target
rm -f devenv
if [ -z "$JAVA_HOME" ]; then
  JAVA_HOME=/opt/taobao/java
fi
export PATH=$M2_HOME/bin:$JAVA_HOME/bin:$PATH
mvn -Dmaven.test.skip=true clean package install assembly:assembly -U

ln -s target/alibaba-rocketmq-3.1.9/alibaba-rocketmq devenv
cp ${JAVA_HOME}/jre/lib/ext/sunjce_provider.jar devenv/lib/
