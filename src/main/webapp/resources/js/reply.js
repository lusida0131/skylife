// replyService : javascript의 객체이다.
//console.log("Reply Module.........");
var replyService = (function() {	// HTML 코드가 로딩이 되면 자동 실행을 위해
	/*
	function add(a, b) {		// 함수를 정의(객체의 매소드)
		var sum = a + b;
		console.log("add: " + sum);
	}
	return {
		add: add	// 변수 : 함수이름 매핑
	};
	*/
	
	function getList(param, callback, error) {
		var b_num = param.b_num;
		var page = param.page || 1;	// page=-1
		$.getJSON("/replies/pages/" + b_num + "/" + page + ".json",
			function(data) {	// data에 댓글 목록이 실려온다. List<ReplyVO> -> ReplyPageDTO
				if(callback) {
					// callback(data);	// 댓글 목록만 가져오는 경우
					callback(data.replyCnt, data.list);	// 댓글 목록만 가져오는 경우
				}
		}).fail(function(xhr, status, err) {
			if(error) {
				error();
			}
		});
	}
	
	return {
		getList: getList,
	};
})();