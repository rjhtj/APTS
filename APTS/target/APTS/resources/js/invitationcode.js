/**
 * Created by RuanJH on 2016/8/27.
 */
function delconfirm(id){
    if(confirm("确定要删除吗？")){
        window.location.href="/delInvitationcode.do?id="+id;
    }
}
function invitation_submit(){
    var type;
    if($("#selecttype").val()==0 ){
        alert("请选择类型！")
    }
    else if($("#selecttype").val()==1){
        type=1;
        document.getElementById("form-invitationcode-add").setAttribute("action","/addInvitationcode.do?type="+type);
        document.getElementById("form-invitationcode-add").submit();
    } else if($("#selecttype").val()==2){
        type=0;
        document.getElementById("form-invitationcode-add").setAttribute("action","/addInvitationcode.do?type="+type);
        document.getElementById("form-invitationcode-add").submit();
    }
}
function getContent(){
    var num=$("#selectcorpName").get(0).selectedIndex;
    $("#corpId").attr("value",$("#selectId").find("option:eq("+num+")").text());
}
$(function(){
    $("#selectId").hide();
});