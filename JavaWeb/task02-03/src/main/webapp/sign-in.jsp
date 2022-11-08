<!doctype html>
<!--
* Tabler - Premium and Open Source dashboard template with responsive and high quality UI.
* @version 1.0.0-beta11
* @link https://tabler.io
* Copyright 2018-2022 The Tabler Authors
* Copyright 2018-2022 codecalm.net Paweł Kuna
* Licensed under MIT (https://github.com/tabler/tabler/blob/master/LICENSE)
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String baseUrl="";
  baseUrl=request.getContextPath();
%>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>登录 - Tabler - 具有响应式和高质量 UI 的高级和开源仪表板模板。</title>
  <!-- CSS files -->
  <link href="./dist/css/tabler.min.css" rel="stylesheet"/>
  <link href="./dist/css/tabler-flags.min.css" rel="stylesheet"/>
  <link href="./dist/css/tabler-payments.min.css" rel="stylesheet"/>
  <link href="./dist/css/tabler-vendors.min.css" rel="stylesheet"/>
  <link href="./dist/css/demo.min.css" rel="stylesheet"/>
</head>
<body  class=" border-top-wide border-primary d-flex flex-column">
<div class="page page-center">
  <div class="container-tight py-4">
    <div class="text-center mb-4">
      <a href="." class="navbar-brand navbar-brand-autodark"><img src="./static/logo.svg" height="36" alt=""></a>
    </div>
      <form class="card card-md" method="post" action="<%=baseUrl%>/login"
          autocomplete="off">
      <div class="card-body">
        <h2 class="card-title text-center mb-4">请输入你的用户名和密码登录</h2>
        <div class="mb-3">
          <label class="form-label">用户名</label>
          <input id="userName" name="userName" type="userName" class="form-control" placeholder="请输入用户名"
                 autocomplete="off" value="admin">
        </div>
        <div class="mb-2">
          <label class="form-label">
            密码
            <span class="form-label-description">
<a href="./forgot-password.jsp">找回密码</a>
</span>
          </label>
          <div class="input-group input-group-flat">
            <input id="password" type="password" name="password" class="form-control" placeholder="请输入密码" autocomplete="off" value="123456">
            <span class="input-group-text">
                <a href="#" class="link-secondary" title="Show password" databs- toggle="tooltip"><!-- Download SVG icon from http://tabler-icons.io/i/eye -->
                <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" strokelinejoin="
                round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><circle cx="12" cy="12" r="2" /><path d="M22 12c-2.667 4.667 -6 7 -10 7s-7.333 -2.333
                -10 -7c2.667 -4.667 6 -7 10 -7s7.333 2.333 10 7" /></svg>
                </a>
            </span>
          </div>
        </div>
        <div class="mb-2">
          <label class="form-check">
            <input type="checkbox" name="remember" class="form-check-input"/>
            <span class="form-check-label">记住我</span>
          </label>
        </div>
        <div class="form-footer">
          <button type="submit" class="btn btn-primary w-100">登 录</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!-- Libs JS -->
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
<!-- Tabler Core -->
<script src="./dist/js/tabler.min.js" defer></script>
<script src="./dist/js/demo.min.js" defer></script>
<script>
    $(document).ready(function (){
        $("button").click(function (){
            var userName=$("#userName").val();
            var password=$("#password").val();
            $.post("<%=baseUrl%>/login",{
                userName:userName,
                password:password
            },function (data){
                if(data==="1"){
                    console.log("允许你")
                    window.location.href="<%=baseUrl%>/admin/user-list.jsp";
                }
                else{
                    alert("用户名或密码错误");
                }
            });
        });
    });
</script>
</body>
</html>