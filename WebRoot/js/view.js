// JavaScript Document
$(document).ready(function () {
    $(".commentlist li:odd").addClass("odd");
    $(".topbar_right dl").hover(function () { $(this).addClass("on") }, function () { $(this).removeClass("on") });
    $(".menu dl").hover(function () { $(this).addClass("on") }, function () { $(this).removeClass("on") });
    $(".shopping").hover(function () { $(this).addClass("on_shopping") }, function () { $(this).removeClass("on_shopping") });
    $(".shopping_m dl").hover(function () { $(this).css("background", "#f8f8f8") }, function () { $(this).css("background", "#fff") });
    $(".classify").hover(function () { $(this).addClass("showcy") }, function () { $(this).removeClass("showcy") });
    $(".maincate").hover(function () { $(this).addClass("on").find(".subbox").stop().animate({ "left": "198px" }, 300); }, function () { $(this).removeClass("on").find(".subbox").stop().animate({ "left": "190px" }, 300); });
    $(".amount-down").click(SubNumber);
    $(".amount-up").click(AddNumber);
    $("#buynum").bind("input propertychange", function () {
        $(this).val($(this).val().replace(/\D/g, ""));
        SetTotalMoney();
    });
    InitTotalMoney();
    //产品规格颜色选择
    $(".view_property dd.cl1").click(function (event) {
        $(this).addClass("on");
        $(this).siblings().removeClass("on");
        var myContent = $(this).html();

        var productId = _productId;
        var baoJiaType = $("#hidBaoJiaType").val();
        var ruleNameOne = $(this).text().trim();
        var ruleNameTwo = "";
        var dataObject = { "productId": productId, "baoJiaType": baoJiaType, "ruleNameOne": ruleNameOne, "ruleNameTwo": ruleNameTwo, "t": Math.random() };

        $.ajax({
            url: "/Handler/SaleNumHandler.asmx/GetSaleNumAndHasSaleNum",
            type: "post",
            contentType: "application/json;utf-8",
            dataType: "json",
            data: JSON.stringify(dataObject),
            success: function (data) {
                if (data.d !== undefined) {
                    var resultObj = JSON.parse(data.d);
                    $("#productPrice1").text("¥" + resultObj.SamplePrice);
                    $("#eableSaleNum").text(resultObj.EableSaleNum + _productUnit + "可售");
                    $("#hidMaxNum").val(resultObj.EableSaleNum);
                    $("#spYiShouNum").html(resultObj.HasSaleNum);
                    SetTotalMoney();
                } else {
                    art.artDialog({
                        title: "系统提示",
                        content: "系统繁忙，获取数据失败",
                        lock: true,
                        fixed: true,
                        okValue: "确定",
                        ok: function () { }
                    });
                }
            }
        });
    });
    $(".item-control li span").hover(function () {
        $(this).parent().siblings().find("input").addClass("on");
    }, function () {
        $(this).parent().siblings().find("input").removeClass("on");
    });
    // 图片上下滚动
    var count = $("#imageMenu li").length - 5;
    var interval = $("#imageMenu li:first").width();
    var curIndex = 0;
    $(".scrollbutton").click(function () {
        if ($(this).hasClass("disabled")) return false;
        if ($(this).hasClass("smallImgUp"))--curIndex;
        else ++curIndex;
        $(".scrollbutton").removeClass("disabled");
        if (curIndex == 0) $(".smallImgUp").addClass("disabled");
        if (curIndex == count - 1) $(".smallImgDown").addClass("disabled");
        $("#imageMenu ul").stop(false, true).animate({ "marginLeft": -curIndex * interval + "px" }, 600);
    });
    // 解决 ie6 select框 问题
    $.fn.decorateIframe = function (options) {
        if ($.browser.msie && $.browser.version < 7) {
            var opts = $.extend({}, $.fn.decorateIframe.defaults, options);
            $(this).each(function () {
                var $myThis = $(this);
                //创建一个IFRAME
                var divIframe = $("<iframe />");
                divIframe.attr("id", opts.iframeId);
                divIframe.css("position", "absolute");
                divIframe.css("display", "none");
                divIframe.css("display", "block");
                divIframe.css("z-index", opts.iframeZIndex);
                divIframe.css("border");
                divIframe.css("top", "0");
                divIframe.css("left", "0");
                if (opts.width == 0) {
                    divIframe.css("width", $myThis.width() + parseInt($myThis.css("padding")) * 2 + "px");
                }
                if (opts.height == 0) {
                    divIframe.css("height", $myThis.height() + parseInt($myThis.css("padding")) * 2 + "px");
                }
                divIframe.css("filter", "mask(color=#fff)");
                $myThis.append(divIframe);
            });
        }
    };
    $.fn.decorateIframe.defaults = {
        iframeId: "decorateIframe1",
        iframeZIndex: -1,
        width: 0,
        height: 0
    }; //放大镜视窗
    $("#bigView").decorateIframe();
    //点击到中图
    var midChangeHandler = null;

    $("#imageMenu li img").bind("click", function () {
        if ($(this).attr("id") != "onlickImg") {
            midChange($(this).attr("src").replace("/s_", "/m_"));
            $("#imageMenu li").removeAttr("id");
            $(this).parent().attr("id", "onlickImg");
        }
    }).bind("mouseover", function () {
        if ($(this).attr("id") != "onlickImg") {
            window.clearTimeout(midChangeHandler);
            midChange($(this).attr("src").replace("/s_", "/m_"));
            $(this).css({ "border": "1px solid #f50" });
        }
    }).bind("mouseout", function () {
        if ($(this).attr("id") != "onlickImg") {
            $(this).removeAttr("style");
            midChangeHandler = window.setTimeout(function () {
                var url = $("#onlickImg img").attr("src");
                if (url) {
                    midChange(url.replace("/s_", "/m_"));
                }
            }, 1000);
        }
    });

    function midChange(src) {
        $("#midimg").attr("src", src).load(function () {
            changeViewImg();
        });
    }

    //大视窗看图
    function mouseover(e) {
        if ($("#winSelector").css("display") == "none") {
            $("#winSelector,#bigView").show();
        }
        $("#winSelector").css(fixedPosition(e));
        e.stopPropagation();
    }

    function mouseOut(e) {
        if ($("#winSelector").css("display") != "none") {
            $("#winSelector,#bigView").hide();
        }
        e.stopPropagation();
    }

    $("#midimg").mouseover(mouseover); //中图事件
    $("#midimg,#winSelector").mousemove(mouseover).mouseout(mouseOut); //选择器事件
    var $divWidth = $("#winSelector").width(); //选择器宽度
    var $divHeight = $("#winSelector").height(); //选择器高度
    var $imgWidth = $("#midimg").width(); //中图宽度
    var $imgHeight = $("#midimg").height(); //中图高度
    var $viewImgWidth = $viewImgHeight = $height = null; //IE加载后才能得到 大图宽度 大图高度 大图视窗高度
    function changeViewImg() {
        $("#bigView img").attr("src", $("#midimg").attr("src").replace("/m_", "/b_"));
    }

    changeViewImg();
    $("#bigView").scrollLeft(0).scrollTop(0);

    function fixedPosition(e) {
        if (e == null) {
            return;
        }
        var $imgLeft = $("#midimg").offset().left; //中图左边距
        var $imgTop = $("#midimg").offset().top; //中图上边距
        X = e.pageX - $imgLeft - $divWidth / 2; //selector顶点坐标 X
        Y = e.pageY - $imgTop - $divHeight / 2; //selector顶点坐标 Y
        X = X < 0 ? 0 : X;
        Y = Y < 0 ? 0 : Y;
        X = X + $divWidth > $imgWidth ? $imgWidth - $divWidth : X;
        Y = Y + $divHeight > $imgHeight ? $imgHeight - $divHeight : Y;
        if ($viewImgWidth == null) {
            $viewImgWidth = $("#bigView img").outerWidth();
            $viewImgHeight = $("#bigView img").height();
            if ($viewImgWidth < 200 || $viewImgHeight < 200) {
                $viewImgWidth = $viewImgHeight = 800;
            }
            $height = $divHeight * $viewImgHeight / $imgHeight;
            $("#bigView").width($divWidth * $viewImgWidth / $imgWidth);
            $("#bigView").height($height);
        }
        var scrollX = X * $viewImgWidth / $imgWidth;
        var scrollY = Y * $viewImgHeight / $imgHeight;
        $("#bigView img").css({ "left": scrollX * -1, "top": scrollY * -1 });
        $("#bigView").css({ "top": 20, "left": 468 });
        return { left: X, top: Y };
    }
});

