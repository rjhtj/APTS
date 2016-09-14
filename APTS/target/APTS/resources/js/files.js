/**
 * Created by RuanJH on 2016/8/31.
 */
function getContent(){
    var num=$("#selectdetector").get(0).selectedIndex;
    $("#detectorId").attr("value",$("#selectdetectorId").find("option:eq("+num+")").text());
}
$(function(){
    $("#selectdetectorId").hide();
});