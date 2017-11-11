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
		
				var merchantId = $(this).attr("merchantId");
		
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/merchant/delete',
			data : 'merchantId=' + merchantId,
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
					property : 'merchantId',
					label : '商户id',
					sortable : false
				},
				{
					property : 'merchantNo',
					label : '商户编号',
					sortable : false
				},
				{
					property : 'name',
					label : '商户简称',
					sortable : false
				},
				{
					property : 'fullName',
					label : '商户全称',
					sortable : false
				},
				{
					property : 'legalPerson',
					label : '法人代表',
					sortable : false
				},
				{
					property : 'registeredCapital',
					label : '公司注册资金',
					sortable : false
				},
				{
					property : 'cardType',
					label : '证件类型',
					sortable : false
				},
				{
					property : 'cardNo',
					label : '证件号码',
					sortable : false
				},
				{
					property : 'companyType',
					label : '公司类型',
					sortable : false
				},
				{
					property : 'businessLicenseNo',
					label : '营业执照号码',
					sortable : false
				},
				{
					property : 'businessLicenseBeginTime',
					label : '营业执照开始时间',
					sortable : false
				},
				{
					property : 'businessLicenseEndTime',
					label : '营业执照结束时间',
					sortable : false
				},
				{
					property : 'organizationCode',
					label : '组织机构代码',
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
					label : '办公详细地址',
					sortable : false
				},
				{
					property : 'linkmanName',
					label : '联系人姓名',
					sortable : false
				},
				{
					property : 'linkmanPhone',
					label : '联系人电话',
					sortable : false
				},
				{
					property : 'linkmanEmail',
					label : '联系人邮箱',
					sortable : false
				},
				{
					property : 'contractBeginTime',
					label : '合同开始时间',
					sortable : false
				},
				{
					property : 'contractEndTime',
					label : '合同结束时间',
					sortable : false
				},
				{
					property : 'bankAccountName',
					label : '清算账户户名',
					sortable : false
				},
				{
					property : 'bankAccount',
					label : '清算账号',
					sortable : false
				},
				{
					property : 'bankName',
					label : '开户行名称',
					sortable : false
				},
				{
					property : 'bankNo',
					label : '开户行编号',
					sortable : false
				},
				{
					property : 'bankCity',
					label : '开户行所在城市编码',
					sortable : false
				},
				{
					property : 'bankAccountType',
					label : '账户类型',
					sortable : false
				},
				{
					property : 'financeLinkmanName',
					label : '财务联系人姓名',
					sortable : false
				},
				{
					property : 'financeLinkmanPhone',
					label : '财务联系人电话',
					sortable : false
				},
				{
					property : 'financeLinkmanEmail',
					label : '财务联系人邮箱',
					sortable : false
				},
				{
					property : 'extraFile',
					label : '附件',
					sortable : false
				},
				{
					property : 'contractFile',
					label : '合同',
					sortable : false
				},
				{
					property : 'description',
					label : '简介',
					sortable : false
				},
				{
					property : 'verifyStatus',
					label : '审核状态',
					sortable : false
				},
				{
					property : 'isStop',
					label : '是否终止',
					sortable : false
				},
				{
					property : 'isDel',
					label : '是否删除',
					sortable : false
				},
				{
					property : 'creator',
					label : '创建人',
					sortable : false
				},
				{
					property : 'ctime',
					label : '创建时间',
					sortable : false
				},
				{
					property : 'modifier',
					label : '修改人',
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
		item._query = '<a href="'+BASE_URL + '/merchant/detail?merchantId=' + item.merchantId + '"  class="modal-detail"><i class="fa fa-search-plus" title="查看详情"></i></a>';
		item._action = '<a href="' + BASE_URL + '/merchant/edit?merchantId=' + item.merchantId
				+ '" class="operating-edit" title="编辑"><i class="fa fa-pencil"></i></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" merchantId="' + item.merchantId
				+ '" title="删除"><i class="fa fa-trash-o"></i></a>';


		var strCardType = '未知';
		if (item.cardType == 1) {
			strCardType = '身份证';
		} else if (item.cardType == 2) {
			strCardType = '驾驶证';
		} else if (item.cardType == 3) {
			strCardType = '护照';
		}
        item.cardType = strCardType;

		var strCompanyType = '未知';
		if (item.companyType == 1) {
			strCompanyType = '私营';
		} else if (item.companyType == 2) {
			strCompanyType = '国企';
		} else if (item.companyType == 3) {
			strCompanyType = '合资';
		} else if (item.companyType == 4) {
			strCompanyType = '外企';
		}
        item.companyType = strCompanyType;
		item.businessLicenseBeginTime = dateConverter(item.businessLicenseBeginTime, PATTERN_ENUM.datetime);
		item.businessLicenseEndTime = dateConverter(item.businessLicenseEndTime, PATTERN_ENUM.datetime);
		item.organizationBeginTime = dateConverter(item.organizationBeginTime, PATTERN_ENUM.datetime);
		item.organizationEndTime = dateConverter(item.organizationEndTime, PATTERN_ENUM.datetime);
		item.contractBeginTime = dateConverter(item.contractBeginTime, PATTERN_ENUM.datetime);
		item.contractEndTime = dateConverter(item.contractEndTime, PATTERN_ENUM.datetime);

		var strBankAccountType = '未知';
		if (item.bankAccountType == 1) {
			strBankAccountType = '储蓄卡';
		} else if (item.bankAccountType == 2) {
			strBankAccountType = '信用卡';
		} else if (item.bankAccountType == 3) {
			strBankAccountType = '企业账户';
		}
        item.bankAccountType = strBankAccountType;

		var strVerifyStatus = '未知';
		if (item.verifyStatus == 0) {
			strVerifyStatus = '未审核';
		} else if (item.verifyStatus == 1) {
			strVerifyStatus = '审核通过';
		} else if (item.verifyStatus == 2) {
			strVerifyStatus = '审核不通过';
		}
        item.verifyStatus = strVerifyStatus;

		var strIsStop = '未知';
		if (item.isStop == 0) {
			strIsStop = '未终止';
		} else if (item.isStop == 1) {
			strIsStop = '终止';
		}
        item.isStop = strIsStop;

		var strIsDel = '未知';
		if (item.isDel == 0) {
			strIsDel = '未删除';
		} else if (item.isDel == 1) {
			strIsDel = '删除';
		}
        item.isDel = strIsDel;
		item.ctime = dateConverter(item.ctime, PATTERN_ENUM.datetime);
		item.mtime = dateConverter(item.mtime, PATTERN_ENUM.datetime);
	});
}