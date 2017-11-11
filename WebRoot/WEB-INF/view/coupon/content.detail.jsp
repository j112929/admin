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
	                <header class="panel-heading">优惠券表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">promotion：</td>
                                <td class="col-sm-4">${couponContent.couponId}</td>
								<td class="col-sm-2">优惠券类型：</td>
                                <td class="col-sm-4">
									<c:if test="${couponContent.couponType == 0}">
									全场类型
									</c:if>
									<c:if test="${couponContent.couponType == 1}">
									专场类型
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">分类：</td>
                                <td class="col-sm-4">${couponContent.categoryId}</td>
                                <td class="col-sm-2">优惠券编码：</td>
                                <td class="col-sm-4">${couponContent.code}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">优惠券名称：</td>
                                <td class="col-sm-4">${couponContent.couponName}</td>
                                <td class="col-sm-2">优惠券金额：</td>
                                <td class="col-sm-4">${couponContent.amount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商户承担额：</td>
                                <td class="col-sm-4">${couponContent.undertakeAmount}</td>
                                <td class="col-sm-2">银行补贴金额：</td>
                                <td class="col-sm-4">${couponContent.bankSubsidy}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">数量：</td>
                                <td class="col-sm-4">${couponContent.count}</td>
                                <td class="col-sm-2">有效期开始：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.validityStart}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">有效期结束：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.validityEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">优惠券使用金额下限：</td>
                                <td class="col-sm-4">${couponContent.minLimitAmount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">每单使用最大次数：</td>
                                <td class="col-sm-4">${couponContent.maxUseCount}</td>
                                <td class="col-sm-2">使用详情：</td>
                                <td class="col-sm-4">${couponContent.useDetail}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">使用须知：</td>
                                <td class="col-sm-4">${couponContent.useNotice}</td>
                                <td class="col-sm-2">发布时间开始：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.publishDateStart}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">发布时间结束：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.publishDateEnd}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
								<td class="col-sm-2">发布方式：</td>
                                <td class="col-sm-4">
									<c:if test="${couponContent.publishType == 0}">
									自动发布
									</c:if>
									<c:if test="${couponContent.publishType == 1}">
									用户自行领取
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">发布人群：</td>
                                <td class="col-sm-4">
									<c:if test="${couponContent.publishPopulation == 0}">
									所有用户
									</c:if>
									<c:if test="${couponContent.publishPopulation == 1}">
									白名单
									</c:if>
								</td>
                                <td class="col-sm-2">优惠券图片：</td>
                                <td class="col-sm-4">${couponContent.attachmentId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">${couponContent.auditStatus}</td>
                                <td class="col-sm-2">审核人：</td>
                                <td class="col-sm-4">${couponContent.auditUserId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">最后一次更新时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponContent.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${couponContent.createUserId}</td>
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
<script src="${STATIC_URL}/modules/coupon/js/content.detail.js" type="text/javascript"></script>
