<#include "template/header.ftl"/>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Books</h1>

            <p class="lead">Checkout all the books in the lab!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>价格</th>
                <th>版次</th>
                <th>ISBN</th>
                <th>持有者</th>
                <th></th>
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
                    <td>
                        <a href="/bookList/viewBook/${book.bookId}" class="glyphicon glyphicon-info-sign"></a>
                        <a href="/admin/bookInventory/editBook/${book.bookId}" class="glyphicon glyphicon-pencil"></a>
                        <a href="/admin/bookInventory/deleteBook/${book.bookId}" class="glyphicon glyphicon-remove"></a>
                    </td>
                </tr>
            </#list>
        </#if>
        </table>

        <a href="/admin/bookInventory/addBook" class="btn btn-primary">添加图书</a>
    <#include "template/footer.ftl"/>
