<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Apply for  Books(Three at most)</h1>

            <p class="lead">Fill the below information to apply for three books:</p>
        </div>

        <form action="${springMacroRequestContext.contextPath}/admin/bookInventory/addBook" method="post"
              enctype="multipart/form-data">
            <div class="row">
            <#list books as i>
            <div class="form-group col-md-4">
                <label for="name">Name</label>
                <@spring.bind "books[${i_index}].bookName"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="name" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>

                <div class="form-group col-md-4">
                    <label for="author">Author</label>
                    <@spring.bind "books[${i_index}].bookAuthor"/>
                    <input id="author" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>
                <div class="form-group col-md-4">
                    <label for="press">Press</label>
                    <@spring.bind "books[${i_index}].bookPress"/>
                    <input id="press" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>
                <div class="form-group col-md-4">
                    <label for="price">Price</label>
                    <@spring.bind "books[${i_index}].bookPrice"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                    <input id="price" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>
                <div class="form-group col-md-4">
                    <label for="edition">Edition</label>
                    <@spring.bind "books[${i_index}].bookEdition"/>
                    <input id="edition" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>
                <div class="form-group col-md-4">
                    <label for="ISBN">ISBN</label>
                    <@spring.bind "books[${i_index}].bookISBN"/>
                    <input id="ISBN" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <div class="row">
            <#list books as i>
                <div class="form-group col-md-4">
                    <label for="owner">Owner</label>
                    <@spring.bind "books[${i_index}].bookOwner"/>
                    <input id="owner" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
                </div>
            </#list>
            </div>

            <br><br>
            <input type="submit" value="submit" class="btn btn-default">
            <a href="/admin/bookInventory" class="btn btn-default">Cancel</a>
        </form>

    <#include "template/footer.ftl">

