package br.com.msf.exemplo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.msf.exemplo.bean.Livro;

public class MarshallingExemplo {

	public static void main(String[] args) throws Exception {
		Livro livro;
		MarshallingExemplo me;
		String xmlFileName;
		
		livro = new Livro();

		livro.setCodigo("Arq");
		livro.setTitulo("JAXB Java");
		livro.setNomeAutor("Joao da Silva");
		livro.setValor(new BigDecimal("109.90"));
		
		xmlFileName = livro.getClass().getSimpleName() + ".xml";
		
		me = new MarshallingExemplo();
		System.out.printf("Marshalling executado com sucesso: %s", me.marshaller(livro, xmlFileName) ? "Sim": "Nao");
	}

	public boolean marshaller(Livro livro, String xmlFileName) throws Exception {

		if (livro != null) {
			
			JAXBContext context = JAXBContext.newInstance(Livro.class);
			Marshaller marshaller = context.createMarshaller();
			
			// formatando o arquivo Xml
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(livro, new FileOutputStream(xmlFileName));

			return true;
		}

		return false;
	}
}
