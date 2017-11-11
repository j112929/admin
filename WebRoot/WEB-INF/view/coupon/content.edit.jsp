<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<!--  <link href="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css" />
<link href="${STATIC_URL}/plugins/jquery-prettyphoto/3.1.5/css/prettyPhoto.css" rel="stylesheet" type="text/css" /> -->
  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${couponContent!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form  method="post" enctype="multipart/form-data" class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${couponContent!=null}">"${BASE_URL}/couponContent/edit"</c:when><c:otherwise>"${BASE_URL}/couponContent/add"</c:otherwise></c:choose> >
					<div class="form-group">
				        <label class="col-sm-3 control-label"><font class="red">* </font>优惠券类型</label>
				        <div class="col-sm-4">
  			            <select id="couponType" name="couponType" class="form-control" onchange="changeCate()">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponContent.couponType == 0}">selected="selected"</c:if>>全场类型</option>
				                	<option value="1" <c:if test="${couponContent.couponType == 1}">selected="selected"</c:if>>专场类型</option>
				            </select>
   <%--				            <label class="checkbox-inline p-left-0">
                              <input type="radio" name="couponType" value="0" onclick="changeCate(this)"<c:if test="${ couponContent.couponType == 0 || couponContent.couponId == null}">checked="checked"</c:if> />&nbsp;全场类型
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="couponType" value="1" onclick="changeCate(this)"<c:if test="${ couponContent.couponType == 1}">checked="checked"</c:if> />&nbsp;专场类型
                            </label>--%>
				        </div> 
				    </div>
				    <div class="line line-dashed line pull-in"></div>
                    <div class="form-group">                     
                        <div class="col-sm-10"> 
                        	<div id="cateList" style="display: none;">      
                        	 <label for="categoryId" class="col-sm-3 control-label"><font class="red">* </font>使用专场</label>  
                          		<c:forEach items="${categories}" var="v">
                          	    	<input type="checkbox" name="category" id="${v.id}"/>${v.name}
                          		</c:forEach>      
                            </div>                                       
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="couponName" class="col-sm-3 control-label"><font class="red">* </font>优惠券名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="couponName" name="couponName" value="${couponContent.couponName}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="amount" class="col-sm-3 control-label"><font class="red">* </font>优惠券金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="amount" name="amount" value="${couponContent.amount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="undertakeAmount" class="col-sm-3 control-label"><font class="red">* </font>商户承担额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="undertakeAmount" name="undertakeAmount" value="${couponContent.undertakeAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="bankSubsidy" class="col-sm-3 control-label"><font class="red">* </font>银行补贴金额</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="bankSubsidy" name="bankSubsidy" value="${couponContent.bankSubsidy}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="count" class="col-sm-3 control-label"><font class="red">* </font>添加数量</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="count" name="count" value="${couponContent.count}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-inline form-group">
                        <label for="validityStart" class="col-sm-3 control-label"><font class="red">* </font>有效期</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="validityStart" name="validityStart" 
                            value="<fmt:formatDate value="${couponContent.validityStart}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择有效期开始时间" readonly="readonly"/>--
                        <input type="text" class="input-sm input-s datetimepicker-input form-control" id="validityEnd" name="validityEnd" 
                            value="<fmt:formatDate value="${couponContent.validityEnd}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择有效期结束时间" readonly="readonly"/>                       
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>                   
                    <div class="form-group">
                    
                        <label for="minLimitAmount" class="col-sm-3 control-label"><font class="red">* </font>使用规则</label><br/>                                    
                        <div class="col-sm-4">
                        			<div class="form-group form-inline">
                             优惠券使用金额下限:&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;<input type="text" class="form-control" id="minLimitAmount" name="minLimitAmount" value="${couponContent.minLimitAmount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />&nbsp;&nbsp;&nbsp;元
                     				</div>
                     				<div class="form-group form-inline">	 
                     					 每单使用最大次数: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="form-control" id="maxUseCount" name="maxUseCount" value="${couponContent.maxUseCount}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />&nbsp;&nbsp;&nbsp;次
                       				</div>
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="useDetail" class="col-sm-3 control-label">使用详情</label>
                        <div class="col-sm-4">
                            <input type="text" rows="4" class="form-control" id="useDetail" name="useDetail" value="${couponContent.useDetail}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="useNotice" class="col-sm-3 control-label">使用须知</label>
                        <div class="col-sm-4">                   
                            <input type="text" class="form-control" id="useNotice" name="useNotice" value="${couponContent.useNotice}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group form-inline m-b-xs">
                        <label for="publishDateStart" class="col-sm-3 control-label">发布时间</label>
                        <div class="col-sm-4">
                            <input type="text" class="input-sm input-s datetimepicker-input form-control" id="publishDateStart" name="publishDateStart" 
                            value="<fmt:formatDate value="${couponContent.publishDateStart}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择发布时间开始时间" readonly="readonly"/>--
                           <input type="text" class="input-sm input-s datetimepicker-input form-control" id="publishDateEnd" name="publishDateEnd" 
                            value="<fmt:formatDate value="${couponContent.publishDateEnd}" pattern="yyyy-MM-dd HH:mm"/>" placeholder="请选择发布时间结束时间" readonly="readonly"/>                        
                        </div>
                    </div>
                    <div class="line line-dashed line-lg pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">发布方式</label>
				        <div class="col-sm-4">
				            <select id="publishType" name="publishType" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponContent.publishType == 0}">selected="selected"</c:if>>自动发布</option>
				                	<option value="1" <c:if test="${couponContent.publishType == 1}">selected="selected"</c:if>>用户自行领取</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
					<div class="form-group">
				        <label class="col-sm-3 control-label">发布人群</label>
				        <div class="col-sm-4">
				            <select id="publishPopulation" name="publishPopulation" class="form-control">
				                <option value="0">请选择</option>
				                	<option value="0" <c:if test="${couponContent.publishPopulation == 0}">selected="selected"</c:if>>所有用户</option>
				                	<option value="1" <c:if test="${couponContent.publishPopulation == 1}">selected="selected"</c:if>>白名单</option>
				            </select>
				        </div>
				    </div>
				    <div class="line line-dashed line pull-in"></div>
               <div class="form-group file-reset">
                        <label for="attachmentId" class="col-sm-3 control-label">优惠券图片</label>
                        <div class="col-sm-9">
							<input type="file" name="picLogo" id="picLogo" class="filestyle" data-icon="false" data-buttonText="上传图片" data-classbutton="btn btn-default" data-classinput="form-control inline input-s" />
				<!-- 	<input type="hidden" name="files" id="files" value="" /> -->		
							<c:if test="${couponContent.pic != null && couponContent.pic != ''}">
				            <a href="${IMG_URL}${couponContent.pic}" class="thumb-sm" target="_blank"><img src="${IMG_URL}${couponContent.pic}" /></a>
				            </c:if>
						</div>
                    </div>            
					<div class="line line-dashed line pull-in"></div>   
					
			<!-- 		 <div class="form-group">
                        <label for="pic" class="col-sm-3 control-label">优惠券图片</label>
                            <div class="thumbnail uploadDiv">
                                                        <div class="uploadImg">
                                                            <input type="file" style="width:85px;height:85px;" onclick="uploadImage(this);" name="files" id="pic" data-type="0" class="uploadInput upload btn_fileupload">
                                                        </div>
                                                    </div>
                            <div class='thumbnail uploadDiv'>
                                <div class='viewImg'>
                                            <a class='glyphicon gallery-delete delImg'
                                                href='javascript:;'></a>
                                            <img width='90px' height='90px'
                                                src='${IMG_URL}${couponContent.pic}'>
                                            <input type='hidden' value='${couponContent.pic}'id="pic" name='pic' />
                                </div>
                            </div>
                        </div>
                   
                    <div class="line line-dashed line pull-in"></div> -->
                    
                    <input type="hidden" name="couponId" value="${couponContent.couponId}" />
                    <input type="hidden" name="ctime" value="${couponContent.ctime} ">
                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并添加商户</button>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/plugins/file-input/bootstrap-filestyle.min.js"></script>  
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/coupon/js/content.edit.js" type="text/javascript"></script>

<!-- <script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/vendor/jquery.ui.widget.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.iframe-transport.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.fileupload.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-prettyphoto/3.1.5/js/jquery.prettyPhoto.js" type="text/javascript"></script> -->
<!-- / modal - 编辑-->