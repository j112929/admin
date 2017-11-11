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
			url : BASE_URL + '/logAudit/delete',
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
					property : 'type',
					label : '审核类型',
					sortable : false
				},
				{
					property : 'targetId',
					label : '审核目标id',
					sortable : false
				},
				{
					property : 'remark',
					label : '备注',
					sortable : false
				},
				{
					property : 'description',
					label : '描述',
					sortable : false
				},
				{
					property : 'grade',
					label : '审核级别',
					sortable : false
				},
				{
					property : 'status',
					label : '审核状态',
					sortable : false
				},
				{
					property : 'auditer',
					label : '审核人',
					sortable : false
				},
				{
					property : 'auditTime',
					label : '审核时间',
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
		item._query = '<a href="'+BASE_URL + '/logAudit/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/logAudit/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strType = '未知';
		if (item.type == 1) {
			strType = '供应商入驻';
		} else if (item.type == 2) {
			strType = '商品上架';
		} else if (item.type == 3) {
			strType = '供应商可售商品类型';
		} else if (item.type == 4) {
			strType = '优惠券';
		} else if (item.type == 5) {
			strType = '秒杀';
		} else if (item.type == 6) {
			strType = '抽奖';
		} else if (item.type == 7) {
			strType = '团购';
		}
        item.type = strType;

		var strGrade = '未知';
		if (item.grade == 1) {
			strGrade = '一级审核';
		} else if (item.grade == 2) {
			strGrade = '二级审核';
		}
        item.grade = strGrade;

		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = '不通过';
		} else if (item.status == 1) {
			strStatus = '通过';
		}
        item.status = strStatus;
		item.auditTime = dateConverter(item.auditTime, PATTERN_ENUM.datetime);
	});
}