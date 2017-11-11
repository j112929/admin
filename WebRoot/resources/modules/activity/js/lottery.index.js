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
			url : BASE_URL + '/activityLottery/delete',
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
					property : 'name',
					label : '名称',
					sortable : false
				},
				{
					property : 'description',
					label : '活动规则',
					sortable : false
				},
				{
					property : 'maxLotteryCount',
					label : '每人每天最大抽奖次数',
					sortable : false
				},
				{
					property : 'count',
					label : '总转动次数',
					sortable : false
				},
				{
					property : 'settlementPrice',
					label : '结算价格',
					sortable : false
				},
				{
					property : 'price',
					label : '每次抽奖价格',
					sortable : false
				},
				{
					property : 'beginTime',
					label : '开始时间',
					sortable : false
				},
				{
					property : 'endTime',
					label : '结束时间',
					sortable : false
				},
				{
					property : 'verifyStatus',
					label : '审核状态',
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
		item._query = '<a href="'+BASE_URL + '/activityLottery/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/activityLottery/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

		item.beginTime = dateConverter(item.beginTime, PATTERN_ENUM.datetime);
		item.endTime = dateConverter(item.endTime, PATTERN_ENUM.datetime);

		var strVerifyStatus = '未知';
		if (item.verifyStatus == 0) {
			strVerifyStatus = '未审核';
		} else if (item.verifyStatus == 1) {
			strVerifyStatus = '审核通过';
		} else if (item.verifyStatus == 2) {
			strVerifyStatus = '审核不通过';
		}
        item.verifyStatus = strVerifyStatus;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}