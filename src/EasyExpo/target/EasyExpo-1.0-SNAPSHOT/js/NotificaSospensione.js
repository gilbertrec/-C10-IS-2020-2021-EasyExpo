function NotificaSospension(url) {
    if (confirm("Vuoi sospendere l'utente selezionato?") == true) {
        window.location.href = url;
    }
}