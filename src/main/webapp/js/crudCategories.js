
function loadCategory(id, name, description){
    
    var li = document.createElement('li');
    var a = document.createElement('a');
    var linkText = document.createTextNode(" [Borrar]");
    
    a.appendChild(linkText);
    
    a.onclick = function () {
        $.ajax({
            url: 'rest/categories/' + id,
            type: 'DELETE',
            dataType: "json", 
            success: function(result) {
                document.getElementById(id).remove();
            }
        });
    };

    
    li.id = id;		
    li.appendChild(document.createTextNode("Id: " + id + "	name: " + name + "	Descripcion: " + description));
    li.appendChild(a);
    
    $('#categoriesList').append(li);
}


$(document).ready(function(){
    

    $("#sendCategoryButton").click(function(){
        
        var sendInfo = {id: $('#categoryId').val(), name: $('#categoryName').val(), description: $('#categoryDescription').val()};

        $.ajax({
                url: 'rest/categories/', 
                headers: { 
                       'Accept': 'application/json',
                       'Content-Type': 'application/json' 
                   },
                type: 'POST', 
                dataType: "json", 
                success: function(result) {
                    loadCategory(result.videogame.id, result.videogame.name, result.videogame.description);
                },
                error: function(result) {
                },
                data:  JSON.stringify(sendInfo) //Datos a enviar al servidor
                
            });
        });

    
    $.ajax({
        url: 'rest/categories/',
        type: 'GET',
        dataType: "json",
        success: function(result) {
            jQuery.each(result.categories, function(i, val) {
                loadCategory(val.id, val.name, val.description);
              });
        }
    });
});