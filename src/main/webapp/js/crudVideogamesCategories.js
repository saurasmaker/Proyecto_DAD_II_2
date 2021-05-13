var videogameCategoryList;

function addVideogameCategory(sendInfo){

    $.ajax({
        url: 'rest/videogamescategories/', 
        headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
        type: 'POST', 
        dataType: "json", 
        success: function(result) {
            videogameCategoryList = result.videogamesCategories;
        },
        error: function(result) {
        },
        data:  JSON.stringify(sendInfo)
            
    });

}
    

$(document).ready(function(){
    
    $("#input-send-videogamecategory").click(function(){ 
        
        var sendInfo = {
            id: $('#videogamecategory-input-id').val(), videogameId: $('#videogamecategory-input-videogameid').val(), categoryId: $('#videogamecategory-input-categoryid option:selected').val(),
        };

        addVideogameCategory(sendInfo); 
    });
    
    $.ajax({
        url: 'rest/videogamescategories/',
        type: 'GET',
        dataType: "json",
        success: function(result) {
            videogameCategoryList = result.videogamesCategories;
        }
    });

});