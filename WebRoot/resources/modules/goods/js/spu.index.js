$(document).ready(function() {
	loadDataGridContent(columnsDefined(), 'formatData');

	/**
	 * 刷新或搜索
	 */
	$('body').delegate('.action-refresh, #action_search', 'click', function() {
		$('#content_listing').datagrid('reload');
	});

	/**
	 * 关键字搜索 - 支持回车
	 */
	$("input[name=key]").on('keypress', function(event) {
		if (event.which == '13') {
			$('#content_listing').datagrid('reload');
			return false;
		}
	});

	/**
	 * 单个删除
	 */
	$('body').delegate('.operate-delete', 'click', function() {
		var del = confirm('确定要删除吗？');
		if (!del) {
			return false;
		}
		
				var spuId = $(this).attr("spuId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsSpu/delete',
			data : 'spuId=' + spuId,
			dataType : 'json',
			timeout : 10000,
			success : function(data) {
				if (data.status == 0) {
					$('#content_listing').datagrid('reload');
				} else {
					alert(data.msg);
				}
				return false;
			}
		});
	});
});

function columnsDefined() {
	return [
				{
					property: '_query',
					label: ''
				},
				{
					property : 'spuId',
					label : '商品spu',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户id',
					sortable : false
				},
				{
					property : 'name',
					label : '商品名称',
					sortable : false
				},
				{
					property : 'brandId',
					label : '商品品牌',
					sortable : false
				},
				{
					property : 'categoryId1',
					label : '商品一级分类',
					sortable : false
				},
				{
					property : 'categoryId2',
					label : '商品二级分类',
					sortable : false
				},
				{
					property : 'categoryId3',
					label : '商品三级分类',
					sortable : false
				},
				{
					property : 'goodsType',
					label : '商品类型',
					sortable : false
				},
				{
					property : 'viewType',
					label : '商品显示端',
					sortable : false
				},
				{
					property : 'regionId',
					label : '商品配送范围',
					sortable : false
				},
				{
					property : 'isMoneyPay',
					label : '是否支持本金支付',
					sortable : false
				},
				{
					property : 'isPointPay',
					label : '是否支持积分支付',
					sortable : false
				},
				{
					property : 'isRefundable',
					label : '是否支持退货',
					sortable : false
				},
				{
					property : 'isInvoice',
					label : '是否提供发票',
					sortable : false
				},
				{
					property : 'maxBuyCount',
					label : '每月限购件数',
					sortable : false
				},
				{
					property : 'vipType',
					label : '专享类型',
					sortable : false
				},
				{
					property : 'promotion',
					label : '促销语',
					sortable : false
				},
				{
					property : 'promotionBeginTime',
					label : '促销语开始时间',
					sortable : false
				},
				{
					property : 'promotionEndTime',
					label : '促销语结束时间',
					sortable : false
				},
				{
					property : 'procurementBatchNo',
					label : '采购批次编号',
					sortable : false
				},
				{
					property : 'status',
					label : '状态',
					sortable : false
				},
				{
					property : 'isShow',
					label : '前台是否显示',
					sortable : false
				},
				{
					property : 'verifyStatus',
					label : '审核状态',
					sortable : false
				},
				{
					property : 'isDel',
					label : '是否删除',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : '_action',
					label : '操作',
					sortable : false
				} 
			];
}

function formatData(items) {
	$.each(items, function(index, item) {
		item._query = '<a href="'+BASE_URL + '/goodsSpu/detail?spuId=' + item.spuId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/goodsSpu/edit?spuId=' + item.spuId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" spuId="' + item.spuId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strGoodsType = '未知';
		if (item.goodsType == 1) {
			strGoodsType = '实物商品';
		} else if (item.goodsType == 2) {
			strGoodsType = '虚拟商品';
		}
        item.goodsType = strGoodsType;

		var strViewType = '未知';
		if (item.viewType == 1) {
			strViewType = '手机端';
		} else if (item.viewType == 2) {
			strViewType = 'web端';
		} else if (item.viewType == 3) {
			strViewType = '手机端和web端';
		}
        item.viewType = strViewType;

		var strIsMoneyPay = '未知';
		if (item.isMoneyPay == 0) {
			strIsMoneyPay = '不支持';
		} else if (item.isMoneyPay == 1) {
			strIsMoneyPay = '支持';
		}
        item.isMoneyPay = strIsMoneyPay;

		var strIsPointPay = '未知';
		if (item.isPointPay == 0) {
			strIsPointPay = '不支持';
		} else if (item.isPointPay == 1) {
			strIsPointPay = '支持';
		}
        item.isPointPay = strIsPointPay;

		var strIsMixPay = '未知';
		if (item.isMixPay == 0) {
			strIsMixPay = '不支持';
		} else if (item.isMixPay == 1) {
			strIsMixPay = '支持';
		}
        item.isMixPay = strIsMixPay;

		var strIsInstallmentPay = '未知';
		if (item.isInstallmentPay == 0) {
			strIsInstallmentPay = '不支持';
		} else if (item.isInstallmentPay == 1) {
			strIsInstallmentPay = '支持';
		}
        item.isInstallmentPay = strIsInstallmentPay;

		var strIsRefundable = '未知';
		if (item.isRefundable == 0) {
			strIsRefundable = '不支持';
		} else if (item.isRefundable == 1) {
			strIsRefundable = '支持';
		}
        item.isRefundable = strIsRefundable;

		var strIsInvoice = '未知';
		if (item.isInvoice == 0) {
			strIsInvoice = '不提供';
		} else if (item.isInvoice == 1) {
			strIsInvoice = '提供';
		}
        item.isInvoice = strIsInvoice;

		var strVipType = '未知';
		if (item.vipType == 1) {
			strVipType = '生日专享';
		} else if (item.vipType == 2) {
			strVipType = '白金专享';
		} else if (item.vipType == 3) {
			strVipType = '白名单专享';
		}
        item.vipType = strVipType;

		var strIsMultSku = '未知';
		if (item.isMultSku == 0) {
			strIsMultSku = '单SKU';
		} else if (item.isMultSku == 1) {
			strIsMultSku = '多SKU';
		}
        item.isMultSku = strIsMultSku;
		item.promotionBeginTime = dateConverter(item.promotionBeginTime, PATTERN_ENUM.datetime);
		item.promotionEndTime = dateConverter(item.promotionEndTime, PATTERN_ENUM.datetime);

		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = '下架';
		} else if (item.status == 1) {
			strStatus = '上架';
		}
        item.status = strStatus;

		var strIsShow = '未知';
		if (item.isShow == 0) {
			strIsShow = '不显示';
		} else if (item.isShow == 1) {
			strIsShow = '显示';
		}
        item.isShow = strIsShow;

		var strVerifyStatus = '未知';
		if (item.verifyStatus == 0) {
			strVerifyStatus = '未审核';
		} else if (item.verifyStatus == 1) {
			strVerifyStatus = '审核通过';
		} else if (item.verifyStatus == 2) {
			strVerifyStatus = '审核不通过';
		}
        item.verifyStatus = strVerifyStatus;

		var strIsDel = '未知';
		if (item.isDel == 0) {
			strIsDel = '未删除';
		} else if (item.isDel == 1) {
			strIsDel = '删除';
		}
        item.isDel = strIsDel;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}