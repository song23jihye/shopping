<%@page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>shopping home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        .main {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .shopping-title {
            font-size: 2.5rem;
            font-weight: bold;
        }
        .grid-container{
            display: grid;
            grid-template-columns:repeat(3,1fr);
            grid-template-rows:repeat(3,1fr);
            gap:10px;
            width:300px;
            height:300px;
            margin:auto;
            border:2px solid #000;
        }
        .grid-item{
            display:flex;
            jusify-content:center;
            align-items:center;
            border:1px solid #000;
            background-color:#f0f0f0;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="main h-100">
            <div class="shopping-title">Shopping Home</div>
            <form action="/user/auth" method="post">
                <%-- controller에 map해둠 user/auth, PostMapping으로 받음--%>
                <div class="row justify-content-center">
                    <div class="col-20">
                        <label for="username">아이디</label>
                        <input type="text" class="form-control" name="username" id="username">
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-20">
                        <label for="password">비밀번호</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                </div>
                <div class="row justify-content-center mt-5">
                    <div class="col-40 text-center">
                        <input type="submit" class="btn btn-outline-primary" value="로그인">
                    </div>
                    <div class="col-40 text-center">
                        <a href="/user/register" class="btn btn-outline-secondary">회원가입</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


