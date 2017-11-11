<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${btsOrderItems!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${btsOrderItems!=null}">"${BASE_URL}/btsOrderItems/edit"</c:when><c:otherwise>"${BASE_URL}/btsOrderItems/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="orderChildNo" class="col-sm-3 control-label">子订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderChildNo" name="orderChildNo" value="${btsOrderItems.orderChildNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="userId" class="col-sm-3 control-label">用户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="userId" name="userId" value="${btsOrderItems.userId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="remark" class="col-sm-3 control-label">订单明细备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remark" name="remark" value="${btsOrderItems.remark}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="merchantId" class="col-sm-3 control-label">商户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="merchantId" name="merchantId" value="${btsOrderItems.merchantId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="spuId" class="col-sm-3 control-label">商品spu</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="spuId" name="spuId" value="${btsOrderItems.spuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="skuId" class="col-sm-3 control-label">商品sku</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="skuId" name="skuId" value="${btsOrderItems.skuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsName" class="col-sm-3 control-label">商品名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsName" name="goodsName" value="${btsOrderItems.goodsName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsPic" class="col-sm-3 control-label">商品图片</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsPic" name="goodsPic" value="${btsOrderItems.goodsPic}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">属性</label>
				        <div class="col-sm-4">
				            <select id="propertys" name="propertys" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${btsOrderItems.propertys == 1}">selected="selected"</c:if>>""valueName""白色"}{"id""</option>
				                	<option value="3" <c:if test="${btsOrderItems.propertys == 3}">selected="selected"</c:if>>""name""颜色""value""</option>
				                	<option value="4" <c:if test="${btsOrderItems.propertys == 4}">selected="selected"</c:if>>""name""尺码""value""1""valueName""X码"}]</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-3 control-label">商品数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="quantity" name="quantity" value="${btsOrderItems.quantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="refundQuantity" class="col-sm-3 control-label">已退数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="refundQuantity" name="refundQuantity" value="${btsOrderItems.refundQuantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsOriginalPrice" class="col-sm-3 control-label">原价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsOriginalPrice" name="goodsOriginalPrice" value="${btsOrderItems.goodsOriginalPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsPrice" class="col-sm-3 control-label">现价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsPrice" name="goodsPrice" value="${btsOrderItems.goodsPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="goodsAmount" class="col-sm-3 control-label">商品总价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="goodsAmount" name="goodsAmount" value="${btsOrderItems.goodsAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="couponAmount" class="col-sm-3 control-label">优惠金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="couponAmount" name="couponAmount" value="${btsOrderItems.couponAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pointAmount" class="col-sm-3 control-label">积分总价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pointAmount" name="pointAmount" value="${btsOrderItems.pointAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="discountAmount" class="col-sm-3 control-label">金币抵扣金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="discountAmount" name="discountAmount" value="${btsOrderItems.discountAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="freightAmount" class="col-sm-3 control-label">运费</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="freightAmount" name="freightAmount" value="${btsOrderItems.freightAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payableAmount" class="col-sm-3 control-label">应付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payableAmount" name="payableAmount" value="${btsOrderItems.payableAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payAmount" class="col-sm-3 control-label">实付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payAmount" name="payAmount" value="${btsOrderItems.payAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否评价</label>
				        <div class="col-sm-4">
				            <select id="isComment" name="isComment" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${btsOrderItems.isComment == 0}">selected="selected"</c:if>>未评价</option>
				                	<option value="1" <c:if test="${btsOrderItems.isComment == 1}">selected="selected"</c:if>>已评价</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${btsOrderItems.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${btsOrderItems.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${btsOrderItems.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${btsOrderItems==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/bts/js/orderItems.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->