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
	                <header class="panel-heading">抽奖明细详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${activityLotteryItem.id}</td>
                                <td class="col-sm-2">抽奖活动id：</td>
                                <td class="col-sm-4">${activityLotteryItem.lotteryId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品sku：</td>
                                <td class="col-sm-4">${activityLotteryItem.skuId}</td>
                                <td class="col-sm-2">位置：</td>
                                <td class="col-sm-4">${activityLotteryItem.position}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">图片：</td>
                                <td class="col-sm-4">${activityLotteryItem.pic}</td>
                                <td class="col-sm-2">商品数量：</td>
                                <td class="col-sm-4">${activityLotteryItem.quantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品剩余数量：</td>
                                <td class="col-sm-4">${activityLotteryItem.remainQuantity}</td>
                                <td class="col-sm-2">结算价格：</td>
                                <td class="col-sm-4">${activityLotteryItem.settlementPrice}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLotteryItem.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLotteryItem.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/activity/js/lotteryItem.detail.js" type="text/javascript"></script>
