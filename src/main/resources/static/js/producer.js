document.addEventListener("DOMContentLoaded", () => {
    const producerNameForm = document.getElementById("producerName");
    const countryForm = document.getElementById("country");
    const addressForm = document.getElementById("address");
    const idForm = document.getElementById("producerId");

    const modal = document.getElementById("addProducerModal");
    const addBtn = document.getElementById("addProducerButton");

    addBtn.addEventListener("click", () => {
        document.getElementById("producerForm").reset();
        modal.classList.add("show");
    });

    window.closeModal = function () {
        modal.classList.remove("show");
    }

    modal.addEventListener("click", (e) => {
        if (e.target === e.currentTarget) {
            closeModal();
        }
    });

    const editProducerButton = document.querySelectorAll(".edit-producer");
    editProducerButton.forEach(e => {
        e.addEventListener("click", (e) => {
            e.preventDefault();
            modal.classList.add("show");
            const data = e.target.closest(".table-row-description");
            const producerName = data.dataset.name;
            const producerAddress = data.dataset.address;
            const producerCountry = data.dataset.country;
            const producerId = data.dataset.id;

            idForm.value = producerId;
            producerNameForm.value = producerName;
            countryForm.value = producerCountry;
            addressForm.value = producerAddress;
        })
    })


});