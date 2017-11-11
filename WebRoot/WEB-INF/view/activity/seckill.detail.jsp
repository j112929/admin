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
	                <header class="panel-heading">秒杀活动：积分秒杀，平台发起详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${activitySeckill.id}</td>
                                <td class="col-sm-2">名称：</td>
                                <td class="col-sm-4">${activitySeckill.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品sku：</td>
                                <td class="col-sm-4">${activitySeckill.skuId}</td>
                                <td class="col-sm-2">每人限购数量：</td>
                                <td class="col-sm-4">${activitySeckill.maxBuyQuantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">秒杀商品数量：</td>
                                <td class="col-sm-4">${activitySeckill.quantity}</td>
                                <td class="col-sm-2">结算价格：</td>
                                <td class="col-sm-4">${activitySeckill.settlementPrice}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">价格：</td>
                                <td class="col-sm-4">${activitySeckill.price}</td>
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${activitySeckill.sortOrder}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">描述：</td>
                                <td class="col-sm-4">${activitySeckill.description}</td>
                                <td class="col-sm-2">预发布时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activitySeckill.showTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activitySeckill.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activitySeckill.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否是白名单活动：</td>
                                <td class="col-sm-4">
									<c:if test="${activitySeckill.isWhiteListActivity == 0}">
									不是
									</c:if>
									<c:if test="${activitySeckill.isWhiteListActivity == 1}">
									是
									</c:if>
								</td>
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${activitySeckill.verifyStatus == 0}">
									未审核
									</c:if>
									<c:if test="${activitySeckill.verifyStatus == 1}">
									审核通过
									</c:if>
									<c:if test="${activitySeckill.verifyStatus == 2}">
									审核不通过
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${activitySeckill.creator}</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activitySeckill.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${activitySeckill.modifier}</td>
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activitySeckill.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/activity/js/seckill.detail.js" type="text/javascript"></script>
