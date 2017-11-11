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
	                <header class="panel-heading">商品spu详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">商品spu：</td>
                                <td class="col-sm-4">${goodsSpu.spuId}</td>
                                <td class="col-sm-2">商户id：</td>
                                <td class="col-sm-4">${goodsSpu.merchantId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">标准化产品单元：</td>
                                <td class="col-sm-4">${goodsSpu.spu}</td>
                                <td class="col-sm-2">商品名称：</td>
                                <td class="col-sm-4">${goodsSpu.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品品牌：</td>
                                <td class="col-sm-4">${goodsSpu.brandId}</td>
                                <td class="col-sm-2">商品一级分类：</td>
                                <td class="col-sm-4">${goodsSpu.categoryId1}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品二级分类：</td>
                                <td class="col-sm-4">${goodsSpu.categoryId2}</td>
                                <td class="col-sm-2">商品三级分类：</td>
                                <td class="col-sm-4">${goodsSpu.categoryId3}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">商品类型：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.goodsType == 1}">
									实物商品
									</c:if>
									<c:if test="${goodsSpu.goodsType == 2}">
									虚拟商品
									</c:if>
								</td>
								<td class="col-sm-2">商品显示端：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.viewType == 1}">
									手机端
									</c:if>
									<c:if test="${goodsSpu.viewType == 2}">
									web端
									</c:if>
									<c:if test="${goodsSpu.viewType == 3}">
									手机端和web端
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品配送范围：</td>
                                <td class="col-sm-4">${goodsSpu.regionId}</td>
								<td class="col-sm-2">是否支持本金支付：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isMoneyPay == 0}">
									不支持
									</c:if>
									<c:if test="${goodsSpu.isMoneyPay == 1}">
									支持
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否支持积分支付：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isPointPay == 0}">
									不支持
									</c:if>
									<c:if test="${goodsSpu.isPointPay == 1}">
									支持
									</c:if>
								</td>
								<td class="col-sm-2">是否支持混合支付：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isMixPay == 0}">
									不支持
									</c:if>
									<c:if test="${goodsSpu.isMixPay == 1}">
									支持
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否支持分期支付：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isInstallmentPay == 0}">
									不支持
									</c:if>
									<c:if test="${goodsSpu.isInstallmentPay == 1}">
									支持
									</c:if>
								</td>
								<td class="col-sm-2">是否支持退货：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isRefundable == 0}">
									不支持
									</c:if>
									<c:if test="${goodsSpu.isRefundable == 1}">
									支持
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否提供发票：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isInvoice == 0}">
									不提供
									</c:if>
									<c:if test="${goodsSpu.isInvoice == 1}">
									提供
									</c:if>
								</td>
                                <td class="col-sm-2">每月限购件数：</td>
                                <td class="col-sm-4">${goodsSpu.maxBuyCount}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">专享类型：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.vipType == 1}">
									生日专享
									</c:if>
									<c:if test="${goodsSpu.vipType == 2}">
									白金专享
									</c:if>
									<c:if test="${goodsSpu.vipType == 3}">
									白名单专享
									</c:if>
								</td>
								<td class="col-sm-2">是否有多SKU：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isMultSku == 0}">
									单SKU
									</c:if>
									<c:if test="${goodsSpu.isMultSku == 1}">
									多SKU
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">属性：</td>
                                <td class="col-sm-4">${goodsSpu.propertys}</td>
                                <td class="col-sm-2">图文详情：</td>
                                <td class="col-sm-4">${goodsSpu.pics}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品简介：</td>
                                <td class="col-sm-4">${goodsSpu.description}</td>
                                <td class="col-sm-2">促销语：</td>
                                <td class="col-sm-4">${goodsSpu.promotion}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">促销语开始时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSpu.promotionBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">促销语结束时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSpu.promotionEndTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">采购批次编号：</td>
                                <td class="col-sm-4">${goodsSpu.procurementBatchNo}</td>
                                <td class="col-sm-2">长：</td>
                                <td class="col-sm-4">${goodsSpu.length}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">宽：</td>
                                <td class="col-sm-4">${goodsSpu.wide}</td>
                                <td class="col-sm-2">高：</td>
                                <td class="col-sm-4">${goodsSpu.high}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">重量：</td>
                                <td class="col-sm-4">${goodsSpu.weight}</td>
                                <td class="col-sm-2">销售数量：</td>
                                <td class="col-sm-4">${goodsSpu.salesQuantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">销售金额：</td>
                                <td class="col-sm-4">${goodsSpu.salesAmount}</td>
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.status == 0}">
									下架
									</c:if>
									<c:if test="${goodsSpu.status == 1}">
									上架
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">前台是否显示：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isShow == 0}">
									不显示
									</c:if>
									<c:if test="${goodsSpu.isShow == 1}">
									显示
									</c:if>
								</td>
								<td class="col-sm-2">审核状态：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.verifyStatus == 0}">
									未审核
									</c:if>
									<c:if test="${goodsSpu.verifyStatus == 1}">
									审核通过
									</c:if>
									<c:if test="${goodsSpu.verifyStatus == 2}">
									审核不通过
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSpu.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${goodsSpu.isDel == 1}">
									删除
									</c:if>
								</td>
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${goodsSpu.creator}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSpu.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${goodsSpu.modifier}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSpu.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
<script src="${STATIC_URL}/modules/goods/js/spu.detail.js" type="text/javascript"></script>
