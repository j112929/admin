<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>
<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<section class="hbox stretch">
<aside class="aside-md bg-white b-r" id="subNav">
        <section class="vbox">
            <header class="b-b header"><p class="h4">选择商品</p></header>
            <section class="scrollable w-f">
                <ul class="nav nav-pills nav-stacked no-radius">
                    <li class="b-b m-t-none-reset nav-map active" id="nav_property">
                        <a href="javascript:;">
                            <i class="fa fa-chevron-right pull-right m-t-xs text-xs icon-muted"></i>
                            <i class="fa fa-fw fa-ellipsis-v"></i>
                            选择商品
                        </a>
                    </li>
                </ul>
            </section>.		<option >一级分类</option>
		                    			<c:forEach items="${allOneGradeCategory}" var="v">
	                            		<option value="${v.id}" <c:if test="${v.id == ppId}">selected="selected"</c:if>>
		                                	${v.name}
	                                	</option>
	                            	</c:forEach>
		                    	      </select>
		                    	      <select>
		                    	      	<option>二级分类</option>
		                    	      	<c:forEach items="${allTwoGradeCategory}" var="v">
	                            		<option value="${v.id}" <c:if test="${v.id == goodsCategory.getPId()}">selected="selected"</c:if>>
		                                	${v.name}
	                                	</option>
	                            	</c:forEach>
		                    	      </select>
		                    	      <select>
		                    	      	<option>三级分类</option>
		                    	      	<c:forEach items="${allThreeGradeCategory}" var="v">
	                            		<option value="${v.id}" <c:if test="${v.id == goodsCategory.getPId()}">selected="selected"</c:if>>
		                                	${v.name}
	                                	</option>
	                                	</c:forEach>
		                    	      </select>
		                    	 商品spu编号<input name="id" type="text" placeholder="精确"/>
		                    	 供应商名称<input name="sname" type="text" placeholder="模糊"/>
		                    	商品名称<input name="name" type="text" placeholder="模糊"/>
	                        </div>
	                        <div class="input-group">
	                            	<input type="text" class="input-sm input-s datetimepicker-input form-control" id="beginTime" name="beginTime" value="<fmt:formatDate value="${advert.beginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择开始时间时间" readonly="readonly"/>
		                        <input type="text" class="input-sm input-s datetimepicker-input form-control" id="endTime" name="endTime" value="<fmt:formatDate value="${advert.endTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择结束时间时间" readonly="readonly"/>
		                                                               商品类型 <select>
		                    			<option>全部</option>
		                    	      </select>
		                    	发布平台 <select>
		                    			<option>WEB</option>
		                    	      </select>
		                    	
	                        </div>
	                    	<button class="btn btn-sm btn-default action-refresh" type="button">查询</button>
                    </div>
                </div>
            </header>
            <section class="scrollable wrapper w-f">
   
                    <%-- <form action="${BASE_URL}/whiteList/pageRelated" id="searchForm"> --%>
	                    
	                <form class="form-horizontal" id="edit_form" action="${BASE_URL}/whiteList/choosegoods" method="post">    
	                    <div class="edit-map" id="edit_property">
                        <section class="panel panel-default">
                            <table class="table table-striped m-b-none datagrid" id="property_listing">
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
                    </div>
                    <input type="hidden" id="id" name="id" value="${whiteList.id}" />
                    <input type="hidden" name="contentIds" value="${contentIds}" />
	            </form>
	            </section>
            
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" id="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <button type="button" id="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
    
    <aside class="bg-light lter aside-md" id="selected_property">
        <section class="vbox">
            <header class="b-b header"><p class="h4">已选<font class="text-sm">（可拖拽排序）</font></p></header>
            <section class="scrollable w-f">
                <ul class="nav nav-stacked list-group gutter list-group-lg list-group-sp sortable">
                	<c:forEach items="${properties}" var="v">
                    <li class="b-b m-t-none-reset" id="${v.id}" property_id="${v.id}"  draggable="true">
                        <a href="javascript:;">
                            <i title="移除该属性" class="fa fa-times pull-right m-t-xs fa-remove-property"></i>
                            <i class="fa fa-fw fa-ellipsis-v"></i><font class="property-name">${v.name}</font>
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
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/vendor/jquery.ui.widget.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.iframe-transport.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.fileupload.js" type="text/javascript"></script>
<script src="${STATIC_URL}/modules/white/js/listchoosegoods.js" type="text/javascript"></script>