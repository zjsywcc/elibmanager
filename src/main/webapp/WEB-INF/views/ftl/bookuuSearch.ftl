<#include "template/header.ftl"/>



<div class="container-wrapper">
    <div class="container">
        <form action="${springMacroRequestContext.contextPath}/student/searchForBooks" method="post">
            <div class="input-group">
                <input class="form-control" type="text"  id="w-input-search" value="" name="searchText">
                <span class="input-group-btn">
			        <button class="btn btn-default" id="w-button-search" type="submit">Search</button>
		        </span>
            </div>

        </form>

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



    <#include "template/footer.ftl"/>
