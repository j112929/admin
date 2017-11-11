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
	                <header class="panel-heading">对账表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${financeReconciliation.id}</td>
                                <td class="col-sm-2">批次号：</td>
                                <td class="col-sm-4">${financeReconciliation.batchNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">交易流水号：</td>
                                <td class="col-sm-4">${financeReconciliation.sno}</td>
                                <td class="col-sm-2">支付方式：</td>
                                <td class="col-sm-4">${financeReconciliation.payType}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">订单号：</td>
                                <td class="col-sm-4">${financeReconciliation.orderNo}</td>
                                <td class="col-sm-2">币种：</td>
                                <td class="col-sm-4">${financeReconciliation.cur}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">我方交易金额：</td>
                                <td class="col-sm-4">${financeReconciliation.mtransAmt}</td>
                                <td class="col-sm-2">收银台方交易金额：</td>
                                <td class="col-sm-4">${financeReconciliation.transAmt}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">我方交易积分：</td>
                                <td class="col-sm-4">${financeReconciliation.mintegral}</td>
                                <td class="col-sm-2">收银台方交易积分：</td>
                                <td class="col-sm-4">${financeReconciliation.tintegral}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">交易类型：</td>
                                <td class="col-sm-4">
									<c:if test="${financeReconciliation.businessDea == 0}">
									退款
									</c:if>
									<c:if test="${financeReconciliation.businessDea == 1}">
									购买
									</c:if>
								</td>
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${financeReconciliation.status == 1}">
									平
									</c:if>
									<c:if test="${financeReconciliation.status == 2}">
									长款
									</c:if>
									<c:if test="${financeReconciliation.status == 3}">
									短款
									</c:if>
									<c:if test="${financeReconciliation.status == 4}">
									金融不一致
									</c:if>
									<c:if test="${financeReconciliation.status == 5}">
									积分不一致
									</c:if>
									<c:if test="${financeReconciliation.status == 6}">
									积分金额都不一致
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeReconciliation.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeReconciliation.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/finance/js/reconciliation.detail.js" type="text/javascript"></script>
