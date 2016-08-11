<#include "template/header.ftl"/>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Students</h1>

            <p class="lead">Check out students and book requests:</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>姓名</th>
                <th>邮箱</th>
                <th>用户名</th>
                <th>状态</th>
                <th>申请</th>
                <th>管理</th>
                <th>删除</th>
            </tr>
            </thead>
        <#if students??>
            <#list students as student>
                <tr>
                    <td>${student.studentName}</td>
                    <td>${student.studentEmail}</td>
                    <td>${student.username}</td>
                    <td>${student.enabled}</td>
                    <td>
                        <a href="/admin/students/bookApply/${student.studentId}"><span class="glyphicon glyphicon-info-sign"></span></a>
                    </td>
                    <td>
                        <a href="/admin/students/studentManagement/${student.studentId}"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                    <td>
                        <a href="/rest/studentManagement/deleteStudent/${student.studentId}"><span class="glyphicon glyphicon-remove"></span></a>
                    </td>
                </tr>
            </#list>
        </#if>
        </table>


    <#include "template/footer.ftl"/>
