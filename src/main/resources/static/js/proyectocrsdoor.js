/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


 
document.addEventListener("DOMContentLoaded", function () {

    const botonesEliminar = document.querySelectorAll(".btn-danger");

    botonesEliminar.forEach(function (boton) {

        boton.addEventListener("click", function (event) {

            const confirmar = confirm("Desea eliminar este registro?");

            if (!confirmar) {
               event.preventDefault();
            }

        });

    });

});