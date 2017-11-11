/**
 * 定义一些常量
 */
/**
 * 支付方式  sku 是否显示
 * @author lixue
 */
function paytype(){
	obj = document.getElementsByName("payType");
	for(k in obj){
		if(obj[k].checked){
			$('.pay_type_'+obj[k].value).show();
		}else{
			$('.pay_type_'+obj[k].value).hide();
		}
	}
}
/**
 * sku  列表
 * @author lixue
 */
function fun(gpvid,gpvname,isPicValue){
	if(isPicValue==1){
		$("#skuImages").html("");
	}
	obj = document.getElementsByName("gpv_0");
    var skuImages_v="";
    check_val = [];
    check_id = [];
    for(k in obj){
        if(obj[k].checked){
        	check_val.push(obj[k].alt);
        	check_id.push(obj[k].value);
        	if(obj[k].id==1&& isPicValue==1){
        		//图片属性
    			$("#skuImages").append(createBaseImageTD(gpvid, gpvid, obj[k].alt));
    		}
        }
    }
    obj1 = document.getElementsByName("gpv_1");
    check_val1 = [];
    check_id1 = [];
    for(k in obj1){
        if(obj1[k].checked){
        	check_val1.push(obj1[k].alt);
        	check_id1.push(obj1[k].value);
        		if(obj1[k].id==1&& isPicValue==1){
        			//图片属性
        			$("#skuImages").append(createBaseImageTD(gpvid, gpvid, obj1[k].alt));
        		}
        	}
        }
   
    var tbody_format="";
    if(check_val.length>0&&check_val1.length>0){
    	for (var i = 0; i < check_val.length; i++) {
    		for (var j = 0; j < check_val1.length; j++) {
    			tbody_format+='<tr><th align="center" style="width: 10%;text-align: center;">'+check_val[i]+'<input type="hidden" name="gpv0" value="'+check_id[i]+'" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;">'+check_val1[j]+'<input type="hidden" name="gpv1" value="'+check_id1[j]+'" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;"><input type="text" name="stock" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;"><input type="text" name="stockWarn" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;"><input type="text" name="originalPrice" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;" class="pay_type_1"><input type="text" name="price" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;" class="pay_type_1"><input type="text" name="chargeRate" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;" class="pay_type_2"><input type="text" name="pointPrice" style="width: 40px;" value="" /></th>'+
    			'<th align="center" style="width: 10%;text-align: center;" class="pay_type_2"><input type="text" name="settlementPrice" style="width: 40px;" value="" /></th>'+
    			'</tr>';
    		}
    	}	
    }
    $('#edit_base_tbody').html(tbody_format);
    //支付方式    是否显示
    if(check_val.length>0&&check_val1.length>0){
    	obj = document.getElementsByName("payType");
    	for(k in obj){
    		if(obj[k].checked){
    			$('.pay_type_'+obj[k].value).show();
    		}else{
    			$('.pay_type_'+obj[k].value).hide();
    		}
    	}

    }
}
/**
 * isPic
 * 图片属性
 * @author lixue
 */
function createBaseImageTD (propertyId, propertyValueId, propertyValue) {
	var imageHTML = "<tr id='images_"+propertyValueId+"'>";
	imageHTML += "<td width='5%' height='120px;' align='center' style='border:1px solid #E8E8E8'>";
	imageHTML += "<p>"+propertyValue+"</p>";
	imageHTML += "</td>";
	imageHTML += "<td width='95%' height='120px;' style='border:1px solid #E8E8E8'>";
	imageHTML += "<div class='thumbnail uploadDiv' name='uploadImage'>";
	imageHTML += "<div class='uploadImg'>";
	imageHTML += "<input class='uploadInput upload btn_fileupload' type='file' multiple='' id='uploadImage_"+propertyValueId+"' name='files' onclick='uploadImage(this);' style='width:85px;height:85px;' multiple>";
	imageHTML += "</div>";
	imageHTML += "</div>";
	imageHTML += "</td>";
	imageHTML += "<td><input type='hidden' id='imgrow_"+propertyValueId+"' value='check' /></td>";
	imageHTML += "</tr>";
	return imageHTML;
}

/**
 * 为同一列属性赋值
 * 
 * @author zhangzheng
 * @date 2015-11-16
 * @param obj
 */
function addValues(obj) {
	var input = $(obj).parents('th').find('input');
	var inputs = document.getElementsByName(input[0].getAttribute("data-filed"));
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].value = input[0].value;
	}
}
//单选框赋值
function isChecked(sdata,name){
    $("input[name="+name+"]").each(function(){
        if(sdata==$(this).val()){
        $(this).attr("checked","checked");
        }

    });
}



