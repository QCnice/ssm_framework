/**
 * 解析URL
 * @param url
 * @returns {Object}
 */
function parseUrl(url){
    if(url.indexOf("?")){
        url = url.substring(url.indexOf("?")+1);
        var param = url.split("&");
        var obj = new Object();
        for(var i = 0; i < param.length; i++){
            var keyValue = param[i].split("=");
            var key = keyValue[0];
            var value = keyValue[1];
            obj[key] = value;
        }
        return obj;
    }
}