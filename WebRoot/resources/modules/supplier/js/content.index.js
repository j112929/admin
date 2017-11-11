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
		
				var supplierId = $(this).attr("supplierId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/supplierContent/delete',
			data : 'supplierId=' + supplierId,
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
					property : 'supplierId',
					label : '供应商编号',
					sortable : false
				},
				{
					property : 'name',
					label : '供应商名称',
					sortable : false
				},
				{
					property : 'nameSp',
					label : '供应商简称',
					sortable : false
				},
				{
					property : 'smemo',
					label : '备注',
					sortable : false
				},
				{
					property : 'corporateName',
					label : '法人代表姓名',
					sortable : false
				},
				{
					property : 'registered',
					label : '注册资金',
					sortable : false
				},
				{
					property : 'cardType',
					label : '证件类型',
					sortable : false
				},
				{
					property : 'cardNumber',
					label : '证件号码',
					sortable : false
				},
				{
					property : 'type',
					label : '公司类型',
					sortable : false
				},
				{
					property : 'licence',
					label : '营业执照',
					sortable : false
				},
				{
					property : 'organizationCard',
					label : '组织机构代码',
					sortable : false
				},
				{
					property : 'licenceBeginTime',
					label : '营业执照开始时间',
					sortable : false
				},
				{
					property : 'licenceEndTime',
					label : '营业执照结束时间',
					sortable : false
				},
				{
					property : 'organizationBeginTime',
					label : '组织机构开始时间',
					sortable : false
				},
				{
					property : 'organizationEndTime',
					label : '组织机构结束时间',
					sortable : false
				},
				{
					property : 'province',
					label : '省份代码',
					sortable : false
				},
				{
					property : 'city',
					label : '城市代码',
					sortable : false
				},
				{
					property : 'county',
					label : '区县代码',
					sortable : false
				},
				{
					property : 'address',
					label : '详细地址',
					sortable : false
				},
				{
					property : 'email',
					label : '联系人邮箱',
					sortable : false
				},
				{
					property : 'phone',
					label : '联系人电话',
					sortable : false
				},
				{
					property : 'agreementBeginTime',
					label : '合同开始时间',
					sortable : false
				},
				{
					property : 'agreementEndTime',
					label : '合同结束时间',
					sortable : false
				},
				{
					property : 'accountsName',
					label : '清算户名',
					sortable : false
				},
				{
					property : 'accountsCard',
					label : '清算账号',
					sortable : false
				},
				{
					property : 'bank',
					label : '开户行代码',
					sortable : false
				},
				{
					property : 'bankCard',
					label : '行号',
					sortable : false
				},
				{
					property : 'bankAddr',
					label : '开户行所在地',
					sortable : false
				},
				{
					property : 'financialPerson',
					label : '财务联系人',
					sortable : false
				},
				{
					property : 'financialEmail',
					label : '财务邮箱',
					sortable : false
				},
				{
					property : 'financialPhone',
					label : '财务联系电话',
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
					property : 'modifier',
					label : '修改人',
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
		item._query = '<a href="'+BASE_URL + '/supplierContent/detail?supplierId=' + item.supplierId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/supplierContent/edit?supplierId=' + item.supplierId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="supplierId_' + item.supplierId + '" supplierId="' + item.supplierId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strCardType = '未知';
		if (item.cardType == 0) {
			strCardType = '身份证';
		} else if (item.cardType == 1) {
			strCardType = '护照';
		}
        item.cardType = strCardType;

		var strType = '未知';
		if (item.type == 0) {
			strType = '私营';
		} else if (item.type == 1) {
			strType = '国企';
		} else if (item.type == 2) {
			strType = '合资';
		} else if (item.type == 3) {
			strType = '外企';
		}
        item.type = strType;
		item.licenceBeginTime = dateConverter(item.licenceBeginTime, PATTERN_ENUM.datetime);
		item.licenceEndTime = dateConverter(item.licenceEndTime, PATTERN_ENUM.datetime);
		item.organizationBeginTime = dateConverter(item.organizationBeginTime, PATTERN_ENUM.datetime);
		item.organizationEndTime = dateConverter(item.organizationEndTime, PATTERN_ENUM.datetime);
		item.agreementBeginTime = dateConverter(item.agreementBeginTime, PATTERN_ENUM.datetime);
		item.agreementEndTime = dateConverter(item.agreementEndTime, PATTERN_ENUM.datetime);
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}