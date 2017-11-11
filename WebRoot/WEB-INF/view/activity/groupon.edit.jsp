<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../wrapper.prefix.jsp"/>
<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${activityGroupon!=null}">编辑团购</c:when><c:otherwise>添加团购</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                	<div class="panel-body">
		                <form class="form-horizontal h-100" id="edit_form" action=<c:choose> <c:when test="${activityGroupon!=null}">"${BASE_URL}/activityGroupon/edit"</c:when><c:otherwise>"${BASE_URL}/activityGroupon/add"</c:otherwise></c:choose>  method="post">
                		
						<div class="form-group m-b-xs">
                            <label class="col-sm-2 control-label"><font class="red">*
                            </font>团名称</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control input-s inline" id="name" name="name" value="${activityGroupon.name}" >                               
                            </div>
                        </div>
                        <div class="line line-dashed line-sm pull-in"></div>
						
						<div class="form-group m-b-xs">
							<label class="col-sm-2 control-label"><font class="red">*
							</font>成团人数</label>
							<div class="col-sm-6">
								<input type="text" class="form-control input-s inline" id="userCount" name="userCount" value="${activityGroupon.userCount}" >								
								
							</div>
						</div>
						<div class="line line-dashed line-sm pull-in"></div>
						
						
					    <div class="form-group m-b-xs">
							<label for="start_time" class="col-sm-2 control-label"><font class="red">* </font>活动时间</label>
							<div class="col-sm-6">
								<input type="text" class="input-s datetimepicker-input  form-control  inline  " id="beginTime" name="beginTime" 
								value="<fmt:formatDate value="${activityGroupon.beginTime}" pattern="yyyy-MM-dd hh:mm"/>" readonly="readonly">
							  -  
								<input type="text" class="input-s datetimepicker-input form-control  inline " id="endTime" name="endTime" 
								value="<fmt:formatDate value="${activityGroupon.endTime}" pattern="yyyy-MM-dd hh:mm"/>" readonly="readonly">
							</div>
						</div>
						<div class="line line-dashed line-sm pull-in"></div>
						
					   <div class="form-group m-b-xs">
							<label class="col-sm-2 control-label"><font class="red">*
						</font>商品信息</label>
						<div class="col-sm-6">
                                <input type="text" class="form-control input-s inline" id="skuId" name="skuId" value="${activityGroupon.skuId}" >                               
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					
						<div class="form-group m-b-xs">
							<label class="col-sm-2 control-label"><font class="red">*
							</font>单件本金价格</label>
							<div class="col-sm-6">
								<input type="text" class="form-control input-s inline" id="price" name="price" value="${activityGroupon.price}" >								
								
							</div>
						</div>
						<div class="line line-dashed line-sm pull-in"></div>
						<div class="form-group m-b-xs">
							<label class="col-sm-2 control-label"><font class="red">*
							</font>单件手续费率</label>
							<div class="col-sm-6">
								<input type="text" class="form-control input-s inline" id="chargeRate" name="chargeRate" value="${activityGroupon.chargeRate}" >								
							</div>
						</div>
						<div class="line line-dashed line-sm pull-in"></div>
						
						<input type="hidden" name="id" value="${activityGroupon.id}" />
						</form>
                	</div>
            </section>
            
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${activityGroupon ==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
 <script src="${STATIC_URL}/modules/activity/js/groupon.edit.js"></script>

