package br.com.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Messages {

		public static void setMessage(String message,String tipo){
				
			Severity severidade;
			
			switch (tipo) {
			case "info":
			 	severidade = FacesMessage.SEVERITY_INFO;
				break;
			case "error":
				severidade = FacesMessage.SEVERITY_ERROR;
				break;
			case "aviso":
				severidade = FacesMessage.SEVERITY_WARN;
				break;
			default:
				severidade = FacesMessage.SEVERITY_INFO;
				break;
			}
			
			FacesContext context = FacesContext.getCurrentInstance();		
			context.addMessage(":form:msg", new FacesMessage(severidade, message, null));
		}
		
		
		
	}