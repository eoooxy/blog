/**
 * Created by xueyuan on 2017/7/27.
 */
function article(id) {
    window.location = "/article.html?recid=" + id;
}

function filterType(key) {
    window.location = "/filter.html?keywords=" + key + "&type=type";
}

function filterTag(key) {
    window.location = "/filter.html?keywords=" + key + "&type=tag";
}

function filterTime(key) {
    window.location = "/filter.html?keywords=" + key + "&type=time";
}
