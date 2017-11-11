<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${activityLottery!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${activityLottery!=null}">"${BASE_URL}/activityLottery/edit"</c:when><c:otherwise>"${BASE_URL}/activityLottery/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${activityLottery.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">活动规则</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${activityLottery.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="maxLotteryCount" class="col-sm-3 control-label">每人每天最大抽奖次数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="maxLotteryCount" name="maxLotteryCount" value="${activityLottery.maxLotteryCount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="count" class="col-sm-3 control-label">总转动次数</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="count" name="count" value="${activityLottery.count}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="settlementPrice" class="col-sm-3 control-label">结算价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="settlementPrice" name="settlementPrice" value="${activityLottery.settlementPrice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="price" class="col-sm-3 control-label">每次抽奖价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="price" name="price" value="${activityLottery.price}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="beginTime" class="col-sm-3 control-label">开始时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="beginTime" name="beginTime" 
                            value="<fmt:formatDate value="${activityLottery.beginTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择开始时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="endTime" class="col-sm-3 control-label">结束时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="endTime" name="endTime" 
                            value="<fmt:formatDate value="${activityLottery.endTime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择结束时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">审核状态</label>
				        <div class="col-sm-4">
				            <select id="verifyStatus" name="verifyStatus" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${activityLottery.verifyStatus == 0}">selected="selected"</c:if>>未审核</option>
				                	<option value="1" <c:if test="${activityLottery.verifyStatus == 1}">selected="selected"</c:if>>审核通过</option>
				                	<option value="2" <c:if test="${activityLottery.verifyStatus == 2}">selected="selected"</c:if>>审核不通过</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="creator" class="col-sm-3 control-label">创建人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="creator" name="creator" value="${activityLottery.creator}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="ctime" class="col-sm-3 control-label">创建时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="ctime" name="ctime" 
                            value="<fmt:formatDate value="${activityLottery.ctime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择创建时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <div class="form-group">
                        <label for="modifier" class="col-sm-3 control-label">修改人</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="modifier" name="modifier" value="${activityLottery.modifier}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group m-b-xs">
                        <label for="mtime" class="col-sm-3 control-label">修改时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="mtime" name="mtime" 
                            value="<fmt:formatDate value="${activityLottery.mtime}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择修改时间时间" readonly="readonly"/>
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
                    <input type="hidden" name="id" value="${activityLottery.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${activityLottery==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
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
<script src="${STATIC_URL}/modules/activity/js/lottery.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->