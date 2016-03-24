function getBaseInfo(callback){
    cordova.exec(callback, null, "BaseInfo", "getBaseInfo", []);
}

function updateBaseInfo(sid, uid, token){
    cordova.exec(null, null, "BaseInfo", "updateBaseInfo", [sid, uid, token]);
}

function showStock(code, name, productType, productSubType,isLogin,isAdded,base,pym,ipList){
    cordova.exec(null, null, "StockActivity", "showStock", [code, name, productType, productSubType,isLogin,isAdded,base,pym,ipList]);
}

function signUp(base, mobile, nickname, password, activeCode, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "signUp", [base, mobile, nickname, password, activeCode]);
}

function signIn(base, name, password, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "signIn", [base, name, password]);
}

function signOut(base, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "signOut", [base]);
}

function activeCode(base, mobile, type, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "activeCode", [base, mobile, type]);
}

function forgotPassword(base, mobile, newpwd, activeCode, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "forgotPassword", [base, mobile, newpwd, activeCode]);
}

function changePassword(base, oldPswd, newPswd, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "changePassword", [base, oldPswd, newPswd]);
}

function myFavorite(base, page, pageSize, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "myFavorite", [base, page, pageSize]);
}

function addFavorite(base, docTitle, docId, docPublishTime, docCategory, docType, docURL, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "addFavorite", [base, docTitle, docId, docPublishTime, docCategory, docType, docURL]);
}

function removeFavorite(base, docid, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "removeFavorite", [base, docid]);
}

function myOptionalStockList(base, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "myOptionalStockList", [base]);
}

function addOptionalStock(base, COMPANY_CODE, COMPANY_NAME, PYM, stocktype, productsubtype, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "addOptionalStock", [base, COMPANY_CODE, COMPANY_NAME, PYM, stocktype, productsubtype]);
}

function removeOptionalStock(base, code, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "removeOptionalStock", [base, code]);
}

function getVoiceString(callback, errorback){
    cordova.exec(callback, errorback, "BaiduVoice", "getVoiceString", []);
}

function stopVoiceRecognize(){
    cordova.exec(null, null, "BaiduVoice", "stopVoiceRecognize", []);
}

function setTopColor(red, green, blue){
    cordova.exec(null, null, "TopColor", "setTopColor", [red, green, blue]);
}

function resetTopImage(){
    cordova.exec(null, null, "TopColor", "resetTopImage", []);
}

function openPdf(pdfurl, title, isLogin, docInfo){
    cordova.exec(null, null, "PdfReadPlugin", "openPdf", [pdfurl, title, isLogin, docInfo]);
}

function showShareActionSheet(title, content, image, url){
    cordova.exec(null, null, "Share", "showShareActionSheet", [title, content, image, url]);
}

function share(platform, title, content, image, url){
    cordova.exec(null, null, "Share", "share", [platform, title, content, image, url]);
}

function loadFinish(){
    cordova.exec(null, null, "WebManager", "loadFinish", []);
}

function stockDetailLoadFinish(){
    cordova.exec(null, null, "StockActivity", "stockDetailLoadFinish", []);
}

function stockDetailBack(){
    cordova.exec(null, null, "StockActivity", "stockDetailBack", []);
}

function stockLoginLoadFinish(){
    cordova.exec(null, null, "StockActivity", "stockLoginLoadFinish", []);
}

function stockLoginBack(isLogin, isAdded){
    cordova.exec(null, null, "StockActivity", "stockLoginBack", [isLogin, isAdded]);
}

function openUrl(url){
    cordova.exec(null, null, "WebView", "openUrl", [url]);
}

function closeWebView(){
    cordova.exec(null, null, "WebView", "closeWebView", []);
}

function recordError(msg){
    cordova.exec(null, null, "ExceptionHandler", "uncaughtException", [msg]);
}

function recordConnect(msg){
    cordova.exec(null, null, "ExceptionHandler", "networkException", [msg]);
}

function recordBehavior(page){
    cordova.exec(null, null, "UserBehavior", "record", [page]);
}

function scan(){
    cordova.exec(null, null, "QRCodeScan", "scan", []);
}

function getIpList(callback){
    cordova.exec(callback, null, "LaunchParams", "getIpList", []);
}

function getCleanCache(callback){
    cordova.exec(callback, null, "LaunchParams", "getCleanCache", []);
}

function encryptServerRequest(url, reqContent, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "encryptServerRequest", [url, reqContent]);
}

function serverRequest(url, reqContent, method, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "serverRequest", [url, reqContent, method]);
}

function httpRequest(url, callback, errorback){
    cordova.exec(callback, errorback, "WebService", "httpRequest", [url]);
}

function getIpListNow(callback){
    cordova.exec(callback, null, "LaunchParams", "getIpListNow", []);
}
function pdfShowLogin(){
    cordova.exec(null, null, "PdfReadPlugin", "showLogin", []);
}