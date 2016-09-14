/**
 * Created by RuanJH on 2016/8/30.
 */
function delconfirm(id, role){
    if(confirm("确定要删除吗？")){
        window.location.href="/delCorporationInfo.do?id="+id+"&role="+role;
    }
}