/**
 * Created by RuanJH on 2016/8/18.
 */
function delconfirm(id){
    if(confirm("确定要删除吗？")){
        window.location.href="/delPesticide.do?id="+id;
    }
}
