var dateFun = function (d) {
    var sp = d.initDate.split(" ");
    var spDay;
    spDay = sp[0].split("-")[2];
    var nowStr = new Date(Date.now()); //2018/2/8 下午9:38:06
    nowStr = nowStr.toLocaleString()
    console.info(nowStr);
    var nowSp = nowStr.split(" ");
    var nowDay = nowSp[0].split("/")[2];
    if (parseInt(spDay) - parseInt(nowDay) === 0) {
        return '<span style="color: #ff1b11;">' + ' 今天' + '</span>'
    } else if (parseInt(spDay) - parseInt(nowDay) === -1) {
        return '<span style="color: #ffa139;">' + ' 昨天' + '</span>'
    } else {
        return sp[0];
    }
};

function setCookie(data) {
    var expiresData = new Date();
    expiresData.setTime(expiresData.getTime() + (60 * 60 * 1000));
    $.cookie("TOTUR_TOKEN", data, {
        path: '/',
        expires: 1
    });
}

function getCookie() {
    return $.cookie('TOTUR_TOKEN')
}

