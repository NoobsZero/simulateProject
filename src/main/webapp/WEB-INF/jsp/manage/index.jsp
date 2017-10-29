<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SMG权限管理中心</title>

        <link href="<c:url value="/resources/admin/plugins/bootstrap-3.3.0/css/bootstrap.min.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/admin/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/admin/plugins/waves-0.7.5/waves.min.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/admin/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.min.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/admin/css/admin.css" />" rel="stylesheet"/>

        <style>
            /** skins **/
            <c:forEach var="upmsSystem" items="${upmsSystems}">
                #${upmsSystem.name} #header {background: ${upmsSystem.theme};}
                #${upmsSystem.name} .content_tab{background: ${upmsSystem.theme};}
                #${upmsSystem.name} .s-profile>a{background: url(<c:url value="${upmsSystem.banner}" />) left top no-repeat;}
            </c:forEach>
        </style>
    </head>
    <body>
        <header id="header">
            <ul id="menu">
                <li id="guide" class="line-trigger">
                    <div class="line-wrap">
                        <div class="line top"></div>
                        <div class="line center"></div>
                        <div class="line bottom"></div>
                    </div>
                </li>
                <li id="logo" class="hidden-xs">
                    <span id="system_title">SMG权限管理中心</span>
                </li>
                <li class="pull-right">
                    <ul class="hi-menu">
                        <!-- 搜索 -->
                        <li class="dropdown">
                            <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                                <i class="him-icon zmdi zmdi-search"></i>
                            </a>
                            <ul class="dropdown-menu dm-icon pull-right">
                                <form id="search-form" class="form-inline">
                                    <div class="input-group">
                                        <input id="keywords" type="text" name="keywords" class="form-control" placeholder="搜索"/>
                                        <div class="input-group-btn">
                                            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                                        </div>
                                    </div>
                                </form>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                                <i class="him-icon zmdi zmdi-dropbox"></i>
                            </a>
                            <ul class="dropdown-menu dm-icon pull-right">
                                <li class="skin-switch hidden-xs">
                                    请选择系统切换
                                </li>
                                <li class="divider hidden-xs"></li>
                                    <c:forEach var="upmsSystem" items="${upmsSystems}">
                                    <li>
                                        <a class="waves-effect switch-systems" href="javascript:;" systemid="${upmsSystem.systemId}" systemname="${upmsSystem.name}" systemtitle="${upmsSystem.title}"><i class="${upmsSystem.icon}"></i> ${upmsSystem.title}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                                <i class="him-icon zmdi zmdi-more-vert"></i>
                            </a>
                            <ul class="dropdown-menu dm-icon pull-right">
                                <li class="hidden-xs">
                                    <a class="waves-effect" data-ma-action="fullscreen" href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
                                </li>
                                <li>
                                    <a class="waves-effect" data-ma-action="clear-localstorage" href="javascript:;"><i class="zmdi zmdi-delete"></i> 清除缓存</a>
                                </li>
                                <li>
                                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                                </li>
                                <li>
                                    <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
                                </li>
                                <li>
                                    <a class="waves-effect" href="javascript:Tab.addTab('修改密码', '<c:url value="/manage/user/modipass" />');"><i class="zmdi zmdi-archive"></i> 修改密码</a>
                                </li>
                                <li>
                                    <a class="waves-effect" href="<c:url value="/sso/logout" />"><i class="zmdi zmdi-run"></i> 退出登录</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </header>
        <section id="main">
            <!-- 左侧导航区 -->
            <aside id="sidebar">
                <!-- 个人资料区 -->
                <div class="s-profile">
                    <a class="waves-effect waves-light" href="javascript:;">
                        <div class="sp-pic">
                            <img src="<c:url value="${upmsUser.avatar}" />"/>
                        </div>
                        <div class="sp-info">
                            ${upmsUser.realname}，您好！
                            <i class="zmdi zmdi-caret-down"></i>
                        </div>
                    </a>
                    <ul class="main-menu">
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-account"></i> 个人资料</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-face"></i> 隐私管理</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:;"><i class="zmdi zmdi-settings"></i> 系统设置</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="javascript:Tab.addTab('修改密码', '<c:url value="/manage/user/modipass" />');"><i class="zmdi zmdi-archive"></i> 修改密码</a>
                        </li>
                        <li>
                            <a class="waves-effect" href="<c:url value="/sso/logout" />"><i class="zmdi zmdi-run"></i> 退出登录</a>
                        </li>
                    </ul>
                </div>
                <!-- /个人资料区 -->
                <!-- 菜单区 -->
                <ul class="main-menu">
                    <li>
                        <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i class="zmdi zmdi-home"></i> 首页</a>
                    </li>
                    <c:forEach var="upmsPermission" items="${upmsPermissions}" varStatus="status">
                        <c:if test="${upmsPermission.pid == 0}">
                            <li class="sub-menu system_menus system_${upmsPermission.systemId} ${status.index}" <c:if test="${upmsPermission.systemId != 1}">style="display:none;"</c:if>>
                                <a class="waves-effect" href="javascript:;"><i class="${upmsPermission.icon}"></i> ${upmsPermission.name}</a>
                                <ul>
                                    <c:forEach var="subUpmsPermission" items="${upmsPermissions}">
                                        <c:if test="${subUpmsPermission.pid == upmsPermission.permissionId}">
                                            <c:forEach var="upmsSystem" items="${upmsSystems}">
                                                <c:if test="${subUpmsPermission.systemId == upmsSystem.systemId}">
                                                    <c:set var="systemBasePath" value="${upmsSystem.basepath}"/></c:if>
                                            </c:forEach>
                                            <li><a class="waves-effect" href="javascript:Tab.addTab('${subUpmsPermission.name}', '${systemBasePath}${subUpmsPermission.uri}');">${subUpmsPermission.name}</a></li>
                                            </c:if>
                                        </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                <!-- /菜单区 -->
            </aside>
            <!-- /左侧导航区 -->
            <section id="content">
                <div class="content_tab">
                    <div class="tab_left">
                        <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
                    </div>
                    <div class="tab_right">
                        <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
                    </div>
                    <ul id="tabs" class="tabs">
                        <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                            <a class="waves-effect waves-light" href="javascript:;">首页</a>
                        </li>
                    </ul>
                </div>
                <div class="content_main">
                    <div id="iframe_home" class="iframe cur">
                        <p><h4>欢迎进入SMG权限管理中心</h4></p>
                    </div>
                </div>
            </section>
        </section>
        <footer id="footer"></footer>
        <script src="<c:url value="/resources/admin/plugins/jquery.1.12.4.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/waves-0.7.5/waves.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/BootstrapMenu.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/device.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/jquery.cookie.js" />"></script>
        <script src="<c:url value="/resources/admin/js/admin.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/fullPage/jquery.fullPage.min.js" />"></script>
        <script src="<c:url value="/resources/admin/plugins/fullPage/jquery.jdirk.min.js" />"></script>

        <script>
            // 修改密码
            var modifyPasswdDialog;
            function modifyPasswdAction() {
                alert("hello");
            }
        </script>
    </body>
</html>
