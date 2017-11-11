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
			url : BASE_URL + '/goodsProperty/delete',
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
/**
 * 设置为sku属性
 */
$('#content_listing').delegate('.is-property', 'click', function() {
	var property_id = $(this).attr('property_id');
	var status = $('#publish_' + property_id).is(':checked') ? 0: 1;
	alert("property_id:"+property_id+",isSku="+status);
	publishProperty(property_id, status);
	return false;
});

/**
 * 设置为sku属性功能
 * 
 * @param id
 * @param status
 */
function publishProperty(id, status) {
	var param = {
		id : id,
		isSku : status
	};
	$.ajax({
		type : 'post',
		url : BASE_URL + '/goodsProperty/edit',
		data : param,
		dataType : 'json',
		timeout : 60000,
		success : function(data) {
			if (data.status == 0) {
				if ($('#publish_' + id).is(':checked')) {
					$('#publish_' + id).prop('checked', false);
				} else {
					$('#publish_' + id).prop('checked', true);
				}
			} else {
				alert(data.msg);
			}
			return false;
		}
	});
}

/**
 * 设置为图片属性
 */
$('#content_listing').delegate('.is-image', 'click', function() {
	var property_id = $(this).attr('property_id');
	var status = $('#publish_image_' + property_id).is(':checked') ? 0 : 1;
	alert("property_id:"+property_id+",isPic="+status);
	publishImage(property_id, status);
	return false;
});

/**
 * 设置为图片属性功能
 * 
 * @param id
 * @param status
 */
function publishImage(id, status) {
	var param = {
		id : id,
		isPic : status
	};
	$.ajax({
		type : 'post',
		url : BASE_URL + '/goodsProperty/edit',
		data : param,
		dataType : 'json',
		timeout : 60000,
		success : function(data) {
			if (data.status == 0) {
				if ($('#publish_image_' + id).is(':checked')) {
					$('#publish_image_' + id).prop('checked', false);
				} else {
					$('#publish_image_' + id).prop('checked', true);
				}
			} else {
				alert(data.msg);
			}
			return false;
		}
	});
}
function columnsDefined() {
	return [
				{
					property: '_query',
					label: ''
				},
				{
					property : 'propertyId',
					label : '属性id',
					sortable : false
				},
				{
					property : 'propertyName',
					label : '属性名称',
					sortable : false
				},
				{
					property : 'propertyValue',
					label : '属性值名称',
					sortable : false
				},
				{
					property : 'description',
					label : '备注',
					sortable : false
				},
				{
					property : 'sortOrder',
					label : '序号',
					sortable : false
				},
				{
					property : 'isSku',
					label : '是否是sku属性',
					sortable : false
				},
				{
					property : 'isPic',
					label : '是否是图片属性',
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
		item._query = '<a href="'+BASE_URL + '/goodsProperty/detail?id=' + item.propertyId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/goodsProperty/edit?id=' + item.propertyId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.propertyId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';
		var isSku = item.isSku == 1 ? 'checked="checked"' : '';
		item.isSku = '<label class="switch-sm is-property" property_id="' + item.propertyId + '">' + '<input type="checkbox" id="publish_' 
				+ item.propertyId + '" ' + isSku + ' />' + '<span></span></label>';

		var isPic = item.isPic == 1 ? 'checked="checked"' : '';
		item.isPic = '<label class="switch-sm is-image" property_id="' + item.propertyId + '">' + '<input type="checkbox" id="publish_image_'
				+ item.propertyId + '" ' + isPic + ' />' + '<span></span></label>';
	});
}