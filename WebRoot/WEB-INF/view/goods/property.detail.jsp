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
	                <header class="panel-heading">商品属性基础数据表详情</header>
		            <table class="table table-striped2 m-b-none text-sm">
                        <tbody>
                        
                            <tr>  
                                <td class="col-sm-2">属性id：</td>
                                <td class="col-sm-4">${goodsProperty.id}</td>
                                <td class="col-sm-2">属性名称：</td>
                                <td class="col-sm-4">${goodsProperty.name}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">备注：</td>
                                <td class="col-sm-4">${goodsProperty.description}</td>
                                <td class="col-sm-2">序号：</td>
                                <td class="col-sm-4">${goodsProperty.sortOrder}</td>
                            </tr>
                            <tr>  
                                <td class="col-sm-2">是否是sku属性：</td>
                                <td class="col-sm-4">${goodsProperty.isSku}</td>
                                <td class="col-sm-2">是否是图片属性：</td>
                                <td class="col-sm-4">${goodsProperty.isPic}</td>
                            </tr>
                         
                        </tbody>
                    </table>
                </section>
            </section>
        </section>
    </aside>
</section>

<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/goods/js/property.detail.js" type="text/javascript"></script>
