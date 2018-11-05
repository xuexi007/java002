<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新发地蔬菜市场大白菜价格走势图</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/echarts.common.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
    <div id="chart" style="width:3500;height:600px"></div>
    
    <script type="text/javascript">
    var myChart=echarts.init(document.getElementById('chart'));
    
    var option={
        title:{
          text:'新发地蔬菜市场大白菜价格走势图'
        },
        xAxis:{
          data:[]
        },
        yAxis:{
        
        },
        series:[{
            name:'最低价格',
            type:'line',
            data:[]
        },{
            name:'平均价格',
            type:'line',
            data:[]
        },{
            name:'最高价格',
            type:'line',
            data:[]
        }]
    
    };
    
    myChart.setOption(option);
    
    myChart.showLoading();
    var lowprices=[];
    var avgprices=[];
    var hprices=[];
    var dates=[];
    //ajax
    $.ajax({
       type:"post",
       url:"list",
       data:{begindate:'2018-10-1',enddate:'2018-10-31'},
       dataType:'json',
       success:function(json){
         if(json){
         
           for(var i=0;i<json.length;i++){
              lowprices.push(json[i].lowprice);
              avgprices.push(json[i].avgprice);
              hprices.push(json[i].hprice)
              //需要把毫秒转换为年月日的格式
             var time= new Date(json[i].createdate);
             var y=time.getFullYear();
             var m=time.getMonth()+1;
             var d=time.getDate();
              dates.push(y+'-'+m+'-'+d);
           }
           
           //设置echarts数据
           myChart.hideLoading();
           myChart.setOption({
           
              xAxis:{
                data:dates
              },
              series:[{
              
               name:'最低价格',
               type:'line',
               data:lowprices
              },{
              
               name:'平均价格',
               type:'line',
               data:avgprices
              },{
              
               name:'最高价格',
               type:'line',
               data:hprices
              }]
           })
         }
       }
        
    })
    
    
    </script>
  </body>
</html>
