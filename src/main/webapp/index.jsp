<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession(true).setAttribute("auth", Boolean.TRUE);
%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="HandheldFriendly" content="True">
    <title>Il Google delle Bestemmie </title>
    <meta name="generator" content="HTML Tidy for Linux/666 (vers 1 September 2005), see www.infer.no"/>
    <meta name="keywords"
          content="porcodio, diocane, bestemmie, bestemmia, google bestemmie, madonna, cristo, betlemme, kolimano, prcd, diocane, official, cristo morto, pene negro, googlebestemmie, bestemie, google bestemie, smadonner, smadonnare, smadonnamenti, bestemmier, magnotta, crocifisso, porkodio, mannaggia al bambinello, nazanegro, diofa, diofà, smoccolare, bestemmiare, imprecare, porconare, il google delle bestemmie"/>
    <meta name="description" content="IL GOOGLE DELLE BESTEMMIE, porcodio, diocane, prcd, dioboia, madonna, cristo"/>
    <meta name="author" content="a k p"/>

    <link rel="icon" href="images/favicon.ico">
    <link rel="shortcut icon" href="images/favicon.ico">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="css/sticky-footer.css" rel="stylesheet">
</head>

<body>

<div class="container text-center">
    <div class="row">
        <img src="images/logobest.jpg" class="img-responsive center-block"
             alt="Il Google delle Bestemmie"/>
        <br/>
    </div>
    <div class="row">
        <form name="f" id="f" onsubmit="return s()">
            <input id="ts" type="text" maxlength="20" placeholder="Porcodio Search" title="Che bestemmia vuoi cercare"
                   required>
            <input type="submit" class="btn btn-danger" value="Search" title="Cerca una bestemmia">
            <input id="sp" type="button" class="btn btn-danger" value="Spara!" title="Spara una bestemmia a casaccio"
                   onclick="sr()">
        </form>
        <br/>
        <img id="w" src="images/ajax-wait.gif" alt="Attendere cristo">
    </div>

    <div class="row">
        <div id="rs0"></div>
        <br/>
    </div>

    <div class="row">
        <div id="rs1"></div>
        <br/>
    </div>

</div>

<div class="footer">
    <div class="container">
        <p class="text-muted">
            <b>Disclaimer e Note sui Contenuti</b><br/>
            Ogni riferimento a fatti, persone, cose, nomi, eventi, situazioni è puramente casuale. I
            contenuti del presente sito sono interamente frutto di fantasia.<br/>
            La ricerca automatica, nonostante gli espressi divieti previsti, potrebbe portare alla
            consultazione d'informazioni dal contenuto non gradito o adatto ad un pubblico adulto, in merito
            alle quali si declina ogni responsabilità.<br/>
            L'accesso dei minori ai servizi forniti dal sito non è e non può essere controllato in alcun
            modo. L'eventuale utilizzo dei servizi da parte dei minori di 18 anni sottintende il permesso
            dei genitori o di chi ne ha la tutela assumendosi, questi ultimi, la responsabilità per ogni
            comportamento del minore relativamente all'accesso, all'utilizzo, al controllo ed agli abusi del
            servizio.</p>
    </div>
</div>

<p style="display: none">
    Kolimano nudo, Kolimano sexy pictures, kolimano is here, kolimano home page, KOLIMANO, kolimano i Love You,
    kolimano,mesk, mesk sexy pictures, mesk nudo, mesk nude
    pictures, mesk pelato, ingegnere di ivrea, mesk java, java mesk, mesk snoopy, mesk torino, mesk ivrea, mesk tcp,
    kolimano, porcodio, diocane, prcd, official porcodio, dioboia, madonna troia, cristo, cristo cane, bestemmie,
    bestemmia, google bestemmie, il google delle bestemmie, san google, dio peto, dio negro, dio martire, dio bosco
    di
    merde, dio cadavere, dio sarcofago, official porcodio, official PRCD, diorave, diocane, diorave.mod, diopene,
    dionegro, nigger maphia, dio ano banzai, dio ano bastardo, dio ANO BUCATO,
    dio ano del cosmico, dio ano del cosmo, dio ANO DEL COSMO, dio ANO del d`ano, dio ano della galassia, dio ano
    dell'inferno collegato RICORSOPORCODIOIVAMENTE all'utero della madonna, dio ano di cristo, ridotto a un torrente
    in
    piena di diarrea dopo esser stato montato da diversi caproni, bestemmie rigogliose di un certo
    dio ano di dano, dio ano di grillo, dio ano dilatato, dio ano di moebius, dio ano emorroidato, dio anoflex, dio
    cane
    PINDARICO, dio cane pisquano, dio cane più di Rex, dio cane piuttosto torno a winme, dio cane poliziotto che
    ringhia
    a dano pensando sia carico di afghano mentre non si e` solo lavato le ascelle, dio cane porco, diocane porco,
    dio
    cane porco diaccio burgher
    dio cane porco DIASPANO, dio cane porcodio, dio cane porco dio, dio CANE PORCO DIO GESU' san lisippo, DIO CANE
    PORCODIO MERDA, dio cane porco dioo, dio CANE PORCODIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO, dio cane porco dio
    porco e porco e dio, dio cane porco dio santo bastardo, dio cane porco dio zum zum zum, dio cane porco IDDIO,
    dio
    cane porco il dio iccane lurido figlio di quattro demoni e della figlia di un porcodio arrostito sulle palle del
    demonio, dio cane porco impanato, googlebestemmie, IL GOOGLE DELLE BESTEMMIE, PORCODIO
    Punx, dano, Punx nudo, dano nudo, dano nude pictures, Punx nude pictures, smoccolare, bestemmiare, imprecare,
    porconare, bardano, bardano di dano, dano bardano, banano, albero di banano, berluscone, berluscao, berluskao,
    bill
    gates porcodio, windows porcodio, scimmione, gibibbo, nigger, nigga, niggaz, niggas, heynigga, hellonigga,
    uomotalpa, uomotalpa nudo, uomotalpa gay, uomotalpa nude pictures, uomotalpa hot
    porcodio, diocane, bestemmie, bestemmia, google bestemmie, madonna, cristo, betlemme, kolimano, prcd, diocane,
    official, cristo morto, pene negro, googlebestemmie, bestemie, google bestemie, smadonner, smadonnare,
    smadonnamenti, bestemmier, magnotta, crocifisso, porkodio, mannaggia al bambinello, nazanegro, diofa, diofà,
    smoccolare, bestemmiare, imprecare, porconare
    dano dixit, ipse dixit, babbo satanale, babbo cristo, cristo in cariola, cristo bucato, mesk cesare ragazzi,
    calvizie, cura calvizie, perdita dei capelli, perdita della cappella, perdita di mesk, mesk trip to hell, dano
    hood,
    the dano hood, dano nepal, namaste, hooray ho, hora hora hora, da no hood, 50 cent in da no hood
    dano dixit, bantumi, stritolato, sardinia air lines, nigger maphia, thelirius, the lirius, the.lirius, delirius!
    iscristo del porco del quale nulla mai si butta via
</p>

<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="js/ie10-viewport-bug-workaround.js"></script>
<script src="js/gbe.js"></script>
</body>
</html>
