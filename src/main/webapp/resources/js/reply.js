function updateviewBtn(r_num, r_content, id) {
	console.log("들어와주세요...);
	
	var commentsview = "";
	
	commentsview += '<div id="r_num' + r_num +'">';
	commentsview += '<strong>';
	commentsview += '작성자 : ' + id;
	commentsview += '</strong>&nbsp;&nbsp;&nbsp;';
	commentsview += '댓글 내용 : &nbsp;&nbsp;&nbsp;';
	commentsview +='<textarea class="form-control" id="reply_edit_content">';
	commentsview += r_content;
	commentsview += '</textarea>';
	commentsview += '</p>';
	commentsview += '<br/>';
	commentsview += <button type="button" class="btn-outline-success"';
	commentsview += 'onclick="up