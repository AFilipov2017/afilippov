<script>

	$("#valid_email").blur(function() {
	
		var email = $(this).val(); // �������� e-mail ������������
		var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;

		if(pattern.test(email)) {
		
			// ��������, ���� e-mail ���������
			
		} else {
		
			// ��������, ���� e-mail �����������
			
		}
		
	});
	
</script>
