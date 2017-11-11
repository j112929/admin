<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${activitySeckill!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${activitySeckill!=null}">"${BASE_URL}/activitySeckill/edit"</c:when><c:otherwise>"${BASE_URL}/activitySeckill/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${activitySeckill.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="skuId" class="col-sm-3 control-label">商品sku</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="skuId" name="skuId" value="${activitySeckill.skuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="maxBuyQuantity" class="col-sm-3 control-label">每人限购数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="maxBuyQuantity" name="maxBuyQuantity" value="${activitySeckill.maxBuyQuantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-3 control-label">秒杀商品数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="quantity" name="quantity" value="${activitySeckill.quantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="settlementPrice" class="col-sm-3 control-label">结算价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="settlementPrice" name="settlementPrice" value="${activitySeckill.settlementPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="price" class="col-sm-3 control-label">价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price" name="price" value="${activitySeckill.price}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="sortOrder" class="col-sm-3 control-label">序号</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="sortOrder" name="sortOrder" value="${activitySeckill.sortOrder}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">描述</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${activitySeckill.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="showTime" class="col-sm-3 control-label">预发布时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="showTime" name="showTime" 
                            value="<fmt:formatDate value="${activitySeckill.showTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择预发布时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="beginTime" class="col-sm-3 control-label">开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="beginTime" name="beginTime" 
                            value="<fmt:formatDate value="${activitySeckill.beginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="endTime" class="col-sm-3 control-label">结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="endTime" name="endTime" 
                            value="<fmt:formatDate value="${activitySeckill.endTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">是否是白名单活动</label>
				        <div class="col-sm-4">
				            <select id="isWhiteListActivity" name="isWhiteListActivity" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${activitySeckill.isWhiteListActivity == 0}">selected="selected"</c:if>>不是</option>
				                	<option value="1" <c:if test="${activitySeckill.isWhiteListActivity == 1}">selected="selected"</c:if>>是</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核状态</label>
				        <div class="col-sm-4">
				            <select id="verifyStatus" name="verifyStatus" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${activitySeckill.verifyStatus == 0}">selected="selected"</c:if>>未审核</option>
				                	<option value="1" <c:if test="${activitySeckill.verifyStatus == 1}">selected="selected"</c:if>>审核通过</option>
				                	<option value="2" <c:if test="${activitySeckill.verifyStatus == 2}">selected="selected"</c:if>>审核不通过</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="creator" class="col-sm-3 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="creator" name="creator" value="${activitySeckill.creator}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${activitySeckill.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="modifier" class="col-sm-3 control-label">修改人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="modifier" name="modifier" value="${activitySeckill.modifier}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${activitySeckill.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${activitySeckill.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${activitySeckill==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/activity/js/seckill.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->