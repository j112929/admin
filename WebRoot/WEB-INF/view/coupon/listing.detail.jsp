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
	                <header class="panel-heading">优惠券使用情况表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">ID：</td>
                                <td class="col-sm-4">${couponListing.id}</td>
                                <td class="col-sm-2">客户端用户id：</td>
                                <td class="col-sm-4">${couponListing.userId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商户ID：</td>
                                <td class="col-sm-4">${couponListing.merchantId}</td>
                                <td class="col-sm-2">优惠券ID：</td>
                                <td class="col-sm-4">${couponListing.couponId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">优惠券编码：</td>
                                <td class="col-sm-4">${couponListing.code}</td>
								<td class="col-sm-2">优惠券状态：</td>
                                <td class="col-sm-4">
									<c:if test="${couponListing.status == 0}">
									未使用
									</c:if>
									<c:if test="${couponListing.status == 1}">
									已使用
									</c:if>
									<c:if test="${couponListing.status == 2}">
									已作废
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">订单号：</td>
                                <td class="col-sm-4">${couponListing.orderCode}</td>
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${couponListing.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${couponListing.isDel == 1}">
									已删除
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否失效：</td>
                                <td class="col-sm-4">
									<c:if test="${couponListing.isFailure == 0}">
									未失效
									</c:if>
									<c:if test="${couponListing.isFailure == 1}">
									已失效
									</c:if>
								</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponListing.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">最后一次更新时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${couponListing.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/coupon/js/listing.detail.js" type="text/javascript"></script>
