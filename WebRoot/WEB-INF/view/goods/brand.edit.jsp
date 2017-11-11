<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../wrapper.prefix.jsp" />

<link
	href="${STATIC_URL}/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css" />

<section class="hbox stretch">
	<aside class="aside-md bg-white b-r">
		<section class="vbox">
			<header class="b-b header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="modal_title">
					<c:choose>
						<c:when test="${goodsBrand != null}">编辑品牌</c:when>
						<c:otherwise>添加品牌</c:otherwise>
					</c:choose>
				</h4>
			</header>

			<section class="scrollable wrapper w-f">
				<form class="form-horizontal" id="edit_form"
					action="${BASE_URL}/goodsBrand/add"
					method="post"
					enctype="multipart/form-data">

					<div class="form-group">
						<label for="id" class="col-sm-3 control-label">品牌id</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="id" name="id"
								value="${goodsBrand.id}" readonly />
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>


					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">品牌名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="name" name="name"
								value="${goodsBrand.name}"
								onkeydown="if(event.keyCode==13)return false;" placeholder="请输入" />
						</div>
					</div>
					<div class="line line-dashed line pull-in"></div>
					
					<div class="form-group file-reset">
	                    <label class="col-sm-3 control-label">品牌 Logo</label>
	                	<div class="col-sm-9">
	                        <input type="file" name="pic" id="pic" class="filestyle" data-icon="false" data-classbutton="btn btn-default" data-classinput="form-control inline input-s" />
	                        <c:if test="${goodsBrand.pic != null && goodsBrand.pic != ''}">
	                            <a href="${IMG_URL}${goodsBrand.pic}" class="thumb-sm" target="_blank"><img src="${IMG_URL}${goodsBrand.pic}" /></a>
	                        </c:if> 
	                    </div>
	                </div>
						
				</form>
			</section>
			<footer class="footer b-t bg-white-only">
				<div class="m-t-sm">
					<button type="button" data_submit_type="submit_save_back"
						class="btn btn-s-md btn-primary btn-sm input-submit">保存</button>
					<c:if test="${goodsBrand==null}">
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
<script
	src="${STATIC_URL}/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="${STATIC_URL}/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<script src="${STATIC_URL}/modules/goods/js/brand.edit.js"></script>

<!-- / modal - 编辑-->