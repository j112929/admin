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
	                <header class="panel-heading">活动类型：团购</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                            <tr>                    
                                <td class="col-sm-2">活动有效时间:</td>
                                <td class="col-sm-4">${couponTO.coupon.couponName}</td>
                                <td class="col-sm-2">距离活动结束:</td>
                                <td class="col-sm-4">${couponTO.coupon.total}</td>
                            </tr>
                            <tr>                    
                                <td class="col-sm-2">成团人数：</td>
                                <td class="col-sm-2">
                                    <fmt:formatDate value="${couponTO.coupon.validStime}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td class="col-sm-2">当前参团人数:</td>
                                <td class="col-sm-2">
                                    <fmt:formatDate value="${couponTO.coupon.validEtime}" pattern="yyyy-MM-dd"/>
                                </td>
                                
                            </tr>
                            <tr>                    
                                <td class="col-sm-2">实际参团人数：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponTO.coupon.grantStime}" pattern="yyyy-MM-dd"/>
                                </td>
                                <td class="col-sm-2">供应商简称:</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponTO.coupon.grantEtime}" pattern="yyyy-MM-dd"/>
                                </td>
                            </tr>
                            <tr>                    
                                <td class="col-sm-2">商品SKU编号:</td>
                                <td class="col-sm-4">
                                    <c:if test="${couponTO.coupon.couponType == 0}">全场</c:if>
                                    <c:if test="${couponTO.coupon.couponType == 1}">满减</c:if>
                                </td>
                                <td class="col-sm-2">商品名称:</td>
                                <td class="col-sm-4">${couponTO.coupon.faceValue}</td>
                            </tr>
                            <tr>                    
                                <td class="col-sm-2">商品分类:</td>
                                <td class="col-sm-4">
                                    <c:if test="${couponTO.coupon.couponType == 0}">全场</c:if>
                                    <c:if test="${couponTO.coupon.couponType == 1}">满减</c:if>
                                </td>
                                <td class="col-sm-2">商品规格:</td>
                                <td class="col-sm-4">${couponTO.coupon.faceValue}</td>
                            </tr>
                             <tr>                    
                                <td class="col-sm-2">出售价(元)</td>
                                <td class="col-sm-4">
                                    <c:if test="${couponTO.coupon.couponType == 0}">全场</c:if>
                                    <c:if test="${couponTO.coupon.couponType == 1}">满减</c:if>
                                
                            </tr>
                           
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/coupon/js/category.detail.js" type="text/javascript"></script>