<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<script>var BASE_PATH = '${basePath}';</script>
<script src="<c:url value="/resources/admin/plugins/jquery.1.12.4.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/bootstrap-3.3.0/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/bootstrap-table-1.11.0/bootstrap-table.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/bootstrap-table-1.11.0/locale/bootstrap-table-zh-CN.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/waves-0.7.5/waves.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/jquery-confirm/jquery-confirm.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/select2/js/select2.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/zTree_v3/js/jquery.ztree.all.min.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/webuploader-0.1.5/webuploader.min.js" />"></script>
<script src="<c:url value="/resources/admin/js/common.js" />"></script>
<script src="<c:url value="/resources/admin/plugins/personselect/js/select.js" />"></script>