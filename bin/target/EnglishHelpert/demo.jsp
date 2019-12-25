<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
    <tr>        
        <td>id</td>
        <td>注册日期</td>
        <td>密码</td>
        <td>昵称</td>
        <td>真实姓名</td>
        <td>年龄</td>
        <td>手机号</td>
        <td>邮箱</td>
    </tr>
    <!-- 使用struts2标签库中的iterator将所有数据遍历循环显示出来 -->
    <s:iterator value="#myUserList" status="bcs">
        <tr>    
            <td><s:property value="id"></s:property></td>
            <td><s:property value="createTime"></s:property></td>
            <td><s:property value="password"></s:property></td>
            <td><s:property value="nickName"></s:property></td>
            <td><s:property value="trueName"></s:property></td>
            <td><s:property value="age"></s:property></td>
            <td><s:property value="mobile"></s:property></td>
            <td><s:property value="email"></s:property></td>
        </tr>
    </s:iterator>
    <!-- 判断查询出来等于0，就显示“没有查找到数据” -->
    <s:if test="myUserList.size()==0">
        <tr>                    
            <td colspan="7">没有查找到数据</td>
        </tr>
    </s:if>
</table>
</body>
</html>
