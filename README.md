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