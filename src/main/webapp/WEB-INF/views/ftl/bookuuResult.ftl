<#include "template/header.ftl">
<script>
    $(document).ready(function() {

        $('#w-input-search').autocomplete({
            serviceUrl: '${springMacroRequestContext.contextPath}/student/getBookuuInfos',
            paramName: "searchText",
            delimiter: ",",
            transformResult: function(response) {

                return {

                    suggestions: $.map($.parseJSON(response), function(item) {

                        return { value: item.bookName, data: item.id };
                    })
                };
            }
        });
    });
</script>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <form action="${springMacroRequestContext.contextPath}/student/searchForBooks" method="post">
                <div class="input-group">
                    <input class="form-control" type="text"  id="w-input-search" value="" name="searchText">
                    <span class="input-group-btn">
			        <button class="btn btn-default" id="w-button-search" type="submit">Search</button>
		        </span>
                </div>
            </form>
        </div>
        <div class="container" ng-app="applyApp">
    <#if allFoundBooks ??>
        <#list allFoundBooks as book>
            <div class="books-list">
                <h3><a href="${book.bookUrl}" target="_blank"
                       class="l">${book.bookName}</a> &nbsp;</h3>
                <div class="photo">
                <span><a href="${book.bookUrl}" target="_blank"><img width="150"
                                                                     src="${book.bookImage}"
                                                                     height="150"
                                                                     alt="${book.bookName}"
                                                                     style="width: 150px; height: 150px;"></a></span>
                </div>
                <ul>
                    <li>作者：${book.bookAuthor}</li>
                    <li>出版社：${book.bookPress}</li>
                    <li>价格：${book.bookPrice}</li>
                    <li>版次：${book.bookEdition}</li>
                </ul>
                <p>作品简介</p>
                <div>
                    <p class="ll">
                        <b>${book.bookPress}</b>
                    </p>
                </div>
                <p ng-controller="applyCtrl">
                    <a href="#" class="btn btn-warning btn-lg" ng-click="addToApply(${book.id?long?c})"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                </p>
            </div>
        </#list>
        <#else>
        <p>没找到你想要的图书？前往<a href="/student/applyForBooks">手动提交</a></p>
    </#if>
        </div>
        <script src="/resources/js/controller.js"></script>
    <#include "template/footer.ftl">
