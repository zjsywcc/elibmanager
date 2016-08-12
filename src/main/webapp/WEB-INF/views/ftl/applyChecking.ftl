<#include "template/header.ftl"/>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Checking student requests:</h1>

            <p class="lead">Check if books is available and put them on shelf</p>
        </div>

    <#if studentOrders??><#list studentOrders as studentOrder>
        <#assign books = studentOrder.bookList/>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>价格</th>
                <th>版次</th>
                <th>ISBN</th>
                <th>申请人</th>
                <th>状态</th>
                <th>上架</th>
                <th>删除</th>
            </tr>
            </thead>
            <#if books??>
                <#list books as book>
                    <tr>
                        <td>${book.bookName}</td>
                        <td>${book.bookAuthor}</td>
                        <td>${book.bookPress}</td>
                        <td>${book.bookPrice}</td>
                        <td>${book.bookEdition}</td>
                        <td>${book.bookISBN}</td>
                        <td>${book.bookOwner}</td>
                        <td>${book.bookStatus}</td>
                        <td>
                            <a href="/admin/students/bookApply/checkBook/${book.bookId}" class="btn btn-primary">上架</a>
                        </td>
                        <td>
                            <a href="/admin/students/bookApply/deleteApply/${book.bookId}" class="btn btn-danger">删除</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
        <a href="/admin/students/bookApply/deleteApply?order=${studentOrder.studentOrderId}"
           class="btn btn-danger pull-left">删除全部</a>
        <a href="/admin/students/bookApply/checkBook?order=${studentOrder.studentOrderId}"
           class="btn btn-primary pull-right">上架全部</a>
        <br><br>
    </#list>
        <a href="/admin/students/bookApply/deleteApply?student=${studentId}" class="btn btn-danger pull-left">删除全部</a>
        <a href="/admin/students/bookApply/checkBook?student=${studentId}" class="btn btn-primary pull-right">上架全部</a>
    </#if>


    <#include "template/footer.ftl"/>
