<#include "template/header.ftl"/>

<script>
    $(document).ready(function(){

        $('.table').DataTable({
            "lengthMenu": [[5,10, -1], [5,10, "All"]]
        });
    });
</script>

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
                <th>状态</th>
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
                    <td>${book.bookStatus}</td>
                    <td>
                        <a href="/bookList/viewBook/${book.bookId}"><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="/admin/bookInventory/editBook/${book.bookId}"><span class="glyphicon glyphicon-pencil"></span></a>
                        <a href="/admin/bookInventory/deleteBook/${book.bookId}"><span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </#list>
        </#if>
        </table>

        <a href="/admin/bookInventory/addBook" class="btn btn-primary">添加图书</a>
    <#include "template/footer.ftl"/>
