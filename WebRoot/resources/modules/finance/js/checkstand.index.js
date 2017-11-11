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
			url : BASE_URL + '/financeCheckstand/delete',
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
					property : 'appid',
					label : 'APPID',
					sortable : false
				},
				{
					property : 'channelNo',
					label : '渠道号',
					sortable : false
				},
				{
					property : 'sno',
					label : '兴知付流水号',
					sortable : false
				},
				{
					property : 'mrchSno',
					label : '商户流水号',
					sortable : false
				},
				{
					property : 'receiptType',
					label : '账单类型',
					sortable : false
				},
				{
					property : 'impeachType',
					label : '存疑类型',
					sortable : false
				},
				{
					property : 'integral',
					label : '积分',
					sortable : false
				},
				{
					property : 'cur',
					label : '币种',
					sortable : false
				},
				{
					property : 'transAmt',
					label : '交易金额',
					sortable : false
				},
				{
					property : 'payTime',
					label : '支付时间',
					sortable : false
				},
				{
					property : 'receiptTime',
					label : '账务日期',
					sortable : false
				},
				{
					property : 'createTime',
					label : '创建日期',
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
		item._query = '<a href="'+BASE_URL + '/financeCheckstand/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/financeCheckstand/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strReceiptType = '未知';
		if (item.receiptType == 1) {
			strReceiptType = '-出账入账合一';
		} else if (item.receiptType == 2) {
			strReceiptType = '-入账';
		} else if (item.receiptType == 3) {
			strReceiptType = '-出账';
		} else if (item.receiptType == 4) {
			strReceiptType = '-存疑';
		}
        item.receiptType = strReceiptType;

		var strImpeachType = '未知';
		if (item.impeachType == 1) {
			strImpeachType = '-渠道方成功';
		} else if (item.impeachType == 2) {
			strImpeachType = '-渠道方失败';
		} else if (item.impeachType == 3) {
			strImpeachType = '-渠道方少';
		} else if (item.impeachType == 4) {
			strImpeachType = '-金额不匹配';
		}
        item.impeachType = strImpeachType;
		item.payTime = dateConverter(item.payTime, PATTERN_ENUM.datetime);
		item.receiptTime = dateConverter(item.receiptTime, PATTERN_ENUM.datetime);
		item.createTime = dateConverter(item.createTime, PATTERN_ENUM.datetime);
	});
}