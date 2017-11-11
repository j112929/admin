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
	                <header class="panel-heading">广告表，存放广告位信息、banner信息等详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">广告id：</td>
                                <td class="col-sm-4">${advert.id}</td>
                                <td class="col-sm-2">标题：</td>
                                <td class="col-sm-4">${advert.name}</td>
                            </tr>
                            <tr>                                  
								<td class="col-sm-2">推荐专区：</td>
                                <td class="col-sm-4">
									<c:if test="${advert.position == 1}">
									商城banner
									</c:if>
									<c:if test="${advert.position == 2}">
									积分专区banner
									</c:if>
									<c:if test="${advert.position == 3}">
									分期专区banner
									</c:if>
								</td>
								<td class="col-sm-2">推荐位置：</td>
                                <td class="col-sm-4">${advert.sortOrder}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">链接类型：</td>
                                <td class="col-sm-4">
									<c:if test="${advert.linkType == 1}">
									H
									</c:if>
									<c:if test="${advert.linkType == 2}">
									商品详情
									</c:if>
									<c:if test="${advert.linkType == 5}">
									页面
									</c:if>
								</td>
                                <td class="col-sm-2">链接目标：</td>
                                <td class="col-sm-4">${advert.link}</td>
                            </tr>
                            <tr>  
                                
                                <td class="col-sm-2">广告图片：</td>
                                <td class="col-sm-4">${advert.pic}</td>
                                <td class="col-sm-2">描述：</td>
                                <td class="col-sm-4">${advert.description}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${advert.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${advert.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${advert.status == 0}">
									不显示
									</c:if>
									<c:if test="${advert.status == 1}">
									显示
									</c:if>
								</td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${advert.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${advert.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${advert.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${advert.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/advert/js/advert.detail.js" type="text/javascript"></script>
