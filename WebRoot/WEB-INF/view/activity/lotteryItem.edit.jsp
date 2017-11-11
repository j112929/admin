<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${activityLotteryItem!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${activityLotteryItem!=null}">"${BASE_URL}/activityLotteryItem/edit"</c:when><c:otherwise>"${BASE_URL}/activityLotteryItem/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="lotteryId" class="col-sm-3 control-label">抽奖活动id</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="lotteryId" name="lotteryId" value="${activityLotteryItem.lotteryId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="skuId" class="col-sm-3 control-label">商品sku</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="skuId" name="skuId" value="${activityLotteryItem.skuId}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="position" class="col-sm-3 control-label">位置</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="position" name="position" value="${activityLotteryItem.position}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="pic" class="col-sm-3 control-label">图片</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="pic" name="pic" value="${activityLotteryItem.pic}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="quantity" class="col-sm-3 control-label">商品数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="quantity" name="quantity" value="${activityLotteryItem.quantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="remainQuantity" class="col-sm-3 control-label">商品剩余数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="remainQuantity" name="remainQuantity" value="${activityLotteryItem.remainQuantity}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="settlementPrice" class="col-sm-3 control-label">结算价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="settlementPrice" name="settlementPrice" value="${activityLotteryItem.settlementPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="beginTime" class="col-sm-3 control-label">开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="beginTime" name="beginTime" 
                            value="<fmt:formatDate value="${activityLotteryItem.beginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="endTime" class="col-sm-3 control-label">结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="endTime" name="endTime" 
                            value="<fmt:formatDate value="${activityLotteryItem.endTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${activityLotteryItem.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${activityLotteryItem==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/activity/js/lotteryItem.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->