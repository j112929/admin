<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<section class="hbox stretch">
    <aside class="bg-white">
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="m-t-sm">
                    <a href="#subNav" data-toggle="class:hide" class="btn btn-sm btn-default active btn-nav-goods" btn_nav_goods_index="0">
                        <i class="fa fa-caret-right text fa-lg"></i>
                        <i class="fa fa-caret-left text-active fa-lg"></i>
                    </a>
                        <a href="javascript:;" class="btn btn-sm btn-default" id="button_cancel"><i class="fa fa-reply"></i> 返回</a>
                </div>
            </header>
              
            <section class="scrollable wrapper">
                <section class="panel panel-default portlet-item">
	                <header class="panel-heading">商户表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">商户id：</td>
                                <td class="col-sm-4">${merchant.merchantId}</td>
                                <td class="col-sm-2">商户编号：</td>
                                <td class="col-sm-4">${merchant.merchantNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商户简称：</td>
                                <td class="col-sm-4">${merchant.name}</td>
                                <td class="col-sm-2">商户全称：</td>
                                <td class="col-sm-4">${merchant.fullName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">法人代表：</td>
                                <td class="col-sm-4">${merchant.legalPerson}</td>
                                <td class="col-sm-2">公司注册资金：</td>
                                <td class="col-sm-4">${merchant.registeredCapital}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">证件类型：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.cardType == 1}">
									身份证
									</c:if>
									<c:if test="${merchant.cardType == 2}">
									驾驶证
									</c:if>
									<c:if test="${merchant.cardType == 3}">
									护照
									</c:if>
								</td>
                                <td class="col-sm-2">证件号码：</td>
                                <td class="col-sm-4">${merchant.cardNo}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">公司类型：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.companyType == 1}">
									私营
									</c:if>
									<c:if test="${merchant.companyType == 2}">
									国企
									</c:if>
									<c:if test="${merchant.companyType == 3}">
									合资
									</c:if>
									<c:if test="${merchant.companyType == 4}">
									外企
									</c:if>
								</td>
                                <td class="col-sm-2">营业执照号码：</td>
                                <td class="col-sm-4">${merchant.businessLicenseNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">营业执照开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.businessLicenseBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">营业执照结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.businessLicenseEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">组织机构代码：</td>
                                <td class="col-sm-4">${merchant.organizationCode}</td>
                                <td class="col-sm-2">组织机构开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.organizationBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">组织机构结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.organizationEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">省份代码：</td>
                                <td class="col-sm-4">${merchant.province}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">城市代码：</td>
                                <td class="col-sm-4">${merchant.city}</td>
                                <td class="col-sm-2">区县代码：</td>
                                <td class="col-sm-4">${merchant.county}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">办公详细地址：</td>
                                <td class="col-sm-4">${merchant.address}</td>
                                <td class="col-sm-2">联系人姓名：</td>
                                <td class="col-sm-4">${merchant.linkmanName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">联系人电话：</td>
                                <td class="col-sm-4">${merchant.linkmanPhone}</td>
                                <td class="col-sm-2">联系人邮箱：</td>
                                <td class="col-sm-4">${merchant.linkmanEmail}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">合同开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.contractBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">合同结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.contractEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">清算账户户名：</td>
                                <td class="col-sm-4">${merchant.bankAccountName}</td>
                                <td class="col-sm-2">清算账号：</td>
                                <td class="col-sm-4">${merchant.bankAccount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开户行名称：</td>
                                <td class="col-sm-4">${merchant.bankName}</td>
                                <td class="col-sm-2">开户行编号：</td>
                                <td class="col-sm-4">${merchant.bankNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">开户行所在城市编码：</td>
                                <td class="col-sm-4">${merchant.bankCity}</td>
								<td class="col-sm-2">账户类型：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.bankAccountType == 1}">
									储蓄卡
									</c:if>
									<c:if test="${merchant.bankAccountType == 2}">
									信用卡
									</c:if>
									<c:if test="${merchant.bankAccountType == 3}">
									企业账户
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">财务联系人姓名：</td>
                                <td class="col-sm-4">${merchant.financeLinkmanName}</td>
                                <td class="col-sm-2">财务联系人电话：</td>
                                <td class="col-sm-4">${merchant.financeLinkmanPhone}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">财务联系人邮箱：</td>
                                <td class="col-sm-4">${merchant.financeLinkmanEmail}</td>
                                <td class="col-sm-2">附件：</td>
                                <td class="col-sm-4">${merchant.extraFile}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">合同：</td>
                                <td class="col-sm-4">${merchant.contractFile}</td>
                                <td class="col-sm-2">简介：</td>
                                <td class="col-sm-4">${merchant.description}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.verifyStatus == 0}">
									未审核
									</c:if>
									<c:if test="${merchant.verifyStatus == 1}">
									审核通过
									</c:if>
									<c:if test="${merchant.verifyStatus == 2}">
									审核不通过
									</c:if>
								</td>
								<td class="col-sm-2">是否终止：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.isStop == 0}">
									未终止
									</c:if>
									<c:if test="${merchant.isStop == 1}">
									终止
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${merchant.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${merchant.isDel == 1}">
									删除
									</c:if>
								</td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${merchant.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${merchant.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${merchant.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2"></td>
                                <td class="col-sm-4"></td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/merchant/js/merchant.detail.js" type="text/javascript"></script>
