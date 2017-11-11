$(document).ready(function() {
	$(".datetimepicker-input").datetimepicker({
		format : 'yyyy-mm-dd hh:ii',
		language : 'zh-CN'
	}).on('changeDate', function(ev) {
		$('.datetimepicker-input').datetimepicker('hide');
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

	
	/*
	 * 添加商品列表
	 */
	$('#typesList').delegate('input[name="typeDel"]','click',function(){
		$(this).parent().remove();
	});
	
	$('#typesList').delegate('input[name="typeAdd"]','click',function(){
		
		var html =  '<div class="form-group">'
	        +'<label for="link" class="col-sm-3 control-label">请输入商品</label>'
	        +'<div class="col-sm-4">'
	        +'<input type="text" class="form-control" id="link" name="link"  onkeydown="if(event.keyCode==13)return false;" placeholder="请输入"/></div>'
	        +'<input id="typeDel" name="typeDel" type="button" value="—"/>'
	        +'<div class="line line-dashed line pull-in"></div>';
		$('#typesList').append(html);

	});
		
	
});

/**
 * 表单提交处理
 */
function form_submit() {
	notice('editNotice', img_loading_small, false);

	if ($("#name").val() < 1) {
		notice('edit_notice', img_delete + ' 标题不能为空', true, 5000);
		return false;
	}
	if ($("#position").val() < 1) {
		notice('edit_notice', img_delete + ' 推荐专区不能为空', true, 5000);
		return false;
	}
	if ($("#sortOrder").val() < 1) {
		notice('edit_notice', img_delete + ' 推荐位置不能为空', true, 5000);
		return false;
	}
	if ($("#pic").val() < 1) {
		notice('edit_notice', img_delete + ' 广告图片不能为空', true, 5000);
		return false;
	}
	
	if ($("#description").val() < 1) {
		notice('edit_notice', img_delete + ' 描述不能为空', true, 5000);
		return false;
	}
	if ($("#beginTime").val() < 1) {
		notice('edit_notice', img_delete + ' 开始时间不能为空', true, 5000);
		return false;
	}
	if ($("#endTime").val() < 1) {
		notice('edit_notice', img_delete + ' 结束时间不能为空', true, 5000);
		return false;
	}

	if ($("#endTime").val() < $("#beginTime").val()) {
		notice('edit_notice', img_delete + ' 结束时间小于开始时间', true, 5000);
		return false;
	}
	if ($("#linkType").val() < 1) {
		notice('edit_notice', img_delete + ' 链接类型不能为空', true, 5000);
		return false;
	}
	if ($("#link").val() < 1) {
		notice('edit_notice', img_delete + ' 链接目标不能为空', true, 5000);
		return false;
	}

	var id = $("input[name=id]").val();

	//$(".input-submit").attr('disabled', true);

	var saveCallBack;
	console.log(id);
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
	window.location.href = BASE_URL + "/advert/index";
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
			window.location.href = BASE_URL + "/advert/add";
		}
	} else {
		// notice('editNotice', img_delete + " " + data.msg, true, 5000);
		notice('edit_notice', img_delete + data.msg, true, 5000);
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
		notice('edit_notice', img_delete + data.msg, true, 5000);
	}
	$(".input-submit").removeAttr('disabled');
}

function changetips() {
	if ("1" == $("#linkType").val()) {
		$("#tips").show();
	} else {
		$("#tips").hide();
	}
	if ("2" == $("#linkType").val()) {
		$("#tips1").show();
	} else {
		$("#tips1").hide();		
	}
	if("3" == $("#linkType").val()) {
		$("#typeAdd").show();
	} else {
		$("#typeAdd").hide();
	}
	
	
}

function uploadImage(obj) {
	$(obj).fileupload({
		dataType : 'json',
		url : BASE_URL + '/advert/uploadImage',
		submit : function(e, data) {
		},
		done : function(e, data) { 
		  	/* 返回数据显示处理 */
			if (data.result.status == 0) {
				showImage(data.result.data);
				// /* 附件中图片的 pretty 处理 */
				// editPretty();
			} else {
				alert(data.result.msg);
			}
		}
	});
}
function showImage(d) {
// /* 列表显示处理 */
// $("#contentImg").parent().find("a").attr("href", IMG_URL + d.image);
// $("#contentImg").parent().find("img").attr("src", IMG_URL + d.image);
	$("#pic").val(d.image);
}
