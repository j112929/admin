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
			url : BASE_URL + '/btsOrderRefund/delete',
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
					label : '退货单id',
					sortable : false
				},
				{
					property : 'userId',
					label : '用户id',
					sortable : false
				},
				{
					property : 'shopId',
					label : '店铺id',
					sortable : false
				},
				{
					property : 'refundNo',
					label : '退货单号',
					sortable : false
				},
				{
					property : 'orderItemsId',
					label : '订单明细id',
					sortable : false
				},
				{
					property : 'quantity',
					label : '退货商品数量',
					sortable : false
				},
				{
					property : 'reason',
					label : '退货原因',
					sortable : false
				},
				{
					property : 'pics',
					label : '图片地址',
					sortable : false
				},
				{
					property : 'status',
					label : '退货单状态',
					sortable : false
				},
				{
					property : 'refundAmount',
					label : '退款金额',
					sortable : false
				},
				{
					property : 'isComment',
					label : '是否评价',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
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
		item._query = '<a href="'+BASE_URL + '/btsOrderRefund/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/btsOrderRefund/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = '取消申请';
		} else if (item.status == 1) {
			strStatus = '申请退货';
		} else if (item.status == 2) {
			strStatus = '审批通过';
		} else if (item.status == 3) {
			strStatus = '审批拒绝';
		} else if (item.status == 4) {
			strStatus = '退款完成';
		}
        item.status = strStatus;

		var strIsComment = '未知';
		if (item.isComment == 0) {
			strIsComment = '未评价';
		} else if (item.isComment == 1) {
			strIsComment = '已评价';
		}
        item.isComment = strIsComment;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}