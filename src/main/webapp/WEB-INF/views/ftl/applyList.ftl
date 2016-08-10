<#include "template/header.ftl">
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Apply List</h1>

                    <p>All the books you have chosen in your list</p>
                </div>
            </div>
        </section>

        <section class="container" ng-app="applyApp">
            <div ng-controller="applyCtrl" ng-init="initApplyId(${applyId})">
                <div>
                    <a class="btn btn-danger pull-left" ng-click="clearApply()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Apply</a>
                    <a class="btn btn-success pull-right" ng-click="createOrder()"><span class="glyphicon glyphicon-shopping-cart"></span>Submit Apply</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>书名</th>
                        <th>作者</th>
                        <th>出版社</th>
                        <th>价格</th>
                        <th>版次</th>
                        <th>ISBN</th>
                        <th>持有者</th>
                        <th>Action</th>
                    </tr>
                    <tr ng-repeat="item in apply.applyItems">
                        <td>{{item.book.bookName}}</td>
                        <td>{{item.book.bookAuthor}}</td>
                        <td>{{item.book.bookPress}}</td>
                        <td>{{item.book.bookPrice}}</td>
                        <td>{{item.book.bookEdition}}</td>
                        <td>{{item.book.bookISBN}}</td>
                        <td>{{item.book.bookOwner}}</td>
                        <td><a href="#" class="label label-danger" ng-click="removeFromApply(item.book.bookId)"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>Grand Total</th>
                        <th>{{applyGrandTotal()}}</th>
                        <th></th>
                    </tr>
                </table>

                <a href="/bookList" class="btn btn-default">等待上架中</a>
            </div>
        </section>

<script src="/resources/js/controller.js"></script>
<#include "template/footer.ftl">
