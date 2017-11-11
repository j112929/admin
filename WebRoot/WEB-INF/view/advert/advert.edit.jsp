<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<link href="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/css/jquery.fileupload-ui.css" rel="stylesheet" type="text/css" />
<link href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
<section class="hbox stretch">
	<aside class="aside-md bg-white b-r">
		<section class="vbox">
			<header class="b-b header">
				<p class="h4">
					<c:choose>
						<c:when test="${advert!=null}">编辑</c:when>
						<c:otherwise>添加</c:otherwise>
					</c:choose>
				</p>
			</header>
			<section class="scrollable wrapper w-f">
				<form class="form-horizontal" id="edit_form"
					action=<c:choose> <c:when test="${advert!=null}">"${BASE_URL}/advert/edit"</c:when><c:otherwise>"${BASE_URL}/advert/add"</c:otherwise></c:choose>
					method="post">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label"><font
							class="red">* </font>标题</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name"
								value="${advert.name}"
								onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label"><font class="red">*
						</font>推荐专区</label>
						<div class="col-sm-4">
							<select id="position" name="position" class="form-control">
								<option value="0">请选择</option>
								<option value="1"
									<c:if test="${advert.position == 1}">selected="selected"</c:if>>商城banner</option>
								<option value="2"
									<c:if test="${advert.position == 2}">selected="selected"</c:if>>积分专区banner</option>
								<option value="3"
									<c:if test="${advert.position == 3}">selected="selected"</c:if>>分期专区banner</option>
							</select>
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
						<label for="sortOrder" class="col-sm-3 control-label"><font
							class="red">* </font>推荐位置</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="sortOrder"
								name="sortOrder" value="${advert.sortOrder}"
								onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>


					<div class="form-group">
						<label for="contentImg" class="col-sm-3 control-label"><font
							class="red">* </font>广告图片</label>
						<div class="col-sm-4">
							<input type="file" class="filestyle" name="files"
								onclick="uploadImage(this)" data-icon="false" data-location="1"
								data-buttonText="上传图片" data-classbutton="btn btn-default"
								data-classinput="form-control inline input-s" /> <input
								type="hidden" name="pic" id="pic"
								value="${IMG_URL}${advert.pic}" /> <a
								href="${IMG_URL}${advert.pic}" class="thumb-sm" target="_blank">
								<img src="${IMG_URL}${advert.pic}" />
							</a>
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					<div class="form-group">
						<label for="description" class="col-sm-3 control-label"><font
							class="red">* </font>描述</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="description"
								name="description" value="${advert.description}"
								onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>

					<div class="form-group">
						<label class="col-sm-3 control-label"><font class="red">*
						</font>状态</label>
						<div class="col-sm-4">
							<label class="checkbox-inline p-left-0"> <input
								type="radio" <c:if test="${advert.status == 1}">checked</c:if>
								name="status" value="1" /> 启用 </label> <label
								class="checkbox-inline p-left-0"> <input type="radio"
								<c:if test="${advert == null ||advert.status == 0}">checked</c:if>
								name="status" value="0" /> 关闭 </label>
						</div>
					</div>



					<div class="line line-dashed line pull-in"></div>
					<div class="form-group m-b-xs">
						<label for="beginTime" class="col-sm-3 control-label"><font
							class="red">* </font>开始时间</label>
						<div class="col-sm-4">
							<input type="text"
								class="input-sm input-s datetimepicker-input form-control"
								id="beginTime" name="beginTime"
								value="<fmt:formatDate value="${advert.beginTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"
								placeholder="请选择开始时间" readonly="readonly" />
						</div>
					</div>
					<div class="line line-dashed line-lg pull-in"></div>

					<%-- 
					 <div class="form-group">
					            	<label for="startTime" class="col-sm-2 control-label">开始时间</label>
					                <div class="col-sm-4">
					                	<input id="startTime" name="beginTime" class="input-sm input-s datetimepicker-input form-control" type="text" 
					                        value="<fmt:formatDate value="${advert.beginTime}" pattern="yyyy-MM-dd hh:mm"/>" readonly="readonly" placeholder="点击选择开始时间" />
					                </div>
					            </div>
					   <div class="line line-dashed line pull-in"></div> --%>



					<div class="form-group m-b-xs">
						<label for="endTime" class="col-sm-3 control-label"><font
							class="red">* </font>结束时间</label>
						<div class="col-sm-4">
							<input type="text"
								class="input-sm input-s datetimepicker-input form-control"
								id="endTime" name="endTime"
								value="<fmt:formatDate value="${advert.endTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"
								placeholder="请选择结束时间" readonly="readonly" />
						</div>
					</div>
					<div class="line line-dashed line-lg pull-in"></div>


					<div class="form-group">
						<label class="col-sm-3 control-label"><font class="red">*
						</font>链接类型</label>
						<div class="col-sm-4">
							<select id="linkType" name="linkType" class="form-control" onchange="test()">
								<option value="0">请选择</option>
								<option value="1"
									<c:if test="${advert.linkType == 1}">selected="selected"</c:if>>活动地址</option>
								<option value="2"
									<c:if test="${advert.linkType == 2}">selected="selected"</c:if>>商品详情</option>
								<option value="3"
									<c:if test="${advert.linkType == 3}">selected="selected"</c:if>>商品SKU列表</option>
								<option value="4"
									<c:if test="${advert.linkType == 4}">selected="selected"</c:if>>无链接</option>
							</select>
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					<c:if test="${advert == null}">
                                    <div id = "linkTypeDiv">                                  
                                            <div class="form-group">
                                                <label id="linkTypeLabel" for="link" class="col-sm-3 control-label"><font class="red">* </font>活动地址</label>
					                            <div class="col-sm-4">
					                                <input type="text" class="form-control" id="link" name="link" value="${advert.link}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
					                            </div>
					                            <div id="linkTypeFoot"><label><font color="green">团购活动地址:https://www.tmall.com/</br>抽奖活动地址:http://www.jumei.com/&nbsp;&nbsp;</font></label></div>                                                                    
                                            </div>         
                                        <div class="line line-dashed line pull-in"></div>
                                    </div>
<!--                                     <div id = "linkType2"  style="display:none">                                   -->
<!--                                             <div class="form-group"> -->
<!--                                                 <label for="link" class="col-sm-3 control-label"><font class="red">* </font>商品详情</label> -->
<!-- 					                            <div class="col-sm-4"> -->
<!-- 					                                <input type="text" class="form-control" id="link2" name="link" value="${advert.link}" onkeydown="if(event.keyCode==13)return true;" placeholder="请输入" /> -->
<!-- 					                            </div>                                                                      -->
<!--                                             </div>          -->
<!--                                         <div class="line line-dashed line pull-in"></div> -->
<!--                                     </div> -->
<!--                                     <div id = "linkType3"  style="display:none">                                   -->
<!--                                             <div class="form-group"> -->
<!--                                                 <label for="link" class="col-sm-3 control-label"><font class="red">* </font>商品SKU列表</label> -->
<!-- 					                            <div class="col-sm-4"> -->
<!-- 					                                <input type="text" class="form-control" id="link3" name="link" value="${advert.link}" onkeydown="if(event.keyCode==13)return true;" placeholder="请输入" /> -->
<!-- 					                            </div> -->
<!-- 					                            <input  name="typeAdd" type="button" value="+" onclick="typeAddAdvert()"/> -->
<!--                                                </div>        -->
<!--                                         <div class="line line-dashed line pull-in"></div> -->
<!--                                     </div> -->
<!--                                     <div id = "linkType4" style="display:none">                                   -->
<!--                                             <div class="form-group"> -->
<!--                                                 <label for="link" class="col-sm-3 control-label"><font class="red">* </font>无链接目标</label> -->
<!--                                                 <div class="col-sm-4"> -->
                                                    <!-- <input type="text" id="link" name="link" value=" "> -->
<!--                                                 </div>                                                                -->
<!--                                             </div>          -->
<!--                                         <div class="line line-dashed line pull-in"></div> -->
<!--                                     </div> -->
                                </c:if>
					
                    <c:if test="${advert.linkType == 1}">
                        <label for="link" class="col-sm-3 control-label"><font class="red">* </font>链接目标</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control"  name="link" value="${advert.link}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                            </div>
                    </c:if>

                    <c:if test="${advert.linkType == 2}">
                        <label for="link" class="col-sm-3 control-label"><font class="red">* </font>链接目标</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control"  name="link" value="${advert.link}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                            </div>
                            <label id="tips1" style="display:none"><font color="green">请输入商品SKU名称</font> </label> 
                    </c:if>
                    <c:if test="${advert.linkType == 3}">                     
                                    <!-- <div class="form-group" id="skuList"> -->
                                        <c:if test="${fn:length(skuList)!=0}">
                                            <c:forEach items="${skuList}" var="sku" varStatus="status">
                                                <div class="form-group">
                                                    <label for="link" class="col-sm-3 control-label">请输入商品SKU</label>
                                                    <div class="col-sm-4">
                                                       <input type="text" class="form-control" name="link" value="${sku}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />                                                    
                                                    </div>
                                                    <c:choose> <c:when test="${status.count==0}"><input name="typeAdd" type="button" value="+"/></c:when><c:otherwise><input type="button" name="typeDel" value="-" onclick="typeDeleteAdvert(this)"/></c:otherwise></c:choose>
                                                </div>  
                                            </c:forEach>    
                                        </c:if>
                                        <c:if test="${fn:length(skuList)==0}"> 
                                            <div class="form-group">
                                                    <label for="goodsId" class="col-sm-3 control-label">请输入商品SKU</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" name="link" value="${sku}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                                                    </div>
                                                    <input name="typeAdd" type="button" value="+"/>                                                                     
                                                </div>  
                                        </c:if>  
                                   <!-- </div> -->
                                   <div class="line line-dashed line pull-in"></div>                                        
                      </c:if>
                      <c:if test="${advert.linkType == 4}">
                            <label for="link" class="col-sm-3 control-label"><font class="red">* </font>无链接目标</label>
                      </c:if>
                      
					<input type="hidden" value="${storeId}" id="storeId" /> <input
						type="hidden" name="id" value="${advert.id}" />
				</form>
			</section>

			<footer class="footer b-t bg-white-only">
				<div class="m-t-sm">
					<button type="button" data_submit_type="submit_save_back"
						class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
					<c:if test="${advert==null}">
						<button type="button" data_submit_type="submit_save_continue"
							class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button>
					</c:if>
					<button type="button" data_submit_type="submit_cancel"
						class="btn btn-danger btn-sm input-submit">取消</button>
					<span id="edit_notice"></span>
				</div>
			</footer>
		</section>
	</aside>
</section>

<jsp:include page="../wrapper.suffix.jsp" />
<script src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="${STATIC_URL}/plugins/sortable/jquery.sortable.js"></script>

<script src="${STATIC_URL}/plugins/file-input/bootstrap-filestyle.min.js"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/vendor/jquery.ui.widget.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.iframe-transport.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-fileupload/6.9.7/js/jquery.fileupload.js" type="text/javascript"></script>
<script src="${STATIC_URL}/plugins/jquery-prettyphoto/3.1.5/js/jquery.prettyPhoto.js" type="text/javascript"></script>
<script src="${STATIC_URL}/modules/advert/js/advert.edit.js"
	type="text/javascript"></script>
<!-- / modal - 编辑-->