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
	
	$('#linkType').change(function(){		
		 if($(this).val()==2){
			$('#typesOne').find('[name="goodsId"]').prop('disabled',true);
			$('#typesOne').hide();
			$('#typesList').find('[name="goodsId"]').prop('disabled',false);
			$('#typesList').show();
		}
	});


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
	
	
	
	/*
	 * 添加商品列表
	 */
	$('#typesList').delegate('input[name="typeDelAdvert"]','click',function(){
		alert(11);
		$(this).parent().remove();
	});
	
	$('#typesList111').delegate('input[name="typeAdd111"]','click',function(){
		var html =  '<div class="form-group">'
	        +'<label for="link" class="col-sm-3 control-label">请输入商品SKU</label>'
	        +'<div class="col-sm-4">'
	        +'<input type="text" class="form-control" id="link" name="link"  onkeydown="if(event.keyCode==13)return false;" placeholder="请输入SKU"/></div>'
	        +'<input id="typeDelAdvert" name="typeDelAdvert" type="button" value="—"/>'
	        +'<div class="line line-dashed line pull-in"></div>';
		$('#linkType3').append(html);
	});
		
});

//添加sku框
function typeAddAdvert() {
	var html =  '<div class="form-group">'
        +'<label for="link" class="col-sm-3 control-label">请输入商品SKU</label>'
        +'<div class="col-sm-4">'
        +'<input type="text" class="form-control" id="link" name="link"  onkeydown="if(event.keyCode==13)return false;" placeholder="请输入SKU"/></div>'
        +'<input id="typeDelAdvert" name="typeDelAdvert" type="button" value="-" onclick="typeDeleteAdvert(this)"/>'
        +'<div class="line line-dashed line pull-in"></div>';
	$('#linkTypeDiv').append(html);
}

function typeDeleteAdvert(obj) {
	$(obj).parent().remove();
}

//删除sku框
function typeDelAdvert() {
	$(this).parent().remove();
}

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
//	if ($("#link").val() < 1) {
//		notice('edit_notice', img_delete + ' 链接目标不能为空', true, 5000);
//		return false;
//	}
	
	/*var str=$("#link").val();
	if (isNaN(str)) {
	if("3" == $("#linkType").val()) {
		notice('edit_notice', img_delete + '链接目标只能为数字', true, 2000);
		return;
	}*/

		
	}
	
	
	var id = $("input[name=id]").val();

	// $(".input-submit").attr('disabled', true);

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

$("#link").blur(function(){
	
	linkchk();
});

function linkchk(){
	var str=$("#link").val();
	if (isNaN(str)) {
	if("3" == $("#linkType").val()) {
		
	}
		
	}
}

function test() {
	var foot = "<label><font color=\"green\">团购活动地址:https://www.tmall.com/</br>抽奖活动地址:http://www.jumei.com/&nbsp;&nbsp;</font></label>";
	var label1= "<font class=\"red\">* </font>活动地址";
	var label2 = "<font class=\"red\">* </font>商品详情";
	var label3 = "<font class=\"red\">* </font>商品SKU列表";
	var label4 = "<font class=\"red\">* </font>无链接目标";
	var add = "<input id=\"typeAdd\" name=\"typeAdd\" type=\"button\" value=\"+\" onclick=\"typeAddAdvert()\"/>";
	
	var linkType = $("#linkType").val();
	if (linkType == 1) {
		$("#linkTypeLabel").html(label1);
		$("#linkTypeFoot").html(foot);
		$("#typeAdd").remove();
	} else if (linkType == 2) {
		$("#linkTypeLabel").html(label2);
		$("#linkTypeFoot").html("");
		$("#typeAdd").remove();
	} else if (linkType == 3) {
		$("#linkTypeLabel").html(label3);
		$("#linkTypeFoot").html(add);
	} else if (linkType == 4) {
		$("#linkTypeLabel").html(label4);
		$("#linkTypeFoot").html("");
		$("#typeAdd").remove();
	}
	
	
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
		$("#linkType1").show();
		$("#linkType2").hide();	
		$("#linkType3").hide();	
		$("#linkType4").hide();	
	} 
	if ("2" == $("#linkType").val()) {
		$("#linkType1").hide();
		$("#linkType2").show();	
		$("#linkType3").hide();	
		$("#linkType4").hide();	
	} 
	if("3" == $("#linkType").val()) {
		$("#linkType1").hide();
		$("#linkType2").hide();	
		$("#linkType3").show();	
		$("#linkType4").hide();	
		
		/*$('#skuList').find('[name="link"]').prop('disabled',false);
		$('#skuList').show();
		
		$("#typeAdd").show();*/
		/*
		 * $("#link").blur(function(){ var str=$("#link").val(); if
		 * (!isNaN(str)) { notice('edit_notice', img_delete + '链接目标不能为数', true,
		 * 5000); return false; } });
		 */
	} 
	if("4" == $("#linkType").val()) {
		$("#linkType1").hide();
		$("#linkType2").hide();	
		$("#linkType3").hide();	
		$("#linkType4").show();	
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
