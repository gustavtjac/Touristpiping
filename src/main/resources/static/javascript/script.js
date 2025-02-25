document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector(".add-form");

    window.toggleForm = function () {
        if (form.classList.contains("show")) {
            form.classList.remove("show");
            setTimeout(() => {
                form.style.display = "none"; // Skjuler helt efter animation
            }, 400); // Samme varighed som transition i CSS
        } else {
            form.style.display = "block"; // Gør formen synlig først
            setTimeout(() => {
                form.classList.add("show");
            }, 10); // Lidt forsinkelse for at sikre animation starter
        }
    };
});
