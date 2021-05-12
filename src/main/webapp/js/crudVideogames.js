
function loadVideogame(id, name, description){
    
    var li = document.createElement('li');
    var a = document.createElement('a');
    var linkText = document.createTextNode(" [Borrar]");
    
    a.appendChild(linkText);
    
    a.onclick = function () {
        $.ajax({
            url: 'rest/videogames/' + id,
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
    
    $('#videogamesList').append(li);
}


$(document).ready(function(){
    

    $("#sendVideogameButton").click(function(){
        
        var sendInfo = {id: $('#videogameId').val(), name: $('#videogameName').val(), description: $('#videogameDescription').val()};

        $.ajax({
                url: 'rest/videogames/', 
                headers: { 
                       'Accept': 'application/json',
                       'Content-Type': 'application/json' 
                   },
                type: 'POST', 
                dataType: "json", 
                success: function(result) {
                    loadVideogame(result.videogame.id, result.videogame.name, result.videogame.description);
                },
                error: function(result) {
                },
                data:  JSON.stringify(sendInfo) //Datos a enviar al servidor
                
            });
        });

    
    $.ajax({
        url: 'rest/videogames/',
        type: 'GET',
        dataType: "json",
        success: function(result) {
            jQuery.each(result.videogames, function(i, val) {
                loadVideogame(val.id, val.name, val.description);
              });
        }
    });
});