var tt, tt2;

$(document).ready(function () {
    $('#w').hide();
});

$(document).ajaxStart(function () {
    $("#f :input").prop("disabled", true);
    tt = setTimeout(function () {
        $('#w').show();
    }, 600);

    tt2 = setTimeout(function () {
        window.top.location.reload(true);
    }, 6000);
});

$(document).ajaxComplete(function (event, xhr, settings) {
    clearTimeout(tt);
    clearTimeout(tt2);
    $('#w').hide();
    $("#f :input").prop("disabled", false);
});

function s() {
    ss($('#ts').val());
    return false;
}

function sr() {
    ss('');
}

function ss(st) {
    $.ajax({
        type: 'POST',
        url: 'q.nrk',
        dataType: 'json',
        data: { q: st },
        headers: { j: '19238183766162' }
    }).done(function (data) {
        if (!data || !data['d'] || !data['d'][0] || !data['d'][0]['o'] || 0 === data['d'][0]['o']) {
            $('#rs0').html('Forse cercavi porcodio?');
            $('#rs1').html('');
        } else {
            $('#rs0').html(data['d'][0]['s'] + ' (' + (1 + data['d'][0]['n']) + "/" + data['d'][0]['o'] + ')');
            if (data['d'][0]['s'] === data['d'][1]['s']) {
                $('#rs1').html('');
            } else {
                $('#rs1').html(data['d'][1]['s'] + ' (' + (1 + data['d'][1]['n']) + "/" + data['d'][1]['o'] + ')');
            }
        }
    });
}
