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
			url : BASE_URL + '/btsOrderItems/delete',
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
					property : 'id',
					label : '订单明细id',
					sortable : false
				},
				{
					property : 'orderChildNo',
					label : '子订单号',
					sortable : false
				},
				{
					property : 'userId',
					label : '用户id',
					sortable : false
				},
				{
					property : 'remark',
					label : '订单明细备注',
					sortable : false
				},
				{
					property : 'merchantId',
					label : '商户id',
					sortable : false
				},
				{
					property : 'spuId',
					label : '商品spu',
					sortable : false
				},
				{
					property : 'skuId',
					label : '商品sku',
					sortable : false
				},
				{
					property : 'goodsName',
					label : '商品名称',
					sortable : false
				},
				{
					property : 'goodsPic',
					label : '商品图片',
					sortable : false
				},
				{
					property : 'propertys',
					label : '属性',
					sortable : false
				},
				{
					property : 'quantity',
					label : '商品数量',
					sortable : false
				},
				{
					property : 'refundQuantity',
					label : '已退数量',
					sortable : false
				},
				{
					property : 'goodsOriginalPrice',
					label : '原价',
					sortable : false
				},
				{
					property : 'goodsPrice',
					label : '现价',
					sortable : false
				},
				{
					property : 'goodsAmount',
					label : '商品总价',
					sortable : false
				},
				{
					property : 'couponAmount',
					label : '优惠金额',
					sortable : false
				},
				{
					property : 'pointAmount',
					label : '积分总价',
					sortable : false
				},
				{
					property : 'discountAmount',
					label : '金币抵扣金额',
					sortable : false
				},
				{
					property : 'freightAmount',
					label : '运费',
					sortable : false
				},
				{
					property : 'payableAmount',
					label : '应付金额',
					sortable : false
				},
				{
					property : 'payAmount',
					label : '实付金额',
					sortable : false
				},
				{
					property : 'isComment',
					label : '是否评价',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'mtime',
					label : '修改时间',
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
		item._query = '<a href="'+BASE_URL + '/btsOrderItems/detail?id=' + item.id + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/btsOrderItems/edit?id=' + item.id
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="' + item.id
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strPropertys = '未知';
		if (item.propertys == 1) {
			strPropertys = '""valueName""白色"}{"id""';
		} else if (item.propertys == 3) {
			strPropertys = '""name""颜色""value""';
		} else if (item.propertys == 4) {
			strPropertys = '""name""尺码""value""1""valueName""X码"}]';
		}
        item.propertys = strPropertys;

		var strIsComment = '未知';
		if (item.isComment == 0) {
			strIsComment = '未评价';
		} else if (item.isComment == 1) {
			strIsComment = '已评价';
		}
        item.isComment = strIsComment;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}