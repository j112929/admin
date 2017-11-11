$(document).ready(function() {
	
		$(".datetimepicker-input").datetimepicker({
		format: 'yyyy-mm-dd hh:ii',
		language : 'zh-CN'
	}).on('changeDate', function(ev){
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
});

/**
 * 表单提交处理
 */
function form_submit() {
	var couponId = $("input[name=couponId]").val();

	$(".input-submit").attr('disabled', true);

	var saveCallBack;
	if (couponId == '' || couponId == 0) {
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
	window.location.href = BASE_URL + "/couponContent/index";
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
			window.location.href = BASE_URL + "/couponMerchant/index";
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
		// 判断是否返回列表管理
		if (back_listing == true) {
			form_cancel();
		} else {
			window.location.href = BASE_URL + "/couponMerchant/index";
		}
	} else {
		alert(data.msg);
	}
	$(".input-submit").removeAttr('disabled');
}

//function changeCate(obj){
//	if(this.val()=="1"){
//		alert(1);
//		$("#cateList").show();
//	}else{
//		alert(2);
//		$("#cateList").hide();
//	}
//}
/**
 * 显示或者隐藏专场选项
 */
function changeCate(){
	if($("#couponType").val()=="1"){
		$("#cateList").show();
	}else{
		$("#cateList").hide();
	}
}

/**
 * 上传图片
 */
//function uploadImage(obj){
//	/*var type = $(obj).attr("data-sort");*/
//	$(obj).fileupload({
//		dataType:'json',
///*		formData:{
//			type:type
//		},*/
//		url: BASE_URL+'/couponContent/uploadImage',
//		submit:function(e,data){
//			
//		},
//		done:function(e,data){
//			/*返回数据显示处理*/
//			if(data.result.status == 0){
//				showImage(data.result.data);
//				/*附件中图片的pretty处理*/
//				editPretty();
//			}else{
//				alert(data.result.msg);
//			}
//		}
//	});
//}
//function showImage(d) {
//	/* 列表显示处理 */
//		var imageDiv = "<label for='pic' class='col-sm-3 control-label'><font class='red'>* </font>未选中图标</label>";
//		imageDiv += "<div class='thumbnail uploadDiv'>";
//		imageDiv += "<div class='uploadImg'>";
//		imageDiv += "<input type='file' style='width:85px;height:85px;' onclick='uploadImage(this);' name='files' id='"+d.inputId+"' data-type='0'  class='uploadInput upload btn_fileupload'>";
//		imageDiv += "</div>";
//		imageDiv += "</div>";
//		imageDiv += "<div class='thumbnail uploadDiv'>";
//		imageDiv += "<div class='viewImg'>";
//		imageDiv += "<a class='glyphicon gallery-delete delImg' href='javascript:;' ></a> <img width='90px' height='90px' src='" + IMG_URL + d.fileUrl + "'>";
//		imageDiv += "<input type='hidden' value="+d.fileUrl+" name='pic' />";
//		imageDiv += "</div>";
//		imageDiv += "</div>";
//
//	$("#" + d.inputId).parent().parent().parent().html(imageDiv);
//}
///**
//* 附件中的图片 pretty 处理
//*/
//function editPretty() {
//	$(".gallery-edit:first a[rel^='prettyPhoto']").prettyPhoto({
//		animation_speed : 'normal',
//		theme : 'light_square',
//		slideshow : 3000,
//		autoplay_slideshow : false
//	});
//}

