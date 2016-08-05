<#include "template/header.ftl"/>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Login Page</h1>
            <p class="lead">Login with username and password</p>
        </div>
        <div id="login-box">
            <#if msg??>
                <div class="msg">${msg}</div>
            </#if>

            <form name="loginForm" action="/j_spring_security_check" method="post">
                <#if error??>
                    <div class="error" style="color: #ff0000">${error}</div>
                </#if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control"/>
                </div>

                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </div>

                <input type="submit" value="submit" class="btn btn-default"/>
            </form>
        </div>


<#include "template/footer.ftl"/>
