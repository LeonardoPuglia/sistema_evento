package br.com.SistemaControleEvento.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void addMsgInfo(String mensagem) {
		FacesMessage facesMensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);

		FacesContext facesContexto = FacesContext.getCurrentInstance();

		facesContexto.addMessage(null, facesMensagem);
	}

	public static void addMsgError(String mensagem) {

		FacesMessage facesMensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);

		FacesContext facesContexto = FacesContext.getCurrentInstance();

		facesContexto.addMessage(null, facesMensagem);
	}

	public static String getParam(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();

		Map<String, String> parametros = externalContext.getRequestParameterMap();

		String valor = parametros.get(nome);

		return valor;
	}

	public static String converterMD5(String valor) {
		MessageDigest msg;
		try {
			msg = MessageDigest.getInstance("MD5");

			byte[] valorMD5;

			valorMD5 = msg.digest(valor.getBytes("UTF-8"));

			StringBuffer sb = new StringBuffer();

			// converter os bytes para hexadecimal
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).subSequence(1, 3));
			}

			return sb.toString();// retornar o valor em hexadecimal

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
