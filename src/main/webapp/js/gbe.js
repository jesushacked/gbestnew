var tt;

$(document).ready(function () {
    $('#w').hide();
});

$(document).ajaxStart(function () {
    $("#f :input").prop("disabled", true);
    tt = setTimeout(function () {
        $('#w').show();
    }, 666);
});

$(document).ajaxComplete(function () {
    clearTimeout(tt);
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
        headers: { j: $('#authz').val() }
    }).done(function (data) {
        if (!data || !data['d'] || !data['d'][0] || !data['d'][0]['o'] || 0 === data['d'][0]['o']) {
            $('#rs0').html('Forse cercavi <i>porcodio</i>?');
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