/*view tab 滑动门*/
function show_t(id_num, maxs, num) {
    for (var i = 1; i <= maxs; i++) {
        document.getElementById("mt" + id_num + i).className = "tit_bg03";
        document.getElementById("c" + id_num + i).style.display = "none";
    }
    document.getElementById("mt" + id_num + num).className = "tit_bg02";
    document.getElementById("c" + id_num + num).style.display = "block";
}

/*view category 侧栏分类*/
function w(vd) {
    var ob = document.getElementById(vd);
    if (ob.style.display == "block" || ob.style.display == "") {
        ob.style.display = "none";
        var ob2 = document.getElementById("s" + vd);
        ob2.style.backgroundImage = "url(images/open.gif)";
    } else {
        ob.style.display = "block";
        var ob2 = document.getElementById("s" + vd);
        ob2.style.backgroundImage = "url(images/close.gif)";
    }
}

function SubNumber() {
    var n = parseInt($("#buynum").val());
    if (n > 1) {
        $("#buynum").val(n - 1);
        SetTotalMoney();
    }
}

function AddNumber() {
    var n = parseInt($("#buynum").val());
    $("#buynum").val(n + 1);
    SetTotalMoney();
}

function SetTotalMoney() {
    var nn = parseInt($("#buynum").val());
    var number1 = $("#productNum1").text();
    var number2 = $("#productNum2").length > 0 ? parseInt($("#productNum2").text()) : 0;
    var number3 = $("#productNum3").length > 0 ? parseInt($("#productNum3").text()) : 0;
    var price1 = parseFloat($("#productPrice1").text().substr(1));
    var price2 = $("#productPrice2").length > 0 ? parseFloat($("#productPrice2").text().substr(1)) : 0;
    var price3 = $("#productPrice3").length > 0 ? parseFloat($("#productPrice3").text().substr(1)) : 0;

    if (nn >= 1) {
        var total = 0;
        if (number3 > 0 && nn >= number3) {
            total = price3 * nn;
        } else if (number2 > 0 && nn >= number2) {
            total = price2 * nn;
        } else {
            total = price1 * nn;
        }
        $("#totalMoney").text(total.toFixed(2));
    }
}

