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
        .address-header {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .address-adder{
            font-weight: bold;
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
<div class="container main h-100">
    <div class="text-center address-header">${logIn.nickname}님의 배송지</div>
    <div class="row justify-content-center">
        <div class="col-8">
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>자치도</th>
                        <th>시·도</th>
                        <th>번지수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${addressList}" var="address">
                        <tr>
                            <td>${address.province}</td>
                            <td>${address.city}</td>
                            <td>${address.streetNumber}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="address-adder mt-4">
                <a href="/address/newAddress/${logIn.id}" class="btn btn-primary">배송지 추가</a>
            </div>
        </div>

    </div>
</div>
</body>
</html>