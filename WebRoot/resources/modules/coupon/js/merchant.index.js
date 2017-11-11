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
	 * 重载已选属性列表的拖拽事件
	 */
	$('#selected_property').find('ul').sortable('refresh');

	/**
	 * 选择一个关联属性
	 */
	$("#content_listing>tbody").delegate('.select-single', 'change', function(){
		if ($(this).is(':checked')) {
			select_property($(this).parent().parent());
		} else {
			remove_property($('li#li_property_' + $(this).val()));
		}
	});
	
	/**
	 * 移除一个已选择的关联属性
	 */
	$("#selected_property").delegate('.fa-remove-property', 'click', function(){
		remove_property($(this).parent().parent());
	});
	
	$(".input-submit").click(function(){
		var submit_id = $(this).attr("id");
		switch (submit_id) {
			case 'submit_cancel' : form_cancel(); break;
			case 'submit_save_back' : back_listing = true; form_submit(); break;
		}
	});

	/**
	 * 单个删除
	 */
	/*
	$('body').delegate('.operate-delete', 'click', function() {
		var del = confirm('确定要删除吗？');
		if (!del) {
			return false;
		}
		
				var id = $(this).attr("id");
		
		 执行 
		$.ajax({
			type : 'post',
			url : BASE_URL + '/couponMerchant/delete',
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
	});*/
});

function columnsDefined() {
	return [
				{
					property: 'checkbox',
					label: ''
				},
				{
					property : 'id',
					label : 'p_store_id',
					sortable : false
				},
				
				{
					property : 'couponId',
					label : '优惠券ID',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户ID',
					sortable : false
				}
			];
}

function formatData(items) {
		// 将已选属性添加到array中，循环时做判断是否选中
		var propertyArray = new Array();
		$('#selected_property').find('ul>li').each(function(){
			propertyArray.push($(this).attr('merchantId'));
		});
		$.each(items,function(index,item){
			if (propertyArray.indexOf(item.merchantId + "") > -1) {
				item.checkbox = '<input type="checkbox" checked="checked" name="post[]" id="select_single_' + item.merchantId + '" class="select-single" value="' + item.merchantId + '">';
			} else {
				item.checkbox = '<input type="checkbox" name="post[]" id="select_single_' + item.merchantId + '" class="select-single" value="' + item.merchantId + '">';
			}
	    	item.is_spec = item.is_spec == 1 ? '<i class="fa fa-check text-success"></i>' : '<i class="fa fa-ban text-danger"></i>';
	});
	}


/**
 * 处理一个关联属性
 */
function select_property(obj) {
	var template_selected_property = '<li class="b-b m-t-none-reset" id="li_property_{#merchantId#}" merchantId="{#merchantId#}" draggable="true">' + 
        	'<a href="javascript:;">' + 
        	'<i title="移除该属性" class="fa fa-times pull-right m-t-xs fa-remove-property"></i>' + 
        	'<i class="fa fa-fw fa-ellipsis-v"></i><font class="merchantName">{#merchantName#}</font>' + 
        	'</a></li>';
	
	var merchantId = obj.find('td').eq(2).text();
	var merchantName = obj.find('td').eq(3).text();
	
	var tsp = template_selected_property.replace(/{#merchantId#}/g, merchantId)
			.replace('{#merchantName#}', merchantName);
	
	/* 将新选择属性加入到已选列表，并重载该列表的拖拽事件 */
	$('#selected_property').find('ul').append(tsp).sortable('refresh');
}


/**
 * 移除一个已选择的关联属性
 */
function remove_property(obj) {
	$('#select_single_' + obj.attr('merchantId')).removeAttr('checked');
	obj.remove();
}

/**
 * 提交按钮处理
 */
$(".input-submit").click(function(){
	var submit_id = $(this).attr("id");
	switch (submit_id) {
		case 'submit_cancel' : form_cancel(); break;
		case 'submit_save_back' : back_listing = true; form_submit(); break;
		case 'submit_save_continue' : back_listing = false; form_submit(); break;
	}
});

/**
 * 取消处理
 */
function form_cancel() {
	window.location.href = BASE_URL + "/couponMerchant/index";
}

