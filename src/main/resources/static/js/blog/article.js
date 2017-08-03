/**
 * Created by xueyuan on 2017/7/16.
 */
function editArticle(recid) {
    // alert(recid);
    window.location = "/back/console.html?recid=" + recid;
}

function article(recid) {
    window.location = "/article.html?recid=" + recid;
}

function delMsg(msgid) {
    alert(msgid);
}

function msgTop(name) {
    $("#msg-area").text("回复：" + name);
}

function saveMsg(recid) {
    alert("施工中……")
    // alert(recid);
}

function filterType(keywords) {
    window.location = "/filter.html?keywords=" + keywords + "&type=type";
}

function filterTag(keywords) {
    window.location = "/filter.html?keywords=" + keywords + "&type=tag";
}

function filterTime(keywords) {
    window.location = "/filter.html?keywords=" + keywords + "&type=time";
}

