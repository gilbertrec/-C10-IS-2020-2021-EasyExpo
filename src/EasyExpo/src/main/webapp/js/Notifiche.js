function notificaSospensione(url) {
    if (confirm("Vuoi sospendere l'utente selezionato?") == true) {
        window.location.href = url;
    }
}

function notificaRiabilitazione(url) {
    if (confirm("Vuoi riabilitare l'utente selezionato?") == true) {
        window.location.href = url;
    }
}

function notificaEliminazioneProdotto(url) {
    if (confirm("Vuoi eliminare il prodotto selezionato?") == true) {
        window.location.href = url;
    }
}