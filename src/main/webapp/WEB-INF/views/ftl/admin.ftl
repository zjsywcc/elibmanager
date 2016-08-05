<#include "template/header.ftl">

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>
            <p class="lead">This is administator page!</p>
        </div>
            <#--<h2>-->
                <#--Welcome: <@security.authentication property="name"/> | <a href="/j_spring_security_logout">Logout</a>-->
            <#--</h2>-->
            <#if Session["SPRING_SECURITY_CONTEXT"]?exists>
                <h2>
                    Welcome: ${Session["SPRING_SECURITY_CONTEXT"].authentication.name} | <a href="/j_spring_security_logout">Logout</a>
                </h2>
            </#if>
        <h3>
            <a href="/admin/bookInventory">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the book inventory!</p>

<#include "template/footer.ftl">

