<%@page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>로그인페이지</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <style>
        .main {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .page-title {
            font-size: 2.5rem;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="main h-100">
        <div class="page-title">Log in</div>
        <form action="/user/auth" method="post"> <!--form태그, input으로 인자 전달 action 경로로 전달-->
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
</body>