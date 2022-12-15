# 💙 수강 신청 RMI 프로그램

해당 프로그램은 RMI를 기반으로 하는 수강 신청 프로그램으로,     
각각 분산되어 존재하는 서버-클라이언트-데이터 객체 간의 요청과 응답을 바탕으로 한 통신 기법이다.
<br>
<br>

## 🔎 UML Diagram
![image](https://user-images.githubusercontent.com/90022940/207894454-8c08f241-c69f-4b8f-b270-01b8e991575b.png)
<br>
<br>

## 🔎 Sequence Diagram
<details>
<summary>로그인 및 사용자 정보 암호화&복호화</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207895091-0a913561-c0eb-4e46-9bb0-2891fadf828c.png"/>
</details>
<details>
<summary>학생 및 과목 목록 조회</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207895870-f90373fb-d732-415a-8345-5b19d1581720.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207896356-ec1937a0-7694-4099-ba7c-7a049a871373.png"/>
<br>
</details>
<details>
<summary>학생 및 과목 등록</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897115-9fc85156-a203-4db5-9ddb-a0822e2d8fcd.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207897180-d20564bb-9741-437e-a78f-b4aad26517e0.png"/>
<br>
</details>
<details>
<summary>학생 및 과목 삭제</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897402-06b64fc9-471a-4b5d-aaaf-7038ab6be065.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207897454-a9609a8d-9b20-4f0d-b2e0-cb234a79f376.png"/>
<br>
</details>
<details>
<summary>수강 신청</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897693-c70a5230-374b-4d7e-aea2-f4098df56a2b.png"/>
<br>
</details>
<details>
<summary>수강 신청 목록 조회</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897888-ab4e73d9-03bc-4be7-8862-4f3b9aea0a24.png"/>
<br>
</details>
<details>
<summary>로깅 및 예외처리</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207898413-57ca3e7d-e16a-4bcd-9ab1-f2ccdce6c424.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207898658-8d5e53da-13d1-452a-b025-a80312420451.png"/>
<br>
</details>
<br>

## 🙂 Advantage

#### 1. 손쉬운 로직 변경
client → server → data → server → client, 이와 같은 형태의 3-tier 구조<br>
각 client/server/data가 독립적으로 동작하므로 손쉬운 로직 변경이 가능하다.

#### 2. 분업 최적화 및 업무 효율 증가 
3-tier 구조를 가지기 때문에, client/server/database를 각각 담당하도록 분업하기 유리하며, 이에 업무 효율도 증가할 수 있다.

#### 3. 명확한 디버깅
client, server, data에 각 요청에 따른 에러 확인을 수행해 client에게 전달할 수 있기 때문에 보다 명확한 디버깅이 가능하다.

