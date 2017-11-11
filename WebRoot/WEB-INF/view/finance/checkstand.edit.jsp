<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${financeCheckstand!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${financeCheckstand!=null}">"${BASE_URL}/financeCheckstand/edit"</c:when><c:otherwise>"${BASE_URL}/financeCheckstand/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="batchNo" class="col-sm-3 control-label">批次号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="batchNo" name="batchNo" value="${financeCheckstand.batchNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="appid" class="col-sm-3 control-label">APPID</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="appid" name="appid" value="${financeCheckstand.appid}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="channelNo" class="col-sm-3 control-label">渠道号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="channelNo" name="channelNo" value="${financeCheckstand.channelNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sno" class="col-sm-3 control-label">兴知付流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sno" name="sno" value="${financeCheckstand.sno}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mrchSno" class="col-sm-3 control-label">商户流水号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mrchSno" name="mrchSno" value="${financeCheckstand.mrchSno}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">账单类型</label>
				        <div class="col-sm-4">
				            <select id="receiptType" name="receiptType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${financeCheckstand.receiptType == 1}">selected="selected"</c:if>>-出账入账合一</option>
				                	<option value="2" <c:if test="${financeCheckstand.receiptType == 2}">selected="selected"</c:if>>-入账</option>
				                	<option value="3" <c:if test="${financeCheckstand.receiptType == 3}">selected="selected"</c:if>>-出账</option>
				                	<option value="4" <c:if test="${financeCheckstand.receiptType == 4}">selected="selected"</c:if>>-存疑</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">存疑类型</label>
				        <div class="col-sm-4">
				            <select id="impeachType" name="impeachType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${financeCheckstand.impeachType == 1}">selected="selected"</c:if>>-渠道方成功</option>
				                	<option value="2" <c:if test="${financeCheckstand.impeachType == 2}">selected="selected"</c:if>>-渠道方失败</option>
				                	<option value="3" <c:if test="${financeCheckstand.impeachType == 3}">selected="selected"</c:if>>-渠道方少</option>
				                	<option value="4" <c:if test="${financeCheckstand.impeachType == 4}">selected="selected"</c:if>>-金额不匹配</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="integral" class="col-sm-3 control-label">积分</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="integral" name="integral" value="${financeCheckstand.integral}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cur" class="col-sm-3 control-label">币种</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cur" name="cur" value="${financeCheckstand.cur}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="transAmt" class="col-sm-3 control-label">交易金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="transAmt" name="transAmt" value="${financeCheckstand.transAmt}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="payTime" class="col-sm-3 control-label">支付时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="payTime" name="payTime" 
                            value="<fmt:formatDate value="${financeCheckstand.payTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择支付时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="receiptTime" class="col-sm-3 control-label">账务日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="receiptTime" name="receiptTime" 
                            value="<fmt:formatDate value="${financeCheckstand.receiptTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择账务日期时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="createTime" class="col-sm-3 control-label">创建日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="createTime" name="createTime" 
                            value="<fmt:formatDate value="${financeCheckstand.createTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建日期时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${financeCheckstand.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${financeCheckstand==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/finance/js/checkstand.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->