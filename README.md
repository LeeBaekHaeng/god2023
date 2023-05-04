# god2023 2023 전자정부 표준프레임워크 4.1.0

목차

1. 개발환경
2. 실행환경
3. 운영환경
4. 공통컴포넌트
5. 로컬 서버
   1. MariaDB
      1. 다운로드
      2. 설치
      3. 설정
      4. 실행
      5. 공통컴포넌트 데이터베이스/사용자 생성


## 개발환경

## 실행환경

## 운영환경

## 공통컴포넌트

## 로컬 서버

### MariaDB

MariaDB는 오픈 소스의 관계형 데이터베이스 관리 시스템이다. MySQL과 동일한 소스 코드를 기반으로 하며, GPL v2 라이선스를 따른다. 오라클 소유의 현재 불확실한 MySQL의 라이선스 상태에 반발하여 만들어졌으며, 배포자는 몬티 프로그램 AB와 저작권을 공유해야 한다.

https://mariadb.org/

#### 다운로드

https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.11.2

```
MariaDB Server Version: MariaDB Server 10.11.2

Display older releases:

Operating System: Windows

Architecture: x86_64

Package Type: ZIP file
```

mariadb-10.11.2-winx64.zip

다운로드 위치

```
C:\EGOVFRAME
```

#### 설치

설치 위치

```
C:\EGOVFRAME\mariadb-10.11.2-winx64
```

mariadb-install-db.exe 실행

```
C:\EGOVFRAME\mariadb-10.11.2-winx64\bin
```

```
mariadb-install-db.exe
```

#### 설정

```
C:\EGOVFRAME\mariadb-10.11.2-winx64\data
```

원본 백업

```
my - 복사본.ini
```

```
my.ini
```

port, character-set-server 추가

```ini
port=3306
character-set-server=utf8
```

[client] port 추가

```ini
port=3306
```

#### 실행

```
D:\EGOVFRAME2\mariadb-10.11.2-winx64\bin
```

```
mysqld.exe
```

Windows 10 액세스 허용

#### 공통컴포넌트 데이터베이스/사용자 생성

DBeaver 실행

DBeaver는 SQL 클라이언트이자 데이터베이스 관리 도구이다. 관계형 데이터베이스의 경우 JDBC API를 사용하여 JDBC 드라이버를 통해 데이터베이스와 통신한다. 그 밖의 데이터베이스의 경우 사유 데이터베이스 드라이버를 사용한다.

https://dbeaver.io/download/

DBeaver Community 23.0.3

https://dbeaver.io/files/dbeaver-ce-latest-x86_64-setup.exe

https://dbeaver.io/files/dbeaver-ce-latest-win32.win32.x86_64.zip

com 데이터베이스 생성

```
com
utf8mb3
utf8mb3_general_ci
```

```sql
CREATE DATABASE `com` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */
```

com / com01 사용자 생성

```
CREATE USER 'com'@'%' IDENTIFIED BY 'com01';
GRANT Delete ON com.* TO 'com'@'%';
GRANT Insert ON com.* TO 'com'@'%';
GRANT Select ON com.* TO 'com'@'%';
GRANT Update ON com.* TO 'com'@'%';
```

공통컴포넌트 전체 com mariadb script root 사용자로 com 데이터베이스 선택해서 실행

```
C:\EGOVFRAME\eGovFrameDev-4.1.0-64bit\workspace\god2023\god.test-com-all\script\ddl\maria\com_DDL_maria.sql
```

```
C:\EGOVFRAME\eGovFrameDev-4.1.0-64bit\workspace\god2023\god.test-com-all\script\comment\maria\egov_maria_comment.sql
```

```
C:\EGOVFRAME\eGovFrameDev-4.1.0-64bit\workspace\god2023\god.test-com-all\script\dml\maria\com_DML_maria.sql
```

