<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${financeClearing!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${financeClearing!=null}">"${BASE_URL}/financeClearing/edit"</c:when><c:otherwise>"${BASE_URL}/financeClearing/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="batchNo" class="col-sm-3 control-label">批次号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="batchNo" name="batchNo" value="${financeClearing.batchNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="payType" class="col-sm-3 control-label">支付方式</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="payType" name="payType" value="${financeClearing.payType}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sno" class="col-sm-3 control-label">交易流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sno" name="sno" value="${financeClearing.sno}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="orderNo" class="col-sm-3 control-label">订单号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="orderNo" name="orderNo" value="${financeClearing.orderNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="buinessName" class="col-sm-3 control-label">商户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="buinessName" name="buinessName" value="${financeClearing.buinessName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="buinessNo" class="col-sm-3 control-label">商户号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="buinessNo" name="buinessNo" value="${financeClearing.buinessNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">交易类型</label>
				        <div class="col-sm-4">
				            <select id="businessDeal" name="businessDeal" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeClearing.businessDeal == 0}">selected="selected"</c:if>>退款</option>
				                	<option value="1" <c:if test="${financeClearing.businessDeal == 1}">selected="selected"</c:if>>购买</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cur" class="col-sm-3 control-label">币种</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cur" name="cur" value="${financeClearing.cur}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="transAmt" class="col-sm-3 control-label">清算金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="transAmt" name="transAmt" value="${financeClearing.transAmt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="integral" class="col-sm-3 control-label">积分</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="integral" name="integral" value="${financeClearing.integral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="channel" class="col-sm-3 control-label">来源渠道</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="channel" name="channel" value="${financeClearing.channel}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">手工清算</label>
				        <div class="col-sm-4">
				            <select id="flag" name="flag" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeClearing.flag == 0}">selected="selected"</c:if>>手工清算</option>
				                	<option value="1" <c:if test="${financeClearing.flag == 1}">selected="selected"</c:if>>自动清算）</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="paybkNo" class="col-sm-3 control-label">银行卡号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="paybkNo" name="paybkNo" value="${financeClearing.paybkNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="paybkCode" class="col-sm-3 control-label">开户行</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="paybkCode" name="paybkCode" value="${financeClearing.paybkCode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="receiptTime" class="col-sm-3 control-label">账务日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="receiptTime" name="receiptTime" 
                            value="<fmt:formatDate value="${financeClearing.receiptTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择账务日期时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="createTime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="createTime" name="createTime" 
                            value="<fmt:formatDate value="${financeClearing.createTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${financeClearing.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${financeClearing==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/finance/js/clearing.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->