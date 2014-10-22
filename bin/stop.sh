#!/bin/sh
for pid in `jps|awk '{if ($2 != "Jps") print $1}'`
do
   kill -15 ${pid}
done

