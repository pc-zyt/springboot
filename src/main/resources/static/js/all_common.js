// 便于项目维护，设置basePath
var BASEPATH = "/";
// 静态资源的basePath(默认与basePath相同)
var CARDBASEPATH = BASEPATH;
// 天宫卡url路径
var TGCARD = "oa-jy/img/tianGong_A.png";
// 拥有天宫卡的标志
var TGFLAG = "oa-jy/gather.html";
// 总卡片数量
var CARDTOTALNUM = 4;


// 通用的方法
/*
 * 将url中的参数部分提取出来，存储到object中
 */
function getRequest(url) {
  var theRequest = new Object();
  url = url+"";
  if (url.indexOf("?") != -1) {
    var str = url.substr(url.indexOf("?") + 1);
    strs = str.split("&");
    for (var i = 0; i < strs.length; i++) {
      theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
    }
  }
  return theRequest;
}

/**
 * 判断手机是否是手机号
 */
function isPhoneNumber(s){ 
	 var length = s.length;  
	    if(length == 11 && /^(((13[0-9]{1})|(17[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(14[0-9]{1})|)+\d{8})$/.test(s) )  
	    {  
	        return true;  
	    }else{  
	        return false;  
	    }   
}

/**
 * 判断是否是固话
 */
function isTel(s){ 
	 var length = s.length;  
	    if(/^0\d{2,3}[-]\d{7,8}([-]\d{3})*$/.test(s) )  
	    {  
	        return true;  
	    }else{  
	        return false;  
	    }   
}