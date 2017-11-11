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
	                <header class="panel-heading">评论表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">评论id：</td>
                                <td class="col-sm-4">${commonComment.id}</td>
                                <td class="col-sm-2">用户id：</td>
                                <td class="col-sm-4">${commonComment.userId}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">评论类型：</td>
                                <td class="col-sm-4">
									<c:if test="${commonComment.type == 1}">
									订单明细(商品)
									</c:if>
									<c:if test="${commonComment.type == 2}">
									物流服务(子订单)
									</c:if>
									<c:if test="${commonComment.type == 3}">
									服务态度(子订单)
									</c:if>
								</td>
                                <td class="col-sm-2">评论目标id：</td>
                                <td class="col-sm-4">${commonComment.targetId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">评分：</td>
                                <td class="col-sm-4">${commonComment.score}</td>
                                <td class="col-sm-2">评论内容：</td>
                                <td class="col-sm-4">${commonComment.content}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">评论时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${commonComment.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${commonComment.status == 0}">
									未审核
									</c:if>
									<c:if test="${commonComment.status == 1}">
									审核通过
									</c:if>
									<c:if test="${commonComment.status == 2}">
									审核不通过
									</c:if>
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
<script src="${STATIC_URL}/modules/common/js/comment.detail.js" type="text/javascript"></script>
