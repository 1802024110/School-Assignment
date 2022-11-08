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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Dashboard-Tabler-Premium和开放源码的Dashboard模板具有响应迅速和高质量的UI。</title>
    <!-- CSS files -->
    <link href="./dist/css/tabler.min.css" rel="stylesheet">
    <link href="./dist/css/tabler-flags.min.css" rel="stylesheet">
    <link href="./dist/css/tabler-payments.min.css" rel="stylesheet">
    <link href="./dist/css/tabler-vendors.min.css" rel="stylesheet">
    <link href="./dist/css/demo.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="page">
      <aside class="navbar navbar-vertical navbar-expand-lg navbar-transparent">
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu">
            <span class="navbar-toggler-icon"></span>
          </button>
          <h1 class="navbar-brand navbar-brand-autodark">
            <a href=".">
              <img src="../static/logo.svg" width="110" height="32" alt="压片机" class="navbar-brand-image">
            </a>
          </h1>
          <div class="navbar-nav flex-row d-lg-none">
            <div class="nav-item d-none d-lg-flex me-3">
              <div class="btn-list">
                <a href="https://github.com/tabler/tabler" class="btn" target="_blank" rel="noreferrer">
                  <!-- Download SVG icon from http://tabler-icons.io/i/brand-github -->
                  <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M9 19c-4.3 1.4 -4.3 -2.5 -6 -3m12 5v-3.5c0 -1 .1 -1.4 -.5 -2c2.8 -.3 5.5 -1.4 5.5 -6a4.6 4.6 0 0 0 -1.3 -3.2a4.2 4.2 0 0 0 -.1 -3.2s-1.1 -.3 -3.5 1.3a12.3 12.3 0 0 0 -6.2 0c-2.4 -1.6 -3.5 -1.3 -3.5 -1.3a4.2 4.2 0 0 0 -.1 3.2a4.6 4.6 0 0 0 -1.3 3.2c0 4.6 2.7 5.7 5.5 6c-.6 .6 -.6 1.2 -.5 2v3.5"></path></svg>源代码</a>
                <a href="https://github.com/sponsors/codecalm" class="btn" target="_blank" rel="noreferrer">
                  <!-- Download SVG icon from http://tabler-icons.io/i/heart -->
                  <svg xmlns="http://www.w3.org/2000/svg" class="icon text-pink" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M19.5 12.572l-7.5 7.428l-7.5 -7.428m0 0a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572"></path></svg>赞助商</a>
              </div>
            </div>
            <div class="d-none d-lg-flex">
              <a href="?theme=dark" class="nav-link px-0 hide-theme-dark" title="Enable dark mode" data-bs-toggle="tooltip" data-bs-placement="bottom">
                <!-- Download SVG icon from http://tabler-icons.io/i/moon -->
                <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 3c.132 0 .263 0 .393 0a7.5 7.5 0 0 0 7.92 12.446a9 9 0 1 1 -8.313 -12.454z"></path></svg>
              </a>
              <a href="?theme=light" class="nav-link px-0 hide-theme-light" title="Enable light mode" data-bs-toggle="tooltip" data-bs-placement="bottom">
                <!-- Download SVG icon from http://tabler-icons.io/i/sun -->
                <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="4"></circle><path d="M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7"></path></svg>
              </a>
              <div class="nav-item dropdown d-none d-md-flex me-3">
                <a href="#" class="nav-link px-0" data-bs-toggle="dropdown" tabindex="-1" aria-label="Show notifications">
                  <!-- Download SVG icon from http://tabler-icons.io/i/bell -->
                  <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 5a2 2 0 0 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6"></path><path d="M9 17v1a3 3 0 0 0 6 0v-1"></path></svg>
                  <span class="badge bg-red"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-end dropdown-menu-card">
                  <div class="card">
                    <div class="card-header">
                      <h3 class="card-title">上次更新</h3>
                    </div>
                    <div class="list-group list-group-flush list-group-hoverable">
                      <div class="list-group-item">
                        <div class="row align-items-center">
                          <div class="col-auto"><span class="status-dot status-dot-animated bg-red d-block"></span></div>
                          <div class="col text-truncate">
                            <a href="#" class="text-body d-block">例1</a>
                            <div class="d-block text-muted text-truncate mt-n1">将不推荐使用的html标记更改为文本装饰类(#29604)</div>
                          </div>
                          <div class="col-auto">
                            <a href="#" class="list-group-item-actions">
                              <!-- Download SVG icon from http://tabler-icons.io/i/star -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon text-muted" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z"></path></svg>
                            </a>
                          </div>
                        </div>
                      </div>
                      <div class="list-group-item">
                        <div class="row align-items-center">
                          <div class="col-auto"><span class="status-dot d-block"></span></div>
                          <div class="col text-truncate">
                            <a href="#" class="text-body d-block">例2</a>
                            <div class="d-block text-muted text-truncate mt-n1">justify-content：between：justify-content：space-between(#29734)</div>
                          </div>
                          <div class="col-auto">
                            <a href="#" class="list-group-item-actions show">
                              <!-- Download SVG icon from http://tabler-icons.io/i/star -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon text-yellow" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z"></path></svg>
                            </a>
                          </div>
                        </div>
                      </div>
                      <div class="list-group-item">
                        <div class="row align-items-center">
                          <div class="col-auto"><span class="status-dot d-block"></span></div>
                          <div class="col text-truncate">
                            <a href="#" class="text-body d-block">例3</a>
                            <div class="d-block text-muted text-truncate mt-n1">更新change-version.js(#29736)</div>
                          </div>
                          <div class="col-auto">
                            <a href="#" class="list-group-item-actions">
                              <!-- Download SVG icon from http://tabler-icons.io/i/star -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon text-muted" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z"></path></svg>
                            </a>
                          </div>
                        </div>
                      </div>
                      <div class="list-group-item">
                        <div class="row align-items-center">
                          <div class="col-auto"><span class="status-dot status-dot-animated bg-green d-block"></span></div>
                          <div class="col text-truncate">
                            <a href="#" class="text-body d-block">例4</a>
                            <div class="d-block text-muted text-truncate mt-n1">重新生成包-lock.json(#29730)</div>
                          </div>
                          <div class="col-auto">
                            <a href="#" class="list-group-item-actions">
                              <!-- Download SVG icon from http://tabler-icons.io/i/star -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon text-muted" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z"></path></svg>
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="nav-item dropdown">
              <a href="#" class="nav-link d-flex lh-1 text-reset p-0" data-bs-toggle="dropdown" aria-label="Open user menu">
                <span class="avatar avatar-sm" style="background-image: url(./static/avatars/000m.jpg)"></span>
                <div class="d-none d-xl-block ps-2">
                  <div>帕韦乌库纳</div>
                  <div class="mt-1 small text-muted">UI设计器</div>
                </div>
              </a>
              <div class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                <a href="#" class="dropdown-item">设置状态</a>
                <a href="#" class="dropdown-item">配置文件和帐户</a>
                <a href="#" class="dropdown-item">反馈</a>
                <div class="dropdown-divider"></div>
                <a href="#" class="dropdown-item">设置</a>
                <a href="#" class="dropdown-item">退出</a>
              </div>
            </div>
          </div>
          <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="navbar-nav pt-lg-3">
              <li class="nav-item">
                <a class="nav-link" href="../index.html">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/home -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="5 12 3 12 12 3 21 12 19 12"></polyline><path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7"></path><path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6"></path></svg>
                  </span>
                  <span class="nav-link-title">首页</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#navbar-base" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/package -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="12 3 20 7.5 20 16.5 12 21 4 16.5 4 7.5 12 3"></polyline><line x1="12" y1="12" x2="20" y2="7.5"></line><line x1="12" y1="12" x2="12" y2="21"></line><line x1="12" y1="12" x2="4" y2="7.5"></line><line x1="16" y1="5.25" x2="8" y2="9.75"></line></svg>
                  </span>
                  <span class="nav-link-title">界面</span>
                </a>
                <div class="dropdown-menu">
                  <div class="dropdown-menu-columns">
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../empty.html">空页</a>
                      <a class="dropdown-item" href="../accordion.html">手风琴</a>
                      <a class="dropdown-item" href="../blank.html">空白页</a>
                      <a class="dropdown-item" href="../buttons.html">按钮</a>
                      <div class="dropend">
                        <a class="dropdown-item dropdown-toggle" href="#sidebar-cards" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">卡片<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                        </a>
                        <div class="dropdown-menu">
                          <a href="../cards.html" class="dropdown-item">样卡</a>
                          <a href="../card-actions.html" class="dropdown-item">卡片动作<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                          </a>
                          <a href="../cards-masonry.html" class="dropdown-item">卡片砌筑</a>
                        </div>
                      </div>
                      <a class="dropdown-item" href="../colors.html">颜色</a>
                      <a class="dropdown-item" href="../datagrid.html">数据网格<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../datatables.html">DataTables<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../dropdowns.html">下拉</a>
                      <a class="dropdown-item" href="../modals.html">情态动词</a>
                      <a class="dropdown-item" href="../maps.html">地图</a>
                      <a class="dropdown-item" href="../map-fullsize.html">地图全尺寸</a>
                      <a class="dropdown-item" href="../maps-vector.html">矢量地图<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../navigation.html">导航</a>
                      <a class="dropdown-item" href="../charts.html">Charts 表格</a>
                    </div>
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../pagination.html">
                        <!-- Download SVG icon from http://tabler-icons.io/i/pie-chart -->分页</a>
                      <a class="dropdown-item" href="../placeholder.html">占位符</a>
                      <a class="dropdown-item" href="../tabs.html">标签页</a>
                      <a class="dropdown-item" href="../tables.html">表</a>
                      <a class="dropdown-item" href="../carousel.html">旋转木马<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../lists.html">列表</a>
                      <a class="dropdown-item" href="../typography.html">Typography 印刷宣传材料</a>
                      <a class="dropdown-item" href="../offcanvas.html">offcanvas</a>
                      <a class="dropdown-item" href="../markdown.html">降价</a>
                      <a class="dropdown-item" href="../dropzone.html">滴带<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../lightbox.html">灯箱<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../tinymce.html">蒂尼姆采<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../inline-player.html">内联播放器<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <div class="dropend">
                        <a class="dropdown-item dropdown-toggle" href="#sidebar-authentication" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">认证</a>
                        <div class="dropdown-menu">
                          <a href="../sign-in.html" class="dropdown-item">年的征兆</a>
                          <a href="../sign-up.html" class="dropdown-item">征兆上升</a>
                          <a href="../forgot-password.html" class="dropdown-item">忘记密码</a>
                          <a href="../terms-of-service.html" class="dropdown-item">服务条款</a>
                          <a href="../auth-lock.html" class="dropdown-item">锁定屏幕</a>
                        </div>
                      </div>
                      <div class="dropend">
                        <a class="dropdown-item dropdown-toggle" href="#sidebar-error" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">
                          <!-- Download SVG icon from http://tabler-icons.io/i/file-minus -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-inline me-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M14 3v4a1 1 0 0 0 1 1h4"></path><path d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2z"></path><line x1="9" y1="14" x2="15" y2="14"></line></svg>错误页</a>
                        <div class="dropdown-menu">
                          <a href="../error-404.html" class="dropdown-item">404页</a>
                          <a href="../error-500.html" class="dropdown-item">500页</a>
                          <a href="../error-maintenance.html" class="dropdown-item">维护页面</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../form-elements.html">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/checkbox -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="9 11 12 14 20 6"></polyline><path d="M20 12v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h9"></path></svg>
                  </span>
                  <span class="nav-link-title">表格</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#navbar-extra" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/star -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873z"></path></svg>
                  </span>
                  <span class="nav-link-title">额外的</span>
                </a>
                <div class="dropdown-menu">
                  <div class="dropdown-menu-columns">
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../activity.html">活动 -</a>
                      <a class="dropdown-item" href="../gallery.html">画廊</a>
                      <a class="dropdown-item" href="../invoice.html">发票</a>
                      <a class="dropdown-item" href="../search-results.html">搜索结果</a>
                      <a class="dropdown-item" href="../pricing.html">定价卡</a>
                      <a class="dropdown-item" href="../pricing-table.html">定价表</a>
                      <a class="dropdown-item" href="../faq.html">常见问题<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../users.html">用户</a>
                    </div>
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../license.html">许可/执照</a>
                      <a class="dropdown-item" href="../music.html">音乐</a>
                      <a class="dropdown-item" href="../tasks.html">任务<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../uptime.html">正常运行时间监视器</a>
                      <a class="dropdown-item" href="../widgets.html">小部件</a>
                      <a class="dropdown-item" href="../wizard.html">向导</a>
                      <a class="dropdown-item" href="../settings.html">设置<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                    </div>
                  </div>
                </div>
              </li>
              <li class="nav-item active dropdown">
                <a class="nav-link dropdown-toggle" href="#navbar-layout" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="true">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/layout-2 -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="4" width="6" height="5" rx="2"></rect><rect x="4" y="13" width="6" height="7" rx="2"></rect><rect x="14" y="4" width="6" height="7" rx="2"></rect><rect x="14" y="15" width="6" height="5" rx="2"></rect></svg>
                  </span>
                  <span class="nav-link-title">控制面板设计</span>
                </a>
                <div class="dropdown-menu show">
                  <div class="dropdown-menu-columns">
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../layout-horizontal.html">水平方向</a>
                      <a class="dropdown-item" href="../layout-boxed.html">盒装<span class="badge badge-sm bg-green text-uppercase ms-2">新</span>
                      </a>
                      <a class="dropdown-item" href="../layout-vertical.html">竖直方向</a>
                      <a class="dropdown-item active" href="../layout-vertical-transparent.html">垂直透明</a>
                      <a class="dropdown-item" href="../layout-vertical-right.html">右竖向</a>
                      <a class="dropdown-item" href="../layout-condensed.html">凝结的</a>
                      <a class="dropdown-item" href="../layout-combo.html">综合道路</a>
                    </div>
                    <div class="dropdown-menu-column">
                      <a class="dropdown-item" href="../layout-navbar-dark.html">纳夫巴尔黑暗</a>
                      <a class="dropdown-item" href="../layout-navbar-sticky.html">Navbar粘的</a>
                      <a class="dropdown-item" href="../layout-navbar-overlap.html">Navbar重叠</a>
                      <a class="dropdown-item" href="../layout-rtl.html">RTL模式</a>
                      <a class="dropdown-item" href="../layout-fluid.html">体液</a>
                      <a class="dropdown-item" href="../layout-fluid-vertical.html">体液垂直</a>
                    </div>
                  </div>
                </div>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="../icons.html">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/ghost -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 11a7 7 0 0 1 14 0v7a1.78 1.78 0 0 1 -3.1 1.4a1.65 1.65 0 0 0 -2.6 0a1.65 1.65 0 0 1 -2.6 0a1.65 1.65 0 0 0 -2.6 0a1.78 1.78 0 0 1 -3.1 -1.4v-7"></path><line x1="10" y1="10" x2="10.01" y2="10"></line><line x1="14" y1="10" x2="14.01" y2="10"></line><path d="M10 14a3.5 3.5 0 0 0 4 0"></path></svg>
                  </span>
                  <span class="nav-link-title">2160个图标</span>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#navbar-help" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false">
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/lifebuoy -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="12" cy="12" r="4"></circle><circle cx="12" cy="12" r="9"></circle><line x1="15" y1="15" x2="18.35" y2="18.35"></line><line x1="9" y1="15" x2="5.65" y2="18.35"></line><line x1="5.65" y1="5.65" x2="9" y2="9"></line><line x1="18.35" y1="5.65" x2="15" y2="9"></line></svg>
                  </span>
                  <span class="nav-link-title">帮助</span>
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="../docs/index.html">记录</a>
                  <a class="dropdown-item" href="../changelog.html">Changelog</a>
                  <a class="dropdown-item" href="https://github.com/tabler/tabler" target="_blank" rel="noopener">源代码</a>
                  <a class="dropdown-item text-pink" href="https://github.com/sponsors/codecalm" target="_blank" rel="noopener">
                    <!-- Download SVG icon from http://tabler-icons.io/i/heart -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-inline me-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M19.5 12.572l-7.5 7.428l-7.5 -7.428m0 0a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572"></path></svg>赞助项目！</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </aside>
      <div class="page-wrapper">
        <div class="container-xl">
          <!-- Page title -->
          <div class="page-header d-print-none">
            <div class="row g-2 align-items-center">
              <div class="col">
                <!-- Page pre-title -->
                <div class="page-pretitle">概述</div>
                <h2 class="page-title">垂直透明布局</h2>
              </div>
              <!-- Page title actions -->
              <div class="col-12 col-md-auto ms-auto d-print-none">
                <div class="btn-list">
                  <span class="d-none d-sm-inline">
                    <a href="#" class="btn btn-white">新视图</a>
                  </span>
                  <a href="#" class="btn btn-primary d-none d-sm-inline-block" data-bs-toggle="modal" data-bs-target="#modal-report">
                    <!-- Download SVG icon from http://tabler-icons.io/i/plus -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>创建新报表</a>
                  <a href="#" class="btn btn-primary d-sm-none btn-icon" data-bs-toggle="modal" data-bs-target="#modal-report" aria-label="Create new report">
                    <!-- Download SVG icon from http://tabler-icons.io/i/plus -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="page-body">
          <div class="container-xl">
            <div class="row row-deck row-cards">
              <div class="col-sm-6 col-lg-3">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex align-items-center">
                      <div class="subheader">销售</div>
                      <div class="ms-auto lh-1">
                        <div class="dropdown">
                          <a class="dropdown-toggle text-muted" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">最近7天</a>
                          <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item active" href="#">最近7天</a>
                            <a class="dropdown-item" href="#">最近30天</a>
                            <a class="dropdown-item" href="#">最近3个月</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="h1 mb-3">75%</div>
                    <div class="d-flex mb-2">
                      <div>销售转换率</div>
                      <div class="ms-auto">
                        <span class="text-green d-inline-flex align-items-center lh-1">7%<!-- Download SVG icon from http://tabler-icons.io/i/trending-up -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon ms-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="3 17 9 11 13 15 21 7"></polyline><polyline points="14 7 21 7 21 14"></polyline></svg>
                        </span>
                      </div>
                    </div>
                    <div class="progress progress-sm">
                      <div class="progress-bar bg-blue" style="width: 75%" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" aria-label="75% Complete">
                        <span class="visually-hidden">完成75%</span>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex align-items-center">
                      <div class="subheader">收入</div>
                      <div class="ms-auto lh-1">
                        <div class="dropdown">
                          <a class="dropdown-toggle text-muted" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">最近7天</a>
                          <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item active" href="#">最近7天</a>
                            <a class="dropdown-item" href="#">最近30天</a>
                            <a class="dropdown-item" href="#">最近3个月</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="d-flex align-items-baseline">
                      <div class="h1 mb-0 me-2">4,300美元</div>
                      <div class="me-auto">
                        <span class="text-green d-inline-flex align-items-center lh-1">8%<!-- Download SVG icon from http://tabler-icons.io/i/trending-up -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon ms-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="3 17 9 11 13 15 21 7"></polyline><polyline points="14 7 21 7 21 14"></polyline></svg>
                        </span>
                      </div>
                    </div>
                  </div>
                  <div id="chart-revenue-bg" class="chart-sm"></div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex align-items-center">
                      <div class="subheader">新客户</div>
                      <div class="ms-auto lh-1">
                        <div class="dropdown">
                          <a class="dropdown-toggle text-muted" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">最近7天</a>
                          <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item active" href="#">最近7天</a>
                            <a class="dropdown-item" href="#">最近30天</a>
                            <a class="dropdown-item" href="#">最近3个月</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="d-flex align-items-baseline">
                      <div class="h1 mb-3 me-2">6,782</div>
                      <div class="me-auto">
                        <span class="text-yellow d-inline-flex align-items-center lh-1">0%<!-- Download SVG icon from http://tabler-icons.io/i/minus -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon ms-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><line x1="5" y1="12" x2="19" y2="12"></line></svg>
                        </span>
                      </div>
                    </div>
                    <div id="chart-new-clients" class="chart-sm"></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-lg-3">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex align-items-center">
                      <div class="subheader">活动用户</div>
                      <div class="ms-auto lh-1">
                        <div class="dropdown">
                          <a class="dropdown-toggle text-muted" href="#" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">最近7天</a>
                          <div class="dropdown-menu dropdown-menu-end">
                            <a class="dropdown-item active" href="#">最近7天</a>
                            <a class="dropdown-item" href="#">最近30天</a>
                            <a class="dropdown-item" href="#">最近3个月</a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="d-flex align-items-baseline">
                      <div class="h1 mb-3 me-2">2,986</div>
                      <div class="me-auto">
                        <span class="text-green d-inline-flex align-items-center lh-1">4%<!-- Download SVG icon from http://tabler-icons.io/i/trending-up -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon ms-1" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="3 17 9 11 13 15 21 7"></polyline><polyline points="14 7 21 7 21 14"></polyline></svg>
                        </span>
                      </div>
                    </div>
                    <div id="chart-active-users" class="chart-sm"></div>
                  </div>
                </div>
              </div>
              <div class="col-12">
                <div class="row row-cards">
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-blue text-white avatar"><!-- Download SVG icon from http://tabler-icons.io/i/currency-dollar -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M16.7 8a3 3 0 0 0 -2.7 -2h-4a3 3 0 0 0 0 6h4a3 3 0 0 1 0 6h-4a3 3 0 0 1 -2.7 -2"></path><path d="M12 3v3m0 12v3"></path></svg>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium">132销售</div>
                            <div class="text-muted">12等待付款</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-green text-white avatar"><!-- Download SVG icon from http://tabler-icons.io/i/shopping-cart -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><circle cx="6" cy="19" r="2"></circle><circle cx="17" cy="19" r="2"></circle><path d="M17 17h-11v-14h-2"></path><path d="M6 5l14 1l-1 7h-13"></path></svg>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium">78个订单</div>
                            <div class="text-muted">32件已发运</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-twitter text-white avatar"><!-- Download SVG icon from http://tabler-icons.io/i/brand-twitter -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M22 4.01c-1 .49 -1.98 .689 -3 .99c-1.121 -1.265 -2.783 -1.335 -4.38 -.737s-2.643 2.06 -2.62 3.737v1c-3.245 .083 -6.135 -1.395 -8 -4c0 0 -4.182 7.433 4 11c-1.872 1.247 -3.739 2.088 -6 2c3.308 1.803 6.913 2.423 10.034 1.517c3.58 -1.04 6.522 -3.723 7.651 -7.742a13.84 13.84 0 0 0 .497 -3.753c-.002 -.249 1.51 -2.772 1.818 -4.013z"></path></svg>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium">623股</div>
                            <div class="text-muted">今天16日</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6 col-lg-3">
                    <div class="card card-sm">
                      <div class="card-body">
                        <div class="row align-items-center">
                          <div class="col-auto">
                            <span class="bg-facebook text-white avatar"><!-- Download SVG icon from http://tabler-icons.io/i/brand-facebook -->
                              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M7 10v4h3v7h4v-7h3l1 -4h-4v-2a1 1 0 0 1 1 -1h3v-4h-3a5 5 0 0 0 -5 5v2h-3"></path></svg>
                            </span>
                          </div>
                          <div class="col">
                            <div class="font-weight-medium">132个赞</div>
                            <div class="text-muted">今天21日</div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="card">
                  <div class="card-body">
                    <h3 class="card-title">流量汇总</h3>
                    <div id="chart-mentions" class="chart-lg"></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="card">
                  <div class="card-body">
                    <h3 class="card-title">地点</h3>
                    <div class="ratio ratio-21x9">
                      <div>
                        <div id="map-world" class="w-100 h-100"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="row row-cards">
                  <div class="col-12">
                    <div class="card">
                      <div class="card-body">
                        <p class="mb-3">使用存储<strong>6854.45 奔驰</strong>8 GB</p>
                        <div class="progress progress-separated mb-3">
                          <div class="progress-bar bg-primary" role="progressbar" style="width: 44%" aria-label="Regular"></div>
                          <div class="progress-bar bg-info" role="progressbar" style="width: 19%" aria-label="System"></div>
                          <div class="progress-bar bg-success" role="progressbar" style="width: 9%" aria-label="Shared"></div>
                        </div>
                        <div class="row">
                          <div class="col-auto d-flex align-items-center pe-2">
                            <span class="legend me-2 bg-primary"></span>
                            <span>常规的</span>
                            <span class="d-none d-md-inline d-lg-none d-xxl-inline ms-2 text-muted">915MB</span>
                          </div>
                          <div class="col-auto d-flex align-items-center px-2">
                            <span class="legend me-2 bg-info"></span>
                            <span>系统</span>
                            <span class="d-none d-md-inline d-lg-none d-xxl-inline ms-2 text-muted">415MB</span>
                          </div>
                          <div class="col-auto d-flex align-items-center px-2">
                            <span class="legend me-2 bg-success"></span>
                            <span>共享的</span>
                            <span class="d-none d-md-inline d-lg-none d-xxl-inline ms-2 text-muted">201MB</span>
                          </div>
                          <div class="col-auto d-flex align-items-center ps-2">
                            <span class="legend me-2"></span>
                            <span>免费的</span>
                            <span class="d-none d-md-inline d-lg-none d-xxl-inline ms-2 text-muted">612MB</span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="card" style="height: 28rem">
                      <div class="card-body card-body-scrollable card-body-scrollable-shadow">
                        <div class="divide-y">
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar">JL</span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>杰菲·刘易西</strong>对您的<strong>“我不是女巫。”</strong>邮政。</div>
                                <div class="text-muted">昨天</div>
                              </div>
                              <div class="col-auto align-self-center">
                                <div class="badge bg-primary"></div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/002m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">它是<strong>马洛里·休姆</strong>生日。祝他一切顺利！</div>
                                <div class="text-muted">2天前</div>
                              </div>
                              <div class="col-auto align-self-center">
                                <div class="badge bg-primary"></div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/003m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>邓恩斯莱恩</strong>过帐<strong>“嗯，你想要什么？”</strong>.
</div>
                                <div class="text-muted">至今</div>
                              </div>
                              <div class="col-auto align-self-center">
                                <div class="badge bg-primary"></div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/000f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>艾美·莱维特</strong>创建了一个新项目<strong>早晨闹钟</strong>.
</div>
                                <div class="text-muted">4天前</div>
                              </div>
                              <div class="col-auto align-self-center">
                                <div class="badge bg-primary"></div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/001f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>玛丽霍·勒巴雷</strong>喜欢你的照片。</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar">EP</span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>埃根·波茨</strong>已注册新客户端为<strong>特里利亚</strong>.
</div>
                                <div class="text-muted">昨天</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/002f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>凯利·斯金利</strong>在项目上完成了一项新的交易<strong>钢笔菠萝苹果笔</strong>.
</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/003f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>克里斯塔贝尔·查尔伍德</strong>为…创建了一个新项目<strong>维基盒</strong>.
</div>
                                <div class="text-muted">4天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar">HS</span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>哈斯克尔遮蔽器</strong>更改。的状态<strong>表位图标</strong>From
自<strong>打开</strong> 截至 <strong>关闭</strong>.
</div>
                                <div class="text-muted">至今</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/006m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>卡车米恩</strong>喜欢<strong>Tabler UI工具包</strong>.
</div>
                                <div class="text-muted">昨天</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/004f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>利萨·贝蒂</strong>发布了新视频。</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/007m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>佩伦·基马尔</strong>还有3个人跟着你。</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar">SA</span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>阳光明媚的艾瑞</strong>上传3张新照片到类别<strong>灵感</strong>.
</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/009m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>杰弗里·范德斯</strong>做了一个<strong>10美元</strong>捐赠。</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/010m.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>撒切尔龙骨</strong>创建了个人资料。</div>
                                <div class="text-muted">三天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/005f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>戴安·埃斯卡拉</strong>主持这次活动<strong>Tabler UI生日</strong>.
</div>
                                <div class="text-muted">4天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar" style="background-image: url(./static/avatars/006f.jpg)"></span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>阿维瓦·穆格尔斯顿</strong>上面提到了你<strong>2020年最佳</strong>.
</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                          <div>
                            <div class="row">
                              <div class="col-auto">
                                <span class="avatar">AA</span>
                              </div>
                              <div class="col">
                                <div class="text-truncate">
                                  <strong>阿利·阿姆斯泰德</strong>发送审查请求到<strong>阿曼达·布莱克</strong>.
</div>
                                <div class="text-muted">2天前</div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-lg-6">
                <div class="card">
                  <div class="card-header border-0">
                    <div class="card-title">开发活动</div>
                  </div>
                  <div class="position-relative">
                    <div class="position-absolute top-0 left-0 px-3 mt-1 w-75">
                      <div class="row g-2">
                        <div class="col-auto">
                          <div class="chart-sparkline chart-sparkline-square" id="sparkline-activity"></div>
                        </div>
                        <div class="col">
                          <div>今天的收入：4,262.40美元</div>
                          <div class="text-muted"><!-- Download SVG icon from http://tabler-icons.io/i/trending-up -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-inline text-green" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="3 17 9 11 13 15 21 7"></polyline><polyline points="14 7 21 7 21 14"></polyline></svg>比昨天高出5%</div>
                        </div>
                      </div>
                    </div>
                    <div id="chart-development-activity"></div>
                  </div>
                  <div class="card-table table-responsive">
                    <table class="table table-vcenter">
                      <thead>
                        <tr>
                          <th>用户</th>
                          <th>承诺</th>
                          <th>日期</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm" style="background-image: url(./static/avatars/000m.jpg)"></span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">修正飞镖的兼容性(#29755)</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月28日</td>
                        </tr>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm">JL</span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">将不推荐使用的html标记更改为文本装饰类(#29604)</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月27日</td>
                        </tr>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm" style="background-image: url(./static/avatars/002m.jpg)"></span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">justify-content：between：justify-content：space-between(#29734)</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月26日</td>
                        </tr>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm" style="background-image: url(./static/avatars/003m.jpg)"></span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">更新change-version.js(#29736)</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月26日</td>
                        </tr>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm" style="background-image: url(./static/avatars/000f.jpg)"></span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">重新生成包-lock.json(#29730)</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月25日</td>
                        </tr>
                        <tr>
                          <td class="w-1">
                            <span class="avatar avatar-sm" style="background-image: url(./static/avatars/001f.jpg)"></span>
                          </td>
                          <td class="td-truncate">
                            <div class="text-truncate">一些小的文本调整</div>
                          </td>
                          <td class="text-nowrap text-muted">2019年11月24日</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
              <div class="col-12">
                <div class="card card-md">
                  <div class="card-stamp card-stamp-lg">
                    <div class="card-stamp-icon bg-primary">
                      <!-- Download SVG icon from http://tabler-icons.io/i/ghost -->
                      <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 11a7 7 0 0 1 14 0v7a1.78 1.78 0 0 1 -3.1 1.4a1.65 1.65 0 0 0 -2.6 0a1.65 1.65 0 0 1 -2.6 0a1.65 1.65 0 0 0 -2.6 0a1.78 1.78 0 0 1 -3.1 -1.4v-7"></path><line x1="10" y1="10" x2="10.01" y2="10"></line><line x1="14" y1="10" x2="14.01" y2="10"></line><path d="M10 14a3.5 3.5 0 0 0 4 0"></path></svg>
                    </div>
                  </div>
                  <div class="card-body">
                    <div class="row align-items-center">
                      <div class="col-10">
                        <h3 class="h1">表位图标</h3>
                        <div class="markdown text-muted">所有图标来自Tabler图标集，并且是麻省理工学院授权的。到访<a href="https://tabler-icons.io" target="_blank" rel="noopener">Tabler-icons.io</a>,
下载SVG、PNG或&nbsp；Reaction中的2160个图标，并在您喜欢的设计工具中使用它们。</div>
                        <div class="mt-3">
                          <a href="https://tabler-icons.io" class="btn btn-primary" target="_blank" rel="noopener">下载图标</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-12 col-lg-8">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">访问次数最多的网页</h3>
                  </div>
                  <div class="card-table table-responsive">
                    <table class="table table-vcenter">
                      <thead>
                        <tr>
                          <th>页名</th>
                          <th>来访者</th>
                          <th>独特性</th>
                          <th colspan="2">弹跳率</th>
                        </tr>
                      </thead>
                      <tr>
                        <td>/About.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">四八九六</td>
                        <td class="text-muted">三千六百五十四</td>
                        <td class="text-muted">82.54%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-1"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>/Special-promo.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">三六五二</td>
                        <td class="text-muted">三二一五</td>
                        <td class="text-muted">76.29%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-2"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>/News/1，New-UI-kit.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">三千二百五十六</td>
                        <td class="text-muted">二千八百六十五</td>
                        <td class="text-muted">72.65%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-3"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>/Lorem-ipsum-dolor-sit-amet-very-long-url.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">986</td>
                        <td class="text-muted">865</td>
                        <td class="text-muted">44.89%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-4"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>/Colors.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">912</td>
                        <td class="text-muted">822</td>
                        <td class="text-muted">41.12%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-5"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>/Docs/index.html<a href="#" class="ms-1" aria-label="Open website"><!-- Download SVG icon from http://tabler-icons.io/i/link -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M10 14a3.5 3.5 0 0 0 5 0l4 -4a3.5 3.5 0 0 0 -5 -5l-.5 .5"></path><path d="M14 10a3.5 3.5 0 0 0 -5 0l-4 4a3.5 3.5 0 0 0 5 5l.5 -.5"></path></svg>
                          </a>
                        </td>
                        <td class="text-muted">855</td>
                        <td class="text-muted">798</td>
                        <td class="text-muted">32.65%</td>
                        <td class="text-end w-1">
                          <div class="chart-sparkline chart-sparkline-sm" id="sparkline-bounce-rate-6"></div>
                        </td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <a href="https://github.com/sponsors/codecalm" class="card card-sponsor" target="_blank" rel="noopener" style="background-image: url(./static/sponsor-banner-homepage.svg)" aria-label="Sponsor Tabler!">
                  <div class="card-body"></div>
                </a>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">社会媒体流量</h3>
                  </div>
                  <table class="table card-table table-vcenter">
                    <thead>
                      <tr>
                        <th>网络</th>
                        <th colspan="2">来访者</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>Instagram</td>
                        <td>三百五百五十</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 71.0%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>推特</td>
                        <td>一千七百九十八</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 35.96%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>脸书</td>
                        <td>一千二百四十五</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 24.9%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>TikTok</td>
                        <td>986</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 19.72%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>Pinterest</td>
                        <td>854</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 17.08%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>VK</td>
                        <td>650</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 13.0%"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>Pinterest</td>
                        <td>420</td>
                        <td class="w-50">
                          <div class="progress progress-xs">
                            <div class="progress-bar bg-primary" style="width: 8.4%"></div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="col-md-12 col-lg-8">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">任务</h3>
                  </div>
                  <div class="table-responsive">
                    <table class="table card-table table-vcenter">
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task" checked="">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">扩展数据模型。</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>2021年8月4日</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>2/7</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>3</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm" style="background-image: url(./static/avatars/000m.jpg)"></span>
                        </td>
                      </tr>
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">验证事件流。</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>(2019年1月3日)</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>3/10</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>6</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm">JL</span>
                        </td>
                      </tr>
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">数据库备份与维护</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>(2018年12月28日)</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>0/6</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>1</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm" style="background-image: url(./static/avatars/002m.jpg)"></span>
                        </td>
                      </tr>
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task" checked="">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">确定执行小组。</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>(二零七年十一月七日)</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>6/10</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>12</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm" style="background-image: url(./static/avatars/003m.jpg)"></span>
                        </td>
                      </tr>
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">定义用户和工作流</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>2021年11月23日</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>3/7</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>5</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm" style="background-image: url(./static/avatars/000f.jpg)"></span>
                        </td>
                      </tr>
                      <tr>
                        <td class="w-1 pe-0">
                          <input type="checkbox" class="form-check-input m-0 align-middle" aria-label="Select task" checked="">
                        </td>
                        <td class="w-100">
                          <a href="#" class="text-reset">检查拉出请求</a>
                        </td>
                        <td class="text-nowrap text-muted">
                          <!-- Download SVG icon from http://tabler-icons.io/i/calendar -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><rect x="4" y="5" width="16" height="16" rx="2"></rect><line x1="16" y1="3" x2="16" y2="7"></line><line x1="8" y1="3" x2="8" y2="7"></line><line x1="4" y1="11" x2="20" y2="11"></line><line x1="11" y1="15" x2="12" y2="15"></line><line x1="12" y1="15" x2="12" y2="18"></line></svg>(2021年1月14日)</td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/check -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M5 12l5 5l10 -10"></path></svg>2/9</a>
                        </td>
                        <td class="text-nowrap">
                          <a href="#" class="text-muted">
                            <!-- Download SVG icon from http://tabler-icons.io/i/message -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M4 21v-13a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-9l-4 4"></path><line x1="8" y1="9" x2="16" y2="9"></line><line x1="8" y1="13" x2="14" y2="13"></line></svg>3</a>
                        </td>
                        <td>
                          <span class="avatar avatar-sm" style="background-image: url(./static/avatars/001f.jpg)"></span>
                        </td>
                      </tr>
                    </table>
                  </div>
                </div>
              </div>
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                    <h3 class="card-title">发票</h3>
                  </div>
                  <div class="card-body border-bottom py-3">
                    <div class="d-flex">
                      <div class="text-muted">秀<div class="mx-2 d-inline-block">
                          <input type="text" class="form-control form-control-sm" value="8" size="3" aria-label="Invoices count">
                        </div>条目</div>
                      <div class="ms-auto text-muted">查找（Search）：<div class="ms-2 d-inline-block">
                          <input type="text" class="form-control form-control-sm" aria-label="Search invoice">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="table-responsive">
                    <table class="table card-table table-vcenter text-nowrap datatable">
                      <thead>
                        <tr>
                          <th class="w-1"><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select all invoices"></th>
                          <th class="w-1">编号 <!-- Download SVG icon from http://tabler-icons.io/i/chevron-up -->
                            <svg xmlns="http://www.w3.org/2000/svg" class="icon icon-sm text-dark icon-thick" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="6 15 12 9 18 15"></polyline></svg>
                          </th>
                          <th>发票主体</th>
                          <th>Client
委托方</th>
                          <th>增值税编号</th>
                          <th>创建信息</th>
                          <th>地位</th>
                          <th>价格</th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001401</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">设计作品</a></td>
                          <td>
                            <span class="flag flag-country-us"></span>卡尔森有限公司</td>
                          <td>87956621</td>
                          <td>2017年12月15日</td>
                          <td>
                            <span class="badge bg-success me-1"></span>付费</td>
                          <td>$887</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001402</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">UX线框</a></td>
                          <td>
                            <span class="flag flag-country-gb"></span>奥多比</td>
                          <td>87956421</td>
                          <td>2017年4月12日</td>
                          <td>
                            <span class="badge bg-warning me-1"></span>进行：</td>
                          <td>$1200</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001403</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">新仪表板</a></td>
                          <td>
                            <span class="flag flag-country-de"></span>蓝狼人</td>
                          <td>87952621</td>
                          <td>2017年10月23日</td>
                          <td>
                            <span class="badge bg-warning me-1"></span>进行：</td>
                          <td>534美元</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001404</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">着陆页</a></td>
                          <td>
                            <span class="flag flag-country-br"></span>Salesforce</td>
                          <td>87953421</td>
                          <td>2017年9月2日</td>
                          <td>
                            <span class="badge bg-secondary me-1"></span>2周后到期</td>
                          <td>$1500</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001405</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">营销模板</a></td>
                          <td>
                            <span class="flag flag-country-pl"></span>皇族</td>
                          <td>87956621</td>
                          <td>2018年1月29日</td>
                          <td>
                            <span class="badge bg-danger me-1"></span>今天付钱</td>
                          <td>648美元</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001406</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">销售演示文稿</a></td>
                          <td>
                            <span class="flag flag-country-br"></span>塔卜达克</td>
                          <td>87956621</td>
                          <td>2018年2月4日</td>
                          <td>
                            <span class="badge bg-secondary me-1"></span>3周后到期</td>
                          <td>300美元</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001407</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">徽标和印刷品</a></td>
                          <td>
                            <span class="flag flag-country-us"></span>苹果</td>
                          <td>87956621</td>
                          <td>2018年3月22日</td>
                          <td>
                            <span class="badge bg-success me-1"></span>今天付钱</td>
                          <td>2500美元</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                        <tr>
                          <td><input class="form-check-input m-0 align-middle" type="checkbox" aria-label="Select invoice"></td>
                          <td><span class="text-muted">001408</span></td>
                          <td><a href="invoice.html" class="text-reset" tabindex="-1">标志性元素</a></td>
                          <td>
                            <span class="flag flag-country-pl"></span>图卡皮奇</td>
                          <td>87956621</td>
                          <td>2018年5月13日</td>
                          <td>
                            <span class="badge bg-success me-1"></span>今天付钱</td>
                          <td>940美元</td>
                          <td class="text-end">
                            <span class="dropdown">
                              <button class="btn dropdown-toggle align-text-top" data-bs-boundary="viewport" data-bs-toggle="dropdown">行动</button>
                              <div class="dropdown-menu dropdown-menu-end">
                                <a class="dropdown-item" href="#">行动</a>
                                <a class="dropdown-item" href="#">另一种行动</a>
                              </div>
                            </span>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="card-footer d-flex align-items-center">
                    <p class="m-0 text-muted">展示<span>1</span> 截至 <span>8</span> 地址为 <span>16</span>条目</p>
                    <ul class="pagination m-0 ms-auto">
                      <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">
                          <!-- Download SVG icon from http://tabler-icons.io/i/chevron-left -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="15 6 9 12 15 18"></polyline></svg>前</a>
                      </li>
                      <li class="page-item"><a class="page-link" href="#">1</a></li>
                      <li class="page-item active"><a class="page-link" href="#">2</a></li>
                      <li class="page-item"><a class="page-link" href="#">3</a></li>
                      <li class="page-item"><a class="page-link" href="#">4</a></li>
                      <li class="page-item"><a class="page-link" href="#">5</a></li>
                      <li class="page-item">
                        <a class="page-link" href="#">下一个<!-- Download SVG icon from http://tabler-icons.io/i/chevron-right -->
                          <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><polyline points="9 6 15 12 9 18"></polyline></svg>
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <footer class="footer footer-transparent d-print-none">
          <div class="container-xl">
            <div class="row text-center align-items-center flex-row-reverse">
              <div class="col-lg-auto ms-lg-auto">
                <ul class="list-inline list-inline-dots mb-0">
                  <li class="list-inline-item"><a href="../docs/index.html" class="link-secondary">记录</a></li>
                  <li class="list-inline-item"><a href="../license.html" class="link-secondary">许可/执照</a></li>
                  <li class="list-inline-item"><a href="https://github.com/tabler/tabler" target="_blank" class="link-secondary" rel="noopener">源代码</a></li>
                  <li class="list-inline-item">
                    <a href="https://github.com/sponsors/codecalm" target="_blank" class="link-secondary" rel="noopener">
                      <!-- Download SVG icon from http://tabler-icons.io/i/heart -->
                      <svg xmlns="http://www.w3.org/2000/svg" class="icon text-pink icon-filled icon-inline" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><path d="M19.5 12.572l-7.5 7.428l-7.5 -7.428m0 0a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572"></path></svg>赞助商</a>
                  </li>
                </ul>
              </div>
              <div class="col-12 col-lg-auto mt-3 mt-lg-0">
                <ul class="list-inline list-inline-dots mb-0">
                  <li class="list-inline-item">版权所有©2022<a href="." class="link-secondary">压片机</a>.
版权所有。</li>
                  <li class="list-inline-item">
                    <a href="../changelog.html" class="link-secondary" rel="noopener">V1.0.0-Beta11</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </footer>
      </div>
    </div>
    <div class="modal modal-blur fade" id="modal-report" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">新报告</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label class="form-label">名称</label>
              <input type="text" class="form-control" name="example-text-input" placeholder="您的报告名称">
            </div>
            <label class="form-label">报表类型</label>
            <div class="form-selectgroup-boxes row mb-3">
              <div class="col-lg-6">
                <label class="form-selectgroup-item">
                  <input type="radio" name="report-type" value="1" class="form-selectgroup-input" checked="">
                  <span class="form-selectgroup-label d-flex align-items-center p-3">
                    <span class="me-3">
                      <span class="form-selectgroup-check"></span>
                    </span>
                    <span class="form-selectgroup-label-content">
                      <span class="form-selectgroup-title strong mb-1">简单</span>
                      <span class="d-block text-muted">只提供报表所需的基本数据</span>
                    </span>
                  </span>
                </label>
              </div>
              <div class="col-lg-6">
                <label class="form-selectgroup-item">
                  <input type="radio" name="report-type" value="1" class="form-selectgroup-input">
                  <span class="form-selectgroup-label d-flex align-items-center p-3">
                    <span class="me-3">
                      <span class="form-selectgroup-check"></span>
                    </span>
                    <span class="form-selectgroup-label-content">
                      <span class="form-selectgroup-title strong mb-1">高级程度</span>
                      <span class="d-block text-muted">在报告中插入图表和其他高级分析</span>
                    </span>
                  </span>
                </label>
              </div>
            </div>
            <div class="row">
              <div class="col-lg-8">
                <div class="mb-3">
                  <label class="form-label">报表url</label>
                  <div class="input-group input-group-flat">
                    <span class="input-group-text">https://tabler.io/reports/</span>
                    <input type="text" class="form-control ps-0" value="报告-01" autocomplete="off">
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="mb-3">
                  <label class="form-label">视野</label>
                  <select class="form-select">
                    <option value="1" selected="">个人</option>
                    <option value="2">公共的</option>
                    <option value="3">隐藏的</option>
                  </select>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-lg-6">
                <div class="mb-3">
                  <label class="form-label">客户名称</label>
                  <input type="text" class="form-control">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="mb-3">
                  <label class="form-label">报告期</label>
                  <input type="date" class="form-control">
                </div>
              </div>
              <div class="col-lg-12">
                <div>
                  <label class="form-label">补充信息</label>
                  <textarea class="form-control" rows="3"></textarea>
                </div>
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <a href="#" class="btn btn-link link-secondary" data-bs-dismiss="modal">取消</a>
            <a href="#" class="btn btn-primary ms-auto" data-bs-dismiss="modal">
              <!-- Download SVG icon from http://tabler-icons.io/i/plus -->
              <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewbox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"></path><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>创建新报表</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Libs JS -->
    <script src="../dist/libs/apexcharts/dist/apexcharts.min.js" defer=""></script>
    <script src="../dist/libs/jsvectormap/dist/js/jsvectormap.min.js" defer=""></script>
    <script src="../dist/libs/jsvectormap/dist/maps/world.js" defer=""></script>
    <script src="../dist/libs/jsvectormap/dist/maps/world-merc.js" defer=""></script>
    <!-- Tabler Core -->
    <script src="../dist/js/tabler.min.js" defer=""></script>
    <script src="../dist/js/demo.min.js" defer=""></script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('chart-revenue-bg'), {
      		chart: {
      			type: "area",
      			fontFamily: 'inherit',
      			height: 40.0,
      			sparkline: {
      				enabled: true
      			},
      			animations: {
      				enabled: false
      			},
      		},
      		dataLabels: {
      			enabled: false,
      		},
      		fill: {
      			opacity: .16,
      			type: 'solid'
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      			curve: "smooth",
      		},
      		series: [{
      			name: "Profits",
      			data: [37, 35, 44, 28, 36, 24, 65, 31, 37, 39, 62, 51, 35, 41, 35, 27, 93, 53, 61, 27, 54, 43, 19, 46, 39, 62, 51, 35, 41, 67]
      		}],
      		grid: {
      			strokeDashArray: 4,
      		},
      		xaxis: {
      			labels: {
      				padding: 0,
      			},
      			tooltip: {
      				enabled: false
      			},
      			axisBorder: {
      				show: false,
      			},
      			type: 'datetime',
      		},
      		yaxis: {
      			labels: {
      				padding: 4
      			},
      		},
      		labels: [
      			'2020-06-20', '2020-06-21', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-25', '2020-06-26', '2020-06-27', '2020-06-28', '2020-06-29', '2020-06-30', '2020-07-01', '2020-07-02', '2020-07-03', '2020-07-04', '2020-07-05', '2020-07-06', '2020-07-07', '2020-07-08', '2020-07-09', '2020-07-10', '2020-07-11', '2020-07-12', '2020-07-13', '2020-07-14', '2020-07-15', '2020-07-16', '2020-07-17', '2020-07-18', '2020-07-19'
      		],
      		colors: ["#206bc4"],
      		legend: {
      			show: false,
      		},
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('chart-new-clients'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 40.0,
      			sparkline: {
      				enabled: true
      			},
      			animations: {
      				enabled: false
      			},
      		},
      		fill: {
      			opacity: 1,
      		},
      		stroke: {
      			width: [2, 1],
      			dashArray: [0, 3],
      			lineCap: "round",
      			curve: "smooth",
      		},
      		series: [{
      			name: "May",
      			data: [37, 35, 44, 28, 36, 24, 65, 31, 37, 39, 62, 51, 35, 41, 35, 27, 93, 53, 61, 27, 54, 43, 4, 46, 39, 62, 51, 35, 41, 67]
      		},{
      			name: "April",
      			data: [93, 54, 51, 24, 35, 35, 31, 67, 19, 43, 28, 36, 62, 61, 27, 39, 35, 41, 27, 35, 51, 46, 62, 37, 44, 53, 41, 65, 39, 37]
      		}],
      		grid: {
      			strokeDashArray: 4,
      		},
      		xaxis: {
      			labels: {
      				padding: 0,
      			},
      			tooltip: {
      				enabled: false
      			},
      			type: 'datetime',
      		},
      		yaxis: {
      			labels: {
      				padding: 4
      			},
      		},
      		labels: [
      			'2020-06-20', '2020-06-21', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-25', '2020-06-26', '2020-06-27', '2020-06-28', '2020-06-29', '2020-06-30', '2020-07-01', '2020-07-02', '2020-07-03', '2020-07-04', '2020-07-05', '2020-07-06', '2020-07-07', '2020-07-08', '2020-07-09', '2020-07-10', '2020-07-11', '2020-07-12', '2020-07-13', '2020-07-14', '2020-07-15', '2020-07-16', '2020-07-17', '2020-07-18', '2020-07-19'
      		],
      		colors: ["#206bc4", "#a8aeb7"],
      		legend: {
      			show: false,
      		},
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('chart-active-users'), {
      		chart: {
      			type: "bar",
      			fontFamily: 'inherit',
      			height: 40.0,
      			sparkline: {
      				enabled: true
      			},
      			animations: {
      				enabled: false
      			},
      		},
      		plotOptions: {
      			bar: {
      				columnWidth: '50%',
      			}
      		},
      		dataLabels: {
      			enabled: false,
      		},
      		fill: {
      			opacity: 1,
      		},
      		series: [{
      			name: "Profits",
      			data: [37, 35, 44, 28, 36, 24, 65, 31, 37, 39, 62, 51, 35, 41, 35, 27, 93, 53, 61, 27, 54, 43, 19, 46, 39, 62, 51, 35, 41, 67]
      		}],
      		grid: {
      			strokeDashArray: 4,
      		},
      		xaxis: {
      			labels: {
      				padding: 0,
      			},
      			tooltip: {
      				enabled: false
      			},
      			axisBorder: {
      				show: false,
      			},
      			type: 'datetime',
      		},
      		yaxis: {
      			labels: {
      				padding: 4
      			},
      		},
      		labels: [
      			'2020-06-20', '2020-06-21', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-25', '2020-06-26', '2020-06-27', '2020-06-28', '2020-06-29', '2020-06-30', '2020-07-01', '2020-07-02', '2020-07-03', '2020-07-04', '2020-07-05', '2020-07-06', '2020-07-07', '2020-07-08', '2020-07-09', '2020-07-10', '2020-07-11', '2020-07-12', '2020-07-13', '2020-07-14', '2020-07-15', '2020-07-16', '2020-07-17', '2020-07-18', '2020-07-19'
      		],
      		colors: ["#206bc4"],
      		legend: {
      			show: false,
      		},
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('chart-mentions'), {
      		chart: {
      			type: "bar",
      			fontFamily: 'inherit',
      			height: 240,
      			parentHeightOffset: 0,
      			toolbar: {
      				show: false,
      			},
      			animations: {
      				enabled: false
      			},
      			stacked: true,
      		},
      		plotOptions: {
      			bar: {
      				columnWidth: '50%',
      			}
      		},
      		dataLabels: {
      			enabled: false,
      		},
      		fill: {
      			opacity: 1,
      		},
      		series: [{
      			name: "Web",
      			data: [1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 2, 12, 5, 8, 22, 6, 8, 6, 4, 1, 8, 24, 29, 51, 40, 47, 23, 26, 50, 26, 41, 22, 46, 47, 81, 46, 6]
      		},{
      			name: "Social",
      			data: [2, 5, 4, 3, 3, 1, 4, 7, 5, 1, 2, 5, 3, 2, 6, 7, 7, 1, 5, 5, 2, 12, 4, 6, 18, 3, 5, 2, 13, 15, 20, 47, 18, 15, 11, 10, 0]
      		},{
      			name: "Other",
      			data: [2, 9, 1, 7, 8, 3, 6, 5, 5, 4, 6, 4, 1, 9, 3, 6, 7, 5, 2, 8, 4, 9, 1, 2, 6, 7, 5, 1, 8, 3, 2, 3, 4, 9, 7, 1, 6]
      		}],
      		grid: {
      			padding: {
      				top: -20,
      				right: 0,
      				left: -4,
      				bottom: -4
      			},
      			strokeDashArray: 4,
      			xaxis: {
      				lines: {
      					show: true
      				}
      			},
      		},
      		xaxis: {
      			labels: {
      				padding: 0,
      			},
      			tooltip: {
      				enabled: false
      			},
      			axisBorder: {
      				show: false,
      			},
      			type: 'datetime',
      		},
      		yaxis: {
      			labels: {
      				padding: 4
      			},
      		},
      		labels: [
      			'2020-06-20', '2020-06-21', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-25', '2020-06-26', '2020-06-27', '2020-06-28', '2020-06-29', '2020-06-30', '2020-07-01', '2020-07-02', '2020-07-03', '2020-07-04', '2020-07-05', '2020-07-06', '2020-07-07', '2020-07-08', '2020-07-09', '2020-07-10', '2020-07-11', '2020-07-12', '2020-07-13', '2020-07-14', '2020-07-15', '2020-07-16', '2020-07-17', '2020-07-18', '2020-07-19', '2020-07-20', '2020-07-21', '2020-07-22', '2020-07-23', '2020-07-24', '2020-07-25', '2020-07-26'
      		],
      		colors: ["#206bc4", "#79a6dc", "#bfe399"],
      		legend: {
      			show: false,
      		},
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:on
      document.addEventListener("DOMContentLoaded", function() {
      	const map = new jsVectorMap({
      		selector: '#map-world',
      		map: 'world',
      		backgroundColor: 'transparent',
      		regionStyle: {
      			initial: {
      				fill: '#F8FAFC',
      				stroke: 'rgba(98, 105, 118, .16)',
      				strokeWidth: 1,
      			}
      		},
      		zoomOnScroll: false,
      		zoomButtons: false,
      		// -------- Series --------
      		visualizeData: {
      			scale: ['#F8FAFC', '#206bc4'],
      			values: { "AF": 16, "AL": 11, "DZ": 158, "AO": 85, "AG": 1, "AR": 351, "AM": 8, "AU": 1219, "AT": 366, "AZ": 52, "BS": 7, "BH": 21, "BD": 105, "BB": 3, "BY": 52, "BE": 461, "BZ": 1, "BJ": 6, "BT": 1, "BO": 19, "BA": 16, "BW": 12, "BR": 2023, "BN": 11, "BG": 44, "BF": 8, "BI": 1, "KH": 11, "CM": 21, "CA": 1563, "CV": 1, "CF": 2, "TD": 7, "CL": 199, "CN": 5745, "CO": 283, "KM": 0, "CD": 12, "CG": 11, "CR": 35, "CI": 22, "HR": 59, "CY": 22, "CZ": 195, "DK": 304, "DJ": 1, "DM": 0, "DO": 50, "EC": 61, "EG": 216, "SV": 21, "GQ": 14, "ER": 2, "EE": 19, "ET": 30, "FJ": 3, "FI": 231, "FR": 2555, "GA": 12, "GM": 1, "GE": 11, "DE": 3305, "GH": 18, "GR": 305, "GD": 0, "GT": 40, "GN": 4, "GW": 0, "GY": 2, "HT": 6, "HN": 15, "HK": 226, "HU": 132, "IS": 12, "IN": 1430, "ID": 695, "IR": 337, "IQ": 84, "IE": 204, "IL": 201, "IT": 2036, "JM": 13, "JP": 5390, "JO": 27, "KZ": 129, "KE": 32, "KI": 0, "KR": 986, "KW": 117, "KG": 4, "LA": 6, "LV": 23, "LB": 39, "LS": 1, "LR": 0, "LY": 77, "LT": 35, "LU": 52, "MK": 9, "MG": 8, "MW": 5, "MY": 218, "MV": 1, "ML": 9, "MT": 7, "MR": 3, "MU": 9, "MX": 1004, "MD": 5, "MN": 5, "ME": 3, "MA": 91, "MZ": 10, "MM": 35, "NA": 11, "NP": 15, "NL": 770, "NZ": 138, "NI": 6, "NE": 5, "NG": 206, "NO": 413, "OM": 53, "PK": 174, "PA": 27, "PG": 8, "PY": 17, "PE": 153, "PH": 189, "PL": 438, "PT": 223, "QA": 126, "RO": 158, "RU": 1476, "RW": 5, "WS": 0, "ST": 0, "SA": 434, "SN": 12, "RS": 38, "SC": 0, "SL": 1, "SG": 217, "SK": 86, "SI": 46, "SB": 0, "ZA": 354, "ES": 1374, "LK": 48, "KN": 0, "LC": 1, "VC": 0, "SD": 65, "SR": 3, "SZ": 3, "SE": 444, "CH": 522, "SY": 59, "TW": 426, "TJ": 5, "TZ": 22, "TH": 312, "TL": 0, "TG": 3, "TO": 0, "TT": 21, "TN": 43, "TR": 729, "TM": 0, "UG": 17, "UA": 136, "AE": 239, "GB": 2258, "US": 4624, "UY": 40, "UZ": 37, "VU": 0, "VE": 285, "VN": 101, "YE": 30, "ZM": 15, "ZW": 5 },
      		},
      	});
      	window.addEventListener("resize", () => {
      		map.updateSize();
      	});
      });
      // @formatter:off
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-activity'), {
      		chart: {
      			type: "radialBar",
      			fontFamily: 'inherit',
      			height: 40,
      			width: 40,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		plotOptions: {
      			radialBar: {
      				hollow: {
      					margin: 0,
      					size: '75%'
      				},
      				track: {
      					margin: 0
      				},
      				dataLabels: {
      					show: false
      				}
      			}
      		},
      		colors: ["#206bc4"],
      		series: [35],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('chart-development-activity'), {
      		chart: {
      			type: "area",
      			fontFamily: 'inherit',
      			height: 192,
      			sparkline: {
      				enabled: true
      			},
      			animations: {
      				enabled: false
      			},
      		},
      		dataLabels: {
      			enabled: false,
      		},
      		fill: {
      			opacity: .16,
      			type: 'solid'
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      			curve: "smooth",
      		},
      		series: [{
      			name: "Purchases",
      			data: [3, 5, 4, 6, 7, 5, 6, 8, 24, 7, 12, 5, 6, 3, 8, 4, 14, 30, 17, 19, 15, 14, 25, 32, 40, 55, 60, 48, 52, 70]
      		}],
      		grid: {
      			strokeDashArray: 4,
      		},
      		xaxis: {
      			labels: {
      				padding: 0,
      			},
      			tooltip: {
      				enabled: false
      			},
      			axisBorder: {
      				show: false,
      			},
      			type: 'datetime',
      		},
      		yaxis: {
      			labels: {
      				padding: 4
      			},
      		},
      		labels: [
      			'2020-06-20', '2020-06-21', '2020-06-22', '2020-06-23', '2020-06-24', '2020-06-25', '2020-06-26', '2020-06-27', '2020-06-28', '2020-06-29', '2020-06-30', '2020-07-01', '2020-07-02', '2020-07-03', '2020-07-04', '2020-07-05', '2020-07-06', '2020-07-07', '2020-07-08', '2020-07-09', '2020-07-10', '2020-07-11', '2020-07-12', '2020-07-13', '2020-07-14', '2020-07-15', '2020-07-16', '2020-07-17', '2020-07-18', '2020-07-19'
      		],
      		colors: ["#206bc4"],
      		legend: {
      			show: false,
      		},
      		point: {
      			show: false
      		},
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-1'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [17, 24, 20, 10, 5, 1, 4, 18, 13]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-2'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [13, 11, 19, 22, 12, 7, 14, 3, 21]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-3'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [10, 13, 10, 4, 17, 3, 23, 22, 19]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-4'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [6, 15, 13, 13, 5, 7, 17, 20, 19]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-5'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [2, 11, 15, 14, 21, 20, 8, 23, 18, 14]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
    <script>
      // @formatter:off
      document.addEventListener("DOMContentLoaded", function () {
      	window.ApexCharts && (new ApexCharts(document.getElementById('sparkline-bounce-rate-6'), {
      		chart: {
      			type: "line",
      			fontFamily: 'inherit',
      			height: 24,
      			animations: {
      				enabled: false
      			},
      			sparkline: {
      				enabled: true
      			},
      		},
      		tooltip: {
      			enabled: false,
      		},
      		stroke: {
      			width: 2,
      			lineCap: "round",
      		},
      		series: [{
      			color: "#206bc4",
      			data: [22, 12, 7, 14, 3, 21, 8, 23, 18, 14]
      		}],
      	})).render();
      });
      // @formatter:on
    </script>
  </body>
</html>