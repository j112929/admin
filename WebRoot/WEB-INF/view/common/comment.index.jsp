<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>

<section class="hbox stretch">
    <aside>
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="row m-t-sm">
                    <div class="col-sm-2 m-b-xs">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-default action-refresh" title="刷新"><i class="fa fa-refresh"></i></button>                           
                        </div>
                        <%-- <a href="${BASE_URL}/commonComment/add" class="btn btn-sm btn-default load-content"><i class="fa fa-plus"></i>添加</a> --%>
                    </div>
                    <form class="form-inline"  action="${BASE_URL}/commonComment/page" id="searchForm">
	                    <div class="col-sm-10 m-b-xs text-right">
	                    	<div class="form-group">
                                <input type="text" value="" class="input-sm input-s form-control" name="startDate" id="startDate" placeholder="评价时间" readonly="readonly"> - 
                                <input type="text" value="" class="input-sm input-s form-control" name="endDate" id="endDate" placeholder="评价时间" readonly="readonly">
                       		</div>
                       		<div class="form-group">
                       			<select id="orderType" name="orderType" class="form-control input-sm">
	                                	<option value="" selected>订单类型</option>
	                                	<option value="1" id="orderType_1">普通</option>
	                                	<option value="2" id="orderType_2">折扣</option>
	                                	<option value="3" id="orderType_3">团购</option>
	                                	<option value="4" id="orderType_4">秒杀</option>
	                                	<option value="5" id="orderType_5">抽奖</option>
	                            </select>
	                            <%-- <select id="orderType" name="orderType" class="form-control input-sm">
	                                <option value="" selected>订单类型</option>
	                                <c:forEach items="${orderType}" var="entry">
	                                	<option value="${entry.key}" id="orderType_${entry.key}">${entry.value}</option>
	                                </c:forEach>
	                            </select> --%>
	                   	    </div>
                       		<div class="col-sm-4 m-b-xs pull-right">
		                        <div class="input-group">
		                            <input type="text" name="key" class="input-sm form-control" placeholder="请输入订单号/商品名称/供应商简称/评价总分数" />
		                            <span class="input-group-btn">
		                                <button class="btn btn-sm btn-default action-refresh" type="button">搜索</button>
		                            </span>
		                        </div>
	                        </div>
	                    </div>
	                </form>
                </div>
            </header>
            
			<%@include file = "../page.jsp" %>
            
        </section>
    </aside>
</section>
            
<jsp:include page="../wrapper.suffix.jsp"/>

<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/common/js/comment.index.js" type="text/javascript"></script>