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
        <title>我的待办</title>
        <c:import url="/resources/inc/head.jsp" />
    </head>
    <body>
        <div id="main">
            <c:import url="/resources/inc/search.jsp" />
            <div id="toolbar">

            </div>
            <table id="table"></table>
        </div>
        <c:import url="/resources/inc/footer.jsp" />
        <script>
            var $table = $('#table');
            $(function () {
                // bootstrap table初始化
                $table.bootstrapTable({
                    url: '${basePath}/manage/task/mytodolist',
                    height: getHeight(),
                    striped: true,
                    search: false,
                    showRefresh: true,
                    showColumns: true,
                    minimumCountColumns: 2,
                    clickToSelect: true,
                    detailView: true,
                    detailFormatter: 'detailFormatter',
                    pagination: true,
                    paginationLoop: false,
                    sidePagination: 'server',
                    silentSort: false,
                    smartDisplay: false,
                    escape: true,
                    searchOnEnterKey: true,
                    idField: 'taskId',
                    maintainSelected: true,
                    toolbar: '#toolbar',
                    queryParams: function (params) {
                        var str_search = $('#txt_search_key').val();
                        return {
                            offset: params.offset,
                            limit: params.limit,
                            search: str_search
                        };
                    },
                    columns: [
                        {field: 'ck', checkbox: true},
                        {field: 'taskId', title: '编号', sortable: true, align: 'center'},
                        
                    ]
                });
            });
            // 格式化操作按钮
            function actionFormatter(value, row, index) {
                return [
                    '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
                    '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
                ].join('');
            }


            //折叠查询条件
            $('#collapseone').collapse('hide');

            function search() {

                // 刷新表格  
                $('#table').bootstrapTable('refresh');

            }

            //初始化搜索框
            $('#txt_search_key_placeholder').text("任务编号、任务名称、任务描述");
        </script>
    </body>
</html>