window.addEventListener('load', init);

function init() {
    btn1 = document.querySelector('#addbutton');
    btn1.addEventListener('click', addBtn1Click);
    btn2 = document.querySelector('#getbutton');
    btn2.addEventListener('click', addBtn2Click);
    btn3 = document.querySelector('#getallbutton');
    btn3.addEventListener('click', addBtn3Click);
}
function addBtn1Click(){
	
	 $(".comment").remove();
		
	
	
	var comment_container=document.createElement('div');
	var form=document.createElement("form");
	var comment_box=document.createElement('div');
	var comment_area=document.createElement('textarea');
	var email_container=document.createElement('div');
	var email=document.createElement('input');
	var submit_container=document.createElement('div');
	var submit=document.createElement('input');
	
	form.setAttribute('action','webapi/comment/addcomment');
	form.setAttribute('method','post');
	comment_area.setAttribute('rows','4');
	comment_area.setAttribute('cols','50');
	comment_area.setAttribute('name','comment');
	comment_area.setAttribute('placeholder','Add your comment');
	email.setAttribute('type','email');
	email.setAttribute('name','email');
	email.setAttribute('placeholder','Enter Your Email');
	submit.setAttribute('type','submit');
	submit.setAttribute('value','ok');
	
	form.appendChild(comment_box);
	comment_box.appendChild(comment_area);
	form.appendChild(email_container);
	email_container.appendChild(email);
	form.appendChild(submit_container);
	submit_container.appendChild(submit);
	comment_container.appendChild(form);
	main.appendChild(comment_container);
}
function addBtn2Click(){
	

	

}

