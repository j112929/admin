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
	                <header class="panel-heading">商品订单子表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">子订单id：</td>
                                <td class="col-sm-4">${btsOrderChild.id}</td>
                                <td class="col-sm-2">订单号：</td>
                                <td class="col-sm-4">${btsOrderChild.orderNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">子订单号：</td>
                                <td class="col-sm-4">${btsOrderChild.orderChildNo}</td>
								<td class="col-sm-2">订单类型：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.type == 1}">
									普通
									</c:if>
									<c:if test="${btsOrderChild.type == 2}">
									折扣
									</c:if>
									<c:if test="${btsOrderChild.type == 3}">
									团购
									</c:if>
									<c:if test="${btsOrderChild.type == 4}">
									秒杀
									</c:if>
									<c:if test="${btsOrderChild.type == 5}">
									抽奖
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${btsOrderChild.userId}</td>
                                <td class="col-sm-2">商户id：</td>
                                <td class="col-sm-4">${btsOrderChild.merchantId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">子订单备注：</td>
                                <td class="col-sm-4">${btsOrderChild.remark}</td>
                                <td class="col-sm-2">给卖家留言：</td>
                                <td class="col-sm-4">${btsOrderChild.leaveMessage}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">快递类型：</td>
                                <td class="col-sm-4">${btsOrderChild.expressType}</td>
                                <td class="col-sm-2">快递单号：</td>
                                <td class="col-sm-4">${btsOrderChild.expressNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">发票抬头：</td>
                                <td class="col-sm-4">${btsOrderChild.invoiceTitle}</td>
								<td class="col-sm-2">订单状态：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.status == 1}">
									待付款
									</c:if>
									<c:if test="${btsOrderChild.status == 2}">
									待发货
									</c:if>
									<c:if test="${btsOrderChild.status == 3}">
									待收货
									</c:if>
									<c:if test="${btsOrderChild.status == 4}">
									待评价
									</c:if>
									<c:if test="${btsOrderChild.status == 5}">
									退款
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否取消：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.isCancel == 0}">
									未取消
									</c:if>
									<c:if test="${btsOrderChild.isCancel == 1}">
									已取消
									</c:if>
								</td>
                                <td class="col-sm-2">取消原因：</td>
                                <td class="col-sm-4">${btsOrderChild.cancelReason}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${btsOrderChild.isDel == 1}">
									删除
									</c:if>
								</td>
                                <td class="col-sm-2">商品总价：</td>
                                <td class="col-sm-4">${btsOrderChild.goodsAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">优惠金额：</td>
                                <td class="col-sm-4">${btsOrderChild.couponAmount}</td>
                                <td class="col-sm-2">积分总价：</td>
                                <td class="col-sm-4">${btsOrderChild.pointAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">运费：</td>
                                <td class="col-sm-4">${btsOrderChild.freightAmount}</td>
                                <td class="col-sm-2">应付金额：</td>
                                <td class="col-sm-4">${btsOrderChild.payableAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">实付金额：</td>
                                <td class="col-sm-4">${btsOrderChild.payAmount}</td>
								<td class="col-sm-2">支付订单类型：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.payOrderType == 1}">
									主订单
									</c:if>
									<c:if test="${btsOrderChild.payOrderType == 2}">
									子订单
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">支付方式：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.payType == 1}">
									本金支付
									</c:if>
									<c:if test="${btsOrderChild.payType == 2}">
									积分支付
									</c:if>
								</td>
								<td class="col-sm-2">支付状态：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderChild.payStatus == 0}">
									未支付
									</c:if>
									<c:if test="${btsOrderChild.payStatus == 1}">
									已支付
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">支付时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderChild.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">兴支付流水号：</td>
                                <td class="col-sm-4">${btsOrderChild.sno}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderChild.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/bts/js/orderChild.detail.js" type="text/javascript"></script>
