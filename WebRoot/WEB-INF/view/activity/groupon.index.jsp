<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../wrapper.prefix.jsp" />

<link href="${STATIC_URL}/plugins/datepicker/css/datepicker3.css"
	rel="stylesheet" type="text/css" />
<link href="${STATIC_URL}/modules/activity/css/category.index.css"
	rel="stylesheet" type="text/css" />

<section class="hbox stretch">
	<aside>
		<section class="vbox">
			<header class="header bg-white b-b clearfix">
				<div class="row m-t-sm" >
					<div class="col-sm-2 m-b-xs">
						<div class="btn-group">
							<button type="button"
								class="btn btn-sm btn-default action-refresh" title="Refresh">
								<i class="fa fa-refresh"></i>
							</button>
						</div>
						<a href="${BASE_URL}/activityGroupon/add" class="btn btn-sm btn-default load-content"><i class="fa fa-plus"></i> 添加</a>
					</div>
					<form class="form-inline" action="${BASE_URL}/activityGroupon/page"
						id="searchForm">
						<div class="col-sm-10 m-b-xs text-left p-left">

							<div class="form-group">
								<label><font>供应商编号:&nbsp;&nbsp;</font> </label> <input
									type="text" name="key" class="input-sm form-control" />
							</div>
							<div class="form-group">
								<label><font>供应商简称:&nbsp;&nbsp;</font> </label> <input
									type="text" name="key" class="input-sm form-control" />
							</div>
							<div class="form-group">
								<label><font>商品SKU编号:&nbsp;&nbsp;</font> </label> <input
									type="text" name="skuId" class="input-sm form-control" />
							</div>
							<div class="form-group">
								<label><font>商品名称:&nbsp;&nbsp;</font> </label> <input
									type="text" name="name" class="input-sm form-control" />
							</div>
							<div class="form-group">
								<label><font>审核状态:&nbsp;&nbsp;</font> </label> <select
									name="verifyStatus" class="form-control input-sm">
									<option value="">待审核</option>
									<option value="1">审核通过</option>
									<option value="2">审核不通过</option>
								</select>
							</div>

							 <div class="form-group">
							 <label><font>活动开始时间:&nbsp;&nbsp;</font> </label>
                                <input type="text" value="" size="10" class="input-sm input-s form-control" name="validStartDate" id="validStartDate" placeholder="请选择有效开始时间" readonly="readonly"> - 
                                <input type="text" value="" size="10" class="input-sm input-s form-control" name="validEndDate" id="validEndDate" placeholder="请选择有效结束时间" readonly="readonly">
                            </div>
                            
                            <div class="form-group">
                             <label><font>活动结束时间:&nbsp;&nbsp;</font> </label>
                                <input type="text" value="" size="10" class="input-sm input-s form-control" name="grantStartDate" id="grantStartDate" placeholder="请选择发放开始时间" readonly="readonly"> - 
                                <input type="text" value="" size="10" class="input-sm input-s form-control" name="grantEndDate" id="grantEndDate" placeholder="请选择发放结束时间" readonly="readonly">
                            </div>
							
							<div class="form-group">
								<label><font>活动状态:&nbsp;&nbsp;</font> </label> <select
									name="position" class="form-control input-sm">

									<option value="">未开始</option>
									<option value="1">进行中</option>
									<option value="2">已结束</option>
								</select>

							</div>		
								<div class="form-group">
								<span class="input-group-btn">
	                                <button class="btn btn-sm btn-default action-refresh" type="button">搜索</button>
	                            </span>
                           </div>
                           </div>
					</form>
				</div>
			</header>
            <section class="scrollable wrapper customer">
                <section class="panel panel-default" >
                    <div class="table-responsive">
                        <table class="table table-striped m-b-sm datagrid" id="content_listing">
                            <thead>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th class="row">
                                        <div class="datagrid-footer-left col-sm-6 text-center-xs m-l-n"
                                             style="display:none;">
                                            <div class="grid-controls m-t-sm">
                                                    <span>
                                                        <span class="grid-start"></span> -
                                                        <span class="grid-end"></span> （共
                                                        <span class="grid-count"></span>）
                                                    </span>
    
                                                <div class="select grid-pagesize dropup" data-resize="auto">
                                                    <button data-toggle="dropdown"
                                                            class="btn btn-sm btn-default dropdown-toggle">
                                                        <span class="dropdown-label"></span>
                                                        <span class="caret"></span>
                                                    </button>
                                                    <ul class="dropdown-menu">
                                                        <li data-value="5"><a href="#">5</a></li>
                                                        <li data-value="15" data-selected="true"><a href="#">15</a></li>
                                                        <li data-value="20"><a href="#">20</a></li>
                                                        <li data-value="50"><a href="#">50</a></li>
                                                        <li data-value="100"><a href="#">100</a></li>
                                                    </ul>
                                                </div>
                                                <span>/页</span>
                                            </div>
                                        </div>
    
                                        <div class="datagrid-footer-right col-sm-6 text-right text-center-xs"
                                             style="display:none;">
                                            <div class="grid-pager m-r-n">
                                                <button type="button" class="btn btn-sm btn-default grid-prevpage"><i
                                                        class="fa fa-chevron-left"></i></button>
                                                <!--<span>页</span>-->
    
                                                <div class="inline">
                                                    <div class="input-group dropdown combobox">
                                                        <input class="input-sm form-control" type="text">
    
                                                        <div class="input-group-btn dropup">
                                                            <button class="btn btn-sm btn-default" data-toggle="dropdown"><i
                                                                    class="caret"></i></button>
                                                            <ul class="dropdown-menu pull-right"></ul>
                                                        </div>
                                                    </div>
                                                </div>
                                                <span>/ <span class="grid-pages"></span></span>
                                                <button type="button" class="btn btn-sm btn-default grid-nextpage"><i
                                                        class="fa fa-chevron-right"></i></button>
                                            </div>
                                        </div>
                                    </th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/datepicker/js/bootstrap-datepicker.js"></script>
<script src="${STATIC_URL}/plugins/datepicker/js/locales/bootstrap-datepicker.zh-CN.time.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/activity/js/groupon.index.js" type="text/javascript"></script>