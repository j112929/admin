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
	                <header class="panel-heading">商品关联文件表，如sku图片、商品简介图片、视频、h5等。详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">商品图片id：</td>
                                <td class="col-sm-4">${goodsFile.id}</td>
                                <td class="col-sm-2">图片类型：</td>
                                <td class="col-sm-4">${goodsFile.type}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">目标id：</td>
                                <td class="col-sm-4">${goodsFile.targetId}</td>
                                <td class="col-sm-2">图片地址：</td>
                                <td class="col-sm-4">${goodsFile.pic}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${goodsFile.sortOrder}</td>
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsFile.status == 0}">
									不可用
									</c:if>
									<c:if test="${goodsFile.status == 1}">
									可用
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsFile.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${goodsFile.isDel == 1}">
									删除
									</c:if>
								</td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${goodsFile.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsFile.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${goodsFile.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsFile.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/goods/js/file.detail.js" type="text/javascript"></script>
