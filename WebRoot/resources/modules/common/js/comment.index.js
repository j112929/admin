$(document).ready(function() {
	$('#startDate').datetimepicker({format: 'yyyy-mm-dd hh:ii', autoclose: true});
	$('#endDate').datetimepicker({format: 'yyyy-mm-dd hh:ii', autoclose: true});
	
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
			url : BASE_URL + '/commonComment/delete',
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
					property : 'orderChildNo',
					label : '订单号',
					sortable : false
				},
				{
					property : 'ctime',
					label : '评论时间',
					sortable : false
				},
				{
					property : 'orderType',
					label : '订单类型',
					sortable : false
				},
				{
					property : 'goodsName',
					label : '商品名称',
					sortable : false
				},
				{
					property : 'merchantName',
					label : '供应商简称',
					sortable : false
				},
				{
					property : 'userName',
					label : '客户名',
					sortable : false
				},
				{
					property : 'phone',
					label : '客户联系方式',
					sortable : false
				},
				{
					property : 'rankBase',
					label : '商品质量评分',
					sortable : false
				},
				{
					property : 'rankSpeed',
					label : '物流评分',
					sortable : false
				},
				{
					property : 'rankService',
					label : '服务态度评分',
					sortable : false
				},
				{
					property : 'sumScore',
					label : '总分数',
					sortable : false
				} ,
				{
					property : '_action',
					label : '操作',
					sortable : false
				} 
			];
}

function formatData(items) {
	$.each(items, function(index, item) {
		item._query = index+1;
		/*item._query = '<a href="'+BASE_URL + '/commonComment/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';*/
		item._action = /*'<a href="' + BASE_URL + '/commonComment/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'+ */
				'<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strType = '未知';
		if (item.type == 1) {
			strType = '订单明细(商品)';
		} else if (item.type == 2) {
			strType = '物流服务(子订单)';
		} else if (item.type == 3) {
			strType = '服务态度(子订单)';
		}
        item.type = strType;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);

		if(item.orderType ==1){
			item.orderType="普通";
		}else if(item.orderType ==2){
			item.orderType="折扣";
		}else if(item.orderType ==3){
			item.orderType="团购";
		}else if(item.orderType ==4){
			item.orderType="秒杀";
		}else if(item.orderType ==5){
			item.orderType="抽奖";
		}
		
		var strStatus = '未知';
		if (item.status == 0) {
			strStatus = '未审核';
		} else if (item.status == 1) {
			strStatus = '审核通过';
		} else if (item.status == 2) {
			strStatus = '审核不通过';
		}
        item.status = strStatus;
	});
}