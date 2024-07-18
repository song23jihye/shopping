<%@page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            background-color: #f4f4f4;
        }
        .card {
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .card-title {
            color: #333;
        }
        .profile p {
            font-size: 15px;
            color: #555;
        }
        .profile strong {
            color: #333;
        }
        .actions {
            text-align: center;
            margin-top: 20px; /* 또는 mt-4로 대체 가능 */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                <h1 class="card-title text-center">마이페이지</h1>
                <div class="profile mt-4">
                    <p><strong>고객 이름 : ${logIn.nickname}</strong></p><span id="customer-name"></span>
<%--                    <p><strong>닉네임:</strong></p><span id="nickname"></span>--%>
                </div>
                <div class="actions text-center mt-4">
                    <a href="/address/${logIn.id}" class="btn btn-primary">배송지 관리</a>
                </div>
                <div class="actions text-center mt-4">
                    <a href="/basket/showBasket/${logIn.id}" class="btn btn-primary">장바구니로 가기</a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>