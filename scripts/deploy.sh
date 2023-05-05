#!/bin/bash

cd /home/ec2-user/app

DOCKER_APP_NAME=spring


# 실행중인 blue가 있는지 확인
EXIST_BLUE=$(sudo docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml ps | grep Up)

echo "실행중인 blue 확인 완료 EXIST_BLUE = ${EXIST_BLUE}" >> /home/ec2-user/deploy.log

# green이 실행중이면 blue up
if [ -z "$EXIST_BLUE" ]; then
	echo "blue up - blue 배포 : port:8081" >> /home/ec2-user/deploy.log
	echo "if [-z EXIST_BLUE] 분기 타는 중" >> /home/ec2-user/deploy.log
	sudo docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml up -d --build

  sleep 30

  sudo docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml down
  sudo docker image prune -af # 사용하지 않는 이미지 삭제

# blue가 실행중이면 green up
else
	echo "green up - green 배포 : port:8082" >> /home/ec2-user/deploy.log
	sudo docker-compose -p ${DOCKER_APP_NAME}-green -f docker-compose.green.yml up -d --build

  sleep 30

  sudo docker-compose -p ${DOCKER_APP_NAME}-blue -f docker-compose.blue.yml down
  sudo docker image prune -af
fi