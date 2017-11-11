<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<section class="hbox stretch">
    <aside class="bg-white">
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="m-t-sm">
                    <a href="#subNav" data-toggle="class:hide" class="btn btn-sm btn-default active btn-nav-goods" btn_nav_goods_index="0">
                        <i class="fa fa-caret-right text fa-lg"></i>
                        <i class="fa fa-caret-left text-active fa-lg"></i>
                    </a>
                        <a href="javascript:;" class="btn btn-sm btn-default" id="button_cancel"><i class="fa fa-reply"></i> 返回</a>
                </div>
            </header>
              
            <section class="scrollable wrapper">
                <section class="panel panel-default portlet-item">
	                <header class="panel-heading">批次总表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">主键：</td>
                                <td class="col-sm-4">${financeBatch.id}</td>
                                <td class="col-sm-2">批次号：</td>
                                <td class="col-sm-4">${financeBatch.batchNo}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">账务日期：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeBatch.receiptTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="col-sm-2">创建日期：</td>
                                <td class="col-sm-4">
                                    <fmt:formatDate value="${financeBatch.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">渠道号：</td>
                                <td class="col-sm-4">${financeBatch.channeNo}</td>
                                <td class="col-sm-2">文件名1：</td>
                                <td class="col-sm-4">${financeBatch.fileName1}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">文件名2：</td>
                                <td class="col-sm-4">${financeBatch.fileName2}</td>
                                <td class="col-sm-2">文件名3：</td>
                                <td class="col-sm-4">${financeBatch.fileName3}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">文件名4：</td>
                                <td class="col-sm-4">${financeBatch.fileName4}</td>
                                <td class="col-sm-2">文件名5：</td>
                                <td class="col-sm-4">${financeBatch.fileName5}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">文件名6：</td>
                                <td class="col-sm-4">${financeBatch.fileName6}</td>
                                <td class="col-sm-2">收银台支付金额：</td>
                                <td class="col-sm-4">${financeBatch.thirdbackAmount}</td>
                            </tr>
                            <tr>  
								<td class="col-sm-2">获取对账文件是否成功：</td>
                                <td class="col-sm-4">
									<c:if test="${financeBatch.flag == 0}">
									否
									</c:if>
									<c:if test="${financeBatch.flag == 1}">
									是
									</c:if>
								</td>
								<td class="col-sm-2">状态：</td>
                                <td class="col-sm-4">
									<c:if test="${financeBatch.status == 0}">
									B
									</c:if>
									<c:if test="${financeBatch.status == 1}">
									权益
									</c:if>
									<c:if test="${financeBatch.status == 2}">
									C
									</c:if>
								</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">成功笔数：</td>
                                <td class="col-sm-4">${financeBatch.successTotal}</td>
                                <td class="col-sm-2">失败笔数：</td>
                                <td class="col-sm-4">${financeBatch.faileTotal}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/finance/js/batch.detail.js" type="text/javascript"></script>
