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
	                <header class="panel-heading">二清清算总表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${financeClearing.id}</td>
                                <td class="col-sm-2">批次号：</td>
                                <td class="col-sm-4">${financeClearing.batchNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">支付方式：</td>
                                <td class="col-sm-4">${financeClearing.payType}</td>
                                <td class="col-sm-2">交易流水号：</td>
                                <td class="col-sm-4">${financeClearing.sno}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">订单号：</td>
                                <td class="col-sm-4">${financeClearing.orderNo}</td>
                                <td class="col-sm-2">商户名：</td>
                                <td class="col-sm-4">${financeClearing.buinessName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商户号：</td>
                                <td class="col-sm-4">${financeClearing.buinessNo}</td>
								<td class="col-sm-2">交易类型：</td>
                                <td class="col-sm-4">
									<c:if test="${financeClearing.businessDeal == 0}">
									退款
									</c:if>
									<c:if test="${financeClearing.businessDeal == 1}">
									购买
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">币种：</td>
                                <td class="col-sm-4">${financeClearing.cur}</td>
                                <td class="col-sm-2">清算金额：</td>
                                <td class="col-sm-4">${financeClearing.transAmt}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">积分：</td>
                                <td class="col-sm-4">${financeClearing.integral}</td>
                                <td class="col-sm-2">来源渠道：</td>
                                <td class="col-sm-4">${financeClearing.channel}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">手工清算：</td>
                                <td class="col-sm-4">
									<c:if test="${financeClearing.flag == 0}">
									手工清算
									</c:if>
									<c:if test="${financeClearing.flag == 1}">
									自动清算）
									</c:if>
								</td>
                                <td class="col-sm-2">银行卡号：</td>
                                <td class="col-sm-4">${financeClearing.paybkNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开户行：</td>
                                <td class="col-sm-4">${financeClearing.paybkCode}</td>
                                <td class="col-sm-2">账务日期：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeClearing.receiptTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeClearing.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/finance/js/clearing.detail.js" type="text/javascript"></script>
