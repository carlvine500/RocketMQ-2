#!/bin/sh

function stop() {
    if [ $# > 1 ]; then
        kill -15 $1;
    else
        for pid in `jps|awk '{if ($2 != "Jps") print $1}'`
        do
           kill -15 ${pid}
        done
    fi
}

stop $@;