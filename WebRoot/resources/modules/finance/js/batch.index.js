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
			url : BASE_URL + '/financeBatch/delete',
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
					property : 'channeNo',
					label : '渠道号',
					sortable : false
				},
				{
					property : 'fileName1',
					label : '文件名1',
					sortable : false
				},
				{
					property : 'fileName2',
					label : '文件名2',
					sortable : false
				},
				{
					property : 'fileName3',
					label : '文件名3',
					sortable : false
				},
				{
					property : 'fileName4',
					label : '文件名4',
					sortable : false
				},
				{
					property : 'fileName5',
					label : '文件名5',
					sortable : false
				},
				{
					property : 'fileName6',
					label : '文件名6',
					sortable : false
				},
				{
					property : 'thirdbackAmount',
					label : '收银台支付金额',
					sortable : false
				},
				{
					property : 'flag',
					label : '获取对账文件是否成功',
					sortable : false
				},
				{
					property : 'status',
					label : '状态',
					sortable : false
				},
				{
					property : 'successTotal',
					label : '成功笔数',
					sortable : false
				},
				{
					property : 'faileTotal',
					label : '失败笔数',
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
		item._query = '<a href="'+BASE_URL + '/financeBatch/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/financeBatch/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

		item.receiptTime = dateConverter(item.receiptTime, PATTERN_ENUM.datetime);
		item.createTime = dateConverter(item.createTime, PATTERN_ENUM.datetime);

		var strFlag = '未知';
		if (item.flag == 0) {
			strFlag = '否';
		} else if (item.flag == 1) {
			strFlag = '是';
		}
        item.flag = strFlag;

		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = 'B';
		} else if (item.status == 1) {
			strStatus = '权益';
		} else if (item.status == 2) {
			strStatus = 'C';
		}
        item.status = strStatus;
	});
}