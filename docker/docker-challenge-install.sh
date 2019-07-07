#!/bin/bash

docker build -t jenkins_challenge:v1 jenkins/ --no-cache
docker-compose up -d
