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
            $('#rs0').html(data['d'][0]['s'] + ' ' + data['d'][0]['n'] + "/" + data['d'][0]['o']);
            $('#rs1').html(data['d'][1]['s'] + ' ' + data['d'][1]['n'] + "/" + data['d'][1]['o']);
        }
    });
}
