<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../wrapper.prefix.jsp"/>
<link href="${STATIC_URL}/plugins/datepicker/css/datepicker3.css" rel="stylesheet" type="text/css"/>
<section class="hbox stretch">
    <aside>
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="row m-t-sm">
                    <div class="col-sm-2 m-b-xs">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-default action-refresh" title="刷新"><i class="fa fa-refresh"></i></button>                           
                        </div>
                        <a href="${BASE_URL}/advert/add" class="btn btn-sm btn-default l`oad-content"><i class="fa fa-plus"></i>添加</a>
                    </div>
                    <form class="form-inline" action="${BASE_URL}/advert/page" id="searchForm" method="post">
                    	<div class="col-sm-7 m-b-xs text-right">
                    		<div class="form-group">
                    		    <label ><font >广告创建时间:&nbsp;&nbsp;</font></label>
                                <input type="text" value="" class="input-sm input-s form-control" name="startDate" id="startDate" placeholder="开始时间" readonly="readonly" onmouseover="changetips()" onmouseout="changetipsto()"> - 
                                <input type="text" value="" class="input-sm input-s form-control" name="endDate" id="endDate" placeholder="结束时间" readonly="readonly"   onmouseover="changetips()" onmouseout="changetipsto()">
                            </div>
	                    	<div class="form-group">	                          
                                <select name="position" class="form-control input-sm">
                                    <option value="">请选择专区</option> 
                                    <option value="1">商城banner</option> 
                                    <option value="2">积分专区banner</option>         
                                    <option value="3">分期专区banner</option>                                    
                                </select>                            
	                        </div>	                        
	                    </div>	
	                   <div class="col-sm-3 m-b-xs pull-right">
	                        <div class="input-group">
	                            <input type="text" name="key" class="input-sm form-control" placeholder="请输入标题" />
	                            <span class="input-group-btn">
	                                <button class="btn btn-sm btn-default action-refresh" type="button">搜索</button>
	                            </span>
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
<script src="${STATIC_URL}/modules/advert/js/advert.index.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/datepicker/js/bootstrap-datepicker.js"></script>
<script src="${STATIC_URL}/plugins/datepicker/js/locales/bootstrap-datepicker.zh-CN.time.js" charset="UTF-8"></script>
