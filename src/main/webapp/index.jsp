<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>echarts异步加载demo</title>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/js/echarts.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var myChart=echarts.init(document.getElementById('main'),'light');
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '异步数据加载示例'
        },
        tooltip: {},
        legend: {
            data:['人数']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '人数',
            type: 'bar',
            data: []
        }]
    });
    myChart.showLoading({text: '数据正在加载中...'  });
    $.ajax({
        type:"get",
        async:true,
        url : "${pageContext.request.contextPath}/user/echarts",
        dataType:"json",
        success:function(data){
            console.log(data)
            myChart.setOption({
                xAxis: {
                    data: data.xAxisCategory
                },
                series: [{
                    name: '人数',
                    type: 'bar',
                    data: data.datas
                }]
            });
            myChart.hideLoading();
        }
    });
</script>
</body>
</html>
