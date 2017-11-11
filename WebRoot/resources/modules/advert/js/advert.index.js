$(document).ready(function() {
	$('#startDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});
	$('#endDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});
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
				var id = $(this).attr("id123");				
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/advert/delete',
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
				/*{
					property: '_query',
					label: ''
				},*/
				{
					property : 'id',
					label : '广告id',
					sortable : false
				},
				{
					property : 'name',
					label : '标题',
					sortable : false
				},
				
				{
					property : 'position',
					label : '推荐专区',
					sortable : false
				},
				{
					property : 'sortOrder',
					label : '推荐位置',
					sortable : false
				},
				{
					property : 'pic',
					label : '广告图片',
					sortable : false
				},
				{
					property : 'linkType',
					label : '链接类型',
					sortable : false
				},
				{
					property : 'link',
					label : '链接目标',
					sortable : false
				},
				
				{
					property : 'description',
					label : '描述',
					sortable : false
				},
				{
					property : 'status',
					label : '状态',
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
					property : 'ctime',
					label : '发布时间',
					sortable : false
				},	
				{
					property : '_action',
					label : '操作',
					sortable : false
				} 
			];
}
function changetips() {	
		$("#tips1").show();
}
function changetipsto(){
	$("#tips1").hide();
}
function formatData(items) {
	    $.each(items, function(index, item) {
		item._query = '<a href="'+BASE_URL + '/advert/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/advert/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.id + '" id123="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';

		var strPosition = '未知';
		if (item.position == 1) {
			strPosition = '商城banner';
		} else if (item.position == 2) {
			strPosition = '积分专区banner';
		} else if (item.position == 3) {
			strPosition = '分期专区banner';
		}
        item.position = strPosition;

		var strLinkType = '未知';
		if (item.linkType == 1) {
			strLinkType = '活动';
		} else if (item.linkType == 2) {
			strLinkType = '商品详情';
		} else if (item.linkType == 3) {
			strLinkType = '商品列表';
		} else if (item.linkType == 4) {
			strLinkType = '无链接';
		}
        item.linkType = strLinkType;
		item.beginTime = dateConverter(item.beginTime, PATTERN_ENUM.datetime);
		item.endTime = dateConverter(item.endTime, PATTERN_ENUM.datetime);

		var strStatus = '未知';

//        item.status = strStatus;
		if (item.status == 0) {
			item.status = '<label class="switch-sm" title="关闭显示" linkId="' + item.linkId + '" status="' + item.status + '">' + '<input type="checkbox" id="publish_'
			+ item.linkId + '" />' + '<span></span></label>';
		} else if (item.status == 1) {
			item.status = '<label class="switch-sm" title="开启显示" linkId="' + item.linkId + '" status="' + item.status + '">' + '<input type="checkbox" id="publish_'
			+ item.linkId + '" checked="checked" />' + '<span></span></label>';
		}
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);			
		
		item.checkbox = '<input type="checkbox" class="select-single" value="' + item.linkId + '">';
		var is_publish = item.status == 1 ? 'checked="checked"' : '';
		if (is_publish) {			
		} else {
			
		}
		
		item.pic = '<a href="' + IMG_URL + item.pic + '" class="thumb-sm" target="_blank"><img src="' + IMG_URL + item.pic + '"></a>';
		
	});
}