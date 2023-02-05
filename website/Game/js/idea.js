var app;
const Null = "undefined";
const STRING = "string";
const FUNCTION = "function";
var frames=[];
const BLACK = "#000000";
const FRAME_RATE = 60;  
document.body.style.backgroundColor  =  "#424141"//网页背景颜色
document.body.width = "100%";
document.body.height =  "100%";
document.body.style.margin = 0;
var keys = [];



/**@作用：创建应用
/@参数：width     : 宽度
       height    : 高度
*/
function createApplication(width,height){
    app = new PIXI.Application(width,height);
    app.ticker.add(animate)
    document.body.appendChild( app.view );
    return app;
}



//@作用：添加图片元素
//@参数：path ：图片路径
//       x    ：x轴坐标
//       y    ：y轴坐标
//       anchorX ： x锚点
//       anchorY ： y锚点
//       toImg   ： 添加到指定图片元素中
function addImage(path,x,y,anchorX,anchorY,toImg){
   var img
   if(typeof(path)==STRING) img = new PIXI.Sprite.fromImage(path);
   else img = new PIXI.Sprite(path); 
   img.x = typeof(x)==Null?0:x;
   img.y = typeof(y)==Null?0:y;
   img.anchor.x = typeof(anchorX)==Null?0:anchorX;
   img.anchor.y = typeof(anchorY)==Null?0:anchorY;
   if(typeof(toImg)==Null) app.stage.addChild(img);
   else toImg.addChild( img );  
   return img;
}

//@作用：添加文本元素
//@参数：content : 内容
//       color   : 颜色
//       x       ：x轴坐标
//       y       ；y轴坐标
function addText(content,color,x,y){
    var tex = new PIXI.Text( content );
    if(typeof(color)==Null) color = BLACK;
    tex.x = typeof(x)==Null?0:x;
    tex.y = typeof(y)==Null?0:y;
    tex.style.fill = color;
    app.stage.addChild( tex );
    return tex;
}

//@作用：从应用窗口中移除元素
//@参数：element ：要移除的元素
function remove( element ){
    app.stage.removeChild( element);
}

//@作用：绑定事件
//@参数：e  ：监听的元素
//      eventName ：绑定的事件名称
//      exec      ：处理事件的函数
function eventHandler(e,eventName,exec){
    e.interactive = true;
    e.on(eventName,exec);
}

//@作用：元素跟随鼠标移动
//@参数：e  ：需要跟随鼠标移动的元素
function follower(e){
    e.interactive = true;
    function advance( event ){
        var pos = event.data.getLocalPosition(app.stage);
        e.x = pos.x;
        e.y = pos.y;
    }
    e.on("pointermove",advance)
  
    
}
//@作用：移除鼠标跟随
function removeFollower( e ){
   e.removeListener("pointermove")
}


//@作用：添加帧频动画
//@参数：frame： 帧频函数
function addFrame(frame){ 
    if(typeof(frame)==Null) return;
    frames.push(frame);     
}

//@作用：移除帧频动画
//@参数：frame：帧频函数
function removeFrame(frame){
    if(typeof(frame)==Null) return;
    let index = frames.indexOf(frame);
    if(index==-1){
        for(var i =0; i<frames.length; i++){
            if(typeof(frames[i])==Null ||  typeof(frames[i])==FUNCTION)continue;
            if(frames[i].name==frame.name){
                index = i;
            }
        }
    }
    frames.splice(index,1);
}

//@作用：移除所有动画
function removeAllAnimate(){
    app.ticker.remove(animate);
}

//@作用：恢复所有动画
function recoverAnimate(){
    app.ticker.add(animate);
}

function animate(time){
    let length = frames.length;
    for(let i =0; i<length; i++){
        if(typeof(frames[i])==Null) continue;
        if(typeof(frames[i])==FUNCTION)frames[i](time);
        else frames[i].execute(time);  
    }
}

//@作用：创建定时动画
//@参数：second ：间隔（单位：秒）
//       exec   ：帧频函数
 function addTimedAnimation(second,exec){
    var ta = {};
    ta.name  = exec.name;
    ta.count = 0;
    ta.second = second;
    ta.exec = exec;
    ta.execute = t => {  
        if(ta.count%parseInt(FRAME_RATE/t*ta.second)==0){   
            ta.exec(); 
        }
        ta.count++;  
    } 
    frames.push(ta);
} 



