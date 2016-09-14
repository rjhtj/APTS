/**
 * Created by RuanJH on 2016/8/18.
 */
function delconfirm(id){
    if(confirm("确定要删除吗？")){
        window.location.href="/delProduct.do?id="+id;
    }
}
function getfertContent(){
    var num=$("#fertName").get(0).selectedIndex;
    $("#plantMethodfertId").attr("value",$("#fertId").find("option:eq("+num+")").text());
}
function getpestContent(){
    var num=$("#pestName").get(0).selectedIndex;
    $("#plantMethodpestId").attr("value",$("#pestId").find("option:eq("+num+")").text());
}
function getcorpContent(){
    var num=$("#corpName").get(0).selectedIndex;
    $("#producercorpId").attr("value",$("#corpId").find("option:eq("+num+")").text());
}
$(function(){
    $("#form-producer-info").hide();
    $("#form-storage-info").hide();
    $("#form-transport-info").hide();
    $("#form-distribution-info").hide();
    $("#fertId").hide();
    $("#pestId").hide();
    $("#corpId").hide();
});
function showPro(){
    if($("#form-producer-info").is(":hidden")){
        $("#form-producer-info").show();
    } else{
        $("#form-producer-info").hide();
    }
}
function showStor(){
    if($("#form-storage-info").is(":hidden")){
        $("#form-storage-info").show();
    } else{
        $("#form-storage-info").hide();
    }
}
function showTrans(){
    if($("#form-transport-info").is(":hidden")){
        $("#form-transport-info").show();
    } else{
        $("#form-transport-info").hide();
    }
}
function showDist(){
    if($("#form-distribution-info").is(":hidden")){
        $("#form-distribution-info").show();
    } else{
        $("#form-distribution-info").hide();
    }
}
function updateinfo(role,id,type){
    if(role>type){
        alert("您没有权限修改！")
    } else{
        window.location.href="/toupdateProduct.do?id="+id+"&type="+type;
        //window.open("/pages/product-update.jsp?type="+type);
    }
}

function delmulnews(){
    var str=document.getElementsByName("box");
    var objarray=str.length;
    var chestr="";
    for (i=0;i<objarray;i++)
    {
        if(str[i].checked == true)
        {
            chestr+=str[i].value+",";
        }
    }
    if(chestr!=""){
        if(confirm("确定要删除吗？")){
            window.location.href="/delmulproducts.do?dellist="+chestr;
        }
    }else{
        alert("请选择产品！")
    }
}

function addstorage(){
    var str=document.getElementsByName("box");
    var objarray=str.length;
    var chestr="";
    for (i=0;i<objarray;i++)
    {
        if(str[i].checked == true)
        {
            chestr+=str[i].value+",";
        }
    }
    if(chestr!=""){
        window.location.href="/toaddStorage.do?list="+chestr;

    }else{
        alert("请选择产品！")
    }
}

function addtransport(){
    var str=document.getElementsByName("box");
    var objarray=str.length;
    var chestr="";
    for (i=0;i<objarray;i++)
    {
        if(str[i].checked == true)
        {
            chestr+=str[i].value+",";
        }
    }
    if(chestr!=""){
        window.location.href="/toaddTransport.do?list="+chestr;

    }else{
        alert("请选择产品！")
    }
}

function adddistribution(){
    var str=document.getElementsByName("box");
    var objarray=str.length;
    var chestr="";
    for (i=0;i<objarray;i++)
    {
        if(str[i].checked == true)
        {
            chestr+=str[i].value+",";
        }
    }
    if(chestr!=""){
        window.location.href="/toaddDistribution.do?list="+chestr;

    }else{
        alert("请选择产品！")
    }
}

$("#type").bind("change", function(event) {
    var type = $("#type").val();
    getcoprs(type,"-1");
});

function getcoprs(type,value) {
    $("#corp").empty();
    var url = "/getCorporationInfobyrole.do/" + type;
    $.getJSON(url, function(data) {
        if (data.code == 0) {
            $("#corp").append('<option value="-1" title="-- 请选择 --">-- 请选择 --</option>');
            $.each(data.data, function(i,ele) {
                $("#corp").append("<option value=" + ele.corpId + ">" + ele.name + "</option>");
            });
            $("#corp").val(value);
        }
    });
}

function submitsearch(){
    if(document.getElementById("type").value==0){
        alert("请选择类别");

    }else{
/*        if(document.getElementById("logmin").value=='') {
            document.getElementById("logmin").setAttribute("value","2011-1-1");
        }
        if(document.getElementById("logmax").value=='') {
            document.getElementById("logmax").setAttribute("value","2018-1-1");
        }*/
            document.getElementById("searchbycondition").submit();
    }
}