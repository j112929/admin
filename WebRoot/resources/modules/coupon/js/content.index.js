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
		
				var couponId = $(this).attr("couponId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/couponContent/delete',
			data : 'couponId=' + couponId,
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
					property : 'couponId',
					label : 'ID',
					sortable : false
				},
				{
					property : 'couponType',
					label : '优惠券类型',
					sortable : false
				},
				{
					property : 'categoryId',
					label : '分类',
					sortable : false
				},
				{
					property : 'code',
					label : '优惠券编码',
					sortable : false
				},
				{
					property : 'couponName',
					label : '优惠券名称',
					sortable : false
				},
				{
					property : 'amount',
					label : '优惠券金额',
					sortable : false
				},
				{
					property : 'undertakeAmount',
					label : '商户承担额',
					sortable : false
				},
				{
					property : 'bankSubsidy',
					label : '银行补贴金额',
					sortable : false
				},
				{
					property : 'count',
					label : '数量',
					sortable : false
				},
				{
					property : 'validityStart',
					label : '有效期开始',
					sortable : false
				},
				{
					property : 'validityEnd',
					label : '有效期结束',
					sortable : false
				},
				{
					property : 'minLimitAmount',
					label : '优惠券使用金额下限',
					sortable : false
				},
				{
					property : 'maxUseCount',
					label : '每单使用最大次数',
					sortable : false
				},
				{
					property : 'useDetail',
					label : '使用详情',
					sortable : false
				},
				{
					property : 'useNotice',
					label : '使用须知',
					sortable : false
				},
				{
					property : 'publishDateStart',
					label : '发布时间开始',
					sortable : false
				},
				{
					property : 'publishDateEnd',
					label : '发布时间结束',
					sortable : false
				},
				{
					property : 'publishType',
					label : '发布方式',
					sortable : false
				},
				{
					property : 'publishPopulation',
					label : '发布人群',
					sortable : false
				},
				{
					property : 'pic',
					label : '优惠券图片',
					sortable : false
				},
				{
					property : 'auditStatus',
					label : '审核状态',
					sortable : false
				},
				{
					property : 'auditUserId',
					label : '审核人',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'mtime',
					label : '最后一次更新时间',
					sortable : false
				},
				{
					property : 'createUserId',
					label : '创建人',
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
		item._query = '<a href="'+BASE_URL + '/couponContent/detail?couponId=' + item.couponId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/couponContent/edit?couponId=' + item.couponId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="couponId_' + item.couponId + '" couponId="' + item.couponId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strCouponType = '未知';
		if (item.couponType == 0) {
			strCouponType = '全场类型';
		} else if (item.couponType == 1) {
			strCouponType = '专场类型';
		}
        item.couponType = strCouponType;
		item.validityStart = dateConverter(item.validityStart, PATTERN_ENUM.datetime);
		item.validityEnd = dateConverter(item.validityEnd, PATTERN_ENUM.datetime);
		item.publishDateStart = dateConverter(item.publishDateStart, PATTERN_ENUM.datetime);
		item.publishDateEnd = dateConverter(item.publishDateEnd, PATTERN_ENUM.datetime);

		var strPublishType = '未知';
		if (item.publishType == 0) {
			strPublishType = '自动发布';
		} else if (item.publishType == 1) {
			strPublishType = '用户自行领取';
		}
        item.publishType = strPublishType;

		var strPublishPopulation = '未知';
		if (item.publishPopulation == 0) {
			strPublishPopulation = '所有用户';
		} else if (item.publishPopulation == 1) {
			strPublishPopulation = '白名单';
		}
        item.publishPopulation = strPublishPopulation;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}