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
		
				var discountId = $(this).attr("discountId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/back/permissionDiscounts/delete',
			data : 'discountId=' + discountId,
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
					property : 'discountId',
					label : '优惠折扣Id',
					sortable : false
				},
				{
					property : 'title',
					label : '折扣名称',
					sortable : false
				},
				{
					property : 'startTime',
					label : '折扣活动开始时间',
					sortable : false
				},
				{
					property : 'endTime',
					label : '折扣活动结束时间',
					sortable : false
				},
				{
					property : 'price',
					label : '抢购价格',
					sortable : false
				},
				{
					property : 'sku',
					label : '商品',
					sortable : false
				},
				{
					property : 'buynumber',
					label : '抢购数量',
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
		item._query = '<a href="'+BASE_URL + '/back/permissionDiscounts/detail?discountId=' + item.discountId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/back/permissionDiscounts/edit?discountId=' + item.discountId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="discountId_' + item.discountId + '" discountId="' + item.discountId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

		item.startTime = dateConverter(item.startTime, PATTERN_ENUM.datetime);
		item.endTime = dateConverter(item.endTime, PATTERN_ENUM.datetime);
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
	});
}