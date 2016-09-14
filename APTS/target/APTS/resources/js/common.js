/**
 * Created by RuanJH on 2016/8/30.
 */
function showCorp_list(){
    if($("#corp_list").is(":hidden")){
        $("#corp_list").show();
    } else{
        $("#corp_list").hide();
    }
}
$(function(){
    $("#corp_list").hide();
});