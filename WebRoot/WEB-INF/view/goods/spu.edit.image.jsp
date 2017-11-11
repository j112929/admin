<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="edit-map wrapper default-hidden" id="edit_image">
	<!-- 上传附件 -->
	<section class="editor" id="edit_fileupload">
		<section class="panel panel-default m-t gallery-edit">
            <div>
                <table style="width: 100%" id="skuImages">
					<tr id="images">
						<td width="5%" height="120px;" align="center"
							style="border:1px solid #E8E8E8">
							<p>上传图片</p></td>
						<td width="95%" height="120px;" style="border:1px solid #E8E8E8">
							<div class="thumbnail uploadDiv" name="uploadImage">
								<div class="uploadImg">
									<input class="uploadInput upload btn_fileupload" type="file"
										multiple="" id="uploadImage_354" name="files"
										onclick="uploadImage(this);" style="width:85px;height:85px;">
								</div>
							</div></td>
						<td><input type="hidden" id="imgrow_354" value="check">
						</td>
					</tr>
				</table>
            </div>
        </section>
	</section>

    <input type='hidden' id='imageInfo' value='${skuImages}' />
	<%--     <input type="hidden" name="attachmentIds" value="${content.attachmentIds}" /> --%>
	<%--     <input type="hidden" name="imageDefault" value="${content.imageDefault}" /> --%>
	<!-- 上传附件 @end -->
</section>