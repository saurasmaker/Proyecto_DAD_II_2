function addCategory(sendInfo){

    $.ajax({
        url: 'rest/categories/', 
        headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
        type: 'POST', 
        dataType: "json", 
        success: function(result) {
            loadCategory(
                result.category.id, result.category.name, result.category.description
            );
        },
        error: function(result) {
        },
        data:  JSON.stringify(sendInfo)
            
    });

}



function loadCategory(id, name, description){
    
    var tbody = document.getElementById('tableBodyCategories');
    var tr = document.createElement('tr'); 
    tr.id = 'tr-category-' + id; 

    var selectInput = document.getElementById('videogame-input-category');
    var option = document.createElement('option');
    option.value = id;
    option.innerHTML = name;
    selectInput.appendChild(option);

    var updateButton = document.createElement('button');
    updateButton.id = 'update-category-' + id;
    updateButton.value = 'Actualizar';
    updateButton.innerHTML = 'Actualizar';
    updateButton.classList.add('btn');
    updateButton.classList.add('btn-warning');
    updateButton.onclick = function () { updateCategory(id, name, description) };


    var deleteButton = document.createElement('button');
    deleteButton.id = 'delete-category-' + id;
    deleteButton.value = 'Eliminar';  
    deleteButton.innerHTML = 'Eliminar';
    deleteButton.classList.add('btn');
    deleteButton.classList.add('btn-danger');
    deleteButton.onclick = function () {
        $.ajax({
            url: 'rest/categories/' + id,
            type: 'DELETE',
            dataType: "json", 
            success: function(result) {
                document.getElementById('tr-category-' + id).remove();
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
    
    $("#input-send-category").click(function(){ 
        
        var sendInfo = {
            id: $('#category-input-id').val(), name: $('#category-input-name').val(), description: $('#category-input-description').val(),
        };

        addCategory(sendInfo); 
    });
    $("#input-edit-category").click(function(){
        
        var sendInfo = {
            id: $('#category-input-update-id').val(), name: $('#category-input-update-name').val(), description: $('#category-input-update-description').val(),
        };

        addCategory(sendInfo);
    
    });

    
    $.ajax({
        url: 'rest/categories/',
        type: 'GET',
        dataType: "json",
        success: function(result) {
            jQuery.each(result.categories, function(i, val) {
                loadCategory(
                    val.id, val.name, val.description
                );
            });
        }
    });
});