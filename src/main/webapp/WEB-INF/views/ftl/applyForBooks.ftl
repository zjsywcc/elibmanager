<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Apply for  Books(Three at most)</h1>

            <p class="lead">Fill the below information to apply for three books:</p>
        </div>

        <form action="${springMacroRequestContext.contextPath}/student/applyForBooks" method="post"
              enctype="multipart/form-data">

            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookStatus</#assign>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="status" type="hidden" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </#list>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookName</#assign>
                <div class="form-group col-md-4">
                    <label for="name">Name</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="name" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookAuthor</#assign>
                <div class="form-group col-md-4">
                    <label for="author">Author</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="author" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookPress</#assign>
                <div class="form-group col-md-4">
                    <label for="press">Press</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="press" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookPrice</#assign>
                <div class="form-group col-md-4">
                    <label for="price">Price</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="price" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookEdition</#assign>
                <div class="form-group col-md-4">
                    <label for="edition">Edition</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="edition" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookISBN</#assign>
                <div class="form-group col-md-4">
                    <label for="ISBN">ISBN</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="ISBN" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list bookListWrapper.bookList as book>
                <#assign item>bookListWrapper.bookList[${book_index}].bookOwner</#assign>
                <div class="form-group col-md-4">
                    <label for="owner">Owner</label>
                    <@spring.bind item/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="owner" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <br><br>
            <input type="submit" value="submit" class="btn btn-default">
            <a href="/student/myBooks" class="btn btn-default">Cancel</a>
        </form>

    <#include "template/footer.ftl">

