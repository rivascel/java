$(document).ready(function () {
    $("#btn_add").click(function () {
        var addRow = "<tr>";
        addRow += "<td><input type='number' name='idOrden' class='datoInput'></td>";
        addRow += "<td><input type='text' name='tipOrden' class='datoInput'></td>";
        addRow += "<td><input type='date' name='fecha' class='datoInput'></td>";
        addRow += "<td><input type='text' name='codProd' class='datoInput'></td>";
        addRow += "<td><input type='text' name='nomProd' class='datoInput'></td>";
        addRow += "<td><input type='number' name='cant' class='datoInput'></td>";
        addRow += "<td><input type='number' name='precio' class='datoInput'></td>";
        addRow += "<td style='visibility:hidden;'>${total.total}</td>";
        addRow += "<td><input type='number' name='porcDescto' class='datoInput'></td>";
        addRow += "<td><input type='number' name='porcIva' class='datoInput'></td>";
        addRow += "<td><input type='number' name='porcRteFte' class='datoInput'></td>";
        addRow += "<td style='visibility:hidden;'>${descuento.descuento}</td>";
        addRow += "<td style='visibility:hidden;'>${iva.iva}</td>";
        addRow += "<td style='visibility:hidden;'>${rteFte.rteFte}</td>";
        addRow += "<td><input type='number' name='idClientes' class='datoInput'></td>";
        addRow += "<tr/>";
        $("#bodyTablaOrden").append(addRow);
    });

    $("#btn_save").click(function () {
        var arrayInput = new Array();
        var inputsValues = document.getElementsByClassName("datoInput"),
                namesValues = [].map.call(inputsValues, function (dataInput) {
            arrayInput.push(dataInput.value);
        });
        arrayInput.forEach(function (inputsValuesData) {
            console.log("EL DATO ES :" + inputsValuesData);
        });
    });

});


