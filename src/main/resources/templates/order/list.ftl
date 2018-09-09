<html>
    <#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#--边栏-->
        <#include "../common/nav.ftl">

        <#--主要内容-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>订单id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                        <#list orderDTOS.content as ordDTO>
                        <tr>
                            <td>${ordDTO.orderId}</td>
                            <td>${ordDTO.buyerName}</td>
                            <td>${ordDTO.buyerPhone}</td>
                            <td>${ordDTO.buyerAddress}</td>
                            <td>${ordDTO.orderAmount}</td>
                            <td>${ordDTO.getOrderStatusEnum().message}</td>
                            <td>${ordDTO.getPayStatusEnum().messge}</td>
                            <td>${ordDTO.createTime}</td>
                            <td>
                                <a href="/sell/seller/order/detail?orderId=${ordDTO.orderId}">详情</a>
                            </td>
                            <td>
                                    <#if ordDTO.getOrderStatusEnum().message == "新订单">
                                        <a href="/sell/seller/order/cancel?orderId=${ordDTO.orderId}">取消</a>
                                    </#if>
                            </td>
                        </tr>
                        </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <ul class="pagination  pull-right">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else >
                            <li ><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..orderDTOS.getTotalPages() as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else >
                                <li ><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#if currentPage gte orderDTOS.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else >
                            <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <#--弹窗-->
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒
                    </h4>
                </div>
                <div class="modal-body">
                    内容...
                </div>
                <div class="modal-footer">
                    <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">刷新</button>
                </div>
            </div>
        </div>
    </div>

    <#--播放音乐-->
        <audio id="notice" loop="loop">
            <source src="/sell/mp3/MarkPetrieGoTime.mp3" type="audio/mpeg" />
        </audio>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <script>
        var websocket = null;
        if('WebSocket' in window){
            websocket = new WebSocket('ws://192.168.1.3:8080/sell/webSocket');
        } else {
            alert("该浏览器不支持websocket！");
        }

        websocket.onopen = function (ev) {
            console.log("建立连接");
        }

        websocket.onclose = function (ev) {
            console.log("连接关闭");
        }

        websocket.onmessage = function (ev) {
            console.log("收到消息：" + ev.data);
            //弹窗提醒
            $(".modal-body").html(ev.data);
            $("#myModal").modal('show');
            //播放音乐
            var myAuto = document.getElementById('notice');
            myAuto.play();
        }

        websocket.onerror = function (ev) {
            alert("websocket通信发生错误！");
        }

        //当窗口关闭或刷新时，关闭websocket
        window.onbeforeunload = function (ev) {
            websocket.close();
        }


    </script>
    </body>
</html>