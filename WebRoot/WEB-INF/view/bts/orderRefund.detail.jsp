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
	                <header class="panel-heading">退货单表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">退货单id：</td>
                                <td class="col-sm-4">${btsOrderRefund.id}</td>
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${btsOrderRefund.userId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">店铺id：</td>
                                <td class="col-sm-4">${btsOrderRefund.shopId}</td>
                                <td class="col-sm-2">退货单号：</td>
                                <td class="col-sm-4">${btsOrderRefund.refundNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">订单明细id：</td>
                                <td class="col-sm-4">${btsOrderRefund.orderItemsId}</td>
                                <td class="col-sm-2">退货商品数量：</td>
                                <td class="col-sm-4">${btsOrderRefund.quantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">退货原因：</td>
                                <td class="col-sm-4">${btsOrderRefund.reason}</td>
                                <td class="col-sm-2">图片地址：</td>
                                <td class="col-sm-4">${btsOrderRefund.pics}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">退货单状态：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderRefund.status == 0}">
									取消申请
									</c:if>
									<c:if test="${btsOrderRefund.status == 1}">
									申请退货
									</c:if>
									<c:if test="${btsOrderRefund.status == 2}">
									审批通过
									</c:if>
									<c:if test="${btsOrderRefund.status == 3}">
									审批拒绝
									</c:if>
									<c:if test="${btsOrderRefund.status == 4}">
									退款完成
									</c:if>
								</td>
                                <td class="col-sm-2">退款金额：</td>
                                <td class="col-sm-4">${btsOrderRefund.refundAmount}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否评价：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderRefund.isComment == 0}">
									未评价
									</c:if>
									<c:if test="${btsOrderRefund.isComment == 1}">
									已评价
									</c:if>
								</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderRefund.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderRefund.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/bts/js/orderRefund.detail.js" type="text/javascript"></script>
