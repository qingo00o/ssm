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
<div id="myEcharts" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    /*---------------------------我是进入初始化柱状图代码的分界线---------------------------*/
    var myChart=echarts.init(document.getElementById('main'),'light');
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: '柱状图异步数据加载示例'
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
    /*---------------------------我是进入初始化饼图代码的分界线---------------------------*/
    //最简单的更改全局样式的方式，是直接采用颜色主题（theme）
    var myPie=echarts.init(document.getElementById('myEcharts'),'dark');
    myPie.setOption({
        //设置全局背景色
        backgroundColor: '#2c343c',
        //设置文本样式
        textStyle: {
            color: 'rgba(255, 255, 255, 0.3)'
        },
        //设置标题
        title: {
            text: '扇形图异步数据加载示例',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        //视觉引导线的颜色设置
        labelLine: {
            lineStyle: {
                color: 'rgba(255, 255, 255, 0.3)'
            }
        },
        series : [
            {
                name: '人数',
                type: 'pie',
                //南丁格尔图
                //roseType: 'angle',
                //阴影、透明度、颜色、边框颜色、边框宽度设置
                itemStyle: {
                    // 阴影的大小
                    shadowBlur: 200,
                    // 阴影水平方向上的偏移
                    shadowOffsetX: 0,
                    // 阴影垂直方向上的偏移
                    shadowOffsetY: 0,
                    // 阴影颜色
                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                    //emphasis是鼠标 hover 时候的高亮样式
                    emphasis: {
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },
                radius: '55%',
                data:[]
            }
        ]
    });
    /*---------------------------我是数据在加载的分界线---------------------------*/
    myChart.showLoading({text: '柱状图数据正在加载中...'  });
    myPie.showLoading({text: '饼图数据正在加载中...'  });
    /*---------------------------我是柱状图加载数据代码的分界线---------------------------*/
    $.ajax({
        type:"get",
        async:true,
        url : "${pageContext.request.contextPath}/user/echarts",
        dataType:"json",
        success:function(data){
            myChart.hideLoading();
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

        }
    });
    /*---------------------------我是饼图加载数据代码的分界线---------------------------*/
    $.ajax({
        type:"get",
        async:true,
        url : "${pageContext.request.contextPath}/user/echartsPie",
        dataType:"json",
        success:function(data){
            myPie.hideLoading();
            myPie.setOption({
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                //说明
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    right: 10,
                    top: 20,
                    bottom: 20,
                    data: (function(){
                        var res = [];
                        for (var key in data) {
                            res.push(key);
                        }
                        return res;
                    })()

                },
                series : [{
                    data:(function(){
                        var res = [];
                        for(var key in data){
                            res.push({
                                //通过把data进行遍历循环来获取数据并放入Echarts中
                                name: key,
                                value: data[key]
                            });
                        }
                        return res;
                    })()
                }]
            });

        }
    });
</script>
</body>
</html>
