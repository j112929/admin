<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<section class="hbox stretch">
    <aside class="bg-white">
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="m-t-sm">
                    <a href="#subNav" data-toggle="class:hide" class="btn btn-sm btn-default active btn-nav-goods" btn_nav_goods_index="0">
                        <i class="fa fa-caret-right text fa-lg"></i>
                        <i class="fa fa-caret-left text-active fa-lg"></i>
                    </a>
                        <a href="javascript:;" class="btn btn-sm btn-default" id="button_cancel"><i class="fa fa-reply"></i> 返回</a>
                </div>
            </header>
              
            <section class="scrollable wrapper">
                <section class="panel panel-default portlet-item">
	                <header class="panel-heading">优惠折扣关联商品表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">Id：</td>
                                <td class="col-sm-4">${permissionDiscountsGoods.id}</td>
                                <td class="col-sm-2">优惠折扣ID：</td>
                                <td class="col-sm-4">${permissionDiscountsGoods.discountId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">折扣出售价格：</td>
                                <td class="col-sm-4">${permissionDiscountsGoods.price}</td>
                                <td class="col-sm-2">商品：</td>
                                <td class="col-sm-4">${permissionDiscountsGoods.skuId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品名称：</td>
                                <td class="col-sm-4">${permissionDiscountsGoods.goodsName}</td>
                                <td class="col-sm-2"></td>
                                <td class="col-sm-4"></td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/back/modules/permission/js/discountsGoods.detail.js" type="text/javascript"></script>
