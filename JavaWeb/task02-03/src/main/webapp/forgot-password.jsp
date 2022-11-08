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
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
  <title>忘记密码 - Tabler - 具有响应式和高质量 UI 的高级和开源仪表板模板。</title>
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
    <form class="card card-md" action="." method="get">
      <div class="card-body">
        <h2 class="card-title text-center mb-4">忘记密码</h2>
        <p class="text-muted mb-4">输入您的电子邮件地址，您的密码将被重置并通过电子邮件发送给您。</p>
        <div class="mb-3">
          <label class="form-label">邮箱</label>
          <input type="email" class="form-control" placeholder="Enter email">
        </div>
        <div class="form-footer">
          <div class="form-footer">
            <a href="#" class="btn btn-primary w-100">
              <!-- Download SVG icon from http://tabler-icons.io/i/mail -->
              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><rect x="3" y="5" width="18" height="14" rx="2" /><polyline points="3 7 12 13 21 7" /></svg>
              发送新密码
            </a>
          </div>
        </div>
    </form>
    <div class="text-center text-muted mt-3">
      算了，<a href="./sign-in.jsp">让我回到</a>登录屏幕。
    </div>
  </div>
</div>
<!-- Libs JS -->
<!-- Tabler Core -->
<script src="./dist/js/tabler.min.js" defer></script>
<script src="./dist/js/demo.min.js" defer></script>
</body>
</html>