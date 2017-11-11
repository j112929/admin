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
	                <header class="panel-heading">审核日志表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${logAudit.id}</td>
								<td class="col-sm-2">审核类型：</td>
                                <td class="col-sm-4">
									<c:if test="${logAudit.type == 1}">
									供应商入驻
									</c:if>
									<c:if test="${logAudit.type == 2}">
									商品上架
									</c:if>
									<c:if test="${logAudit.type == 3}">
									供应商可售商品类型
									</c:if>
									<c:if test="${logAudit.type == 4}">
									优惠券
									</c:if>
									<c:if test="${logAudit.type == 5}">
									秒杀
									</c:if>
									<c:if test="${logAudit.type == 6}">
									抽奖
									</c:if>
									<c:if test="${logAudit.type == 7}">
									团购
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">审核目标id：</td>
                                <td class="col-sm-4">${logAudit.targetId}</td>
                                <td class="col-sm-2">备注：</td>
                                <td class="col-sm-4">${logAudit.remark}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">描述：</td>
                                <td class="col-sm-4">${logAudit.description}</td>
								<td class="col-sm-2">审核级别：</td>
                                <td class="col-sm-4">
									<c:if test="${logAudit.grade == 1}">
									一级审核
									</c:if>
									<c:if test="${logAudit.grade == 2}">
									二级审核
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${logAudit.status == 0}">
									不通过
									</c:if>
									<c:if test="${logAudit.status == 1}">
									通过
									</c:if>
								</td>
                                <td class="col-sm-2">审核人：</td>
                                <td class="col-sm-4">${logAudit.auditer}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">审核时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${logAudit.auditTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/log/js/audit.detail.js" type="text/javascript"></script>
