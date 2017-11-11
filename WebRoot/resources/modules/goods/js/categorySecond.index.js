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
				id = id.substring(3);
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsCategory/delete',
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
					property : 'firstCategoryName',
					label : '一级分类名称',
					sortable : false
				},
				{
					property : 'secondCategoryName',
					label : '运营二级分类名称',
					sortable : false
				},
				{
					property : 'secondSortOrder',
					label : '序号',
					sortable : false
				},
				{
					property : 'thirdCategoryAmount',
					label : '三级分类数量',
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
		item._action = '<a href="' + BASE_URL + '/goodsCategory/editSecond?id=' + item.secondCategoryId
				+ '" class="operating-edit" title="编辑"><span>编辑</span></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.secondCategoryId + '" id="' + item.secondCategoryId
				+ '" title="删除"><span>删除</span></a>';
		
	});
}