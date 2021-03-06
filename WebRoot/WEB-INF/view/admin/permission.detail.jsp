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
	                <header class="panel-heading">权限表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">权限id：</td>
                                <td class="col-sm-4">${adminPermission.permissionId}</td>
                                <td class="col-sm-2">权限名称：</td>
                                <td class="col-sm-4">${adminPermission.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">权限代码：</td>
                                <td class="col-sm-4">${adminPermission.code}</td>
                                <td class="col-sm-2">二级菜单id：</td>
                                <td class="col-sm-4">${adminPermission.menuId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">链接=二级菜单url：</td>
                                <td class="col-sm-4">${adminPermission.url}</td>
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${adminPermission.sortOrder}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${adminPermission.status == 0}">
									不使用
									</c:if>
									<c:if test="${adminPermission.status == 1}">
									使用
									</c:if>
								</td>
								<td class="col-sm-2">用户类型：</td>
                                <td class="col-sm-4">
									<c:if test="${adminPermission.userType == 1}">
									平台
									</c:if>
									<c:if test="${adminPermission.userType == 2}">
									商户
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
<script src="${STATIC_URL}/modules/admin/js/permission.detail.js" type="text/javascript"></script>
