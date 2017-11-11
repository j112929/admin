<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${supplierContent!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${supplierContent!=null}">"${BASE_URL}/supplierContent/edit"</c:when><c:otherwise>"${BASE_URL}/supplierContent/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">供应商名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${supplierContent.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="nameSp" class="col-sm-3 control-label">供应商简称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="nameSp" name="nameSp" value="${supplierContent.nameSp}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="smemo" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="smemo" name="smemo" value="${supplierContent.smemo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="corporateName" class="col-sm-3 control-label">法人代表姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="corporateName" name="corporateName" value="${supplierContent.corporateName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="registered" class="col-sm-3 control-label">注册资金</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="registered" name="registered" value="${supplierContent.registered}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">证件类型</label>
				        <div class="col-sm-4">
				            <select id="cardType" name="cardType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${supplierContent.cardType == 0}">selected="selected"</c:if>>身份证</option>
				                	<option value="1" <c:if test="${supplierContent.cardType == 1}">selected="selected"</c:if>>护照</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cardNumber" class="col-sm-3 control-label">证件号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cardNumber" name="cardNumber" value="${supplierContent.cardNumber}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">公司类型</label>
				        <div class="col-sm-4">
				            <select id="type" name="type" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${supplierContent.type == 0}">selected="selected"</c:if>>私营</option>
				                	<option value="1" <c:if test="${supplierContent.type == 1}">selected="selected"</c:if>>国企</option>
				                	<option value="2" <c:if test="${supplierContent.type == 2}">selected="selected"</c:if>>合资</option>
				                	<option value="3" <c:if test="${supplierContent.type == 3}">selected="selected"</c:if>>外企</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="licence" class="col-sm-3 control-label">营业执照</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="licence" name="licence" value="${supplierContent.licence}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="organizationCard" class="col-sm-3 control-label">组织机构代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="organizationCard" name="organizationCard" value="${supplierContent.organizationCard}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="licenceBeginTime" class="col-sm-3 control-label">营业执照开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="licenceBeginTime" name="licenceBeginTime" 
                            value="<fmt:formatDate value="${supplierContent.licenceBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择营业执照开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="licenceEndTime" class="col-sm-3 control-label">营业执照结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="licenceEndTime" name="licenceEndTime" 
                            value="<fmt:formatDate value="${supplierContent.licenceEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择营业执照结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="organizationBeginTime" class="col-sm-3 control-label">组织机构开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="organizationBeginTime" name="organizationBeginTime" 
                            value="<fmt:formatDate value="${supplierContent.organizationBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择组织机构开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="organizationEndTime" class="col-sm-3 control-label">组织机构结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="organizationEndTime" name="organizationEndTime" 
                            value="<fmt:formatDate value="${supplierContent.organizationEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择组织机构结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="province" class="col-sm-3 control-label">省份代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="province" name="province" value="${supplierContent.province}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="city" class="col-sm-3 control-label">城市代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="city" name="city" value="${supplierContent.city}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="county" class="col-sm-3 control-label">区县代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="county" name="county" value="${supplierContent.county}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label">详细地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address" value="${supplierContent.address}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="email" class="col-sm-3 control-label">联系人邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="email" name="email" value="${supplierContent.email}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-3 control-label">联系人电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phone" name="phone" value="${supplierContent.phone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="agreementBeginTime" class="col-sm-3 control-label">合同开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="agreementBeginTime" name="agreementBeginTime" 
                            value="<fmt:formatDate value="${supplierContent.agreementBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择合同开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="agreementEndTime" class="col-sm-3 control-label">合同结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="agreementEndTime" name="agreementEndTime" 
                            value="<fmt:formatDate value="${supplierContent.agreementEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择合同结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="accountsName" class="col-sm-3 control-label">清算户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="accountsName" name="accountsName" value="${supplierContent.accountsName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="accountsCard" class="col-sm-3 control-label">清算账号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="accountsCard" name="accountsCard" value="${supplierContent.accountsCard}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bank" class="col-sm-3 control-label">开户行代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bank" name="bank" value="${supplierContent.bank}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankCard" class="col-sm-3 control-label">行号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankCard" name="bankCard" value="${supplierContent.bankCard}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankAddr" class="col-sm-3 control-label">开户行所在地</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankAddr" name="bankAddr" value="${supplierContent.bankAddr}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financialPerson" class="col-sm-3 control-label">财务联系人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financialPerson" name="financialPerson" value="${supplierContent.financialPerson}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financialEmail" class="col-sm-3 control-label">财务邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financialEmail" name="financialEmail" value="${supplierContent.financialEmail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financialPhone" class="col-sm-3 control-label">财务联系电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financialPhone" name="financialPhone" value="${supplierContent.financialPhone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${supplierContent.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${supplierContent.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="modifier" class="col-sm-3 control-label">修改人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="modifier" name="modifier" value="${supplierContent.modifier}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <input type="hidden" name="supplierId" value="${supplierContent.supplierId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${supplierContent==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/supplier/js/content.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->