function InitTotalMoney() {
    var m = parseFloat($("#productPrice1").text().substr(1));
    $("#totalMoney").text(m.toFixed(2));
}

function hideCartPoint() { $(".cart_point").hide(); }

function clickAttr(ele, conlumnId) {
    $(ele).parent().parent().find("dd").removeClass().addClass("cl1").end().end().removeClass().addClass("cl1");
    $("#hid_" + conlumnId).val($(ele).html().replace(" ", ""));    
}

function shiqu(ele) {
    var minNum = $("#hidMinNum").val();
    var maxNum = $("#hidMaxNum").val();
    var num = ele.value;
    var _unit = _productUnit;
    if (parseInt(num) < parseInt(minNum)) {
        alert("订购数量不能小于" + minNum + _unit);
        ele.value = minNum;
    }
    if (parseInt(num) > parseInt(maxNum)) {
        alert("订购数量不能大于" + maxNum + _unit);
        ele.value = maxNum;
    }
    SetTotalMoney();
}

function addToCart(pid) {
    var pn;
    var pv;
    var pp = "";
    try {
        $("#kuozhanZiduan dd[class='cl1 on']").each(function () {
            pn = $(this).parent().find("dt").text().replace("：", "").trim();
            pv = $(this).text().trim();
            if (pv === "") {
                throw "请选择" + pn + "！";
            }
            pp += pv + ",";
        });
    } catch (e) {
        alert(e);
        return;
    }

    if ($("#buynum").val() == "") {
        alert("请输入订购数量！");
        return;
    }

    var _buynum = parseInt($("#buynum").val());
    var _minNum = $("#hidMinNum").val();
    var _maxNum = $("#hidMaxNum").val();

    if (_buynum < parseInt(_minNum)) {
        alert("订购数量不能小于" + _minNum + _productUnit);
        return;
    }
    if (_buynum > parseInt(_maxNum)) {
        alert("订购数量不能大于" + _maxNum + _productUnit);
        return;
    }

    $.ajax({
        type: "POST",
        url: "/handler/carthandler.ashx?op=atc",
        dataType: "json",
        data: "pid=" + pid + "&pnum=" + _buynum + "&pparam=" + encodeURIComponent(pp),
        success: function (json) {
            if (json.State == "1") {
                $(".cartpnum").text(json.TotalNum);
                $(".cart_point").show();
            } else if (json.Error != "") {
                alert(json.Error);
            }
        }
    });
}

