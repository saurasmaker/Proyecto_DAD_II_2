function addVideogame(sendInfo){

    $.ajax({
        url: 'rest/videogames/', 
        headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
        type: 'POST', 
        dataType: "json", 
        success: function(result) {
            loadVideogame(
                result.videogame.id, result.videogame.name, result.videogame.description, result.videogame.releaseDate,
                result.videogame.stock, result.videogame.purchasePrice, result.videogame.rentalPrice
            );
        },
        error: function(result) {
        },
        data:  JSON.stringify(sendInfo)
            
    });

}




function loadVideogame(id, name, description, releaseDate, stock, purchasePrice, rentalPrice){
    
    var tbody = document.getElementById('tableBodyVideogames');
    var tr = document.createElement('tr'); 
    tr.id = 'tr-videogame-' + id; 


    var updateButton = document.createElement('button');
    updateButton.id = 'update-videogame-' + id;
    updateButton.value = 'Actualizar';
    updateButton.innerHTML = 'Actualizar';
    updateButton.classList.add('btn');
    updateButton.classList.add('btn-warning');
    updateButton.onclick = function () { updateVideogame(id, name, description, releaseDate, stock, purchasePrice, rentalPrice) };


    var deleteButton = document.createElement('button');
    deleteButton.id = 'delete-videogame-' + id;
    deleteButton.value = 'Eliminar';  
    deleteButton.innerHTML = 'Eliminar';
    deleteButton.classList.add('btn');
    deleteButton.classList.add('btn-danger');
    deleteButton.onclick = function () {
        $.ajax({
            url: 'rest/videogames/' + id,
            type: 'DELETE',
            dataType: "json", 
            success: function(result) {
                document.getElementById('tr-videogame-' + id).remove();
            }
        });
    };

    

    //id
    var td = document.createElement('td');
    td.innerHTML = id;
    tr.appendChild(td);

    //name
    td = document.createElement('td');
    td.innerHTML = name;
    tr.appendChild(td);

    //description
    td = document.createElement('td');
    td.innerHTML = description;
    tr.appendChild(td);

    //release date
    td = document.createElement('td');
    td.innerHTML = releaseDate;
    tr.appendChild(td);

    //stock
    td = document.createElement('td');
    td.innerHTML = stock;
    tr.appendChild(td);

    //purchase price
    td = document.createElement('td');
    td.innerHTML = parseFloat(purchasePrice).toFixed(2);
    tr.appendChild(td);

    //rental price
    td = document.createElement('td');
    td.innerHTML = parseFloat(rentalPrice).toFixed(2);
    tr.appendChild(td);

    //update
    td = document.createElement('td');
    td.appendChild(updateButton);
    tr.appendChild(td);

    //remove
    td = document.createElement('td');
    td.appendChild(deleteButton);
    tr.appendChild(td);
    
    tbody.appendChild(tr);

}


$(document).ready(function(){
    
    

    $("#input-send-videogame").click(function(){ 
        
        var sendInfo = {
            id: $('#videogame-input-id').val(), name: $('#videogame-input-name').val(), description: $('#videogame-input-description').val(),
            releaseDate: $('#videogame-input-releasedate').val(), stock: $('#videogame-input-stock').val(), purchasePrice: $('#videogame-input-purchaseprice').val(),
            rentalPrice: $('#videogame-input-rentalprice').val()
        };

        addVideogame(sendInfo); 
    });
    $("#input-edit-videogame").click(function(){
        
        var sendInfo = {
            id: $('#videogame-input-update-id').val(), name: $('#videogame-input-update-name').val(), description: $('#videogame-input-update-description').val(),
            releaseDate: $('#videogame-input-update-releasedate').val(), stock: $('#videogame-input-update-stock').val(), purchasePrice: $('#videogame-input-update-purchaseprice').val(),
            rentalPrice: $('#videogame-input-update-rentalprice').val()
        };

        addVideogame(sendInfo);
    
    });


    $.ajax({
        url: 'rest/videogames/',
        type: 'GET',
        dataType: "json",
        success: function(result) {
            jQuery.each(result.videogames, function(i, val) {
                loadVideogame(
                    val.id, val.name, val.description, val.releaseDate,
                    val.stock, val.purchasePrice, val.rentalPrice
                );
            });
        }
    });
});