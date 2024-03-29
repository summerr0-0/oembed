# READ ME



## 내용

URL을 입력받는 폼을 만들고 확인 버튼을 누르면 해당 URL에 대한 oembed 정보를 출력하고 html값과 thumbnail_url은 미리보기로 보여줍니다.



## 사용기술

- java 11

- Spring Boot 2.7

- thymeleaf

- feign client

- Oembed





## 기능 설명
- 어플리케이션을 실행후 http://localhost:8080/ 에 접속합니다

- 화면에서 테스트용 url을 입력합니다
  - https://www.youtube.com/oembed?url=https://www.youtube.com/watch?v=dBD54EZIrZo&format=json
  - https://vimeo.com/api/oembed.json?url=https://vimeo.com/20097015
  - https://publish.twitter.com/oembed?url=https://twitter.com/hellopolicy/status/867177144815804416
  - 혹은 하단에 테스트용 링크 클릭

![image](https://user-images.githubusercontent.com/120109736/227863691-c6c61d69-34b1-462e-8831-5c5a9c5871f6.png)

- **oembed 정보와 html / thumbnail은 미리보기로 보여줍니다**

  - vimeo

    - 미리보기![image](https://user-images.githubusercontent.com/120109736/227872889-e64892ff-78da-45ff-be2b-9aba694a0db4.png)

      

      - 썸네일![image](https://user-images.githubusercontent.com/120109736/227872933-5a3c6d9f-fd43-4bd2-be1d-bc4855359149.png)

  - Twitter

    - 트위터 미리보기

      ![image](https://user-images.githubusercontent.com/120109736/227874076-bdc17c94-d5cb-4434-9abb-6cdf0c83dab2.png)

  - Youtube

    - 유튜브 미리보기

      ![image](https://user-images.githubusercontent.com/120109736/227873741-21cb1b16-dc8e-43f7-857e-5cb85d72665d.png)

    - 유튜브 썸네일

      ![image](https://user-images.githubusercontent.com/120109736/227873907-5c6be39a-9c11-4186-9c20-df8e40bd6189.png)

- **만약 잘못된 url을 입력하면 error페이지로 이동합니다**
  - ![image](https://user-images.githubusercontent.com/120109736/227874494-d50b9145-2d28-46cc-9872-231438c22917.png)
  - ![image](https://user-images.githubusercontent.com/120109736/227874620-8b04e7bb-2525-4ebb-8490-533ba6e7718e.png)





- **instagram oEmbed 기능을 사용할 수 없었던 이유**

  ![image](https://user-images.githubusercontent.com/120109736/227864112-1434b4fa-7331-422c-8612-8fd485893c86.png)

  - instagram/Facebook은 정책변경으로 인해 인증된 사용자만 API를 사용할 수 있도록 변경되었습니다.
    - 개발자 계정 가입 후 앱을 등록해야 하는 절차가 필요합니다.
  - **앱 승인을 받기 어려운 환경이라 instagram oEmbed 기능을 사용할 수 없었습니다**



## 구조
![image](https://user-images.githubusercontent.com/120109736/228434088-e6a6d077-4e42-4d1a-85ef-f58f33e2cb97.png)
![oembed](https://user-images.githubusercontent.com/120109736/228433665-ea865147-6a02-4c5b-a3cd-745374d2c715.png)
- CallClientService 인터페이스, FormatService 인터페이스로 기능이 아닌 역할에 의존할 수 있도록 하였습니다.
- 테스트코드로 기능개발에 확신을 가질 수 있도록 작업하였습니다.

