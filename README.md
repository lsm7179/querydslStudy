# 실전 QueryDSL! 실습

https://www.inflearn.com/course/Querydsl-%EC%8B%A4%EC%A0%84/dashboard

QueryDsl 에서 컴파일 된 Q가 붙은 객체는 git에 올리지 않는게 좋다.
시스템에서 만들어주기 때문에 로컬환경에 달라질 수 있기 때문이다.

QueryDsl 에러는 컴파일 에러가 나기 때문에 더 안전하게 사용 하능하다.   
ide에서 코드어시를 받을 수 있기 때문에 코드 짜기 수월하다.

Q클래스 인스턴스를 사용하는 2가지 방법
```
QMember qMember = new QMember("m"); //별칭 직접 지정
QMember qMember = QMember.member; //기본 인스턴스 사용
```

서브쿼리는 JPAExpressions 를 사용한다.

### jpa서브쿼리의 한계
from절의 서브쿼리 한계
jpa jpql 서브쿼리의 한계점으로 from절의 서브쿼리는 지원하지 않는다.   
당연히 Querydsl도 지원하지 않는다.      
* from절의 서브쿼리 해결방안
* 서브쿼리를 join으로 변경한다.(보통 바꿀 수 있다.)
* 애플리케이션에서 쿼리를 2번 분리해서 실행한다.
* nativeSQL을 사용한다.

sql에 쿼리기능이 많다. 쿼리가 비대해질 가능성이 높다.   
현대적인 방안으로 디비는 진짜 데이터만 푸는 용도로 끝내고   
비즈니스 로직은 애플리케이션에서 풀고   
뷰로는 프래젠테이션로직을 풀자   
한방 쿼리가 정말 좋은 것인가? 고민을 해볼 필요가 있다.      
쿼리에 대한 추천 책 [SQL AntiPatterns](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=12086993#)

### case
가급적이면 이런 문제들도 쿼리에서 안하려고 한다.   
애플리케이션에서 로직을 풀도록 하는게 좋다.

## 프로젝션
tuple을 보면 querydsl core 패키지인데   
리파지토리 계층까지 사용하는건 좋은데 서비스, 컨트롤러가 알면 안 좋다 라고 생각한다.   
튜플로 리파지토리에서만 사용하고 밖에 꺼낼때는 DTO로  변환 하여 사용하는걸 권장한다.

## 특정 조회용 만들때
새로운 클래스를 만들어서 특정 쿼리를 만들게 넣는다.   
쿼리가 복잡할때 따로 클래스를 만들어서 써도 될거같다.   
(ex: MemberQueryRepository)   
공통성이 없으면 별도의 조회용클래스로 분리하는것도 좋다.    