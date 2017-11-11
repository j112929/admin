<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${logAudit!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${logAudit!=null}">"${BASE_URL}/logAudit/edit"</c:when><c:otherwise>"${BASE_URL}/logAudit/add"</c:otherwise></c:choose> method="post">
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核类型</label>
				        <div class="col-sm-4">
				            <select id="type" name="type" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${logAudit.type == 1}">selected="selected"</c:if>>供应商入驻</option>
				                	<option value="2" <c:if test="${logAudit.type == 2}">selected="selected"</c:if>>商品上架</option>
				                	<option value="3" <c:if test="${logAudit.type == 3}">selected="selected"</c:if>>供应商可售商品类型</option>
				                	<option value="4" <c:if test="${logAudit.type == 4}">selected="selected"</c:if>>优惠券</option>
				                	<option value="5" <c:if test="${logAudit.type == 5}">selected="selected"</c:if>>秒杀</option>
				                	<option value="6" <c:if test="${logAudit.type == 6}">selected="selected"</c:if>>抽奖</option>
				                	<option value="7" <c:if test="${logAudit.type == 7}">selected="selected"</c:if>>团购</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="targetId" class="col-sm-3 control-label">审核目标id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="targetId" name="targetId" value="${logAudit.targetId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" value="${logAudit.remark}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${logAudit.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核级别</label>
				        <div class="col-sm-4">
				            <select id="grade" name="grade" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${logAudit.grade == 1}">selected="selected"</c:if>>一级审核</option>
				                	<option value="2" <c:if test="${logAudit.grade == 2}">selected="selected"</c:if>>二级审核</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${logAudit.status == 0}">selected="selected"</c:if>>不通过</option>
				                	<option value="1" <c:if test="${logAudit.status == 1}">selected="selected"</c:if>>通过</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="auditer" class="col-sm-3 control-label">审核人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="auditer" name="auditer" value="${logAudit.auditer}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="auditTime" class="col-sm-3 control-label">审核时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="auditTime" name="auditTime" 
                            value="<fmt:formatDate value="${logAudit.auditTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择审核时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${logAudit.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${logAudit==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/log/js/audit.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->