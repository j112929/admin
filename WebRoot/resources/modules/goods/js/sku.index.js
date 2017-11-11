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
		
				var skuId = $(this).attr("skuId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsSku/delete',
			data : 'skuId=' + skuId,
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
					property : 'skuId',
					label : '商品sku',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户id',
					sortable : false
				},
				{
					property : 'spuId',
					label : '商品spu',
					sortable : false
				},
				{
					property : 'sku',
					label : '库存量单位',
					sortable : false
				},
				{
					property : 'propertys',
					label : '属性',
					sortable : false
				},
				{
					property : 'pics',
					label : 'sku图片',
					sortable : false
				},
				{
					property : 'stock',
					label : '库存',
					sortable : false
				},
				{
					property : 'stockWarn',
					label : '库存警戒',
					sortable : false
				},
				{
					property : 'originalPrice',
					label : '原价、市场价',
					sortable : false
				},
				{
					property : 'price',
					label : '本金价',
					sortable : false
				},
				{
					property : 'pointPrice',
					label : '积分价',
					sortable : false
				},
				{
					property : 'mixPrice',
					label : '混合支付本金价格',
					sortable : false
				},
				{
					property : 'mixPointPrice',
					label : '混合支付积分价',
					sortable : false
				},
				{
					property : 'chargeRate',
					label : '本金支付手续费率',
					sortable : false
				},
				{
					property : 'settlementPrice',
					label : '积分结算价格',
					sortable : false
				},
				{
					property : 'salesQuantity',
					label : 'sku销售数量',
					sortable : false
				},
				{
					property : 'salesAmount',
					label : 'sku销售金额',
					sortable : false
				},
				{
					property : 'collectCount',
					label : '收藏数',
					sortable : false
				},
				{
					property : 'commentCount',
					label : '评论数',
					sortable : false
				},
				{
					property : 'weight',
					label : '权重',
					sortable : false
				},
				{
					property : 'sortOrder',
					label : '序号',
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
					property : 'isDel',
					label : '是否删除',
					sortable : false
				},
				{
					property : 'creator',
					label : '创建人',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'modifier',
					label : '修改人',
					sortable : false
				},
				{
					property : 'mtime',
					label : '修改时间',
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
		item._query = '<a href="'+BASE_URL + '/goodsSku/detail?skuId=' + item.skuId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/goodsSku/edit?skuId=' + item.skuId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" skuId="' + item.skuId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strPropertys = '未知';
		if (item.propertys == 1) {
			strPropertys = '""valueName""白色"}{"id""';
		} else if (item.propertys == 3) {
			strPropertys = '""name""颜色""value""';
		} else if (item.propertys == 4) {
			strPropertys = '""name""尺码""value""1""valueName""X码"}]';
		}
        item.propertys = strPropertys;

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