$(document).ready(function() {
	$('#validStartDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});
	$('#validEndDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});
	$('#grantStartDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});
	$('#grantEndDate').datepicker({format: 'yyyy-mm-dd', autoclose: true});

	loadDataGridContent(columnsDefined(), 'formatData');
	
	
    /**
	 * 刷新或搜索
	 */
	$('.action-refresh').on('click', function(){
		$('#content_listing').datagrid('reload');
		return false;
	});
	
	/**
	 * 重置搜索条件
	 */
	$('.action-reset').on('click', function(){
		$('#validStartDate').val('');
		$('#validEndDate').val('');
		$('#grantStartDate').val('');
		$('#grantEndDate').val('');
		$('#type').find("option:selected").prop("selected",false);
		$('#status').find("option:selected").prop("selected",false);
		return false;
	});
	
	
	/**
	 * 关键字搜索
	 */
	$('input[name=key]').on('keypress', function (event) {
	    if (event.which == '13') {
	        $('#content_listing').datagrid("reload");
	        return false;
	    }
	});
	
	/**
	 * 删除 - 单条
	 */
    $("#content_listing").delegate('.switch-sm', 'click', function(){
		var couponId = $(this).attr("couponId");
		doDeleteCoupon(couponId);
		return false;
	});
    
    /**
	 * 启用，锁定，解锁 - 单条
	 */
    $("#content_listing").delegate('.operate-delete', 'click', function(){
		var couponId = $(this).attr("couponId");
		changeCouponStatus(couponId);
		return false;
	});
    
});

/**
 * 启用，锁定，解锁
 */
function changeCouponStatus(couponId) {
	var del = confirm('确定要'+$('#couponId_' + couponId + '_status').attr('title')+'所选优惠券吗？');
	if (! del) {return false;}
	/* 执行 */
	var status = $('#couponId_' + couponId + '_status').attr('status');
	$.ajax({
    	type:'post',
        url:BASE_URL + '/activityGroupon/updateStatus',
        data:
        	{
        		'couponId': couponId,
        		'status': status,
        	 },
        dataType:'json',
        timeout:60000,
        success:function(data){
    		if (data.status > 0) {
    			alert(data.msg);
    		}
    		$('#content_listing').datagrid('reload');
    		return false;
    	}
    });
}

/**
 * 删除
 */
function doDeleteCoupon(couponId) {
	var del;
	if($('#coupon_' + couponId).prop('checked')) {
		del = confirm('确定要恢复所选优惠券吗？');
	} else {
		del = confirm('确定要删除所选优惠券吗？');
	}
	if (! del) {return false;}
	
	/* 执行 */
	$.ajax({
    	type:'post',
        url:BASE_URL + '/activityGroupon/delete',
        data:'couponId=' + couponId,
        dataType:'json',
        timeout:60000,
        success:function(data){
    		if (data.status == 0) {
    			$('#coupon_' + couponId).prop('checked', !$('#coupon_' + couponId).prop('checked'));
    		} else {
    			alert(data.msg);
    		}
    		return false;
    	}
    });
}

function columnsDefined() {
	return [
            /*{
            	property: 'a',
            	label: ''
            },*/
            {
                property: 'skuId',
                label: '供应商编号',
            },
            {
                property: 'skuId',
                label: '供应商简称',
            },
            {
                property: 'skuId',
                label: '商品SKU编号',
            },
            {
                property: 'name',
                label: '商品名称',
            },
            {
                property: 'price',
                label: '团购价格',
            },
            {
                property: 'chargeRate',
                label: '手续费率',
            },
            {
                property: 'userCount',
                label: '成团人数',
            },
            {
            	property: 'beginTime',
            	label: '活动开始时间',
            	sortable: false
            },
            {
            	property: 'endTime',
            	label: '活动结束时间',
            	sortable: false
            },
            {
            	property: 'isGroupon',
            	label: '活动状态',
            	sortable: false
            },
            {
            	property: 'verifyStatus',
            	label: '审核状态',
            	sortable: false
            },
            
            {
            	property: 'action',
            	label: '操作',
            	sortable: false
            }
        ];
}

function formatData(items) {
	$.each(items, function (index, item) {
        item.a = '<a href="' + BASE_URL + '/activityGroupon/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
        
        item.action = '<a href="' + BASE_URL + '/activityGroupon/edit?id=' + item.id + '" class="load-content" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;';
        
        var isGroupon = '未知';
        if (item.isGroupon == 0) {
        	isGroupon = '未成团';
        } else if (item.status == 1) {
        	isGroupon = '成团';
        }
        item.isGroupon = isGroupon;
        
        var verifyStatus = '未知';
        if (item.verifyStatus == 0) {
        	verifyStatus = '未审核';
        } else if (item.verifyStatus == 1) {
        	strCouponType = '审核通过';
        } else if (item.verifyStatus == 2) {
        	strCouponType = '审核不通过';
        }
        item.verifyStatus = verifyStatus;
        
        item.beginTime = dateConverter(item.beginTime, PATTERN_ENUM.datetime);
        item.endTime = dateConverter(item.endTime, PATTERN_ENUM.datetime);
	});
}