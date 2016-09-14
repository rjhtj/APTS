/**
 * Created by Rinchar on 2016/9/5.
 */
function compProMarDat(){
    var beginDate = $("#produceTime").val();
    var endDate = $("#marketDate").val();
    var d1 = new Date(beginDate);
    var d2 = new Date(endDate);
    if(beginDate != "" && endDate != "" && d1 >= d2){
        alert("上市时间不能早于生产时间！");
        document.getElementById("marketDate").value = "";
        return false;
    }
}
function compProLimDat(){
    var beginDate = $("#produceTime").val();
    var endDate = $("#limitDate").val();
    var d1 = new Date(beginDate);
    var d2 = new Date(endDate);
    if(beginDate != "" && endDate != "" && d1 >= d2){
        alert("过期时间不能早于生产时间！");
        document.getElementById("limitDate").value = "";
        return false;
    }
}
function compLog(){
    var beginDate = $("#logmin").val();
    var endDate = $("#logmax").val();
    var d1 = new Date(beginDate);
    var d2 = new Date(endDate);
    if(beginDate != "" && endDate != "" && d1 >= d2){
        alert("截止日期不能早于起始日期！");
        document.getElementById("logmax").value = "";
        return false;
    }
}