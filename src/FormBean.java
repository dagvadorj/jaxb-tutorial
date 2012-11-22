import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	// @XmlElement
	private Person person;

	public FormBean() {
		person = new Person();
	}

	@Override
	public String toString() {
		return "Form: " + name + " -> person: " + person.toString();
	}

	public String getName() {
		return name;
	}

	public Person getPerson() {
		return person;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
