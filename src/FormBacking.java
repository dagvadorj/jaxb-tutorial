import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@ManagedBean
@ViewScoped
public class FormBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private FormBean formBean;

	@PostConstruct
	public void init() {
		formBean = new FormBean();
		formBean.setName("New name for form");
		Person person = new Person();
		person.setName("Bob");
		person.setAge(20);
		formBean.setPerson(person);
	}

	public void save() {

		System.out.println(formBean);

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(FormBean.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(formBean, System.out);
		} catch (JAXBException e) {
			System.out.println("Motherfucker threw exception");
			System.out.println(e);
		}

	}

	public FormBean getFormBean() {
		return formBean;
	}

	public void setFormBean(FormBean formBean) {
		this.formBean = formBean;
	}
}
