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
			url : BASE_URL + '/financeReconciliation/delete',
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
					label : '主键',
					sortable : false
				},
				{
					property : 'batchNo',
					label : '批次号',
					sortable : false
				},
				{
					property : 'sno',
					label : '交易流水号',
					sortable : false
				},
				{
					property : 'payType',
					label : '支付方式',
					sortable : false
				},
				{
					property : 'orderNo',
					label : '订单号',
					sortable : false
				},
				{
					property : 'cur',
					label : '币种',
					sortable : false
				},
				{
					property : 'mtransAmt',
					label : '我方交易金额',
					sortable : false
				},
				{
					property : 'transAmt',
					label : '收银台方交易金额',
					sortable : false
				},
				{
					property : 'mintegral',
					label : '我方交易积分',
					sortable : false
				},
				{
					property : 'tintegral',
					label : '收银台方交易积分',
					sortable : false
				},
				{
					property : 'businessDea',
					label : '交易类型',
					sortable : false
				},
				{
					property : 'status',
					label : '状态',
					sortable : false
				},
				{
					property : 'createTime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'updateTime',
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
		item._query = '<a href="'+BASE_URL + '/financeReconciliation/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/financeReconciliation/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strBusinessDea = '未知';
		if (item.businessDea == 0) {
			strBusinessDea = '退款';
		} else if (item.businessDea == 1) {
			strBusinessDea = '购买';
		}
        item.businessDea = strBusinessDea;

		var strStatus = '未知';
		if (item.status == 1) {
			strStatus = '平';
		} else if (item.status == 2) {
			strStatus = '长款';
		} else if (item.status == 3) {
			strStatus = '短款';
		} else if (item.status == 4) {
			strStatus = '金融不一致';
		} else if (item.status == 5) {
			strStatus = '积分不一致';
		} else if (item.status == 6) {
			strStatus = '积分金额都不一致';
		}
        item.status = strStatus;
		item.createTime = dateConverter(item.createTime, PATTERN_ENUM.datetime);
		item.updateTime = dateConverter(item.updateTime, PATTERN_ENUM.datetime);
	});
}