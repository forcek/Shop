$(function(){
	
	switch(menu){
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Buy Products':
		$('#byProducts').addClass('active');
		break;
	default :
		$('#home').addClass('active');
		break;
			
	
	}
	
}
);