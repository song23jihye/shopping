<%@page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>show customer's basket</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .main{
            padding-top: 50px;
        }
        .basket-header {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .total-price-row {
            font-weight: bold;
            background-color: #f8f9fa;
        }
        .btn-custom-black {
            color: #000; /* 텍스트 색상 */
            border-color: #000; /* 테두리 색상 */
        }
        .btn-custom-black:hover {
            color: #fff; /* 호버 시 텍스트 색상 */
            background-color: #000; /* 호버 시 배경색 */
        }
        .btn-delete {
            color: #dc3545; /* 빨간색 */
            border-color: #dc3545; /* 테두리 색상 */
        }
        .btn-delete:hover {
            color: #fff; /* 호버 시 텍스트 색상 */
            background-color: #dc3545; /* 호버 시 배경색 */
        }
    </style>
</head>
<body>
<div class="container main h-100">
    <div class="text-center basket-header">${logIn.nickname}님의 Basket</div>
    <div class="row justify-content-center">
        <div class="col-8">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>상품 이름</th>
                        <th>상품 개수</th>
                        <th>상품 가격</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="totalPrice" value="0"/>
                    <c:forEach items="${goodsInBasket}" var="goods">
                        <tr>
                            <td>${goods.goodsName}</td>
                            <td>${goods.goodsCount}</td>
                            <td>${goods.goodsPrice}</td>
                            <c:set var="itemTotalPrice" value="${goods.goodsCount*goods.goodsPrice}"/>
                        </tr>
                        <c:set var="totalPrice" value="${totalPrice + itemTotalPrice}" />
                    </c:forEach>
                    <tr class="total-price-row">
                        <td colspan="2">총액</td>
                        <td>${totalPrice}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-auto">
            <a href="/product/showAll" class="btn btn-custom-black mx-2">상품 목록으로 돌아가기</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>