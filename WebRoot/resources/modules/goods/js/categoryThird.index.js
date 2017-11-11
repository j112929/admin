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
	 * 二级联动菜单
	 */
	function selectTwoGrade(){
		var value = $('#ppId option:selected').val();
		console.log(value);
		if(value == null) return;
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsCategory/selectTwoGrade',
			data : 'pId=' + value,
			dataType : 'json',
			timeout : 1000,
			success : function(data) {
				if(data == null)return;
				$("#pId").empty();
//				$("#pId").html("");
				var lst = eval(data);
				console.log(lst);
				for (var i = 0; i < lst.length; i++) {
                    $("#pId").append("<option value='" + lst[i].id + "'>" + lst[i].name + "</option>");
                }
			}
		});
	}
	/*function getThreeGrade(){
		var value = $('#pId option:selected').val();
		if(value == null) return;
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsCategory/selectThreeGrade',
			data : 'pId=' + id,
			dataType : 'json',
			timeout : 1000,
			success : function(data) {
				$("#id").html("");
				var lst = eval(data);
				for (var i = 0; i < lst.length; i++) {
                    $("#id").append("<option value='" + lst[i].id + "'>" + lst[i].name + "</option>");
                }
				
				return false;
			}
		});
	}*/
	/**
	 * 单个删除
	 */
	$('body').delegate('.operate-delete', 'click', function() {
		var del = confirm('确定要删除吗？');
		if (!del) {
			return false;
		}
		var id = $(this).attr("id");
		id = id.substring(3);
		/* 执行 */
		$.ajax({
			type : 'post',
			url : BASE_URL + '/goodsCategory/delete',
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
					property : 'firstCategoryName',
					label : '一级分类',
					sortable : false
				},
				{
					property : 'secondCategoryName',
					label : '二级分类',
					sortable : false
				},
				{
					property : 'thirdCategoryName',
					label : '运营三级分类名称',
					sortable : false
				},
				{
					property : 'pic',
					label : '分类图片',
					sortable : false
				},
				{
					property : 'thirdSortOrder',
					label : '序号',
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
		item._action = '<a href="' + BASE_URL + '/goodsCategory/editThird?id=' + item.thirdCategoryId+'&ppId='+item.firstCategoryId
				+ '" class="operating-edit" title="编辑"><span>编辑</span></a>&nbsp;&nbsp;'
				+ '<a href="javascript:;" class="operate-delete" id="id_' + item.thirdCategoryId + '" id="' + item.thirdCategoryId
				+ '" title="删除"><span>删除</span></a>&nbsp;&nbsp;'
				+ '<a href="' + BASE_URL + '/goodsCategory/bindProperty?id=' + item.thirdCategoryId
				+ '" class="operating-edit" title="绑定属性"><span>绑定属性</span></a>';

		if (item.pic) {
			item.pic  = '<a class="thumb m-l" href="javascript:;">' + '<img src="' + IMG_URL + item.pic + '">' + '</a>';
		} else {
			item.pic = '';
		}
	});
}