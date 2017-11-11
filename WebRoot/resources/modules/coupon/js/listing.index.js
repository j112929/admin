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
			url : BASE_URL + '/couponListing/delete',
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
					label : 'ID',
					sortable : false
				},
				{
					property : 'userId',
					label : '客户端用户id',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户ID',
					sortable : false
				},
				{
					property : 'couponId',
					label : '优惠券ID',
					sortable : false
				},
				{
					property : 'code',
					label : '优惠券编码',
					sortable : false
				},
				{
					property : 'status',
					label : '优惠券状态',
					sortable : false
				},
				{
					property : 'orderCode',
					label : '订单号',
					sortable : false
				},
				{
					property : 'isDel',
					label : '是否删除',
					sortable : false
				},
				{
					property : 'isFailure',
					label : '是否失效',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'mtime',
					label : '最后一次更新时间',
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
		item._query = '<a href="'+BASE_URL + '/couponListing/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/couponListing/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.id + '" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = '未使用';
		} else if (item.status == 1) {
			strStatus = '已使用';
		} else if (item.status == 2) {
			strStatus = '已作废';
		}
        item.status = strStatus;

		var strIsDel = '未知';
		if (item.isDel == 0) {
			strIsDel = '未删除';
		} else if (item.isDel == 1) {
			strIsDel = '已删除';
		}
        item.isDel = strIsDel;

		var strIsFailure = '未知';
		if (item.isFailure == 0) {
			strIsFailure = '未失效';
		} else if (item.isFailure == 1) {
			strIsFailure = '已失效';
		}
        item.isFailure = strIsFailure;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}