# ๐ ์๊ฐ ์ ์ฒญ RMI ํ๋ก๊ทธ๋จ

ํด๋น ํ๋ก๊ทธ๋จ์ RMI๋ฅผ ๊ธฐ๋ฐ์ผ๋ก ํ๋ ์๊ฐ ์ ์ฒญ ํ๋ก๊ทธ๋จ์ผ๋ก,     
๊ฐ๊ฐ ๋ถ์ฐ๋์ด ์กด์ฌํ๋ ์๋ฒ-ํด๋ผ์ด์ธํธ-๋ฐ์ดํฐ ๊ฐ์ฒด ๊ฐ์ ์์ฒญ๊ณผ ์๋ต์ ๋ฐํ์ผ๋ก ํ ํต์  ๊ธฐ๋ฒ์ด๋ค.
<br>
<br>

## ๐ UML Diagram
![image](https://user-images.githubusercontent.com/90022940/207894454-8c08f241-c69f-4b8f-b270-01b8e991575b.png)
<br>
<br>

## ๐ Sequence Diagram
<details>
<summary>๋ก๊ทธ์ธ ๋ฐ ์ฌ์ฉ์ ์ ๋ณด ์ํธํ&๋ณตํธํ</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207895091-0a913561-c0eb-4e46-9bb0-2891fadf828c.png"/>
</details>
<details>
<summary>ํ์ ๋ฐ ๊ณผ๋ชฉ ๋ชฉ๋ก ์กฐํ</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207895870-f90373fb-d732-415a-8345-5b19d1581720.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207896356-ec1937a0-7694-4099-ba7c-7a049a871373.png"/>
<br>
</details>
<details>
<summary>ํ์ ๋ฐ ๊ณผ๋ชฉ ๋ฑ๋ก</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897115-9fc85156-a203-4db5-9ddb-a0822e2d8fcd.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207897180-d20564bb-9741-437e-a78f-b4aad26517e0.png"/>
<br>
</details>
<details>
<summary>ํ์ ๋ฐ ๊ณผ๋ชฉ ์ญ์ </summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897402-06b64fc9-471a-4b5d-aaaf-7038ab6be065.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207897454-a9609a8d-9b20-4f0d-b2e0-cb234a79f376.png"/>
<br>
</details>
<details>
<summary>์๊ฐ ์ ์ฒญ</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897693-c70a5230-374b-4d7e-aea2-f4098df56a2b.png"/>
<br>
</details>
<details>
<summary>์๊ฐ ์ ์ฒญ ๋ชฉ๋ก ์กฐํ</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207897888-ab4e73d9-03bc-4be7-8862-4f3b9aea0a24.png"/>
<br>
</details>
<details>
<summary>๋ก๊น ๋ฐ ์์ธ์ฒ๋ฆฌ</summary>
<br>
<img src="https://user-images.githubusercontent.com/90022940/207898413-57ca3e7d-e16a-4bcd-9ab1-f2ccdce6c424.png"/>
<img src="https://user-images.githubusercontent.com/90022940/207898658-8d5e53da-13d1-452a-b025-a80312420451.png"/>
<br>
</details>
<br>

## ๐ Advantage

#### 1. ์์ฌ์ด ๋ก์ง ๋ณ๊ฒฝ
client โ server โ data โ server โ client, ์ด์ ๊ฐ์ ํํ์ 3-tier ๊ตฌ์กฐ<br>
๊ฐ client/server/data๊ฐ ๋๋ฆฝ์ ์ผ๋ก ๋์ํ๋ฏ๋ก ์์ฌ์ด ๋ก์ง ๋ณ๊ฒฝ์ด ๊ฐ๋ฅํ๋ค.

#### 2. ๋ถ์ ์ต์ ํ ๋ฐ ์๋ฌด ํจ์จ ์ฆ๊ฐ 
3-tier ๊ตฌ์กฐ๋ฅผ ๊ฐ์ง๊ธฐ ๋๋ฌธ์, client/server/database๋ฅผ ๊ฐ๊ฐ ๋ด๋นํ๋๋ก ๋ถ์ํ๊ธฐ ์ ๋ฆฌํ๋ฉฐ, ์ด์ ์๋ฌด ํจ์จ๋ ์ฆ๊ฐํ  ์ ์๋ค.

#### 3. ๋ชํํ ๋๋ฒ๊น
client, server, data์ ๊ฐ ์์ฒญ์ ๋ฐ๋ฅธ ์๋ฌ ํ์ธ์ ์ํํด client์๊ฒ ์ ๋ฌํ  ์ ์๊ธฐ ๋๋ฌธ์ ๋ณด๋ค ๋ชํํ ๋๋ฒ๊น์ด ๊ฐ๋ฅํ๋ค.

