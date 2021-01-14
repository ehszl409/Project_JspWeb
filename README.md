# 뚜레쥬르 케이크 예약 / 픽업 서비스 프로젝트

## 페이지 모델화 [1/2] - 01/15 (금)

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
- model : user

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
