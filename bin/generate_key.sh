#!/bin/bash
openssl req -x509 -newkey rsa:2048 -keyout ../conf/key.pem -out ../conf/cert.pem