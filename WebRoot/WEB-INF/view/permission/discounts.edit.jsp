<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${permissionDiscounts!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal " id="edit_form" action=<c:choose> <c:when test="${permissionDiscounts!=null}">"${BASE_URL}/permissionDiscounts/edit"</c:when><c:otherwise>"${BASE_URL}/permissionDiscounts/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="title" class="col-sm-3 control-label"><font class="red">* </font>折扣名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="title" name="title" value="${permissionDiscounts.title}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="startTime" class="col-sm-3 control-label">折扣活动时间</label>
                        <div class="col-sm-4 ">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="startTime" name="startTime" 
                            value="<fmt:formatDate value="${permissionDiscounts.startTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择折扣活动开始时间时间" readonly="readonly"/>-
                         <input type="text" class="input-sm input-s datetimepicker-input form-control" id="endTime" name="endTime" 
                            value="<fmt:formatDate value="${permissionDiscounts.endTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择折扣活动结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="price" class="col-sm-3 control-label">抢购价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price" name="price" value="${permissionDiscounts.price}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>                   
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="buynumber" class="col-sm-3 control-label">抢购数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="buynumber" name="buynumber" value="${permissionDiscounts.buynumber}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label"><font class="red">* </font>创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${permissionDiscounts.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>                 
                </form>
                <div class="line line-dashed line-lg pull-in"></div>
                <section class="panel panel-default">
                <header class="panel-heading">
                        <label for="sku" class="col-sm-3 control-label">商品选择:</label><br/>
                   		<form class="form-inline" action="${BASE_URL}/goodsTrash/page" id="searchForm">
		                    <div class="col-sm-5 m-b-xs pull-left">
		                                <select name="categoryId" class="form-control input-sm">
		                                    <option value="0">请选择分类</option>
		                                    <c:forEach items="${categories}" var="v">
		                                        <option value="${v.categoryId}">
		                                            <c:if test="${v.grade == 1}">${v.categoryName}</c:if>
		                                            <c:if test="${v.grade == 2}">&nbsp;&nbsp;&nbsp;&nbsp;${v.categoryName}</c:if>
		                                            <c:if test="${v.grade == 3}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${v.categoryName}</c:if>
		                                        </option>
		                                    </c:forEach>
		                                </select>	                            
		                                <select name="brandId" class="form-control input-sm">
		                                    <option value="0">请选择品牌</option>
		                                    <c:forEach items="${brands}" var="v">
		                                        <option value="${v.brandId}">${v.brandName}</option>
		                                    </c:forEach>
		                                </select>                 
		                    </div>		                    
		                    <div class="col-sm-3 m-b-xs">
		                        <div class="input-group">
		                            <input type="text" name="key" class="input-sm form-control" placeholder="商品名称" />
		                            <span class="input-group-btn">
		                                <button class="btn btn-sm btn-default action-refresh" type="button">搜索</button>
		                            </span>
		                        </div>
		                    </div>
                    	</form>                 	
                    </header> 
                    <table class="table table-striped m-b-none datagrid" id="content_listing">
				                    <thead>
				                    </thead>
				                    <tfoot>
				                        <tr>
				                            <th class="row">
				                                <div class="datagrid-footer-left col-sm-6 text-center-xs m-l-n" style="display:none;">
				                                    <div class="grid-controls m-t-sm">
			                                            <span>
			                                                <span class="grid-start"></span> -
			                                                <span class="grid-end"></span> （共
			                                                <span class="grid-count"></span>）
			                                            </span>
				
				                                        <div class="select grid-pagesize dropup" data-resize="auto">
				                                            <button data-toggle="dropdown" class="btn btn-sm btn-default dropdown-toggle">
				                                                <span class="dropdown-label"></span>
				                                                <span class="caret"></span>
				                                            </button>
				                                            <ul class="dropdown-menu">
				                                                <li data-value="5"><a href="#">5</a></li>
				                                                <li data-value="15" data-selected="true"><a href="#">15</a></li>
				                                                <li data-value="20"><a href="#">20</a></li>
				                                                <li data-value="50"><a href="#">50</a></li>
				                                                <li data-value="100"><a href="#">100</a></li>
				                                            </ul>
				                                        </div>
				                                        <span>/页</span>
				                                    </div>
				                                </div>
				
				                                <div class="datagrid-footer-right col-sm-6 text-right text-center-xs"
				                                     style="display:none;">
				                                    <div class="grid-pager m-r-n">
				                                        <button type="button" class="btn btn-sm btn-default grid-prevpage"><i class="fa fa-chevron-left"></i></button>
				                                        <!--<span>页</span>-->
				                                        <div class="inline">
				                                            <div class="input-group dropdown combobox">
				                                                <input class="input-sm form-control" type="text">
				                                                <div class="input-group-btn dropup">
				                                                    <button class="btn btn-sm btn-default" data-toggle="dropdown"><i class="caret"></i></button>
				                                                    <ul class="dropdown-menu pull-right"></ul>
				                                                </div>
				                                            </div>
				                                        </div>
				                                        <span>/ <span class="grid-pages"></span></span>
				                                        <button type="button" class="btn btn-sm btn-default grid-nextpage"><i class="fa fa-chevron-right"></i></button>
				                                    </div>
				                                </div>
				                            </th>
				                        </tr>
				                    </tfoot>
				                </table>                 
                </section>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${permissionDiscounts==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
    
    <aside class="bg-light lter aside-md" id="selected_property">
        <section class="vbox">
            <header class="b-b header"><p class="h4">已选商品<font class="text-sm"> （可拖拽排序） </font></p></header>
            <section class="scrollable w-f">
                <ul class="nav nav-stacked list-group gutter list-group-lg list-group-sp sortable">
                	<c:forEach items="${properties}" var="v">
                    <li class="b-b m-t-none-reset" id="li_property_${v.propertyId}" propertyId="${v.propertyId}" draggable="true">
                        <a href="javascript:;">
                            <i title="移除该属性" class="fa fa-times pull-right m-t-xs fa-remove-property"></i>
                            <i class="fa fa-fw fa-ellipsis-v"></i><font class="property-name">${v.labelName}</font>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/permission/js/discounts.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->