<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jspf"%>
<es:contentHeader/>
<div class="panel">

   <%@include file="nav.jspf"%> 

    <form:form id="editForm" method="post" commandName="m" cssClass="form-horizontal">
        <!--上一个地址 如果提交方式是get 需要加上-->
        <%--<es:BackURL hiddenInput="true"/>--%>

            <es:showGlobalError commandName="m"/>

            <form:hidden path="id"/>

            <div class="control-group">
                <form:label path="" cssClass="control-label">描述<strong><font color="red">*</font></strong></form:label>
                <div class="controls">
                    <form:input path=""  placeholder="对活动的描述" cssClass="validate[required]" />
                </div>
            </div>


            <div class="control-group">
                <form:label path="" cssClass="control-label">开始时间<strong><font color="red">*</font></strong></form:label>
                <div class="controls input-append date">
                    <form:input path="" data-format="yyyy-MM-dd" placeholder="例如2015-02-07" cssClass="validate[required]"/>
                    <span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
                </div>
            </div>
            
             <div class="control-group">
                <form:label path="" cssClass="control-label">结束时间<strong><font color="red">*</font></strong></form:label>
                <div class="controls input-append date">
                    <form:input path="" data-format="yyyy-MM-dd" placeholder="例如2015-02-07" cssClass="validate[required]"/>
                    <span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
                </div>
            </div>
            

            <div class="control-group">
                <form:label path="" cssClass="control-label">状态<strong><font color="red">*</font></strong></form:label>
                <div class="controls">
                    <form:select path="">
                        <form:option label="请选择" value=""/>
                        <form:options items="${sexList}" itemLabel="info"></form:options>
                    </form:select>
                </div>
            </div>
            
              <div class="control-group">
                <form:label path="" cssClass="control-label">活动品牌   <strong><font color="red">*</font></strong></form:label>
                <div class="controls">
                    <form:select path="">
                        <form:option label="请选择" value=""/>
                        <form:options items="${sexList}" itemLabel="info"></form:options>
                    </form:select>
                </div>
            </div>
            
            <div class="control-group">
                <form:label path="" cssClass="control-label">备注<strong><font color="red">*</font></strong></form:label>
                <div class="controls inline-radio">
                    <form:textarea path="" />
                </div>
            </div>

            <c:if test="${op eq '新增'}">
                <c:set var="icon" value="icon-file-alt"/>
            </c:if>
            <c:if test="${op eq '修改'}">
                <c:set var="icon" value="icon-edit"/>
            </c:if>
            <c:if test="${op eq '删除'}">
                <c:set var="icon" value="icon-trash"/>
            </c:if>

            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary">
                        <i class="${icon}"></i>
                            ${op}
                    </button>
                    <a href="<es:BackURL/>" class="btn">
                        <i class="icon-reply"></i>
                        返回
                    </a>
                </div>
            </div>


    </form:form>
</div>
<es:contentFooter/>
<script type="text/javascript">
    $(function () {
        <c:choose>
            <c:when test="${op eq '删除'}">
                //删除时不验证 并把表单readonly
                $.app.readonlyForm($("#editForm"), false);
            </c:when>
            <c:when test="${op eq '查看'}">
                $.app.readonlyForm($("#editForm"), true);
            </c:when>
        </c:choose>
    });
</script>