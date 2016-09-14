/**
 * Created by RuanJH on 2016/8/25.
 */
function getcorpContent(){
    var num=$("#selectcorpName").get(0).selectedIndex;
    $("#corpId").attr("value",$("#selectcorpId").find("option:eq("+num+")").text());
}
$(function(){
    $("#selectcorpId").hide();
});