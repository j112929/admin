$(document).ready(function() {
	
	/**
	 * 添加一个属性值编辑区
	 */
	$('#btn_add_property_value').on('click', function(){
		add_property_value();
	});
	
	/**
	 * 移除一个属性值编辑区
	 */
	$('#table_property_value').delegate('.operate-delete', 'click', function(){
		remove_property_value($(this));
	});
	
	/**
	 * 设置一个属性值为默认值
	 */
	$('#table_property_value').delegate('.set-pv-default', 'click', function(){
		set_pv_default($(this));
	});	
	/**
	 * 提交按钮处理
	 */
	$(".input-submit").click(function() {
		var submit_type = $(this).attr("data_submit_type");
		switch (submit_type) {
		case 'submit_cancel':
			form_cancel();
			break;
		case 'submit_save_back':
			back_listing = true;
			form_submit();
			break;
		case 'submit_save_continue':
			back_listing = false;
			form_submit();
			break;
		}
	});
});
/**
 * 添加一个属性值编辑区
 */
function add_property_value() {
	/* 克隆元素样本 */
	var obj_clone = $('#table_property_value>tbody>tr:first').clone();
	
	/* 对克隆元素做基础处理 */
	obj_clone.find('input[type=text]').val('');
	obj_clone.find('input[type=checkbox]').removeAttr('checked');
	obj_clone.find('a.operate-delete').attr('property_value_id', 0);
	obj_clone.find('.property_value_id_hidden').val(0);
	
	/* 处理上传图片组件 */
	obj_clone.find('.bootstrap-filestyle').remove(); // 删除复制元素的 FILE 组件填充内容
	obj_clone.find('input[name=p_property_image_0]').filestyle('clear'); // 清除输入文本内容
	
	/* 添加复制元素 */
	$('#table_property_value>tbody').append(obj_clone);
	
	/* 上传图片元素样式重定义 */
	$('.bootstrap-filestyle:last').find('.input-large').addClass("form-control inline input-s input-sm");
	$('.bootstrap-filestyle:last').find('.btn').addClass("btn-default btn-sm");
	$(".p-property-image:last").filestyle('buttonText', '上传图片');
	
	/* 多于一个参数时，所有删除图标均显示 */
	$('.operate-delete').removeClass('hide');
	
	/* 编辑状态下，往数据库中添加一个属性值记录 */
	if ($('input[name=propertyId]').val()) {
		insert_property_value();
	}
}

/**
 * 移除一个属性值编辑区
 */
function remove_property_value(obj) {
	var del = confirm('删除不可恢复，确认删除本行属性值吗？');
	if (! del) {return false;}
	
	obj.parent().parent().remove();
	
	/* 只剩下一个参数时，去除其删除图标 */
	if ($('.operate-delete').size() == 1) {
		$('.operate-delete:first').addClass('hide');
	}
	
	/* 编辑状态下，彻底删除一个属性值 */
	if ($('input[name=propertyId]').val() && obj.attr('property_value_id') > 0) {
		delete_property_value(obj.attr('property_value_id'));
	}
}

/**
 * 往数据库中添加一个属性值记录 - 仅在编辑状态时
 */
function insert_property_value() {
	var propertyId = $('input[name=propertyId]').val();
	if (! propertyId) {
		return false;
	}
	
	$.ajax({
    	type:'post',
        url:BASE_URL + '/trendProperty/insertPropertyValue',
        data:'propertyId=' + propertyId,
        dataType:'json',
        timeout:60000,
        success:function(data){
    		if (data.status == 0) {
    			$('#table_property_value>tbody>tr:last').find('a.operate-delete').attr('property_value_id', data.data.property_value_id);
    			$('#table_property_value>tbody>tr:last').find('.property_value_id_hidden').val(data.data.property_value_id);
    		} else {
    			alert(data.msg);
    		}
    		return false;
    	}
    });
}

/**
 * 从数据库中彻底删除一个属性值 - 仅在编辑状态时
 */
function delete_property_value(propertyValueId) {
	$.ajax({
    	type:'post',
        url:BASE_URL + '/trendProperty/deletePropertyValue',
        data:'propertyValueId=' + propertyValueId,
        dataType:'json',
        timeout:60000,
        success:function(data){
    		if (data.status != 0) {
    			alert(data.msg);
    		}
    		return false;
    	}
    });
}

/**
 * 设置一个属性值为默认值
 */
function set_pv_default(obj) {
	$('#table_property_value').find('input[type=checkbox]').removeAttr('checked');
	obj.prop('checked', true);
}
/**
 * 表单提交处理
 */
function form_submit() {
	var id = $("input[name=id]").val();
	var if_params = true;
	$('#table_property_value>tbody>tr').each(function(k){
		/* 校验属性值是否都已填写 */
		var obj_tr = $(this);
		if (! obj_tr.find('input[type=text]:first').val()) {
			if_params = false;
			return false;
		}
		
		/* 处理默认值 */
		obj_tr.find('.set-pv-default').val(k);
	});
	if (if_params === false) {
		notice('edit_notice', img_delete + ' 请填写完所有属性值', true, 5000);
		return false;
	}
	$(".input-submit").attr('disabled', true);
	
	var saveCallBack;
	if (id == '' || id == 0) {
		saveCallBack = form_save_added;
	} else {
		saveCallBack = form_save_edited;
	}
	
	var options = {
		dataType : 'json',
		timeout : 60000,
		success : saveCallBack
	};
	$("#edit_form").ajaxSubmit(options);
	return false;
}

/**
 * 取消处理
 */
function form_cancel() {
	window.location.href = BASE_URL + "/goodsProperty/index";
}

/**
 * 添加成功，返回处理
 */
function form_save_added(data, textStatus) {
	if (data.status === 0) {
		alert('添加成功!');

		// 判断是否返回列表管理
		if (back_listing == true) {
			form_cancel();
		} else {
			window.location.href = BASE_URL + "/goodsProperty/add";
		}
	} else {
		alert(data.msg);
	}
	$(".input-submit").removeAttr('disabled');
}

/**
 * 编辑成功，返回处理
 */
function form_save_edited(data, textStatus) {
	if (data.status === 0) {
		alert('编辑成功!');
		form_cancel();
	} else {
		alert(data.msg);
	}
	$(".input-submit").removeAttr('disabled');
}