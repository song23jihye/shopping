<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>show goods list page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        .btn-custom-black {
            color: #000; /* 텍스트 색상 */
            border-color: #000; /* 테두리 색상 */
        }
        .btn-custom-black:hover {
            color: #fff; /* 호버 시 텍스트 색상 */
            background-color: #000; /* 호버 시 배경색 */
        }
    </style>
</head>
<body>
<div class="main h-100">
    <div class="Goods List">Goods List</div>
    <div class="row justify-content-center">
        <div class="col-8 text-center">
            <table class="table table-striped">
                <tr>
                    <th>상품 번호</th>
                    <th colspan="3">상품 이름</th>
                    <th>상품 가격</th>
                    <th>상품 분류</th>
                </tr>
                <c:forEach items="${goodslist}" var="g">
                    <tr onclick="javascript:location.href='/product/showOne/${g.id}'">
                        <td>${g.id}</td>
                        <td colspan="3">${g.name}</td>
                        <td>${g.price}</td>
                        <td>${g.categoryName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-auto">
            <a href="/user/mypage/${logIn.id}" class="btn btn-custom-black mx-2">마이페이지</a>
        </div>
        <div class="col-auto">
            <a href="/basket/showBasket/${logIn.id}" class="btn btn-custom-black">내 장바구니</a>
        </div>
    </div>
</div>
</body>