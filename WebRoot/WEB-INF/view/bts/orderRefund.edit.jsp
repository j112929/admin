<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${btsOrderRefund!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${btsOrderRefund!=null}">"${BASE_URL}/btsOrderRefund/edit"</c:when><c:otherwise>"${BASE_URL}/btsOrderRefund/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="userId" class="col-sm-3 control-label">用户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userId" name="userId" value="${btsOrderRefund.userId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="shopId" class="col-sm-3 control-label">店铺id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="shopId" name="shopId" value="${btsOrderRefund.shopId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="refundNo" class="col-sm-3 control-label">退货单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="refundNo" name="refundNo" value="${btsOrderRefund.refundNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="orderItemsId" class="col-sm-3 control-label">订单明细id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderItemsId" name="orderItemsId" value="${btsOrderRefund.orderItemsId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-3 control-label">退货商品数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="quantity" name="quantity" value="${btsOrderRefund.quantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="reason" class="col-sm-3 control-label">退货原因</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="reason" name="reason" value="${btsOrderRefund.reason}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pics" class="col-sm-3 control-label">图片地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pics" name="pics" value="${btsOrderRefund.pics}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">退货单状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderRefund.status == 0}">selected="selected"</c:if>>取消申请</option>
				                	<option value="1" <c:if test="${btsOrderRefund.status == 1}">selected="selected"</c:if>>申请退货</option>
				                	<option value="2" <c:if test="${btsOrderRefund.status == 2}">selected="selected"</c:if>>审批通过</option>
				                	<option value="3" <c:if test="${btsOrderRefund.status == 3}">selected="selected"</c:if>>审批拒绝</option>
				                	<option value="4" <c:if test="${btsOrderRefund.status == 4}">selected="selected"</c:if>>退款完成</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="refundAmount" class="col-sm-3 control-label">退款金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="refundAmount" name="refundAmount" value="${btsOrderRefund.refundAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否评价</label>
				        <div class="col-sm-4">
				            <select id="isComment" name="isComment" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderRefund.isComment == 0}">selected="selected"</c:if>>未评价</option>
				                	<option value="1" <c:if test="${btsOrderRefund.isComment == 1}">selected="selected"</c:if>>已评价</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${btsOrderRefund.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${btsOrderRefund.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${btsOrderRefund.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${btsOrderRefund==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/bts/js/orderRefund.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->