<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏-->
        <#include "../common/nav.ftl">

<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label for="productName">名称</label>
                            <input type="text" class="form-control" name="productName" value="${(productInfo.productName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="productPrice">价格</label>
                            <input type="number" class="form-control" name="productPrice" value="${(productInfo.productPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="productStock">库存</label>
                            <input type="number" class="form-control" name="productStock" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="productDescription">描述</label>
                            <input type="text" class="form-control" name="productDescription" value="${(productInfo.productDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="productIcon">图片</label>
                            <img src="${(productInfo.productIcon)!''}">
                            <input type="text" class="form-control" name="productIcon" value="${(productInfo.productIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label for="productDescription">类目</label>
                            <select name="categoryType" id="" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                            selected
                                            </#if>
                                    >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>