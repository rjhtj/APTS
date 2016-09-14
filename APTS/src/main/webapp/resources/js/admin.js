/**
 * Created by RuanJH on 2016/8/17.
 */
$(function(){
    $("#selectcorpId").hide();
});
function getContent(){
    var num=$("#selectcorpName").get(0).selectedIndex;
    $("#corpId").attr("value",$("#selectcorpId").find("option:eq("+num+")").text());
}
function delconfirm(id){
    if(confirm("确定要删除吗？")){
        window.location.href="/delAdmin.do?id="+id;
    }
}
function admin_submit(){
    var ismanager;
    if($("#selecttype").val()==0 ) {
        alert("请选择类型！")
    }
    else if($("#selectcorpName").val()==0 ){
        alert("请选择所属单位！")
    }
    else if($("#selecttype").val()==1){
        ismanager=0;
        document.getElementById("form-admin-add").setAttribute("action","/addAdmin.do?ismanager="+ismanager);
        document.getElementById("form-admin-add").submit();
    } else if($("#selecttype").val()==2){
        ismanager=1;
        document.getElementById("form-admin-add").setAttribute("action","/addAdmin.do?ismanager="+ismanager);
        document.getElementById("form-admin-add").submit();
    }

}