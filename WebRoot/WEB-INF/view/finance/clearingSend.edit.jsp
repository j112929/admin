<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${financeClearingSend!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${financeClearingSend!=null}">"${BASE_URL}/financeClearingSend/edit"</c:when><c:otherwise>"${BASE_URL}/financeClearingSend/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="batchNo" class="col-sm-3 control-label">批次号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="batchNo" name="batchNo" value="${financeClearingSend.batchNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="buinessName" class="col-sm-3 control-label">商户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="buinessName" name="buinessName" value="${financeClearingSend.buinessName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="buinessNo" class="col-sm-3 control-label">商户号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="buinessNo" name="buinessNo" value="${financeClearingSend.buinessNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="message" class="col-sm-3 control-label">发送报文</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="message" name="message" value="${financeClearingSend.message}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">发送结果</label>
				        <div class="col-sm-4">
				            <select id="result" name="result" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeClearingSend.result == 0}">selected="selected"</c:if>>失败）</option>
				                	<option value="1" <c:if test="${financeClearingSend.result == 1}">selected="selected"</c:if>>成功</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="createTime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="createTime" name="createTime" 
                            value="<fmt:formatDate value="${financeClearingSend.createTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${financeClearingSend.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${financeClearingSend==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/finance/js/clearingSend.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->