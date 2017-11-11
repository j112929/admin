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
			url : BASE_URL + '/financeClearing/delete',
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
					property : 'payType',
					label : '支付方式',
					sortable : false
				},
				{
					property : 'sno',
					label : '交易流水号',
					sortable : false
				},
				{
					property : 'orderNo',
					label : '订单号',
					sortable : false
				},
				{
					property : 'buinessName',
					label : '商户名',
					sortable : false
				},
				{
					property : 'buinessNo',
					label : '商户号',
					sortable : false
				},
				{
					property : 'businessDeal',
					label : '交易类型',
					sortable : false
				},
				{
					property : 'cur',
					label : '币种',
					sortable : false
				},
				{
					property : 'transAmt',
					label : '清算金额',
					sortable : false
				},
				{
					property : 'integral',
					label : '积分',
					sortable : false
				},
				{
					property : 'channel',
					label : '来源渠道',
					sortable : false
				},
				{
					property : 'flag',
					label : '手工清算',
					sortable : false
				},
				{
					property : 'paybkNo',
					label : '银行卡号',
					sortable : false
				},
				{
					property : 'paybkCode',
					label : '开户行',
					sortable : false
				},
				{
					property : 'receiptTime',
					label : '账务日期',
					sortable : false
				},
				{
					property : 'createTime',
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
		item._query = '<a href="'+BASE_URL + '/financeClearing/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/financeClearing/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strBusinessDeal = '未知';
		if (item.businessDeal == 0) {
			strBusinessDeal = '退款';
		} else if (item.businessDeal == 1) {
			strBusinessDeal = '购买';
		}
        item.businessDeal = strBusinessDeal;

		var strFlag = '未知';
		if (item.flag == 0) {
			strFlag = '手工清算';
		} else if (item.flag == 1) {
			strFlag = '自动清算）';
		}
        item.flag = strFlag;
		item.receiptTime = dateConverter(item.receiptTime, PATTERN_ENUM.datetime);
		item.createTime = dateConverter(item.createTime, PATTERN_ENUM.datetime);
	});
}