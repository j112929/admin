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
			url : BASE_URL + '/goodsBrand/delete',
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
					property : 'name',
					label : '三级分类',
					sortable : false
				},
				
				{
					property : 'secondCategoryName',
					label : '二级分类',
					sortable : false
				},
				
				{
					property : 'thirdCategoryName',
					label : '一级分类',
					sortable : false
				}
			];
}

function formatData(items) {
	$.each(items, function(index, item) {
	
		
		item.checkbox = '<input type="checkbox" name="post[]" class="select-single" value="' + item.pic + '">';

		if (item.pic) {
			item.pic  = '<a class="thumb m-l" href="javascript:;">' + '<img src="' + IMG_URL + item.pic + '">' + '</a>';
		} else {
			item.pic = '';
		}

		
		
		
		item._action = '<a href="' + BASE_URL + '/goodsBrand/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><span>编辑</span></a>&nbsp;&nbsp;'
				+'<a href="' + BASE_URL + '/goodsBrand/bindCategory?id=' + item.id
				+ '" class="operating-edit" title="绑定分类"><span>绑定分类</span></a>&nbsp;&nbsp;'
				+'<a href="javascript:;" id="' + item.id + '" class="operate-delete" title="删除"><span>删除</span></a>';
				
				
        
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
	});
}