// JavaScript  写法：$(function(){…});   jQuery(function($) {…});  $(document).ready(function(){…})

$(
  function(){
    //水果展示的图片上移下移
    $(".index_listpic li").hover(
      function(){$(this).find("dt").stop().animate({"bottom":"18px"},100);},
      function(){$(this).find("dt").stop().animate({"bottom":"15px"},100);}
    );
    // 分类下拉列表的三角形
    $(".menu dl").hover(
      function(){$(this).addClass("on")},
      function(){$(this).removeClass("on")}
    );
    //购物车
    $(".shopping").hover(
      function(){$(this).addClass("on_shopping")},
      function(){$(this).removeClass("on_shopping")}
    );
    //点击小火箭回到最上方
    $('.toTop').click(function(){
      $('body,html').animate({    //因为点击body和html里面的元素
        scrollTop:0  //获取滚动条，最上方位置为0
      },300);
    })
    $(window).scroll(function(){  //检测滚动条所在位置，对小火箭进行隐藏和显示
      if ($(window).scrollTop()>130) {
        // $('.toTop').css('display','block');
        $('.toTop').show(100);
      }else{
        // $('.toTop').css('display','none');
        $('.toTop').hide(100);
      }
    })
  }
);