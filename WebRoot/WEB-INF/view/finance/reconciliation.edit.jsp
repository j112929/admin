<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${financeReconciliation!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${financeReconciliation!=null}">"${BASE_URL}/financeReconciliation/edit"</c:when><c:otherwise>"${BASE_URL}/financeReconciliation/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="batchNo" class="col-sm-3 control-label">批次号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="batchNo" name="batchNo" value="${financeReconciliation.batchNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sno" class="col-sm-3 control-label">交易流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sno" name="sno" value="${financeReconciliation.sno}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payType" class="col-sm-3 control-label">支付方式</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payType" name="payType" value="${financeReconciliation.payType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="orderNo" class="col-sm-3 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderNo" name="orderNo" value="${financeReconciliation.orderNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cur" class="col-sm-3 control-label">币种</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cur" name="cur" value="${financeReconciliation.cur}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mtransAmt" class="col-sm-3 control-label">我方交易金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mtransAmt" name="mtransAmt" value="${financeReconciliation.mtransAmt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="transAmt" class="col-sm-3 control-label">收银台方交易金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="transAmt" name="transAmt" value="${financeReconciliation.transAmt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mintegral" class="col-sm-3 control-label">我方交易积分</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mintegral" name="mintegral" value="${financeReconciliation.mintegral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="tintegral" class="col-sm-3 control-label">收银台方交易积分</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="tintegral" name="tintegral" value="${financeReconciliation.tintegral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">交易类型</label>
				        <div class="col-sm-4">
				            <select id="businessDea" name="businessDea" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeReconciliation.businessDea == 0}">selected="selected"</c:if>>退款</option>
				                	<option value="1" <c:if test="${financeReconciliation.businessDea == 1}">selected="selected"</c:if>>购买</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${financeReconciliation.status == 1}">selected="selected"</c:if>>平</option>
				                	<option value="2" <c:if test="${financeReconciliation.status == 2}">selected="selected"</c:if>>长款</option>
				                	<option value="3" <c:if test="${financeReconciliation.status == 3}">selected="selected"</c:if>>短款</option>
				                	<option value="4" <c:if test="${financeReconciliation.status == 4}">selected="selected"</c:if>>金融不一致</option>
				                	<option value="5" <c:if test="${financeReconciliation.status == 5}">selected="selected"</c:if>>积分不一致</option>
				                	<option value="6" <c:if test="${financeReconciliation.status == 6}">selected="selected"</c:if>>积分金额都不一致</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="createTime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="createTime" name="createTime" 
                            value="<fmt:formatDate value="${financeReconciliation.createTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="updateTime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="updateTime" name="updateTime" 
                            value="<fmt:formatDate value="${financeReconciliation.updateTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${financeReconciliation.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${financeReconciliation==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/finance/js/reconciliation.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->