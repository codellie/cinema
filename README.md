## 1. 도메인 주제 선정
# 영화 예매

## 2. 시나리오 작성
1. 고객이 영화를 선택하여 티켓을 예매한다
2. 예매를 하면 고객에게 티켓을 전송한다
3. 예매를 하면 포인트 적립한다
4. 고객이 영화를 취소하면 티켓과 포인트 반환된다

## 3. 이벤트 스토밍






![image](https://github.com/codellie/cinema/assets/126676314/0794dd51-8052-4a95-9e87-e853c48b00d0)



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

