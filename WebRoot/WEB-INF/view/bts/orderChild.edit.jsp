<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${btsOrderChild!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${btsOrderChild!=null}">"${BASE_URL}/btsOrderChild/edit"</c:when><c:otherwise>"${BASE_URL}/btsOrderChild/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="orderNo" class="col-sm-3 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderNo" name="orderNo" value="${btsOrderChild.orderNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="orderChildNo" class="col-sm-3 control-label">子订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderChildNo" name="orderChildNo" value="${btsOrderChild.orderChildNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">订单类型</label>
				        <div class="col-sm-4">
				            <select id="type" name="type" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrderChild.type == 1}">selected="selected"</c:if>>普通</option>
				                	<option value="2" <c:if test="${btsOrderChild.type == 2}">selected="selected"</c:if>>折扣</option>
				                	<option value="3" <c:if test="${btsOrderChild.type == 3}">selected="selected"</c:if>>团购</option>
				                	<option value="4" <c:if test="${btsOrderChild.type == 4}">selected="selected"</c:if>>秒杀</option>
				                	<option value="5" <c:if test="${btsOrderChild.type == 5}">selected="selected"</c:if>>抽奖</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="userId" class="col-sm-3 control-label">用户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userId" name="userId" value="${btsOrderChild.userId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="merchantId" class="col-sm-3 control-label">商户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="merchantId" name="merchantId" value="${btsOrderChild.merchantId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">子订单备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" value="${btsOrderChild.remark}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="leaveMessage" class="col-sm-3 control-label">给卖家留言</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="leaveMessage" name="leaveMessage" value="${btsOrderChild.leaveMessage}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="expressType" class="col-sm-3 control-label">快递类型</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="expressType" name="expressType" value="${btsOrderChild.expressType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="expressNo" class="col-sm-3 control-label">快递单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="expressNo" name="expressNo" value="${btsOrderChild.expressNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="invoiceTitle" class="col-sm-3 control-label">发票抬头</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="invoiceTitle" name="invoiceTitle" value="${btsOrderChild.invoiceTitle}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">订单状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrderChild.status == 1}">selected="selected"</c:if>>待付款</option>
				                	<option value="2" <c:if test="${btsOrderChild.status == 2}">selected="selected"</c:if>>待发货</option>
				                	<option value="3" <c:if test="${btsOrderChild.status == 3}">selected="selected"</c:if>>待收货</option>
				                	<option value="4" <c:if test="${btsOrderChild.status == 4}">selected="selected"</c:if>>待评价</option>
				                	<option value="5" <c:if test="${btsOrderChild.status == 5}">selected="selected"</c:if>>退款</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否取消</label>
				        <div class="col-sm-4">
				            <select id="isCancel" name="isCancel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderChild.isCancel == 0}">selected="selected"</c:if>>未取消</option>
				                	<option value="1" <c:if test="${btsOrderChild.isCancel == 1}">selected="selected"</c:if>>已取消</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cancelReason" class="col-sm-3 control-label">取消原因</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cancelReason" name="cancelReason" value="${btsOrderChild.cancelReason}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否删除</label>
				        <div class="col-sm-4">
				            <select id="isDel" name="isDel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderChild.isDel == 0}">selected="selected"</c:if>>未删除</option>
				                	<option value="1" <c:if test="${btsOrderChild.isDel == 1}">selected="selected"</c:if>>删除</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsAmount" class="col-sm-3 control-label">商品总价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsAmount" name="goodsAmount" value="${btsOrderChild.goodsAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="couponAmount" class="col-sm-3 control-label">优惠金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="couponAmount" name="couponAmount" value="${btsOrderChild.couponAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pointAmount" class="col-sm-3 control-label">积分总价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pointAmount" name="pointAmount" value="${btsOrderChild.pointAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="freightAmount" class="col-sm-3 control-label">运费</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="freightAmount" name="freightAmount" value="${btsOrderChild.freightAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payableAmount" class="col-sm-3 control-label">应付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payableAmount" name="payableAmount" value="${btsOrderChild.payableAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payAmount" class="col-sm-3 control-label">实付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payAmount" name="payAmount" value="${btsOrderChild.payAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">支付订单类型</label>
				        <div class="col-sm-4">
				            <select id="payOrderType" name="payOrderType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrderChild.payOrderType == 1}">selected="selected"</c:if>>主订单</option>
				                	<option value="2" <c:if test="${btsOrderChild.payOrderType == 2}">selected="selected"</c:if>>子订单</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">支付方式</label>
				        <div class="col-sm-4">
				            <select id="payType" name="payType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrderChild.payType == 1}">selected="selected"</c:if>>本金支付</option>
				                	<option value="2" <c:if test="${btsOrderChild.payType == 2}">selected="selected"</c:if>>积分支付</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">支付状态</label>
				        <div class="col-sm-4">
				            <select id="payStatus" name="payStatus" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderChild.payStatus == 0}">selected="selected"</c:if>>未支付</option>
				                	<option value="1" <c:if test="${btsOrderChild.payStatus == 1}">selected="selected"</c:if>>已支付</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="payTime" class="col-sm-3 control-label">支付时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="payTime" name="payTime" 
                            value="<fmt:formatDate value="${btsOrderChild.payTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择支付时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="sno" class="col-sm-3 control-label">兴支付流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sno" name="sno" value="${btsOrderChild.sno}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${btsOrderChild.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${btsOrderChild.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${btsOrderChild==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/bts/js/orderChild.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->