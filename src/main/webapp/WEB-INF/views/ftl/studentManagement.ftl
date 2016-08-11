<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Manage Student Info</h1>

            <p class="lead">Fill the below information to edit student info:</p>
        </div>

        <section class="container" ng-app="studentManagementApp">
            <div ng-controller="studentManagementCtrl" ng-init="initStudentId(${studentId})">
                <form action="${springMacroRequestContext.contextPath}/rest/studentManagement" method="post"
                      enctype="multipart/form-data">

                <@spring.bind "student.studentId"/>
                    <input type="hidden" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>

                    <div class="form-group">
                        <label for="name">Name</label>
                    <@spring.bind "student.studentName"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                        <input id="name" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value?default("")}"/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                    <@spring.bind "student.studentEmail"/>
                        <input id="email" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value?default("")}"/>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                    <@spring.bind "student.username"/>
                        <input id="username" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value?default("")}"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                    <@spring.bind "student.password"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                        <input id="password" class="form-control" name="${spring.status.expression}"
                               value="${spring.status.value?default("")}"/>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <label class="checkbox-inline"><@spring.formRadioButtons "student.enabled", status, '</label><label class="checkbox-inline">'/></label>
                    </div>
                    <br><br>
                    <input type="submit" value="submit" class="btn btn-default">
                    <a href="/admin/students" class="btn btn-default">Cancel</a>
                </form>
            </div>
        </section>

    <#include "template/footer.ftl">

