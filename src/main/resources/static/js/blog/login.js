/**
 * Created by xueyuan on 2017/7/13.
 */

$(function () {
    $("#username").focus();
});

function login() {
    var data = {"username": $("#username").val(), "password": $("#password").val()};

    doliao.ajax("post", "/loginin", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            if (doliao.isEqual(o.data, 'master')) {
                window.location = "/back/console.html";
            }else {
                //登录的框隐藏
            }
            // alert(msg.title);
        } else {
            alert(o.msg);
        }
    }, "json");
}


function key_login() {
    if (event.keyCode == "13") {//keyCode=13是回车键
        $("#btn-login").click();
    }
}
