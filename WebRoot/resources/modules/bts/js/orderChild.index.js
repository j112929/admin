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
		
				var id = $(this).attr("id");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/btsOrderChild/delete',
			data : 'id=' + id,
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
					property : 'id',
					label : '子订单id',
					sortable : false
				},
				{
					property : 'orderNo',
					label : '订单号',
					sortable : false
				},
				{
					property : 'orderChildNo',
					label : '子订单号',
					sortable : false
				},
				{
					property : 'type',
					label : '订单类型',
					sortable : false
				},
				{
					property : 'userId',
					label : '用户id',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户id',
					sortable : false
				},
				{
					property : 'remark',
					label : '子订单备注',
					sortable : false
				},
				{
					property : 'leaveMessage',
					label : '给卖家留言',
					sortable : false
				},
				{
					property : 'expressType',
					label : '快递类型',
					sortable : false
				},
				{
					property : 'expressNo',
					label : '快递单号',
					sortable : false
				},
				{
					property : 'invoiceTitle',
					label : '发票抬头',
					sortable : false
				},
				{
					property : 'status',
					label : '订单状态',
					sortable : false
				},
				{
					property : 'isCancel',
					label : '是否取消',
					sortable : false
				},
				{
					property : 'cancelReason',
					label : '取消原因',
					sortable : false
				},
				{
					property : 'isDel',
					label : '是否删除',
					sortable : false
				},
				{
					property : 'goodsAmount',
					label : '商品总价',
					sortable : false
				},
				{
					property : 'couponAmount',
					label : '优惠金额',
					sortable : false
				},
				{
					property : 'pointAmount',
					label : '积分总价',
					sortable : false
				},
				{
					property : 'freightAmount',
					label : '运费',
					sortable : false
				},
				{
					property : 'payableAmount',
					label : '应付金额',
					sortable : false
				},
				{
					property : 'payAmount',
					label : '实付金额',
					sortable : false
				},
				{
					property : 'payOrderType',
					label : '支付订单类型',
					sortable : false
				},
				{
					property : 'payType',
					label : '支付方式',
					sortable : false
				},
				{
					property : 'payStatus',
					label : '支付状态',
					sortable : false
				},
				{
					property : 'payTime',
					label : '支付时间',
					sortable : false
				},
				{
					property : 'sno',
					label : '兴支付流水号',
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
		item._query = '<a href="'+BASE_URL + '/btsOrderChild/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/btsOrderChild/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strType = '未知';
		if (item.type == 1) {
			strType = '普通';
		} else if (item.type == 2) {
			strType = '折扣';
		} else if (item.type == 3) {
			strType = '团购';
		} else if (item.type == 4) {
			strType = '秒杀';
		} else if (item.type == 5) {
			strType = '抽奖';
		}
        item.type = strType;

		var strStatus = '未知';
		if (item.status == 1) {
			strStatus = '待付款';
		} else if (item.status == 2) {
			strStatus = '待发货';
		} else if (item.status == 3) {
			strStatus = '待收货';
		} else if (item.status == 4) {
			strStatus = '待评价';
		} else if (item.status == 5) {
			strStatus = '退款';
		}
        item.status = strStatus;

		var strIsCancel = '未知';
		if (item.isCancel == 0) {
			strIsCancel = '未取消';
		} else if (item.isCancel == 1) {
			strIsCancel = '已取消';
		}
        item.isCancel = strIsCancel;

		var strIsDel = '未知';
		if (item.isDel == 0) {
			strIsDel = '未删除';
		} else if (item.isDel == 1) {
			strIsDel = '删除';
		}
        item.isDel = strIsDel;

		var strPayOrderType = '未知';
		if (item.payOrderType == 1) {
			strPayOrderType = '主订单';
		} else if (item.payOrderType == 2) {
			strPayOrderType = '子订单';
		}
        item.payOrderType = strPayOrderType;

		var strPayType = '未知';
		if (item.payType == 1) {
			strPayType = '本金支付';
		} else if (item.payType == 2) {
			strPayType = '积分支付';
		}
        item.payType = strPayType;

		var strPayStatus = '未知';
		if (item.payStatus == 0) {
			strPayStatus = '未支付';
		} else if (item.payStatus == 1) {
			strPayStatus = '已支付';
		}
        item.payStatus = strPayStatus;
		item.payTime = dateConverter(item.payTime, PATTERN_ENUM.datetime);
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
	});
}