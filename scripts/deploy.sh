#!/bin/bash

echo "실행 중" >> /home/ec2-user/deploy.log

cd /home/ec2-user/app

DOCKER_APP_NAME=spring

# 실행중인 blue가 있는지 확인
EXIST_BLUE=$(docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml ps | grep running)

echo "실행중인 blue 확인 완료" >> /home/ec2-user/deploy.log

# blue가 실행중이면 green up
if [ -z "$EXIST_BLUE" ]; then
	echo "green up - green 배포 : port:8081" >> /home/ec2-user/deploy.log
	sudo docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.blue.yml up -d --build

	sleep 30

	sudo docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml down
	sudo docker image prune -af # 사용하지 않는 이미지 삭제

# green이 실행중이면 blue up
else
	echo "blue up - blue 배포 : port:8081" >> /home/ec2-user/deploy.log
	sudo docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml up -d --build

	sleep 30

	sudo docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml down
	sudo docker image prune -af
fi