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
	                <header class="panel-heading">商品订单表，存放主订单编号，收货人信息等详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">订单id：</td>
                                <td class="col-sm-4">${btsOrder.id}</td>
                                <td class="col-sm-2">订单号：</td>
                                <td class="col-sm-4">${btsOrder.orderNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${btsOrder.userId}</td>
                                <td class="col-sm-2">订单备注：</td>
                                <td class="col-sm-4">${btsOrder.remark}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">收货地区id：</td>
                                <td class="col-sm-4">${btsOrder.consigneeRegionId}</td>
                                <td class="col-sm-2">收货地区名称全称：</td>
                                <td class="col-sm-4">${btsOrder.consigneeRegionName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">收货人详细地址：</td>
                                <td class="col-sm-4">${btsOrder.consigneeAddress}</td>
                                <td class="col-sm-2">收货人姓名：</td>
                                <td class="col-sm-4">${btsOrder.consigneeName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">收货人邮箱：</td>
                                <td class="col-sm-4">${btsOrder.consigneeEmail}</td>
                                <td class="col-sm-2">收货人邮编：</td>
                                <td class="col-sm-4">${btsOrder.consigneeZipcode}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">收货人手机号：</td>
                                <td class="col-sm-4">${btsOrder.consigneeMobileNo}</td>
								<td class="col-sm-2">订单状态：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrder.status == 1}">
									待付款
									</c:if>
									<c:if test="${btsOrder.status == 2}">
									已付款
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否取消：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrder.isCancel == 0}">
									未取消
									</c:if>
									<c:if test="${btsOrder.isCancel == 1}">
									已取消
									</c:if>
								</td>
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrder.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${btsOrder.isDel == 1}">
									删除
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品总价：</td>
                                <td class="col-sm-4">${btsOrder.goodsAmount}</td>
                                <td class="col-sm-2">金币抵扣金额：</td>
                                <td class="col-sm-4">${btsOrder.discountAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">运费：</td>
                                <td class="col-sm-4">${btsOrder.freightAmount}</td>
                                <td class="col-sm-2">应付金额：</td>
                                <td class="col-sm-4">${btsOrder.payableAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">实付金额：</td>
                                <td class="col-sm-4">${btsOrder.payAmount}</td>
								<td class="col-sm-2">支付方式：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrder.payType == 1}">
									本金支付
									</c:if>
									<c:if test="${btsOrder.payType == 2}">
									积分支付
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">支付时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrder.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrder.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/bts/js/order.detail.js" type="text/javascript"></script>
