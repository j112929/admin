<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../wrapper.prefix.jsp"/>

<section class="hbox stretch">
    <aside>
        <section class="vbox">
            <header class="header bg-white b-b clearfix">
                <div class="row m-t-sm">
                    <div class="col-sm-3 m-b-xs">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-default action-refresh" title="刷新"><i class="fa fa-refresh"></i></button>                           
                        </div>
                        <a href="${BASE_URL}/goodsCategory/addSecond" class="btn btn-sm btn-default load-content"><i class="fa fa-plus"></i>添加</a>
                    </div>
                    <form class="form-inline" action="${BASE_URL}/goodsCategory/pageSecond" id="searchForm">
	                    <div class="col-sm-9 m-b-xs text-right">
	                    	<div class="form-group">
	                    		运营一级分类名称
	                            <select name="pId" id="pId" class="form-control input-sm">
	                            	<option value="0">请选择分类</option>
	                            	<c:forEach items="${allOneGradeCategory}" var="v">
	                            		<option value="${v.id}" >
		                                	${v.name}
	                                	</option>
	                            	</c:forEach>
	                            </select>
	                        </div>
                        	运营二级分类名称
	                        <input type="text" name="key" class="input-sm form-control" placeholder="模糊" />
                            <button class="btn btn-sm btn-default action-refresh" type="button">查询</button>
	                    </div>
	                </form>
                </div>
            </header>
            
			<%@include file = "../page.jsp" %>
            
        </section>
    </aside>
</section>
            
<jsp:include page="../wrapper.suffix.jsp"/>
<script src="${STATIC_URL}/modules/goods/js/categorySecond.index.js" type="text/javascript"></script>