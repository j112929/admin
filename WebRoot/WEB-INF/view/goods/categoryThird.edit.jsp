<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${goodsCategory!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action="${BASE_URL}/goodsCategory/addThird" 
                method="post" enctype="multipart/form-data">
                    <div class="form-group">
				        <label class="col-sm-3 control-label">选择一级分类</label>
				        <div class="col-sm-4">
				            <select name="ppId" id="ppId" class="form-control input-sm">
                            	<option value="0">请选择分类</option>
                            	<c:forEach items="${allOneGradeCategory}" var="v">
                            		<option value="${v.id}" <c:if test="${v.id == ppId}">selected="selected"</c:if>>
	                                	${v.name}
                                	</option>
                            	</c:forEach>
                            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    
					<div class="form-group">
				        <label class="col-sm-3 control-label">选择二级分类</label>
				        <div class="col-sm-4">
				            <select name="pId" id="pId" class="form-control input-sm">
                            	<option value="0">请选择分类</option>
                            	<c:forEach items="${allTwoGradeCategory}" var="v">
                            		<option value="${v.id}" <c:if test="${v.id == goodsCategory.getPId()}">selected="selected"</c:if>>
	                                	${v.name}
                                	</option>
                            	</c:forEach>
                            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
				    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">三级分类名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${goodsCategory.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
                        <label for="sortOrder" class="col-sm-3 control-label">序号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sortOrder" name="sortOrder" value="${goodsCategory.sortOrder}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group file-reset">
                        <label for="pic" class="col-sm-3 control-label">图片</label>
                        <div class="col-sm-4">
                            <input type="file" class="filestyle" id="pic" name="pic" value="${goodsCategory.pic}" data-icon="false" data-classbutton="btn btn-default" data-classinput="form-control inline input-s"/>
                        	<c:if test="${goodsCategory.pic != null && goodsCategory.pic != ''}">
	                            <a href="${IMG_URL}${goodsCategory.pic}" class="thumb-sm" target="_blank"><img src="${IMG_URL}${goodsCategory.pic}" /></a>
	                        </c:if>
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    
					<%-- <div class="form-group">
				        <label class="col-sm-3 control-label">状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${goodsCategory.status == 0}">selected="selected"</c:if>>不可用</option>
				                	<option value="1" <c:if test="${goodsCategory.status == 1}">selected="selected"</c:if>>可用</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div> --%>
                    <input type="hidden" name="id" value="${goodsCategory.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${goodsCategory==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/goods/js/categoryThird.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->