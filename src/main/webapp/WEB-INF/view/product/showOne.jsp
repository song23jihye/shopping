<%@page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-title {
            margin-top: 20px;
            margin-bottom: 20px;
            font-size: 1.8em;
            text-align: center;
        }
        .product-price {
            color: #d9534f;
            font-size: 1.5em;
            margin-bottom: 10px;
        }
        .btn-custom-black {
            color: #000; /* 텍스트 색상 */
            border-color: #000; /* 테두리 색상 */
        }
        .btn-custom-black:hover {
            color: #fff; /* 호버 시 텍스트 색상 */
            background-color: #000; /* 호버 시 배경색 */
        }
        .product-details {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <h1 class="product-title">상품명 : ${goodsDTO.name}</h1>
            </div>
        </div>
        <div class="row justify-content-center">
<%--            <div class="col-md-6 text-center">--%>
<%--                <img src="src/main/resources/static/goods_default.jpg" class="img-fluid">--%>
<%--            </div>--%>
        </div>
        <div class="row justify-content-center product-details">
            <div class="col-md-6 text-center">
                <p class="product-price">가격 : ${goodsDTO.price}</p>
                <p class="product-price">카테고리 : ${goodsDTO.categoryName}</p>
                <a href="/basket/putItem/${goodsDTO.id}" class="btn btn-custom-black" onClick="alert('장바구니에 추가되었습니다.')">장바구니에 담기</a>
                <a href="/basket/showBasket/${logIn.id}" class="btn btn-custom-black">내 장바구니</a>
                <a href="/product/showAll" class="btn btn-custom-black">상품 더보기</a>
            </div>
        </div>
        <div>
            <table class="table table-light table-sm">
                <tr class="text-center">
                    <td colspan="6">후기</td>
                </tr>
                <tr colspan="10">
                    <th>댓글 번호</th>
                    <th>작성자</th>
                    <th>내용</th>
                    <th>수정일</th>
                </tr>
                <c:forEach items="${replylist}" var="reply">
                    <tr>
                        <td>${reply.id}</td>
                        <td>${reply.writerNickname}</td>
                        <td>${reply.content}</td>
                        <td>
                            <span>
                                <fmt:formatDate value="${reply.modifyDate}" pattern="y년M월d일"/>
                            </span>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <form action="/reply/insert/${goodsDTO.id}" method="post">
                        <td>
                            <input type="text" name="content" class="form-control" placeholder="댓글">
                        </td>
                        <td>
                            <input type="submit" class="btn btn-outline-success" value="댓글작성">
                        </td>
                    </form>
                </tr>
            </table>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>