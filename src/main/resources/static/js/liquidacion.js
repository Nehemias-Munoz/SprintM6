//AGREGO LA URL EN UNA CONSTANTE
const url = "http://localhost:8080/api/trabajador/buscar";

$(document).ready(() => {
    let idPrevision;
    let idSalud;
    let anticipo = 0;
    let porcDctoSalud;
    let porcDctoPrevision;

    //FUNCIÓN PARA OBTENER INFO DEL TRABAJADOR
    const infoTrabajador = () => {
        //CAPTURO EL ID DEL TRABAJADOR DESDE EL SELECT
        const idTrabajador = document.getElementById("idTrabajador").value;

        //CONSUMO LA API CON EL ID DEL TRABAJADOR SELECCIONADO
        fetch(url + "/" + idTrabajador)
            .then((response) => {
                // Verifica si la respuesta fue exitosa (código de estado 200)
                if (!response.ok) {
                    throw new Error("Error en la solicitud. Código de estado: " + response.status);
                }
                return response.json();
            })
            .then((trabajador) => {
                //Crear las variables de acuerdo al trabajador seleccionado
                const descripcionSalud = trabajador.instSalud.descripcion;
                const descripcionPrevision = trabajador.instPrevision.descripcion;
                idPrevision = trabajador.instPrevision.idInstPrevision;
                idSalud = trabajador.instSalud.idInstSalud;

                //AGREGO LA AFP QUE CORRESPONDE AL TRABAJADOR EN EL FORMULARIO
                const nombreAfp = document.getElementById("instPrevision");
                const optionPrevision = document.createElement('option');
                optionPrevision.value = trabajador.instPrevision.idInstPrevision;
                optionPrevision.text = descripcionPrevision
                nombreAfp.appendChild(optionPrevision);


                //AGREGO LA INST. DE SALUD QUE CORRESPONDE AL TRABAJADOR EN EL FORMULARIO
                const selectNombreInstSalud = document.getElementById("instSalud");
                const optionSalud = document.createElement('option');
                optionSalud.value = trabajador.instSalud.idInstSalud;
                optionSalud.text = descripcionSalud
                selectNombreInstSalud.appendChild(optionSalud);

                //Definicion de porcDcto
                porcDctoSalud = trabajador.instSalud.porcDcto;
                porcDctoPrevision = trabajador.instPrevision.porcDcto;


                // Calcular los datos cuando se obtiene la información del trabajador
                // calcularDatos(trabajador);
            })
            .catch((error) => {
                console.error("Error al obtener los datos:", error);
            });
    }

    //EVENTO CHANGE PARA CAPTURAR LA INFO DEL TRABAJADOR AL MOMENTO DE SELECCIONARLO
    document.getElementById("idTrabajador").addEventListener("change", infoTrabajador);


    // Función para obtener el anticipo
    const obtenerAnticipo = () => {
        const anticipoInput = document.getElementById("anticipo");
        anticipo = parseFloat(anticipoInput.value) || 0; // Si no se ingresa valor, se considera 0 como anticipo
        // calcularDatos(); // Llamamos a calcularDatos después de obtener el anticipo para actualizar el "Total Haber"
    };

    // Evento change para capturar el anticipo al momento de ingresarlo
    // document.getElementById("anticipo").addEventListener("change", obtenerAnticipo);

    // Función para actualizar los campos ocultos y enviar el formulario
    const actualizarFormulario = () => {
        // Obtener los valores calculados
        const sueldoImponible = parseFloat(document.getElementById("sueldoImponible").value);
        const porcentajeDctoAFP = descuentoAFP(parseInt(idPrevision));
        const porcentajeDctoSalud = descuentoSalud(parseInt(idSalud));
        const dctoFinalAfp = Math.round(sueldoImponible * (porcentajeDctoAFP / 100));
        const dctoFinalSalud = Math.round(sueldoImponible * (porcentajeDctoSalud / 100));
        const totalDescuentos = dctoFinalAfp + dctoFinalSalud;
        const sueldoLiquido = sueldoImponible - totalDescuentos - anticipo;

        // Actualizar los campos ocultos con los valores calculados
        document.getElementById("idMontoSalud").value = dctoFinalSalud;
        document.getElementById("idMontoAFP").value = dctoFinalAfp;
        document.getElementById("idTotalDscts").value = totalDescuentos;
        document.getElementById("idTotalHaber").value = sueldoImponible;
        document.getElementById("idAnticipo").value = anticipo;
        document.getElementById("idSueldoLiquido").value = sueldoLiquido;

    };

    // Función para calcular los datos y actualizar los campos

    function calcularDatos() {
        let sueldoImponibleInput = document.getElementById("sueldoImponible");
        let sueldoImponible = parseFloat(sueldoImponibleInput.value);


        // Realizar los cálculos con el sueldo imponible y el porcentaje de descuento
        let dctoFinalAfp = Math.round(sueldoImponible * (porcDctoPrevision / 100));
        let dctoFinalSalud = Math.round(sueldoImponible * (porcDctoSalud / 100));

        //TOTAL DESCUENTOS
        let totalDescuentos = dctoFinalAfp + dctoFinalSalud;

        //AGREGO EL DCTO DE AFP EN EL FORMULARIO
        const inputPorcDctoPrevision = document.getElementById("montoInstPrevision");
        inputPorcDctoPrevision.value = dctoFinalAfp;

        //AGREGO EL DCTO DE SALUD EN EL FORMULARIO
        const inputPorcDsctoSalud = document.getElementById("montoInstSalud");
        inputPorcDsctoSalud.value = dctoFinalSalud;

        //AGREGO EL TOTAL DE DESCUENTOS EN EL FORMULARIO
        const inputTotalDsct = document.getElementById("totalDescuento");
        inputTotalDsct.value = totalDescuentos;

        //AGREGO EL TOTAL DE HABERES EN EL FORMULARIO
        const inputTotalHaber = document.getElementById("totalHaberes");
        inputTotalHaber.value = sueldoImponible;

        // Calcular el "Total Haber" restando los descuentos y el anticipo
        const sueldoLiquido = sueldoImponible - totalDescuentos - anticipo;

        // Actualizar el valor del input "sueldoLiquido"
        const inputSueldoLiquidoInput = document.getElementById("sueldoLiquido");
        inputSueldoLiquidoInput.value = sueldoLiquido;

        console.log("Sueldo imponible ingresado:", sueldoImponible);
        console.log("Porcentaje de descuento AFP:", porcDctoPrevision);
        console.log("Descuento AFP calculado:", dctoFinalAfp);
        console.log("Porcentaje de descuento Salud:", inputPorcDsctoSalud);
        console.log("Descuento Salud calculado:", dctoFinalSalud);
        console.log("Total Descuentos:", totalDescuentos);
        console.log("Sueldo Líquido:", sueldoLiquido);
    }

    document.getElementById("sueldoImponible").addEventListener("change", calcularDatos);
    // Evento submit para enviar el formulario
    // document.getElementById("contactForm").addEventListener("submit", (event) => {
    //     event.preventDefault();
    //     actualizarFormulario();
    // });
});