
![image](https://github.com/codellie/sjcu-microservice-labs/assets/126676314/7eeb5d12-226a-4951-8213-c19143796f53)

마이크로서비스응용및활용 과목의 기말고사 대체용으로 마이크로서비스를 직접 구현하고 쿠버네티스에 배포/운영한 결과 리포트입니다.

# 1. 도메인 주제 선정
## 영화 예매



# 2. 시나리오 작성
1. 고객이 영화를 선택하여 티켓을 예매한다
2. 예매를 하면 고객에게 티켓을 전송한다
3. 예매를 하면 포인트 적립한다
4. 고객이 영화를 취소하면 티켓과 포인트 반환된다



# 3. 이벤트 스토밍

![image](https://github.com/codellie/cinema/assets/126676314/7ff7f7bd-f821-4bea-a665-0307527e7581)



# 4. 서비스 구현
분석/설계 단계에서 도출된 이벤트 스토밍 결과에 따라 예매 서비스와 티켓 서비스를 쿠버네티스에 각각 docker 이미지 생성 및 푸시하며 마이크로서비스를 배포하였다. 구현한 각 서비스를 로컬에서 실행하는 방법은 아래와 같다


# 5. 이미지 생성 및 푸쉬

![image](https://github.com/codellie/cinema/assets/126676314/a754df56-ea66-4440-bdcf-8e75cbbd06e6)

```
cd reserve
mvn package
docker image build -t MY-DOCKER ID/reserve:v0.1 .
docker login                    
docker push MY-DOCKER ID/reserve:v0.1

cd ticket
mvn package
docker image build -t MY-DOCKER ID/ticket:v0.1 .
docker login
docker push MY-DOCKER ID/ticket:v0.1

cd point
mvn package
docker image build -t MY-DOCKER ID/point:v0.1 .
docker login
docker push MY-DOCKER ID/point:v0.1
```




# 6. 쿠버네티스 준비

![image](https://github.com/codellie/cinema/assets/126676314/0794dd51-8052-4a95-9e87-e853c48b00d0)




# 7. 서비스 배포

![image](https://github.com/codellie/cinema/assets/126676314/9b40732e-d3c3-4ac5-8c4d-f823e8da3fdb)

```
[reserve]
cd kubernetes
kubectl apply -f deployment.yaml # 파일 내 image: MY-DOCKER ID/reserve:v0.1 로 수정
kubectl apply -f service.yaml

[ticket]
cd kubernetes
kubectl apply -f deployment.yaml # 파일 내 image: MY-DOCKER ID/ticket:v0.1 로 수정
kubectl apply -f service.yaml

[point]
cd kubernetes
kubectl apply -f deployment.yaml # 파일 내 image: MY-DOCKER ID/point:v0.1 로 수정
kubectl apply -f service.yaml
```



# Helm

![image](https://github.com/codellie/cinema/assets/126676314/22943cc0-3b8f-4661-a7d3-9a6b7290084d)


# kafka

![image](https://github.com/codellie/cinema/assets/126676314/421ba0cc-6ab5-4252-8936-0e61a77ccb76)


![image](https://github.com/codellie/cinema/assets/126676314/abc880a2-e1dc-48b8-a9b9-29ed7e190c48)


---

kafka-console-consumer.sh --bootstrap-server my-kafka:9092 --topic cinema --from-beginning

---

![image](https://github.com/codellie/cinema/assets/126676314/ec67ead1-66fb-4060-86a4-32161b647fc8)









## Model
www.msaez.io/#/storming/cinema

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- reserve
- ticket
- point


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- reserve
```
 http :8088/reserves id="id" movieName="movieName" movieId="movieId" qty="qty" customerId="customerId" amount="amount" address="address" 
```
- ticket
```
 http :8088/tickets id="id" adress="adress" customerId="customerId" status="status" movieId="movieId" 
```
- point
```
 http :8088/points id="id" stock="stock" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

