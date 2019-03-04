<script>

	$("#valid_email").blur(function() {
	
		var email = $(this).val(); // Получаем e-mail пользователя
		var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;

		if(pattern.test(email)) {
		
			// Действие, если e-mail корректен
			
		} else {
		
			// Действие, если e-mail некорректен
			
		}
		
	});
	
</script>
