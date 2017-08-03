/**
 * Created by xueyuan on 2017/7/16.
 */
function addArticle() {
    window.location = "console.html";
}

function typeList() {
    window.location = "type.html?type=type";
}

function tagList() {
    window.location = "type.html?type=tag";
}

function sets() {

}

function edittype(recid, name) {
    $("#tid").attr("value", recid);
    $("#typename").val(name);
    // alert($("#tid").val());
}
function deltype(recid) {
    var type = $("#type-mark").val();
    // alert(recid);
}

function savetype() {
    var recid = $("#tid").val();
    var type = $("#type-mark").text();
    var name = $("#typename").val();
    // alert(recid);
    var data = {"recid": recid == null ? null : recid, "type": type, "name": name};
    doliao.ajax("post", "/back/type/update", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            window.location = "/back/type.html?type=" + o.data;
        }
    }, "json")
}

function articles() {
    window.location = "article.html";
}

function editArc(recid) {
    window.location = "/back/console.html?recid=" + recid;
}
function delArc(recid) {
    var data = {"recid": recid};
    doliao.ajax("post", "/back/article/del", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            window.location = "/back/article.html";
        }
    }, "json")
}

function showArc(recid) {
    var data = {"recid": recid};
    doliao.ajax("post", "/back/article/show", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            window.location = "/back/article.html";
        }
    }, "json")
}

function saveArc(recid) {
    var title = $("#article-title").val();
    var content = editor.txt.html();
    var createtime = $("#createtime").val();
    var typeIds = "";
    var tagIds = "";
    var isDraft = false;
    $("input[name='checkType']").each(function () {
        if (this.checked == true) {
            typeIds += "," + this.value;
        }
    })
    $("input[name='checkTag']").each(function () {
        if (this.checked == true) {
            tagIds += "," + this.value;
        }
    })

    var data = {
        "recid": recid == 'null' ? null : recid,
        "title": title,
        "content": content,
        "typeIds": typeIds.substr(1),
        "tagIds": tagIds.substr(1),
        "createtime": createtime,
        "isDraft": isDraft
    };
    doliao.ajax("post", "/back/article/save", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            $("#save-tip").show();
            setTimeout(function () {
                window.location = "../article.html?recid=" + o.data;
            }, 3000);
        }
    }, "json")

}

function saveDraftArc(recid) {
    var title = $("#article-title").val();
    var content = editor.txt.html();
    var createtime = $("#createtime").val();
    var typeIds = "";
    var tagIds = "";
    var isDraft = true;
    $("input[name='checkType']").each(function () {
        if (this.checked == true) {
            typeIds += "," + this.value;
        }
    })
    $("input[name='checkTag']").each(function () {
        if (this.checked == true) {
            tagIds += "," + this.value;
        }
    })

    var data = {
        "recid": recid == 'null' ? null : recid,
        "title": title,
        "content": content,
        "typeIds": typeIds.substr(1),
        "tagIds": tagIds.substr(1),
        "createtime": createtime,
        "isDraft": isDraft
    };
    doliao.ajax("post", "/back/article/save", data, function (o) {
        if (!doliao.isEmpty(o) && doliao.isEqual(o.code, 100)) {
            $("#save-tip").show();
            setTimeout(function () {
                window.location = "../article.html?recid=" + o.data;
            }, 3000);
        }
    }, "json")

}

function flushPage(page) {
    window.location = "/back/article?pageNum=" + page;
}