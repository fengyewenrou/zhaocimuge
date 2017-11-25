<%@page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<style type="text/css">
    #pageLink {
        background-color: #fff;
        height: 50px;
        width: 936px;
        margin-left: 118px;
    }
    #pageTable {
        margin: auto;
        padding: 0 12px;
        text-align: center;
        height: 100%;
    }
    #pageTable td {
        height: 23px;
        padding: 0 5px;
        color: #76746F;
    }
    #pageTable td a {
        display: block;
        height: 23px;
        line-height: 23px;
        font-size: 16px;
        font-family: "Microsoft YaHei", "微软雅黑", "sans-serif";
        border-radius: 2px;
        text-decoration: none;
        text-align: center;
    }
    a:hover {
        text-decoration: none;
    }
    .pre, .next {
        width: 58px;
        color: #76746F;
    }
    .pageIndex {
        /*width: 23px;*/
        color: #76746F;
    }
    .pageIndex:hover, .pre:hover, .next:hover, .go:hover {
        color: #000000;
    }
    .currentIndex {
        color: #fff;
        width: 23px;
        background-color:#ABABAB
    }
    .currentIndex:hover {
        color: #fff;
    }
    .go {
        width: 32px;
        color: #76746F;
    }
    #num {
        padding: 0;
        height: 23px;
        font-size: 14px;
        width: 32px;
        margin-left: 0px;
        border: 1px solid #DDDAD6;
        border-radius: 2px;
    }
    .dot {
        font-size: 25px;
    }
</style>

<div id="pageLink">
    <input type="hidden" id="pageQuery" name="pageQuery" value="0">
    <input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}">
    <table id="pageTable" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <% request.setAttribute("linkSize", 3); %>
            <td><a class="pre" href="javascript:changePage(${page.currentPage - 1})">上一页</a></td>
            <td><a class="${page.currentPage == 1 ? 'currentIndex' : 'pageIndex'}" href="javascript:changePage(1)">1</a></td>
            <c:if test="${page.totalPage > 1}">
                <c:if test="${page.currentPage > linkSize}">
                    <td class="dot">…</td>
                </c:if>
                <c:forEach begin="${page.currentPage > linkSize ? page.currentPage - (linkSize - 2) : 2}" end="${page.totalPage - page.currentPage >= linkSize ? page.currentPage + (linkSize - 2) : page.totalPage - (linkSize - 2)}" step="1" varStatus="status">
                    <td><a class="${page.currentPage == status.index ? 'currentIndex' : 'pageIndex'}" href="javascript:changePage(${status.index})">${status.index}</a></td>
                </c:forEach>
                <c:if test="${page.totalPage - page.currentPage >= linkSize}">
                    <td class="dot">…</td>
                </c:if>
                <td><a class="${page.currentPage == page.totalPage ? 'currentIndex' : 'pageIndex'}" href="javascript:changePage(${page.totalPage})">${page.totalPage}</a></td>
            </c:if>
            <td><a class="next" href="javascript:changePage(${page.currentPage + 1})">下一页</a></td>
            <td><input id="num" class="num" type="text"></td>
            <td><a class="go" href="javascript:changePage(document.getElementById('num').value)">GO</a></td>
        </tr>
    </table>
</div>

<script type="text/javascript">
    function changePage(pageIndex)
    {
        if (pageIndex <= 0) {
            alert("不能在往前了");
            return;
        }
        if (pageIndex > ${page.totalPage}) {
            alert("不能在往后了");
            return;
        }
        document.all.currentPage.value = pageIndex;
        document.all.pageQuery.value = "1";
        document.forms[0].submit();
    }
</script>
