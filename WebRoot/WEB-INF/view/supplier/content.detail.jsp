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
	                <header class="panel-heading">详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">供应商编号：</td>
                                <td class="col-sm-4">${supplierContent.supplierId}</td>
                                <td class="col-sm-2">供应商名称：</td>
                                <td class="col-sm-4">${supplierContent.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">供应商简称：</td>
                                <td class="col-sm-4">${supplierContent.nameSp}</td>
                                <td class="col-sm-2">备注：</td>
                                <td class="col-sm-4">${supplierContent.smemo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">法人代表姓名：</td>
                                <td class="col-sm-4">${supplierContent.corporateName}</td>
                                <td class="col-sm-2">注册资金：</td>
                                <td class="col-sm-4">${supplierContent.registered}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">证件类型：</td>
                                <td class="col-sm-4">
									<c:if test="${supplierContent.cardType == 0}">
									身份证
									</c:if>
									<c:if test="${supplierContent.cardType == 1}">
									护照
									</c:if>
								</td>
                                <td class="col-sm-2">证件号码：</td>
                                <td class="col-sm-4">${supplierContent.cardNumber}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">公司类型：</td>
                                <td class="col-sm-4">
									<c:if test="${supplierContent.type == 0}">
									私营
									</c:if>
									<c:if test="${supplierContent.type == 1}">
									国企
									</c:if>
									<c:if test="${supplierContent.type == 2}">
									合资
									</c:if>
									<c:if test="${supplierContent.type == 3}">
									外企
									</c:if>
								</td>
                                <td class="col-sm-2">营业执照：</td>
                                <td class="col-sm-4">${supplierContent.licence}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">组织机构代码：</td>
                                <td class="col-sm-4">${supplierContent.organizationCard}</td>
                                <td class="col-sm-2">营业执照开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.licenceBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">营业执照结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.licenceEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">组织机构开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.organizationBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">组织机构结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.organizationEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">省份代码：</td>
                                <td class="col-sm-4">${supplierContent.province}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">城市代码：</td>
                                <td class="col-sm-4">${supplierContent.city}</td>
                                <td class="col-sm-2">区县代码：</td>
                                <td class="col-sm-4">${supplierContent.county}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">详细地址：</td>
                                <td class="col-sm-4">${supplierContent.address}</td>
                                <td class="col-sm-2">联系人邮箱：</td>
                                <td class="col-sm-4">${supplierContent.email}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">联系人电话：</td>
                                <td class="col-sm-4">${supplierContent.phone}</td>
                                <td class="col-sm-2">合同开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.agreementBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">合同结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.agreementEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">清算户名：</td>
                                <td class="col-sm-4">${supplierContent.accountsName}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">清算账号：</td>
                                <td class="col-sm-4">${supplierContent.accountsCard}</td>
                                <td class="col-sm-2">开户行代码：</td>
                                <td class="col-sm-4">${supplierContent.bank}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">行号：</td>
                                <td class="col-sm-4">${supplierContent.bankCard}</td>
                                <td class="col-sm-2">开户行所在地：</td>
                                <td class="col-sm-4">${supplierContent.bankAddr}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">财务联系人：</td>
                                <td class="col-sm-4">${supplierContent.financialPerson}</td>
                                <td class="col-sm-2">财务邮箱：</td>
                                <td class="col-sm-4">${supplierContent.financialEmail}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">财务联系电话：</td>
                                <td class="col-sm-4">${supplierContent.financialPhone}</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${supplierContent.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${supplierContent.modifier}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/supplier/js/content.detail.js" type="text/javascript"></script>
