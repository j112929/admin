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
	                <header class="panel-heading">商品sku详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">商品sku：</td>
                                <td class="col-sm-4">${goodsSku.skuId}</td>
                                <td class="col-sm-2">商户id：</td>
                                <td class="col-sm-4">${goodsSku.merchantId}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">商品spu：</td>
                                <td class="col-sm-4">${goodsSku.spuId}</td>
                                <td class="col-sm-2">库存量单位：</td>
                                <td class="col-sm-4">${goodsSku.sku}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">属性：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSku.propertys == 1}">
									""valueName""白色"}{"id""
									</c:if>
									<c:if test="${goodsSku.propertys == 3}">
									""name""颜色""value""
									</c:if>
									<c:if test="${goodsSku.propertys == 4}">
									""name""尺码""value""1""valueName""X码"}]
									</c:if>
								</td>
                                <td class="col-sm-2">sku图片：</td>
                                <td class="col-sm-4">${goodsSku.pics}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">库存：</td>
                                <td class="col-sm-4">${goodsSku.stock}</td>
                                <td class="col-sm-2">库存警戒：</td>
                                <td class="col-sm-4">${goodsSku.stockWarn}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">原价、市场价：</td>
                                <td class="col-sm-4">${goodsSku.originalPrice}</td>
                                <td class="col-sm-2">本金价：</td>
                                <td class="col-sm-4">${goodsSku.price}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">积分价：</td>
                                <td class="col-sm-4">${goodsSku.pointPrice}</td>
                                <td class="col-sm-2">混合支付本金价格：</td>
                                <td class="col-sm-4">${goodsSku.mixPrice}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">混合支付积分价：</td>
                                <td class="col-sm-4">${goodsSku.mixPointPrice}</td>
                                <td class="col-sm-2">本金支付手续费率：</td>
                                <td class="col-sm-4">${goodsSku.chargeRate}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">积分结算价格：</td>
                                <td class="col-sm-4">${goodsSku.settlementPrice}</td>
                                <td class="col-sm-2">sku销售数量：</td>
                                <td class="col-sm-4">${goodsSku.salesQuantity}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">sku销售金额：</td>
                                <td class="col-sm-4">${goodsSku.salesAmount}</td>
                                <td class="col-sm-2">收藏数：</td>
                                <td class="col-sm-4">${goodsSku.collectCount}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">评论数：</td>
                                <td class="col-sm-4">${goodsSku.commentCount}</td>
                                <td class="col-sm-2">权重：</td>
                                <td class="col-sm-4">${goodsSku.weight}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${goodsSku.sortOrder}</td>
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSku.status == 0}">
									下架
									</c:if>
									<c:if test="${goodsSku.status == 1}">
									上架
									</c:if>
								</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">前台是否显示：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSku.isShow == 0}">
									不显示
									</c:if>
									<c:if test="${goodsSku.isShow == 1}">
									显示
									</c:if>
								</td>
								<td class="col-sm-2">是否删除：</td>
                                <td class="col-sm-4">
									<c:if test="${goodsSku.isDel == 0}">
									未删除
									</c:if>
									<c:if test="${goodsSku.isDel == 1}">
									删除
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">创建人：</td>
                                <td class="col-sm-4">${goodsSku.creator}</td>
                                <td class="col-sm-2">创建时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSku.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">修改人：</td>
                                <td class="col-sm-4">${goodsSku.modifier}</td>
                                <td class="col-sm-2">修改时间：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${goodsSku.mtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/goods/js/sku.detail.js" type="text/javascript"></script>