//@作用：碰撞判断
//@参数：e1  元素1
//       e2  元素2
//       spacing： 碰撞距离
function isCollision(e1,e2,spacing){
    if(typeof(e1)==Null||typeof(e2)==Null||typeof(spacing)==Null)return false;
    if(e1.x<=0 || e1.y<=0||e2.x<=0 ||e2.y<=0)return false;
    var xl = e1.x - e2.x;
    var yl = e1.y - e2.y;
    if(Math.sqrt(xl*xl+yl*yl)<= spacing) return true;
    else return false;
}

//@作用：创建纹理
//@参数：texturePath ：纹理路径
function addTexture(texturePath){
    if(typeof(texturePath)==Null ) return;
    return new PIXI.Texture.fromImage(texturePath);
}

//@作用：创建纹理播放器
//@参数：imgs ：纹理数组
//       x    ：x轴坐标
//       y    ：y轴坐标
//       speed：播放速度
//       anchorX、anchorY ：设置锚点
//       isLoop：是否循环播放 1循环 0不循环
//       isDelete：当isLoop为0时，播放结束后自动移除播放器 1移除 0不移除
//       exce    ：当isLoop为0时，isDelete为0时，播放结束后执行exce函数

function addAnimatedSprite(imgs,x,y,speed,anchorX,anchorY,isLoop,isDelete,exce){
    if(typeof(imgs)==Null) return;
    var as = new PIXI.extras.AnimatedSprite.fromImages( imgs );
    as.x = typeof(x)==Null?0:x;
    as.y = typeof(y)==Null?0:y;
    as.anchor.x = typeof(anchorX)==Null?0:anchorX;
    as.anchor.y = typeof(anchorY)==Null?0:anchorY;
    as.loop = typeof(isLoop)==Null?1:isLoop;
    as.animationSpeed = typeof(x)==Null?1:speed;
    app.stage.addChild( as );
    as.play();
    
    if(typeof(isDelete)==Null?false:isDelete){          
        as.onComplete =  function(){
            app.stage.removeChild( as );
        }   
    }else{      
        if(typeof(exce)!=Null || typeof(exce)==FUNCTION){       
            as.onComplete = exce;
        }  
    }
    
    return as;
}


/*
    0~9（数字键）	        48~57	A~Z（字母键）	65~90
    Backspace（退格键）	    8	    Tab（制表键）	9
    Enter（回车键）	        13	    Space（空格键）	32
    Left arrow（左箭头键）	37	    Top arrow（上箭头键）	38
    Right arrow（右箭头键）	39	    Down arrow（下箭头键）	40
    

    65	A   66	B   67	C   68	D   69	E   70	F   71	G   72	H
    73	I   74	J   75	K   76	L   77	M   78	N   79	O   80	P
    81	Q   82	R   83	S   84	T   85	U   86	V   87	W   88	X
    89	Y   90	Z
*/


//@作用：绑定键盘按键事件
//@参数：keyCode：按键编码
//       pre   ： 当按键被按下时或按住时需要执行的函数
//       isLong： 是否需要处理按钮长按事件
function keyboard(keyCode,pre,isLong) {
  let key = {};
  key.code = keyCode;
  key.isDown = false;
  key.isUp = true;
  key.isLong = isLong;//是否长按
  key.press = pre;//按住
  key.release = undefined;//松开
  key.downHandler = event => {
    if (event.keyCode === key.code) {
        if (key.isUp && key.press) {
           if(isLong)addFrame(key.press) 
           else key.press();
       }
      key.isDown = true;
      key.isUp = false;
    }
    event.preventDefault();
   
  };
  key.upHandler = event => {
    if (event.keyCode === key.code) { 
        if (key.isDown && key.isLong)removeFrame(key.press) 
        if (key.isDown && key.release) key.release();
        key.isDown = false;
        key.isUp = true;
    }
    event.preventDefault();
   
  };
  
 window.addEventListener(
   "keydown", key.downHandler.bind(key), false
 );
  window.addEventListener(
    "keyup", key.upHandler.bind(key), false
  );
  return key;
}