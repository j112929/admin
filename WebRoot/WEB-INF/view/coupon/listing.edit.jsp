<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${couponListing!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${couponListing!=null}">"${BASE_URL}/couponListing/edit"</c:when><c:otherwise>"${BASE_URL}/couponListing/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="userId" class="col-sm-3 control-label">客户端用户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userId" name="userId" value="${couponListing.userId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="merchantId" class="col-sm-3 control-label">商户ID</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="merchantId" name="merchantId" value="${couponListing.merchantId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="couponId" class="col-sm-3 control-label">优惠券ID</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="couponId" name="couponId" value="${couponListing.couponId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="code" class="col-sm-3 control-label">优惠券编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="code" name="code" value="${couponListing.code}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">优惠券状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponListing.status == 0}">selected="selected"</c:if>>未使用</option>
				                	<option value="1" <c:if test="${couponListing.status == 1}">selected="selected"</c:if>>已使用</option>
				                	<option value="2" <c:if test="${couponListing.status == 2}">selected="selected"</c:if>>已作废</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="orderCode" class="col-sm-3 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderCode" name="orderCode" value="${couponListing.orderCode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否删除</label>
				        <div class="col-sm-4">
				            <select id="isDel" name="isDel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponListing.isDel == 0}">selected="selected"</c:if>>未删除</option>
				                	<option value="1" <c:if test="${couponListing.isDel == 1}">selected="selected"</c:if>>已删除</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否失效</label>
				        <div class="col-sm-4">
				            <select id="isFailure" name="isFailure" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponListing.isFailure == 0}">selected="selected"</c:if>>未失效</option>
				                	<option value="1" <c:if test="${couponListing.isFailure == 1}">selected="selected"</c:if>>已失效</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${couponListing.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">最后一次更新时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${couponListing.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择最后一次更新时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${couponListing.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${couponListing==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/coupon/js/listing.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->