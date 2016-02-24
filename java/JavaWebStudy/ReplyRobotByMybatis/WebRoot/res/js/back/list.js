function post(URL, PARAMS) {        
    var temp = document.createElement('form');        
    temp.action = URL;        
    temp.method = 'post';        
    temp.style.display = 'none';        
    for (var x in PARAMS) {        
        var opt = document.createElement('textarea');        
        opt.name = x;        
        opt.value = PARAMS[x];        
        temp.appendChild(opt);        
    }        
    document.body.appendChild(temp);        
    temp.submit();        
    return temp;        
} 

$(document).ready(function() {
    $('.delete').click(function(){
        if (confirm('确定删除吗？')) {
            var deleteId = $(this).attr('id').split('_')[1];
            var command = $("[name='command']").val();
            var description = $("[name='description']").val();
            post('DeleteOne.action', {deleteId: deleteId, command: command, description: description});
        }
    });
    
    $('#delete_btn').click(function(){
        var deleteIds = '';
        $("[name='message_checkbox']:checked").each(function() {
             deleteIds += $(this).val() + ",";
        });
        if (confirm('确定删除吗？')) {
            var command = $("[name='command']").val();
            var description = $("[name='description']").val();
            post('DeleteList.action', {deleteIds: deleteIds, command: command, description: description});
        }
    });
    
    $('#select_all').click(function(){
    	if($(this).is(':checked')){ 
    		$("[name='message_checkbox']").prop("checked", true);
    	} else {
    		$("[name='message_checkbox']").removeAttr('checked');
    	}
    });
});