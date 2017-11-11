<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../wrapper.prefix.jsp"/>

  
<section class="hbox stretch">
    <aside class="aside-md bg-white b-r">
        <section class="vbox">
            <header class="b-b header">
                <p class="h4"> <c:choose> <c:when test="${goodsProperty!=null}">编辑</c:when><c:otherwise>添加</c:otherwise></c:choose></p>
            </header>
                
            <section class="scrollable wrapper w-f">
                <form class="form-horizontal" id="edit_form" action=<c:choose> <c:when test="${goodsProperty!=null}">"${BASE_URL}/goodsProperty/edit"</c:when><c:otherwise>"${BASE_URL}/goodsProperty/add"</c:otherwise></c:choose> method="post">
                    <div class="form-group">
                        <label for="name" class="col-sm-3 control-label">属性名称</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="name" name="name" value="${goodsProperty.name}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="description" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="description" name="description" value="${goodsProperty.description}" onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="isSku" class="col-sm-3 control-label">是否是sku属性</label>
                        <div class="col-sm-1">
                            <input type="radio"  id="isSku" name="isSku" value="${goodsProperty.isSku}"  <c:if test="${goodsProperty.isSku==1}">checked="checked"</c:if> />
                        	是
                        </div>
                        <div class="col-sm-1">
                            <input type="radio"  id="isSku" name="isSku" value="${goodsProperty.isSku}"  <c:if test="${goodsProperty.isSku==0}">checked="checked"</c:if> />
                        	否
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
                    <div class="form-group">
                        <label for="isPic" class="col-sm-3 control-label">是否是图片属性</label>
                        <div class="col-sm-1">
                            <input type="radio"  id="isPic" name="isPic" value="${goodsProperty.isPic}"  <c:if test="${goodsProperty.isPic==1}">checked="checked"</c:if>/>
                        	是
                        </div>
                        <div class="col-sm-1">
                            <input type="radio"  id="isPic" name="isPic" value="${goodsProperty.isPic}"  <c:if test="${goodsProperty.isPic==0}">checked="checked"</c:if> />
                        	否
                        </div>
                    </div>
					<div class="line line-dashed line pull-in"></div>
					<!-- 编辑属性值 -->
					<div class="form-group">
                        <label for="sort_order" class="col-sm-2 control-label hide">属性值</label>
                        <div class="col-sm-12">
                            <section class="panel panel-default">
                                <header class="panel-heading">
			                        编辑属性值
			                        <a id="btn_add_property_value" class="btn btn-xs btn-primary pull-right">
		                                <i class="fa fa-plus text"></i>
		                                <span class="text">添加</span>
		                            </a>
			                    </header>
                                <table class="table table-striped m-b-none text-sm" id="table_property_value">
                                    <thead>
                                        <tr>
                                            <th>属性值</th>
                                            <th class="set-property-image default-hidden">规格图片</th>
                                            <th>序号</th>                    
                                            <th>默认值</th>                    
                                            <th width="70">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:choose>
                                    	<c:when test="${propertyValues != null}">
                                    	<c:forEach items="${propertyValues}" var="v" varStatus="k">
                                        <!-- {foreach from=$ item=v key=k} -->
                                        <tr>                    
                                            <td>
                                                <input type="text" class="form-control input-sm" name="pVal" value="${v.propertyValue}" placeholder="请输入属性值" />
                                            </td>
                                            <td class="set-property-image default-hidden">
                                                <input type="file" name="p_property_image_${k}" class="filestyle p-property-image" data-icon="false" data-buttonText="上传图片" data-classbutton="btn btn-default btn-sm" data-classinput="form-control inline input-s input-sm" />
                                                <input type="hidden" name="hasImage" value="false" class="hasImage" />
                                               <c:if test="${v.propertyImage != null && v.propertyImage != ''}">
                                                <a href="${IMG_URL}${v.propertyImage}" class="thumb-sm" target="_blank"><img src="${IMG_URL}${v.propertyImage}" /></a>
                                                </c:if>
                                            </td>
                                            <td>
                                                <input type="text" class="form-control input-sm" name="pSortOrder" value="${v.sortOrder}" placeholder="请输入序号" />
                                            </td>
                                            <td>
                                                <label class="switch-sm m-b-none m-t-xs">
						                            <input type="checkbox" class="set-pv-default" name="pIsDefault" value="${k}" <c:if test="${v.isDefault == 1}">checked="checked"</c:if> />
						                            <span></span>
						                        </label>
                                            </td>
                                            <td class="text-right v-middle"><%-- <c:if test="${property_values|@count <= 1}"> --%><%-- <c:if test="${property_values}">hide</c:if> --%>
                                                <a href="javascript:;" class="operate-delete " property_value_id="${v.propertyValueId}" title="删除"><i class="fa fa-trash-o"></i></a>
                                                <input type="hidden" class="property_value_id_hidden" name="pPropertyValueId" value="${v.propertyValueId}" />
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                        <tr>                    
                                            <td>
                                                <input type="text" class="form-control input-sm" name="pVal" value="" placeholder="请输入属性值" />
                                            </td>
                                            <td class="set-property-image default-hidden">
                                                <input type="file" name="p_property_image_0" value="1" class="filestyle p-property-image" data-icon="false" data-buttonText="上传图片" data-classbutton="btn btn-default btn-sm" data-classinput="form-control inline input-s input-sm" />
                                                <input type="hidden" name="hasImage" value="false" class="hasImage" />
                                            </td>
                                            <td>
                                                <input type="text" class="form-control input-sm" name="pSortOrder" value="" placeholder="请输入序号" />
                                            </td>
                                            <td>
                                                <label class="switch-sm m-b-none m-t-xs">
                                                    <input type="checkbox" class="set-pv-default" name="pIsDefault" value="0" />
                                                    <span></span>
                                                </label>
                                            </td>
                                            <td class="text-right v-middle">
                                                <a href="javascript:;" class="operate-delete hide" property_value_id="0" title="删除"><i class="fa fa-trash-o"></i></a>
                                                <input type="hidden" class="property_value_id_hidden" name="propertyValueId" value="0" />
                                            </td>
                                        </tr>
                                       	</c:otherwise>
                                        </c:choose>
                                    </tbody>
                                </table>
                            </section>
                        </div>
                    </div>
                    
                    <input type="hidden" name="id" value="${goodsProperty.id}" />

                </form>
            </section>
        
            <footer class="footer b-t bg-white-only">
                <div class="m-t-sm">
                    <button type="button" data_submit_type="submit_save_back" class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
                    <c:if test="${goodsProperty==null}"><button type="button" data_submit_type="submit_save_continue" class="btn btn-s-md btn-primary btn-sm input-submit">保存并继续添加</button></c:if>
                    <button type="button" data_submit_type="submit_cancel" class="btn btn-danger btn-sm input-submit">取消</button>
                    <span id="edit_notice"></span>
                </div>
            </footer>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/goods/js/property.edit.js" type="text/javascript"></script>
<!-- / modal - 编辑-->