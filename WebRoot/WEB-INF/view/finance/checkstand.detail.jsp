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
	                <header class="panel-heading">收银台文件数据详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${financeCheckstand.id}</td>
                                <td class="col-sm-2">批次号：</td>
                                <td class="col-sm-4">${financeCheckstand.batchNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">APPID：</td>
                                <td class="col-sm-4">${financeCheckstand.appid}</td>
                                <td class="col-sm-2">渠道号：</td>
                                <td class="col-sm-4">${financeCheckstand.channelNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">兴知付流水号：</td>
                                <td class="col-sm-4">${financeCheckstand.sno}</td>
                                <td class="col-sm-2">商户流水号：</td>
                                <td class="col-sm-4">${financeCheckstand.mrchSno}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">账单类型：</td>
                                <td class="col-sm-4">
									<c:if test="${financeCheckstand.receiptType == 1}">
									-出账入账合一
									</c:if>
									<c:if test="${financeCheckstand.receiptType == 2}">
									-入账
									</c:if>
									<c:if test="${financeCheckstand.receiptType == 3}">
									-出账
									</c:if>
									<c:if test="${financeCheckstand.receiptType == 4}">
									-存疑
									</c:if>
								</td>
								<td class="col-sm-2">存疑类型：</td>
                                <td class="col-sm-4">
									<c:if test="${financeCheckstand.impeachType == 1}">
									-渠道方成功
									</c:if>
									<c:if test="${financeCheckstand.impeachType == 2}">
									-渠道方失败
									</c:if>
									<c:if test="${financeCheckstand.impeachType == 3}">
									-渠道方少
									</c:if>
									<c:if test="${financeCheckstand.impeachType == 4}">
									-金额不匹配
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">积分：</td>
                                <td class="col-sm-4">${financeCheckstand.integral}</td>
                                <td class="col-sm-2">币种：</td>
                                <td class="col-sm-4">${financeCheckstand.cur}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">交易金额：</td>
                                <td class="col-sm-4">${financeCheckstand.transAmt}</td>
                                <td class="col-sm-2">支付时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeCheckstand.payTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">账务日期：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeCheckstand.receiptTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">创建日期：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeCheckstand.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/finance/js/checkstand.detail.js" type="text/javascript"></script>
