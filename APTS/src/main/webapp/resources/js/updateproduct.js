/**
 * Created by RuanJH on 2016/8/24.
 */
function getfertContent(){
    var num=$("#selectfertName").get(0).selectedIndex;
    $("#plantMethodfertId").attr("value",$("#selectfertId").find("option:eq("+num+")").text());
}
function getpestContent(){
    var num=$("#selectpestName").get(0).selectedIndex;
    $("#plantMethodpestId").attr("value",$("#selectpestId").find("option:eq("+num+")").text());
}
function getprocorpContent(){
    var num=$("#selectprocorpName").get(0).selectedIndex;
    $("#producercorpId").attr("value",$("#selectprocorpId").find("option:eq("+num+")").text());
}
function getstorcorpContent(){
    var num=$("#selectstorcorpName").get(0).selectedIndex;
    $("#producercorpId").attr("value",$("#selectstorcorpId").find("option:eq("+num+")").text());
}
function gettranscorpContent(){
    var num=$("#selecttranscorpName").get(0).selectedIndex;
    $("#producercorpId").attr("value",$("#selecttranscorpId").find("option:eq("+num+")").text());
}
function getdistcorpContent(){
    var num=$("#selectdistcorpName").get(0).selectedIndex;
    $("#producercorpId").attr("value",$("#selectdistcorpId").find("option:eq("+num+")").text());
}
function addWaterTime(){
    $("#waterTime").append(
        '<div class="row cl">' +
        '<label class="form-label col-2"><span class="c-red">*</span>灌溉时间：</label>' +
        '<div class="formControls col-10">' +
        '<input type="text" class="input-text" onclick="WdatePicker()" name="waterDate" required>' +
        '</div>' +
        '</div>'
    );
}
$(function(){
    $("#selectfertId").hide();
    $("#selectpestId").hide();
    $("#selectprocorpId").hide();
    $("#selectstorcorpId").hide();
    $("#selecttranscorpId").hide();
    $("#selectdistcorpId").hide();
});