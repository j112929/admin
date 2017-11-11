<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${merchant!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${merchant!=null}">"${BASE_URL}/merchant/edit"</c:when><c:otherwise>"${BASE_URL}/merchant/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="merchantNo" class="col-sm-3 control-label">商户编号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="merchantNo" name="merchantNo" value="${merchant.merchantNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">商户简称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${merchant.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="fullName" class="col-sm-3 control-label">商户全称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="fullName" name="fullName" value="${merchant.fullName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="legalPerson" class="col-sm-3 control-label">法人代表</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="legalPerson" name="legalPerson" value="${merchant.legalPerson}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="registeredCapital" class="col-sm-3 control-label">公司注册资金</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="registeredCapital" name="registeredCapital" value="${merchant.registeredCapital}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">证件类型</label>
				        <div class="col-sm-4">
				            <select id="cardType" name="cardType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${merchant.cardType == 1}">selected="selected"</c:if>>身份证</option>
				                	<option value="2" <c:if test="${merchant.cardType == 2}">selected="selected"</c:if>>驾驶证</option>
				                	<option value="3" <c:if test="${merchant.cardType == 3}">selected="selected"</c:if>>护照</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="cardNo" class="col-sm-3 control-label">证件号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="cardNo" name="cardNo" value="${merchant.cardNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">公司类型</label>
				        <div class="col-sm-4">
				            <select id="companyType" name="companyType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${merchant.companyType == 1}">selected="selected"</c:if>>私营</option>
				                	<option value="2" <c:if test="${merchant.companyType == 2}">selected="selected"</c:if>>国企</option>
				                	<option value="3" <c:if test="${merchant.companyType == 3}">selected="selected"</c:if>>合资</option>
				                	<option value="4" <c:if test="${merchant.companyType == 4}">selected="selected"</c:if>>外企</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="businessLicenseNo" class="col-sm-3 control-label">营业执照号码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="businessLicenseNo" name="businessLicenseNo" value="${merchant.businessLicenseNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="businessLicenseBeginTime" class="col-sm-3 control-label">营业执照开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="businessLicenseBeginTime" name="businessLicenseBeginTime" 
                            value="<fmt:formatDate value="${merchant.businessLicenseBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择营业执照开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="businessLicenseEndTime" class="col-sm-3 control-label">营业执照结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="businessLicenseEndTime" name="businessLicenseEndTime" 
                            value="<fmt:formatDate value="${merchant.businessLicenseEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择营业执照结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="organizationCode" class="col-sm-3 control-label">组织机构代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="organizationCode" name="organizationCode" value="${merchant.organizationCode}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="organizationBeginTime" class="col-sm-3 control-label">组织机构开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="organizationBeginTime" name="organizationBeginTime" 
                            value="<fmt:formatDate value="${merchant.organizationBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择组织机构开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="organizationEndTime" class="col-sm-3 control-label">组织机构结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="organizationEndTime" name="organizationEndTime" 
                            value="<fmt:formatDate value="${merchant.organizationEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择组织机构结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="province" class="col-sm-3 control-label">省份代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="province" name="province" value="${merchant.province}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="city" class="col-sm-3 control-label">城市代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="city" name="city" value="${merchant.city}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="county" class="col-sm-3 control-label">区县代码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="county" name="county" value="${merchant.county}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="address" class="col-sm-3 control-label">办公详细地址</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address" value="${merchant.address}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="linkmanName" class="col-sm-3 control-label">联系人姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="linkmanName" name="linkmanName" value="${merchant.linkmanName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="linkmanPhone" class="col-sm-3 control-label">联系人电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="linkmanPhone" name="linkmanPhone" value="${merchant.linkmanPhone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="linkmanEmail" class="col-sm-3 control-label">联系人邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="linkmanEmail" name="linkmanEmail" value="${merchant.linkmanEmail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="contractBeginTime" class="col-sm-3 control-label">合同开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="contractBeginTime" name="contractBeginTime" 
                            value="<fmt:formatDate value="${merchant.contractBeginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择合同开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="contractEndTime" class="col-sm-3 control-label">合同结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="contractEndTime" name="contractEndTime" 
                            value="<fmt:formatDate value="${merchant.contractEndTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择合同结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="bankAccountName" class="col-sm-3 control-label">清算账户户名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankAccountName" name="bankAccountName" value="${merchant.bankAccountName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankAccount" class="col-sm-3 control-label">清算账号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankAccount" name="bankAccount" value="${merchant.bankAccount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankName" class="col-sm-3 control-label">开户行名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankName" name="bankName" value="${merchant.bankName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankNo" class="col-sm-3 control-label">开户行编号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankNo" name="bankNo" value="${merchant.bankNo}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankCity" class="col-sm-3 control-label">开户行所在城市编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankCity" name="bankCity" value="${merchant.bankCity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">账户类型</label>
				        <div class="col-sm-4">
				            <select id="bankAccountType" name="bankAccountType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${merchant.bankAccountType == 1}">selected="selected"</c:if>>储蓄卡</option>
				                	<option value="2" <c:if test="${merchant.bankAccountType == 2}">selected="selected"</c:if>>信用卡</option>
				                	<option value="3" <c:if test="${merchant.bankAccountType == 3}">selected="selected"</c:if>>企业账户</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financeLinkmanName" class="col-sm-3 control-label">财务联系人姓名</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financeLinkmanName" name="financeLinkmanName" value="${merchant.financeLinkmanName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financeLinkmanPhone" class="col-sm-3 control-label">财务联系人电话</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financeLinkmanPhone" name="financeLinkmanPhone" value="${merchant.financeLinkmanPhone}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="financeLinkmanEmail" class="col-sm-3 control-label">财务联系人邮箱</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="financeLinkmanEmail" name="financeLinkmanEmail" value="${merchant.financeLinkmanEmail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="extraFile" class="col-sm-3 control-label">附件</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="extraFile" name="extraFile" value="${merchant.extraFile}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="contractFile" class="col-sm-3 control-label">合同</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="contractFile" name="contractFile" value="${merchant.contractFile}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">简介</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${merchant.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核状态</label>
				        <div class="col-sm-4">
				            <select id="verifyStatus" name="verifyStatus" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${merchant.verifyStatus == 0}">selected="selected"</c:if>>未审核</option>
				                	<option value="1" <c:if test="${merchant.verifyStatus == 1}">selected="selected"</c:if>>审核通过</option>
				                	<option value="2" <c:if test="${merchant.verifyStatus == 2}">selected="selected"</c:if>>审核不通过</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否终止</label>
				        <div class="col-sm-4">
				            <select id="isStop" name="isStop" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${merchant.isStop == 0}">selected="selected"</c:if>>未终止</option>
				                	<option value="1" <c:if test="${merchant.isStop == 1}">selected="selected"</c:if>>终止</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否删除</label>
				        <div class="col-sm-4">
				            <select id="isDel" name="isDel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${merchant.isDel == 0}">selected="selected"</c:if>>未删除</option>
				                	<option value="1" <c:if test="${merchant.isDel == 1}">selected="selected"</c:if>>删除</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="creator" class="col-sm-3 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="creator" name="creator" value="${merchant.creator}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${merchant.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="modifier" class="col-sm-3 control-label">修改人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="modifier" name="modifier" value="${merchant.modifier}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${merchant.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="merchantId" value="${merchant.merchantId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${merchant==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/merchant/js/merchant.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->