<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${financeBatch!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${financeBatch!=null}">"${BASE_URL}/financeBatch/edit"</c:when><c:otherwise>"${BASE_URL}/financeBatch/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="batchNo" class="col-sm-3 control-label">批次号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="batchNo" name="batchNo" value="${financeBatch.batchNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="receiptTime" class="col-sm-3 control-label">账务日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="receiptTime" name="receiptTime" 
                            value="<fmt:formatDate value="${financeBatch.receiptTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择账务日期时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="createTime" class="col-sm-3 control-label">创建日期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="createTime" name="createTime" 
                            value="<fmt:formatDate value="${financeBatch.createTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建日期时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="channeNo" class="col-sm-3 control-label">渠道号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="channeNo" name="channeNo" value="${financeBatch.channeNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName1" class="col-sm-3 control-label">文件名1</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName1" name="fileName1" value="${financeBatch.fileName1}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName2" class="col-sm-3 control-label">文件名2</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName2" name="fileName2" value="${financeBatch.fileName2}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName3" class="col-sm-3 control-label">文件名3</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName3" name="fileName3" value="${financeBatch.fileName3}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName4" class="col-sm-3 control-label">文件名4</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName4" name="fileName4" value="${financeBatch.fileName4}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName5" class="col-sm-3 control-label">文件名5</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName5" name="fileName5" value="${financeBatch.fileName5}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fileName6" class="col-sm-3 control-label">文件名6</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fileName6" name="fileName6" value="${financeBatch.fileName6}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="thirdbackAmount" class="col-sm-3 control-label">收银台支付金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="thirdbackAmount" name="thirdbackAmount" value="${financeBatch.thirdbackAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">获取对账文件是否成功</label>
				        <div class="col-sm-4">
				            <select id="flag" name="flag" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeBatch.flag == 0}">selected="selected"</c:if>>否</option>
				                	<option value="1" <c:if test="${financeBatch.flag == 1}">selected="selected"</c:if>>是</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${financeBatch.status == 0}">selected="selected"</c:if>>B</option>
				                	<option value="1" <c:if test="${financeBatch.status == 1}">selected="selected"</c:if>>权益</option>
				                	<option value="2" <c:if test="${financeBatch.status == 2}">selected="selected"</c:if>>C</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="successTotal" class="col-sm-3 control-label">成功笔数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="successTotal" name="successTotal" value="${financeBatch.successTotal}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="faileTotal" class="col-sm-3 control-label">失败笔数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="faileTotal" name="faileTotal" value="${financeBatch.faileTotal}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <input type="hidden" name="id" value="${financeBatch.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${financeBatch==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/finance/js/batch.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->