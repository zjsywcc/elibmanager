<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Book  Detail</h1>

            <p class="lead">Here is the detail information of the book!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="/resources/images/${book.bookId}.png" alt="image" style="width:100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${book.bookName}</h3>
                    <p>${book.bookAuthor}</p>
                    <p>
                        <strong>Press</strong>: ${book.bookPress}
                    </p>
                    <p>
                        <strong>Edition</strong>: ${book.bookEdition}
                    </p>
                    <p>
                        <strong>Owner</strong>: ${book.bookOwner}
                    </p>
                    <h4>${book.bookPrice} USD</h4>
                    <br>
                <#if username ??><#assign role="${username}" /></#if>
                <#assign url="/bookList"/>
                <#if role ??><#if role="admin">
                    <#assign url="/admin/bookInventory"/>
                </#if></#if>
                    <p>
                        <a href="${url}" class="btn btn-default">Back</a>
                    </p>
                </div>
            </div>
        </div>



    <#include "template/footer.ftl">
