//회원가입
$('#writeForm #writeBtn').click(function(){
	$('#writeForm #nameDiv').empty();
	$('#writeForm #idDiv').empty();
  	$('#writeForm #pwdDiv').empty();
  	$('#writeForm #repwdDiv').empty();

	if($('#writeForm #name').val() == '') {
		$('#writeForm #nameDiv').html('이름 입력');
		$('#writeForm #name').focus();
		
	}else if($('#writeForm #id').val()=='') {
		$('#writeForm #idDiv').html('아이디 입력');
		$('#writeForm #id').focus();
		
	}else if($('#writeForm #pwd').val()=='') {
		$('#writeForm #pwdDiv').html('비밀번호 입력');
		$('#writeForm #pwd').focus();
		
	}else if($('#writeForm #pwd').val() != $('#writeForm #repwd').val())
		$('#writeForm #repwdDiv').html('비밀번호 틀림');

	else 
		$.ajax({
			url: '/chapter06_SpringWebMaven/user/write',
			type: 'post',
			data: $('#writeForm').serialize(),
			//리턴값 없으므로 dataType 생략, success의 data 생략
			success: function(){
				alert('회원가입 등록 완료');
				location.href='';
			},
			error: function(err){
				console.log(err);
			}
		});
});

//아이디 중복체크
$('#writeForm #id').focusout(function(){
	$('#writeForm #idDiv').empty(); //초기화

	if($('#writeForm #id').val() == '')
		$('#writeForm #idDiv').html('아이디 입력하세요');
	else
		$.ajax({
			url: '/chapter06_SpringWebMaven/user/checkId',
			type: 'post',
			data: 'id=' + $('#id').val(), //서버로 보낼 파라미터 타입 {'id': $('#id').val()}
			dataType: 'text', //서버에서 받을 리턴 타입
			success: function(data){
				if(data == 'exist'){
					$('#writeForm #idDiv').text('사용 불가능');
					
				}else if(data == 'non_exist'){
					$('#writeForm #idDiv').text('사용 가능');
				}
			},
			error: function(err){
				console.log(err);
			}
		});
});


