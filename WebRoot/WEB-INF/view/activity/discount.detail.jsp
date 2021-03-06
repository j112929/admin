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
	                <header class="panel-heading">限时折扣活动：本金购买，商户发起详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${activityDiscount.id}</td>
                                <td class="col-sm-2">名称：</td>
                                <td class="col-sm-4">${activityDiscount.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品sku：</td>
                                <td class="col-sm-4">${activityDiscount.skuId}</td>
                                <td class="col-sm-2">每人限购数量：</td>
                                <td class="col-sm-4">${activityDiscount.maxBuyQuantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">价格：</td>
                                <td class="col-sm-4">${activityDiscount.price}</td>
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${activityDiscount.sortOrder}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">描述：</td>
                                <td class="col-sm-4">${activityDiscount.description}</td>
                                <td class="col-sm-2">开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityDiscount.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityDiscount.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${activityDiscount.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityDiscount.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${activityDiscount.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityDiscount.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
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
<script src="${STATIC_URL}/modules/activity/js/discount.detail.js" type="text/javascript"></script>
