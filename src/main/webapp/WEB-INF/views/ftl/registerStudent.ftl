<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register as a student</h1>

            <p class="lead">Please fill in your information below:</p>
        </div>

        <form action="${springMacroRequestContext.contextPath}/register" method="post"
              >
            <h3>Basic Info</h3>
            <div class="form-group">
                <label for="name">Name</label>
                <@spring.bind "student.studentName"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="name" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <@spring.bind "student.studentEmail"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="email" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <@spring.bind "student.username"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="username" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <@spring.bind "student.password"/><#if spring.status.error><@spring.showErrors "" "color: #ff0000"/></#if>
                <input id="password" class="form-control" name="${spring.status.expression}" value="${spring.status.value?default("")}"/>
            </div>

            <br><br>
            <input type="submit" value="submit" class="btn btn-default">
            <a href="/" class="btn btn-default">Cancel</a>
        </form>

    <#include "template/footer.ftl">

