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
	                <header class="panel-heading">商品订单明细表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">订单明细id：</td>
                                <td class="col-sm-4">${btsOrderItems.id}</td>
                                <td class="col-sm-2">子订单号：</td>
                                <td class="col-sm-4">${btsOrderItems.orderChildNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${btsOrderItems.userId}</td>
                                <td class="col-sm-2">订单明细备注：</td>
                                <td class="col-sm-4">${btsOrderItems.remark}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商户id：</td>
                                <td class="col-sm-4">${btsOrderItems.merchantId}</td>
                                <td class="col-sm-2">商品spu：</td>
                                <td class="col-sm-4">${btsOrderItems.spuId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品sku：</td>
                                <td class="col-sm-4">${btsOrderItems.skuId}</td>
                                <td class="col-sm-2">商品名称：</td>
                                <td class="col-sm-4">${btsOrderItems.goodsName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品图片：</td>
                                <td class="col-sm-4">${btsOrderItems.goodsPic}</td>
								<td class="col-sm-2">属性：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderItems.propertys == 1}">
									""valueName""白色"}{"id""
									</c:if>
									<c:if test="${btsOrderItems.propertys == 3}">
									""name""颜色""value""
									</c:if>
									<c:if test="${btsOrderItems.propertys == 4}">
									""name""尺码""value""1""valueName""X码"}]
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品数量：</td>
                                <td class="col-sm-4">${btsOrderItems.quantity}</td>
                                <td class="col-sm-2">已退数量：</td>
                                <td class="col-sm-4">${btsOrderItems.refundQuantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">原价：</td>
                                <td class="col-sm-4">${btsOrderItems.goodsOriginalPrice}</td>
                                <td class="col-sm-2">现价：</td>
                                <td class="col-sm-4">${btsOrderItems.goodsPrice}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品总价：</td>
                                <td class="col-sm-4">${btsOrderItems.goodsAmount}</td>
                                <td class="col-sm-2">优惠金额：</td>
                                <td class="col-sm-4">${btsOrderItems.couponAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">积分总价：</td>
                                <td class="col-sm-4">${btsOrderItems.pointAmount}</td>
                                <td class="col-sm-2">金币抵扣金额：</td>
                                <td class="col-sm-4">${btsOrderItems.discountAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">运费：</td>
                                <td class="col-sm-4">${btsOrderItems.freightAmount}</td>
                                <td class="col-sm-2">应付金额：</td>
                                <td class="col-sm-4">${btsOrderItems.payableAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">实付金额：</td>
                                <td class="col-sm-4">${btsOrderItems.payAmount}</td>
								<td class="col-sm-2">是否评价：</td>
                                <td class="col-sm-4">
									<c:if test="${btsOrderItems.isComment == 0}">
									未评价
									</c:if>
									<c:if test="${btsOrderItems.isComment == 1}">
									已评价
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderItems.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${btsOrderItems.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/bts/js/orderItems.detail.js" type="text/javascript"></script>
