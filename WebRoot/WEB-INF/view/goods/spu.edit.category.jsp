<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../wrapper.prefix.jsp" />
<link href="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css" />
<link href="${STATIC_URL}/plugins/jquery-prettyphoto/3.1.5/css/prettyPhoto.css" rel="stylesheet" type="text/css" />
<link href="${STATIC_URL}/modules/goods/css/index.index.css" rel="stylesheet" type="text/css" />
<script src="${STATIC_URL}/plugins/jquery/1.11.0/jquery.min.js"></script>
<style type="text/css">
    *{
	   margin:0px;
	   padding:0px;
	}
	ul li{
	  list-style:none;
	}
	#shenfen .nav >li ,#chengshi .nav >li ,#quyu .nav >li{
		  padding: 10px 15px;
		  border-bottom: 1px solid #E4E4E4;
		 
	}
	.linkTip{
		font-size: 14px;
		background-color: rgba(0,0,0,0.05);
		font-weight: 600;
		padding:15px 20px;
	}
	@media (min-width: 768px) {
 
  .hbox {
    display: table;
    table-layout: fixed;
    border-spacing: 0;
    width: 100%;
  }
  .hbox > aside,
  .hbox > section {
    display: table-cell;
    vertical-align: top;
    height: 100%;
    padding: 0;
    float: none;
  }
  .hbox > aside.show,
  .hbox > section.show,
  {
    display: table-cell !important;
  }
  .vbox {
    display: table;
    border-spacing: 0;
    position: relative;
    height: 100%;
    width: 100%;
  }
  .b-b {
  border-bottom: 1px solid #cfcfcf;
}
.b-l {
  border-left: 1px solid #cfcfcf;
}
.b-light {
  border-color: #e4e4e4;
}
  }
</style>
<script type="text/javascript">
			function categoryName1(id,name) {
				$("#category1").html(name);
				$.ajax({
						type : 'post',
						url : BASE_URL + '/goodsSpu/categoryByPid',
						data : 'pId=' + id,
						dataType : 'json',
						timeout : 10000,
						success : function(data) {
							if (data.status == 0) {
							$("#categoryName2").html("");
							$("#categoryName3").html("");
							$("#addGoods").html("");
							$("#category2").html("二级分类");
							$("#category3").html("三级分类");
							$.each(data.data, function(index, item) {
							$("#categoryName2").append("<li onclick=\"categoryName2("+item.id+",'"+item.name+"')\">"+item.name+"</li>");
							});
							} else {
							}
							return false;
						}
					});
			}
			function categoryName2(id,name) {
				$("#category2").html(name);
				$.ajax({
						type : 'post',
						url : BASE_URL + '/goodsSpu/categoryByPid',
						data : 'pId=' + id,
						dataType : 'json',
						timeout : 10000,
						success : function(data) {
							if (data.status == 0) {
							$("#categoryName3").html("");
							$("#addGoods").html("");
							$("#category3").html("三级分类");
							$.each(data.data, function(index, item) {
							$("#categoryName3").append("<li onclick=\"categoryName3("+item.id+",'"+item.name+"')\">"+item.name+"</li>");
							});
							} else {
							}
							return false;
						}
					});
			}
			function categoryName3(id,name) {
				$("#category3").html(name);
				$("#addGoods").html("<a href='"+'${BASE_URL}'+"/goodsSpu/edit?categoryId3="+id+"' class='btn btn-sm btn-default load-content'>添加</a>");
			}
		</script>
	<body>
		<section class="vbox">
			<section>
				<section class="hbox stretch">
					<section id="content">
						<section class="vbox">
						<header class="header bg-white b-b clearfix">
                <div class="row m-t-sm">
                    <div class="col-sm-8 m-b-xs">
                        <div class="btn-group">
                           选择商品分类
                        </div>
                    </div>
                    <form action="${BASE_URL}/goodsSpu/page" id="searchForm">
	                    <div class="col-sm-4 m-b-xs">
	                        <div class="input-group">
	                            <span class="input-group-btn" id="addGoods">
	                            </span>
	                        </div>
	                    </div>
	                </form>
                </div>
            </header>
							<section class="scrollable">
								<section class="hbox stretch">
									<aside class="aside-lg bg-light lter b-r m_zlxg" id="shenfen">
										<p class="wrapper b-b header linkTip" id="category1">一级分类</p>
										<div class="m_zlxg2">
											<ul class="nav">
										<c:forEach items="${goodsCategory}" var="c">
										<li onclick="categoryName1('${c.id}','${c.name}')">${c.name}</li>
										</c:forEach>
											</ul>
										</div>
									</aside>
									<aside class="col-lg-4 b-l bg-white m_zlxg" id="chengshi">
										<p class="wrapper b-b header linkTip" id="category2">二级分类</p>
										<div class="m_zlxg2">
											<ul class="nav" id="categoryName2"></ul>
										</div>
									</aside>
									<aside class="col-lg-4 b-l bg-white m_zlxg" id="quyu">
										<p class="wrapper b-b header linkTip" id="category3">三级分类</p>
										<div class="m_zlxg2">
											<ul class="nav" id="categoryName3"></ul>
										</div>
									</aside>

								</section>
							</section>
						</section>
						<a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
					</section>
					<aside class="bg-light lter b-l aside-md hide" id="notes">
						<div class="wrapper">Notification</div>
					</aside>
				</section>
			</section>
		</section>
		<script src="js/jquery.min.js"></script>
		<!-- Bootstrap -->
		<script src="js/bootstrap.js"></script>
		<!-- App -->
		<script src="js/app.js"></script>
		<script src="js/app.plugin.js"></script>
		<script src="js/slimscroll/jquery.slimscroll.min.js"></script>
		<script type="text/javascript" src="js/address.js"></script>
	</body>

<jsp:include page="../wrapper.suffix.jsp" />
<script src="${STATIC_URL}/plugins/sortable/jquery.sortable.js" type="text/javascript"></script>


<script src="${STATIC_URL}/modules/goods/js/address.js" type="text/javascript"></script>