function buyNow(pid) {
    var pn;
    var pv;
    var pp = "";
    try {
        $("#kuozhanZiduan dd[class='cl1 on']").each(function () {
            pn = $(this).parent().find("dt").text().replace("：", "").trim();
            pv = $(this).text().trim();
            if (pv === "") {
                throw "请选择" + pn + "！";
            }
            pp += pv + ",";
        });
    } catch (e) {
        alert(e);
        return;
    }

    if ($("#buynum").val() == "") {
        alert("请输入订购数量！");
        return;
    }

    var _buynum = parseInt($("#buynum").val());
    var _minNum = $("#hidMinNum").val();
    var _maxNum = $("#hidMaxNum").val();

    if (_buynum < parseInt(_minNum)) {
        alert("订购数量不能小于" + _minNum + _productUnit);
        return;
    }
    if (_buynum > parseInt(_maxNum)) {
        alert("订购数量不能大于" + _maxNum + _productUnit);
        return;
    }

    $.ajax({
        type: "POST",
        url: "/handler/carthandler.ashx?op=atc",
        dataType: "json",
        data: "pid=" + pid + "&pnum=" + _buynum + "&pparam=" + encodeURIComponent(pp),
        success: function (json) {
            if (json.State == "1") {
                window.location = "/ordersubmit.aspx?p=" + json.CartID;
            } else if (json.Error != "") {
                alert(json.Error);
            }
        }
    });
}

//function addToCart() { $(".cart_point").show() }

function hideCartPoint() { $(".cart_point").hide() }

//统计已售或可售数量
function setSaleNum() {
    var baojiaType = $("#hidBaoJiaType").val();
    var ruleNameOne = "";
    var ruleNameTwo = "";
    var columns = $("input[id^='hid_']");
    if (columns.length > 0) {
        ruleNameOne = columns[0].value;
    }
    if (columns.length > 1) {
        ruleNameTwo = columns[1].value;
    }
    var postData = "productId=" + _productId + "&baoJiaType=1&ruleNameOne=" + ruleNameOne + "&ruleNameTwo=" + ruleNameTwo;
    $.ajax({
        type: "POST",
        url: "/Handler/SaleNumHandler.asmx/GetSaleNumAndHasSaleNum",
        data: postData,
        success: function (result) {
            if (result != null) {                
                var data = JSON.parse($(result).text());
                $("#spYiShouNum").html(data.HasSaleNum);
                $("#hidMaxNum").val(data.EableSaleNum);
                $("#eableSaleNum").html(data.EableSaleNum + "件可售");
                $("#productPrice1").html("￥" + data.SamplePrice);
                SetTotalMoney();
            }
        },
        error: function (result) {
            alert("数据加载失败");
        }
    });
}