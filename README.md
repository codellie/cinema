
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










```

