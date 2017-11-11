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
	                <header class="panel-heading">商品分类详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">分类id：</td>
                                <td class="col-sm-4">${goodsCategory.id}</td>
                                <td class="col-sm-2">名称：</td>
                                <td class="col-sm-4">${goodsCategory.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">父级分类id：</td>
                                <td class="col-sm-4">${goodsCategory.pId}</td>
								<td class="col-sm-2">分类等级：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsCategory.grade == 1}">
									一级分类
									</c:if>
									<c:if test="${goodsCategory.grade == 2}">
									二级分类
									</c:if>
									<c:if test="${goodsCategory.grade == 3}">
									三级分类
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">图片：</td>
                                <td class="col-sm-4">${goodsCategory.pic}</td>
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${goodsCategory.sortOrder}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsCategory.status == 0}">
									不可用
									</c:if>
									<c:if test="${goodsCategory.status == 1}">
									可用
									</c:if>
								</td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${goodsCategory.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsCategory.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${goodsCategory.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsCategory.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/goods/js/category.detail.js" type="text/javascript"></script>
