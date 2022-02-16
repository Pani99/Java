$(document).ready(function(){
	$('#updateUserForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			nome: {
				container : '#infoNome',
				validators : {
					notEmpty : {
						message : 'il campo nome non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^[a-zA-Z .']{2,30}$/,
						message : 'Da 2 a 30 caratteri (Solo lettere accettate)'
					}
				}
			},
			
		cognome: {
			container : '#infoCognome',
				validators : {
					notEmpty : {
						message : 'il campo cognome non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^[a-zA-Z .']{2,30}$/,
						message : 'Da 2 a 30 caratteri (Solo lettere accettate)'
					}
				}
			},
			
		indirizzo: {
			container : '#infoIndirizzo',
				validators : {
					notEmpty : {
						message : 'il campo indirizzo non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^[a-zA-Z ,.']+[0-9]{1,4}$/,
						message : 'Inserire indirizzo con numero civico'
					}
				}
			},
		cap: {
			container : '#infoCap',
				validators : {
					notEmpty : {
						message : 'il campo cap non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : 'Il CAP &egrave; composto da 5 cifre e contiene solo numeri.'
					}
				}
			},
		nascita: {
			container : '#infoNascita',
				validators : {
					notEmpty : {
						message : 'il campo nascita non pu&ograve; essere vuoto.'
					},
					regexp : {
						format : 'DD/MM/YYYY',
						regexp : /^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)(?:0?2|(?:Feb))\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$/,
						message : 'La data di nascita deve contenere solo numeri.'
					}
				}
			},	
		password: {
			container : '#infoPassword',
				validators : {
					notEmpty : {
						message : 'il campo password non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{5,20}$/,
						message : 'La password deve contenere almeno una lettera minuscola, una lettera Maiuscola, un carattere speciale, un numero e la sua lunghezza deve andare dai 5 ai 20 caratteri massimo'
					}
				}
			},
		email: {
			container : '#infoEmail',
				validators : {
					notEmpty : {
						message : 'il campo email non pu&ograve; essere vuoto.'
					},
					regexp : {
						regexp : /^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$/,
						message : 'La mail che hai inserito non &egrave; valida.'
					}
				}
			}
		}	
	});
});