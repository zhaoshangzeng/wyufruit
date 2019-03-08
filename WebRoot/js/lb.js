// 轮播图片JavaScript
var i = 0;
var time;
var t;
$(document).ready(function(){
    $('.ig').eq(0).show().siblings().hide();  //显示第一张图片，同时隐藏同class的元素
    //执行定时器
    timer();
    //轮播图左右按钮
    $('.left_btn').click(function(){
      clearInterval(time); //清除定时器
      if(i==0){
        i = 4;
      }
      --i;
      show();
      timer();
    })
    $('.right_btn').click(function(){
      clearInterval(time); //清除定时器
      if(i==3){
        i = -1;
      }
      ++i;
      show();
      timer();
    })
  }
)
//定时器
function timer(){
  time = setInterval(function(){  //每2秒执行
    show();
    i++;
    if(i==4){
      i = 0;
    }
  },2000);
}
//显示的方法
function show(){
  $('.ig').eq(i).fadeIn(300).siblings().fadeOut(300); //第i个缓慢显示，其他缓慢消失
}