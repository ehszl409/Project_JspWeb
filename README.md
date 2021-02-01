# 뚜레쥬르 케이크 예약 / 픽업 서비스 프로젝트

## 페이지 모델화  - 01/15 (금)

### 1. 핵심 서비스 / 페이지 구성

  - 핵심 서비스
    1. 회원가입 (도로명 주소 API) (아임 포트 본인 인증 API)
    2. 로그인 (자동 로그인 방지- 네이버 캡차 API),(네이버 소셜 로그인 API)
    3. 제품 목록 보기 (제품 나열 기능)
    4. 장바구니 보기
    5. 픽업 가능 매장 검색 (네이버 Maps API)
    6. 결제 (아임포트 API)

  - 페이지 구성 (총 7~8페이지)
    1. 메인 페이지
    2. 제품 목록 페이지
    3. 제품 상세 페이지
    4. 회원가입 페이지
    5. 로그인 페이지
    6. 장바구니 페이지
    7. 결제 페이지
    8. 픽업 가능 매장 검색 페이지 OR 팝업 



### 2. 각 페이지별 DB모델화 구상

#### 1. 메인페이지
![메인페이지](https://user-images.githubusercontent.com/73862305/104624530-0a8e7e00-56d7-11eb-8028-37c13c2f70b7.png)
- HEADER가 존재 하며, 메인 사진으로 구상 
- Model : image(사용된 사진 정보)

#### 2. 제품 목록 페이지
![제품목록페이지](https://user-images.githubusercontent.com/73862305/104626079-d0be7700-56d8-11eb-8252-1c26bef0c70a.png)
- 제품 목록이 나열되어 있습니다.
- model : board(목록 정보) 

#### 3. 제품 상세 페이지
![상세페이지](https://user-images.githubusercontent.com/73862305/104626075-d025e080-56d8-11eb-9420-6fc2f3f8ae4e.png)
- 제품의 상세 보기 페이지 입니다.
- 제품의 상세보기 내용과 구매하거나 장바구니에 담기 버튼이 있습니다.
- model : item(제품 정보)

#### 4. 회원 가입 페이지
![회원가입페이지](https://user-images.githubusercontent.com/73862305/104629466-e635a000-56dc-11eb-805b-e8d2d2d1efd7.png)
- 회원 가입을 위한 페이지 입니다.
- 아임 포트 본인 인증 API를 사용 합니다.
- model : user(유저 정보)

#### 5. 로그인 페이지
![로그인화면](https://user-images.githubusercontent.com/73862305/104626069-cef4b380-56d8-11eb-84ca-ac3d5f3a6fc7.png)
- 로그인을 할 수 있는 페이지 입니다.
- 네이버 자동 로그인 방지 캡차 API와 네이버 소셜 로그인 API를 사용 합니다.
- model : user(유저 정보)

#### 6. 장바구니 페이지
![장바구니페이지](https://user-images.githubusercontent.com/73862305/104626076-d025e080-56d8-11eb-851b-2b50004d7839.png)
- 아이템이 담긴 리스트를 볼 수 있습니다.
- model : cart(장바구니 정보)

#### 7. 결제 페이지
![결제페이지](https://user-images.githubusercontent.com/73862305/104626065-ce5c1d00-56d8-11eb-9b62-4005dffeb06e.png)
- 장바구니에 담긴 아이템을 결제 하는 페이지 입니다.
- 배달 서비스는 없으니 지점에 예약을 해야지 결제가 가능 합니다.
- model : orderInfo(주문 정보), orderDetail(주문 상세 정보),  payInfo(결제 정보), Reservation(예약 정보)

#### 8. 픽업 가능 매장 검색 페이지 or 팝업 창
![픽업API](https://user-images.githubusercontent.com/73862305/104626082-d1570d80-56d8-11eb-8307-b57afa5c8dd6.png)
- 결제할 때 아이템을 받아가기 위한 매장을 검색하고 정하는 페이지 or 팝업창 입니다.
- 페이지가 이동시 결제창에 입력 한 정보가 모두 사라지면 안됩니다. (불가능 하거나 번거로우면 팝업 창으로 구현)
- model : store(픽업 가능 매장 정보)


## 기본 디자인 완성 - 01/25 (월)

  - 페이지 구성
	1. 메인 페이지
	2. 제품 목록 페이지
	3. 제품 상세 페이지
	4. 회원가입 페이지
	5. 로그인 페이지
	6. 장바구니 페이지
	7. 결제 페이지
	8. 마이페이지
	
#### 1. 메인 페이지
![01 메인페이지](https://user-images.githubusercontent.com/73862305/105737048-cfaf0480-5f78-11eb-8ec7-a0f40e8528bc.png)

#### 2. 제품 목록 페이지
![02 목록페이지](https://user-images.githubusercontent.com/73862305/105737024-cb82e700-5f78-11eb-97bf-4a15c7ece495.png)

#### 3. 제품 상세 페이지
![05 상세보기페이지](https://user-images.githubusercontent.com/73862305/105737036-cde54100-5f78-11eb-943f-65510f196825.png)

#### 4. 회원가입 페이지
![04 회원가입페이지](https://user-images.githubusercontent.com/73862305/105737033-cde54100-5f78-11eb-9927-f219a9f504c0.png)

#### 5. 로그인 페이지
![03 로그인페이지](https://user-images.githubusercontent.com/73862305/105737030-cd4caa80-5f78-11eb-87ef-4b3993d9a771.png)

#### 6. 장바구니 페이지
![06 장바구니페이지](https://user-images.githubusercontent.com/73862305/105737039-ce7dd780-5f78-11eb-8a09-e3b26a9066c0.png)

#### 7. 결제 페이지
![07 결제하기페이지](https://user-images.githubusercontent.com/73862305/105737044-ce7dd780-5f78-11eb-8bd1-a231b9f8fa4b.png)

#### 8. 마이페이지
![08 마이페이지](https://user-images.githubusercontent.com/73862305/105737046-cf166e00-5f78-11eb-8214-b7a3417366dc.png)

## user DB 구체화 및 로그인 회원가입 구현 - 01/26(화)

#### 1. user DB
```mysql
	CREATE TABLE user(
	id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    address varchar(100),
    createDate timestamp
)engine=InnoDB default charset=utf8;
```

#### 2. 회원가입 구현
![회원가입장면](https://user-images.githubusercontent.com/73862305/105882404-f63c7080-6048-11eb-99ad-b3bef3ebea43.gif)

![01  회원가입구현DB](https://user-images.githubusercontent.com/73862305/105882600-300d7700-6049-11eb-8c06-0f55738713f8.png)


#### 3. 로그인 구현 
![로그인](https://user-images.githubusercontent.com/73862305/105755567-cfb9ff00-5f8e-11eb-9c02-6b9894506a03.gif)

## item DB, image DB 및 제품목록과 상세보기 구현 - 01/26(화)

#### 1. image DB
```mysql
	CREATE TABLE image(
	 id int primary key auto_increment,
   	 imagename varchar(100) not null unique,
    	 image mediumblob not null,
    	 createDate timestamp
	)engine=InnoDB default charset=utf8;
```

#### 2. item DB
```mysql
	CREATE TABLE item(
	 id int primary key auto_increment,
    	 imageId int,
   	 itemname varchar(100) not null,
   	 price int,
   	 content longtext,
   	 subcontent varchar(100),
   	 make varchar(100),
  	 sellByDate varchar(100),
   	 calorie varchar(100),
   	 material varchar(100),
  	 createDate timestamp,
   	 foreign key (imageId) references image (id)
	)engine=InnoDB default charset=utf8;
```

#### 3. 제품목록 및 상세보기
![제품목록및상세보기](https://user-images.githubusercontent.com/73862305/105888017-c2b11480-604f-11eb-932a-6d485b879a27.gif)
	
## cart DB 장바구니 구현 - 01/27(수)

#### 1. cart DB
```mysql
	create table cart(
	 id int primary key auto_increment,
	 userId int not null,
	 itemId int not null,
	 totalPrice int,
	 createDate timestamp,
	 foreign key (userId) references user (id),
	 foreign key (itemId) references item (id)
	)engine=InnoDB default charset=utf8;
```

#### 2. 장바구니 구현
![장바구니구현](https://user-images.githubusercontent.com/73862305/106025489-21d45f00-610c-11eb-8f98-e516368b0b2c.gif)
- 장바구니 추가는 ajax통신으로 구현했습니다.
- 장바구니에 중복된 제품은 userId와 itemId를 통해 select된 값이 있으면 return되는 값을 달리하여 구현했습니다.
- 장바구니 목록은 로그인된 userId 값을 기준으로 데이터를 뿌렸습니다.
- 장바구니 삭제는 ajax통신으로 구현했습니다.
- 장바구니 삭제는 itemId와 userId로 select된 값을 Delete했습니다.
- 장바구니 총 금액은 userId로 inner join 된 테이블을 select하고 sum(price)를 통해 찾았습니다.

#### 2-1. 장바구니 목록 찾기 쿼리
```mysql
	select c.id, c.userId, c.itemId, z.itemname, z.price, z.make, z.calorie, z.sellByDate, z.material, z.image from
	cart c inner join 
	(select i.id, i.itemname, i.price, i.make, i.calorie, i.sellByDate, i.material, m.image from
	item i inner join image m 
	on i.imageId = m.id) as z
	on c.itemId = z.id
	where c.userId = ?;
```
- 두번의 inner join을 사용했습니다.

#### 2-2. 장바구니 총 금액 찾기 쿼리
```mysql
	SELECT sum(price) FROM 
	cart c inner join item i 
	on c.itemId = i.id
	WHERE c.userId = 2;
```

## 주문 페이지와 결제 하기 구현 - 01/29(금)

#### 1. 주문 페이지
![주문페이지](https://user-images.githubusercontent.com/73862305/106312769-888f7f00-62aa-11eb-9f02-dcdb3e792d7b.gif)
 - 주문 페이지는 장바구니 페이지 에서 데이터를 넘겨 받으면 더 이상 장바구니의 간섭을 받으면 안됩니다.
 - 주문 페이지는 결제 페이지와 별도의 DB와 컨트롤러 서비스 DAO를 가지도록 했습니다.
 - 장바구니에서 다수의 제품을 주문 DB에 넣을 땐 INSERT SELECT 문을 사용했습니다.
	
#### 1-1. orderInfo DB
```mysql
	create table orderInfo(
	  id int primary key auto_increment,
	  userId int not null, 
  	  itemId int not null,
  	  createDate timestamp,
  	  foreign key (userId) references user (id)
	)engine=InnoDB default charset=utf8;
```
	
#### 2. 결제 하기
![결재하기](https://user-images.githubusercontent.com/73862305/106312773-8af1d900-62aa-11eb-838e-c9a22452449e.gif)
 - 결제하기는 아임포트 API를 통해서 구현했습니다.
 - 결제하기에서 "Uncaught SyntaxError: missing ) after argument list" 라는 이슈가 발생했는데 자바스트크립트와 HTML과의 매개인자를 주고 받는 과정에서 생긴 이슈 입니다.
 - 해당 이슈는 매개인자를 넘겨줄때 문자열로 인식을 못해서 발생하는 이슈로 해당 매개인자를 ' ' 작은 따옴표로 감싸줘야 합니다.
 - 아임포트에서 결제가 성공하면 ajax통신을 통해 결제 정보를 컨트롤러로 넘겨 줬습니다.
 - 결제가 완료된 후 ajax응답을 통해 결제 완료 페이지로 이동해 방금 결제한 내역을 보여 지도록 했습니다.
 - 과거 결제 내역과 구분을 두기 위해 아임포트에서 결제 성공시 부여되는 고유 ID와 사용자 ID를 통해서 DB를 조회 했습니다.

#### 2-1. pay DB
```mysql
	create table pay(
	  id int primary key auto_increment,
	  userId int,
  	  payName varchar(100),
   	  payAmount varchar(100),
    	  buyer_email varchar(100),
   	  buyer_name varchar (100),
  	  buyer_tel varchar(100),
   	  buyer_addr varchar(100),
   	  pay_method varchar(100),
   	  merchant_uid varchar(100),
   	  pg_tid varchar(100),
  	  imp_uid varchar(100),
  	  paid_at varchar(100),
  	  pickup varchar(100),
   	  message longtext,
   	  createDate timestamp,
   	  foreign key (userId) references user (id)
	)engine=InnoDB default charset=utf8;
```

## 카카오맵 API연동 및 마이페이지 구현 - 01/31(일)

#### 1. 카카오맵 API
![카카오맵연동하기](https://user-images.githubusercontent.com/73862305/106489000-a0a80e00-64f7-11eb-9a71-5266d90a80db.gif)
 - 카카오 맵 API를 통해 검색된 매장 지점을 클릭하면 매장 정보를 추출합니다
 - 추출한 매장 정보를 AJAX 통신으로 DOM을 만들어 줍니다.
 - 지도의 다른 마커를 클릭하면 AJAX통신으로 동적으로 매장 정보를 담은 DOM이 바뀝니다.
 - 사용자가 클릭할 떄 마다 DB에 매장 정보가 저장되고 마지막에 클릭한 매장을 선택한 매장으로 정합니다.

#### 1-1. Store DB
 ```mysql
	create table store(
	 id int primary key auto_increment,
	 userId int not null,
	 name varchar(100),
	 roadAddress varchar(100),
	 address varchar(100),
	 phone varchar(100),
	 createDate timestamp,
	 foreign key (userId) references user (id)
	)engine=InnoDB default charset=utf8;
```
	
#### 2. 마이페이지
![마이페이지](https://user-images.githubusercontent.com/73862305/106489004-a271d180-64f7-11eb-80aa-0ac203ae21d1.gif)
 - 유저 정보, 결제 정보, 매장 정보를 보여주는 마이페이지 입니다.
 - 결제 건에 대한 아이템 정보는 완성하지 못했습니다.
 


