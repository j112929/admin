<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${STATIC_URL}/plugins/jquery/1.11.0/jquery.min.js"></script>

<section class="edit-map wrapper" id="edit_base">
	<section class="panel panel-default">
		<header class="panel-heading font-bold">基本信息</header>
		<div class="panel-body">
			<div class="form-group m-b-xs">
				<label class="col-sm-2 control-label"><font class="red">* </font>所属分类</label>
				<div class="col-sm-2">
				<input name="" value="${categoryTO.firstCategoryName}" readonly="readonly" class="form-control"/> &nbsp;&nbsp;
				<input name="" value="${categoryTO.secondCategoryName}" readonly="readonly" class="form-control"/> &nbsp;&nbsp;
				<input name="" value="${categoryTO.thirdCategoryName}" readonly="readonly" class="form-control"/>
				<input name="categoryId1" type="hidden" value="${categoryTO.firstCateGoryId}"/>
				<input name="categoryId2" type="hidden" value="${categoryTO.secondCateGoryId}"/>
				<input name="categoryId3" type="hidden" value="${categoryTO.thirdCateGoryId}"/>
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>

			<div class="form-group m-b-xs">
				<label class="col-sm-2 control-label"><font class="red">* </font>所属品牌</label>
				<div class="col-sm-6">
					<select name="brandId" id="brandId" class="form-control">
						<option value="0">请选择品牌</option>
						<c:forEach items="${goodsBrand}" var="b">
						<option value="${b.id}">${b.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>商品显示端</label>
				<div class="col-sm-6">
					<input type="radio" class="" id="category_id7" name="viewType" checked="checked" value="1"/>手机端 &nbsp;&nbsp;
					<input type="radio" class="" id="category_id7" name="viewType" value="2"/>平台端 &nbsp;&nbsp;
					<input type="radio" class="" id="category_id7" name="viewType" value="3"/>平台端+手机端
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>商品类型</label>
				<div class="col-sm-6">
					<input type="radio" class="" id="category_id7" name="goodsType" checked="checked" value="1"/>实物商品 &nbsp;&nbsp;
					<input type="radio" class="" id="category_id7" name="goodsType" value="2"/>虚拟商品&nbsp;&nbsp;
					充值卡、加油卡等属于虚拟商品
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>

			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>商品名称</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="name" name="name" value="${spu.name}" placeholder="请输入商品名称" />
					最少3个字符，最多50个中文汉字，不可输入非法字符
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>是否支持退货</label>
				<div class="col-sm-6">
					<input type="radio" class="" id="is_refundable" name="isRefundable" checked="checked" value="0"/>不支持 &nbsp;&nbsp;
					<input type="radio" class="" id="is_refundable" name="isRefundable" value="1"/>支持 &nbsp;&nbsp;
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>是否提供发票</label>
				<div class="col-sm-6">
					<input type="radio" class="" id="category_id7" name="isInvoice" checked="checked" value="0"/>否&nbsp;&nbsp;
					<input type="radio" class="" id="category_id7" name="isInvoice" value="1"/>是 &nbsp;&nbsp;
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label">每月限购件数</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="max_buy_count" name="maxBuyCount" value="${spu.maxBuyCount}" placeholder="请输入每月限购件数" />
					每月每人限购件数,超过此件数将不能购买，留空将不限制
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label">是否支持专享</label>
				<div class="col-sm-6">
					<input type="radio" class="" id="vip_type" name="vipType" checked="checked" value="0"/>不支持
					<input type="radio" class="" id="vip_type" name="vipType" value="1"/>生日专享 &nbsp;&nbsp;
					<input type="radio" class="" id="vip_type" name="vipType" value="2"/>白金专享 &nbsp;&nbsp;
					<input type="radio" class="" id="vip_type" name="vipType" value="3"/>白名单专享
					
					选择商品支持的专享，此专享商品只有指定客户购买
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label">促销语</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="max_buy_count" name="promotion" value="${spu.promotion}" placeholder="" />
					非必填，最少3个字符，最多50个中文汉字
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label">促销语有效期</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="max_buy_count" name="promotionStime" value="" placeholder="日期" />
					<input type="text" class="form-control" id="max_buy_count" name="promotionStime" value="" placeholder="日期" />
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label">采购批次编号</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="max_buy_count" name="procurementBatchNo" value="${spu.procurementBatchNo}" placeholder=""/>
					选填，具体填写内容询问银行方
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label class="col-sm-2 control-label">商品配送范围</label>
				<div class="col-sm-6">
					<select name="regionId" id="regionId" class="form-control">
						<option value="0">全国</option>
						<c:forEach items="${goodsBrand}" var="b">
						<option value="${b.id}">${b.name}</option>
						</c:forEach>
					</select>
					商品支持派送的范围，精确到省份，除选中地区外，其他地址不能购买此商品
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>
			
			<div class="form-group m-b-xs">
				<label for="name" class="col-sm-2 control-label"><font class="red">* </font>选择支付方式</label>
				<div class="col-sm-6">
					<input type="checkbox" class="" id="pay_type" name="payType" value="1" onclick="paytype()"/>本金支付 &nbsp;&nbsp;
					<input type="checkbox" class="" id="pay_type" name="payType" value="2" onclick="paytype()"/>积分支付 &nbsp;&nbsp;
					<!-- <input type="checkbox" class="" id="pay_type" name="payType" value="3"/>分期支付 -->
				</div>
			</div>
			<div class="line line-dashed line-sm pull-in"></div>

		</div>
	</section>

	<section class="panel panel-default " id="edit_base_spec">
		<header class="panel-heading font-bold">选择规格</header>

		<div class="panel-body no-padder">
			<table class="table table-striped m-b-none text-sm" id="spec_option_list">
				<thead>
					<tr>
						<th>规格</th>
						<th>规格值</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<table class="table table-striped m-b-none text-sm" id="spec_list">
		<thead>
		<c:forEach items="${properties}" var="p" begin="0" varStatus="i">
					<c:if test="${p.goodsProperty.isSku==1}">
					<tr>
						<th>${p.goodsProperty.name}
						<input type="hidden" name="skuPropertyId" value="${p.goodsProperty.id}">
						</th>
						<th><c:forEach items="${p.goodsPropertyValue}" var="gpv">
						<input type="checkbox" id="${p.goodsProperty.isPic}" name="gpv_${i.index}" alt="${gpv.name}" value="${gpv.id}" onclick="fun('${gpv.id}','${gpv.name}','${p.goodsProperty.isPic}')"/>${gpv.name}&nbsp;&nbsp;
						</c:forEach>
						</th>
					</tr>
					</c:if>
		</c:forEach>
				</thead>
		</table>

	</section>

	<section class="panel panel-default" id="edit_base_spec">
		<header class="panel-heading font-bold">编辑规格</header>
		<div align="center">
			<table id="createTable">
				<thead>
					<tr>
						<c:forEach items="${properties}" var="p">
						<c:if test="${p.goodsProperty.isSku==1}">
						<th align="center" style="width: 10%;text-align: center;">${p.goodsProperty.name}</th>
						</c:if>
						</c:forEach>
						<th align="center" style="width: 10%;text-align: center;">库存 <input type="text" data-filed="stock" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;">警戒库存 <input type="text" data-filed="stockWarn" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;">原价 <input type="text" data-filed="originalPrice" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;display:none" class="pay_type_1">本金出售价<input type="text" data-filed="price" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;display:none" class="pay_type_1">本金手续费率 <input type="text" data-filed="chargeRate" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;display:none" class="pay_type_2">积分出售价 <input type="text" data-filed="pointPrice" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
						<th align="center" style="width: 10%;text-align: center;display:none" class="pay_type_2">积分结算价 <input type="text" data-filed="settlementPrice" style="width: 40px;" value="" /><input type="button" title="批量设置" value="设置" onclick="addValues(this);" /></th>
					</tr>
				</thead>
				<tbody id="edit_base_tbody">
				
				</tbody>
			</table>
		</div>
	</section>

	<input type="hidden" id="contentId" name="contentId" value='${contentId}' /> <input type="hidden" id="properties" value='${properties}' /> <input type="hidden" id="valueId" value='${valueId}' /> <input type="hidden" id="contentSkus" value='${contentSkus}' /> <input type="hidden" id="contentSkuTos" value='${contentSkuTos}' />

	<section class="panel panel-default" id="edit_base_property">
		<header class="panel-heading font-bold">扩展属性</header>
		<div class="panel-body">
			<c:forEach items="${properties}" var="p" begin="0" varStatus="i">
			<c:if test="${p.goodsProperty.isSku==0}">
				<div class="form-group m-b-xs">
				<label class="col-sm-2 control-label">${p.goodsProperty.name}</label>
				<input type="hidden" name="spuPropertyId" value="${p.goodsProperty.id}">
				<div class="col-sm-6">
					<select name="spuPropertyValueId" class="form-control">
						<c:forEach items="${p.goodsPropertyValue}" var="gpv">
							<option value="${gpv.id}">${gpv.name}</option>
						</c:forEach>
					</select>
				</div>
				<div class="line line-dashed line-sm pull-in"></div>
				</div>
			</c:if>
			</c:forEach>

		</div>
	</section>
	<script type="text/javascript">
	$("#brandId").val('${spu.brandId}');
	$("#regionId").val('${spu.regionId}');
	$(function () {
		isChecked('${spu.viewType}', 'viewType');
		isChecked('${spu.goodsType}', 'goodsType');
		isChecked('${spu.isRefundable}', 'isRefundable');
		isChecked('${spu.isInvoice}', 'isInvoice');
		isChecked('${spu.vipType}', 'vipType');
	});
	</script>
</section>