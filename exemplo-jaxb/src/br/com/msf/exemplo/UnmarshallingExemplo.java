package br.com.msf.exemplo;

import java.io.FileInputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.msf.exemplo.bean.Livro;

public class UnmarshallingExemplo {
	
	public static void main(String[] args) throws Exception {
		Livro livro;
		UnmarshallingExemplo me;
		String xmlFileName;
		
		xmlFileName = Livro.class.getSimpleName() + ".xml";
		
		me = new UnmarshallingExemplo();
		livro = me.unmarshaller(xmlFileName);
		if (livro != null) {
			System.out.println(livro);
		}
		
	}

	public Livro unmarshaller(String xmlFileName) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		Livro livro = (Livro) unmarshaller.unmarshal(new FileInputStream(xmlFileName));

		return livro;
	}
}
