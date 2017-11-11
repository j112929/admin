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
			url : BASE_URL + '/btsOrder/delete',
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
					label : '订单id',
					sortable : false
				},
				{
					property : 'orderNo',
					label : '订单号',
					sortable : false
				},
				{
					property : 'userId',
					label : '用户id',
					sortable : false
				},
				{
					property : 'remark',
					label : '订单备注',
					sortable : false
				},
				{
					property : 'consigneeRegionId',
					label : '收货地区id',
					sortable : false
				},
				{
					property : 'consigneeRegionName',
					label : '收货地区名称全称',
					sortable : false
				},
				{
					property : 'consigneeAddress',
					label : '收货人详细地址',
					sortable : false
				},
				{
					property : 'consigneeName',
					label : '收货人姓名',
					sortable : false
				},
				{
					property : 'consigneeEmail',
					label : '收货人邮箱',
					sortable : false
				},
				{
					property : 'consigneeZipcode',
					label : '收货人邮编',
					sortable : false
				},
				{
					property : 'consigneeMobileNo',
					label : '收货人手机号',
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
					property : 'discountAmount',
					label : '金币抵扣金额',
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
					property : 'payType',
					label : '支付方式',
					sortable : false
				},
				{
					property : 'payTime',
					label : '支付时间',
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
		item._query = '<a href="'+BASE_URL + '/btsOrder/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/btsOrder/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strStatus = '未知';
		if (item.status == 1) {
			strStatus = '待付款';
		} else if (item.status == 2) {
			strStatus = '已付款';
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

		var strPayType = '未知';
		if (item.payType == 1) {
			strPayType = '本金支付';
		} else if (item.payType == 2) {
			strPayType = '积分支付';
		}
        item.payType = strPayType;
		item.payTime = dateConverter(item.payTime, PATTERN_ENUM.datetime);
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
	});
}