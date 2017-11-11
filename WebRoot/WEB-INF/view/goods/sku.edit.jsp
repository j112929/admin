<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${goodsSku!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${goodsSku!=null}">"${BASE_URL}/goodsSku/edit"</c:when><c:otherwise>"${BASE_URL}/goodsSku/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="merchantId" class="col-sm-3 control-label">商户id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="merchantId" name="merchantId" value="${goodsSku.merchantId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="spuId" class="col-sm-3 control-label">商品spu</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="spuId" name="spuId" value="${goodsSku.spuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sku" class="col-sm-3 control-label">库存量单位</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sku" name="sku" value="${goodsSku.sku}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">属性</label>
				        <div class="col-sm-4">
				            <select id="propertys" name="propertys" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="1" <c:if test="${goodsSku.propertys == 1}">selected="selected"</c:if>>""valueName""白色"}{"id""</option>
				                	<option value="3" <c:if test="${goodsSku.propertys == 3}">selected="selected"</c:if>>""name""颜色""value""</option>
				                	<option value="4" <c:if test="${goodsSku.propertys == 4}">selected="selected"</c:if>>""name""尺码""value""1""valueName""X码"}]</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pics" class="col-sm-3 control-label">sku图片</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pics" name="pics" value="${goodsSku.pics}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="stock" class="col-sm-3 control-label">库存</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="stock" name="stock" value="${goodsSku.stock}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="stockWarn" class="col-sm-3 control-label">库存警戒</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="stockWarn" name="stockWarn" value="${goodsSku.stockWarn}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="originalPrice" class="col-sm-3 control-label">原价、市场价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="originalPrice" name="originalPrice" value="${goodsSku.originalPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="price" class="col-sm-3 control-label">本金价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price" name="price" value="${goodsSku.price}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pointPrice" class="col-sm-3 control-label">积分价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pointPrice" name="pointPrice" value="${goodsSku.pointPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mixPrice" class="col-sm-3 control-label">混合支付本金价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mixPrice" name="mixPrice" value="${goodsSku.mixPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="mixPointPrice" class="col-sm-3 control-label">混合支付积分价</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="mixPointPrice" name="mixPointPrice" value="${goodsSku.mixPointPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="chargeRate" class="col-sm-3 control-label">本金支付手续费率</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="chargeRate" name="chargeRate" value="${goodsSku.chargeRate}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="settlementPrice" class="col-sm-3 control-label">积分结算价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="settlementPrice" name="settlementPrice" value="${goodsSku.settlementPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="salesQuantity" class="col-sm-3 control-label">sku销售数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="salesQuantity" name="salesQuantity" value="${goodsSku.salesQuantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="salesAmount" class="col-sm-3 control-label">sku销售金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="salesAmount" name="salesAmount" value="${goodsSku.salesAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="collectCount" class="col-sm-3 control-label">收藏数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="collectCount" name="collectCount" value="${goodsSku.collectCount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="commentCount" class="col-sm-3 control-label">评论数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="commentCount" name="commentCount" value="${goodsSku.commentCount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="weight" class="col-sm-3 control-label">权重</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="weight" name="weight" value="${goodsSku.weight}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sortOrder" class="col-sm-3 control-label">序号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sortOrder" name="sortOrder" value="${goodsSku.sortOrder}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">状态</label>
				        <div class="col-sm-4">
				            <select id="status" name="status" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${goodsSku.status == 0}">selected="selected"</c:if>>下架</option>
				                	<option value="1" <c:if test="${goodsSku.status == 1}">selected="selected"</c:if>>上架</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">前台是否显示</label>
				        <div class="col-sm-4">
				            <select id="isShow" name="isShow" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${goodsSku.isShow == 0}">selected="selected"</c:if>>不显示</option>
				                	<option value="1" <c:if test="${goodsSku.isShow == 1}">selected="selected"</c:if>>显示</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否删除</label>
				        <div class="col-sm-4">
				            <select id="isDel" name="isDel" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${goodsSku.isDel == 0}">selected="selected"</c:if>>未删除</option>
				                	<option value="1" <c:if test="${goodsSku.isDel == 1}">selected="selected"</c:if>>删除</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="creator" class="col-sm-3 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="creator" name="creator" value="${goodsSku.creator}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${goodsSku.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="modifier" class="col-sm-3 control-label">修改人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="modifier" name="modifier" value="${goodsSku.modifier}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${goodsSku.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="skuId" value="${goodsSku.skuId}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${goodsSku==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/goods/js/sku.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->