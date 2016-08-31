<#include "template/header.ftl">
<div class="container-wrapper">
    <div class="container">
    <#if allFoundBooks ??>
        <#list allFoundBooks as book>
            <div class="books-list">
                <h3><a href="/bookList/viewBook/${book.bookId}" target="_blank"
                       class="l">${book.bookName}</a> &nbsp;</h3>
                <div class="photo">
                <span><a href="/bookList/viewBook/${book.bookId}" target="_blank"><img width="150"
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
            </div>
        </#list>
    </#if>
    <#include "template/footer.ftl">
