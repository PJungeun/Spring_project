# Spring_project

## 프로젝트 환경
* Project: Gradle - Groovy Project
* Spring Boot: 2.3.1.RELEASE
* Language: Java
* Packaging: Jar
* Java: 11


* Build and run using: Gradle IntelliJ IDEA
* Run tests using: Gradle IntelliJ IDEA

## 라이브러리
* 스프링부트
  * spring-boot-start-tomcat: 톰캣(웹서버)
  * spring-webmvc: 스프링 웹 MVC
  * spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
* 테스트
  * junit: 테스트 프레임워크
  * mockito: 목 라이브러리
    * mock: 모의, 가짜의. 테스트할 때 필요한 실제 객체와 동일한 모의 객체를 만들어 테스트의 효용성을 높이기 위해 사용
  * assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
  * spring-test: 스프링 통합 테스트 지원

<hr>

* ```static/index.html```을 올려두면 spring boot가 welcome page 기능 제공

<hr>

## 빌드하고 실행하는 방법

콘솔에서
1. ```./gradlew build```
2. ```cd build/libs```
3. ```java -jar hello-spring-0.0.1-SNAPSHOT.jar```

<hr>

### 정적 컨텐츠
웹 브라우저에서 ``locallhost:8080/hello-static.html``로 내장 톰켓 서버에 요청   
--> 스프링 컨테이너에 있는 관련 controller없이 바로 ``resources: static/hello-static.html``로 가서,
``hello-static.html``을 웹브라우저로 가져옴

### MVC
웹 브라우저에서 ``locallhost:8080/hello-mvc``로 내장 톰켓 서버에 요청   
--> 스프링 컨테이너에 있는 ``helloController``에 있는 해당 ``helloMvc``를 매핑해서 호출해주는데,
return 할 때는 이름을 ``hello-template``이라고 해주고,
model에는 ``name:입력한 스트링 값``을 넣어준다     
--> viewResovler가 ``template/hello-template.html``을 찾아서     
--> Thymeleaf 템플릿 엔진이 html로 변환한 후 웹 브라우저에 준다

### API
``@ResponseBody``를 사용하면 ``viewResovler``를 사용하지 않고 ``HTTP의 BODY``에 문자내용을 직접 반환
<br><br> 

웹 브라우저에서 ``locallhost:8080/hello-api``로 내장 톰켓 서버에 요청   
--> 스프링 컨테이너에 있는 ``helloController``에 있는 해당 ``helloApi``를 매핑해서 호출해주는데,
``@ResponseBody``가 붙어있으면 http 응답에 그대로 넘기는데 만약, 객체 오면 디폴트는 json 방식으로 데이터를 만들어서 http 응답에 반응한다     
--> ``HttpMessageConverter``가 단순문자면 'StringConverter', 객체면 'JsonConverter'가 동작해서 바꿔서 
  * 기본 문자처리: ``StringHttpMessageConverter``
  * 기본 객체처리: ``MappingJackson2HttpMessageConverter``

--> 바꾼 것을 브라우저나 서버에 보냄

