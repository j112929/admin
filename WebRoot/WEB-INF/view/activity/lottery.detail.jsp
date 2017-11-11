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
	                <header class="panel-heading">抽奖活动：积分抽奖，平台发起详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${activityLottery.id}</td>
                                <td class="col-sm-2">名称：</td>
                                <td class="col-sm-4">${activityLottery.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">活动规则：</td>
                                <td class="col-sm-4">${activityLottery.description}</td>
                                <td class="col-sm-2">每人每天最大抽奖次数：</td>
                                <td class="col-sm-4">${activityLottery.maxLotteryCount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">总转动次数：</td>
                                <td class="col-sm-4">${activityLottery.count}</td>
                                <td class="col-sm-2">结算价格：</td>
                                <td class="col-sm-4">${activityLottery.settlementPrice}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">每次抽奖价格：</td>
                                <td class="col-sm-4">${activityLottery.price}</td>
                                <td class="col-sm-2">开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLottery.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLottery.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${activityLottery.verifyStatus == 0}">
									未审核
									</c:if>
									<c:if test="${activityLottery.verifyStatus == 1}">
									审核通过
									</c:if>
									<c:if test="${activityLottery.verifyStatus == 2}">
									审核不通过
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${activityLottery.creator}</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLottery.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${activityLottery.modifier}</td>
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${activityLottery.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/activity/js/lottery.detail.js" type="text/javascript"></script>
