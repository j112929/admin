<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${btsOrder!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${btsOrder!=null}">"${BASE_URL}/btsOrder/edit"</c:when><c:otherwise>"${BASE_URL}/btsOrder/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="orderNo" class="col-sm-3 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderNo" name="orderNo" value="${btsOrder.orderNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="userId" class="col-sm-3 control-label">用户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userId" name="userId" value="${btsOrder.userId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">订单备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" value="${btsOrder.remark}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeRegionId" class="col-sm-3 control-label">收货地区id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeRegionId" name="consigneeRegionId" value="${btsOrder.consigneeRegionId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeRegionName" class="col-sm-3 control-label">收货地区名称全称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeRegionName" name="consigneeRegionName" value="${btsOrder.consigneeRegionName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeAddress" class="col-sm-3 control-label">收货人详细地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeAddress" name="consigneeAddress" value="${btsOrder.consigneeAddress}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeName" class="col-sm-3 control-label">收货人姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeName" name="consigneeName" value="${btsOrder.consigneeName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeEmail" class="col-sm-3 control-label">收货人邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeEmail" name="consigneeEmail" value="${btsOrder.consigneeEmail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeZipcode" class="col-sm-3 control-label">收货人邮编</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeZipcode" name="consigneeZipcode" value="${btsOrder.consigneeZipcode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="consigneeMobileNo" class="col-sm-3 control-label">收货人手机号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="consigneeMobileNo" name="consigneeMobileNo" value="${btsOrder.consigneeMobileNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">订单状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrder.status == 1}">selected="selected"</c:if>>待付款</option>
				                	<option value="2" <c:if test="${btsOrder.status == 2}">selected="selected"</c:if>>已付款</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否取消</label>
				        <div class="col-sm-4">
				            <select id="isCancel" name="isCancel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrder.isCancel == 0}">selected="selected"</c:if>>未取消</option>
				                	<option value="1" <c:if test="${btsOrder.isCancel == 1}">selected="selected"</c:if>>已取消</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否删除</label>
				        <div class="col-sm-4">
				            <select id="isDel" name="isDel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrder.isDel == 0}">selected="selected"</c:if>>未删除</option>
				                	<option value="1" <c:if test="${btsOrder.isDel == 1}">selected="selected"</c:if>>删除</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsAmount" class="col-sm-3 control-label">商品总价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsAmount" name="goodsAmount" value="${btsOrder.goodsAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="discountAmount" class="col-sm-3 control-label">金币抵扣金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="discountAmount" name="discountAmount" value="${btsOrder.discountAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="freightAmount" class="col-sm-3 control-label">运费</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="freightAmount" name="freightAmount" value="${btsOrder.freightAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payableAmount" class="col-sm-3 control-label">应付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payableAmount" name="payableAmount" value="${btsOrder.payableAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payAmount" class="col-sm-3 control-label">实付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payAmount" name="payAmount" value="${btsOrder.payAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">支付方式</label>
				        <div class="col-sm-4">
				            <select id="payType" name="payType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrder.payType == 1}">selected="selected"</c:if>>本金支付</option>
				                	<option value="2" <c:if test="${btsOrder.payType == 2}">selected="selected"</c:if>>积分支付</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="payTime" class="col-sm-3 control-label">支付时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="payTime" name="payTime" 
                            value="<fmt:formatDate value="${btsOrder.payTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择支付时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${btsOrder.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${btsOrder.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${btsOrder==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/bts/js/order.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->