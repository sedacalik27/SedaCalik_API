package pojos.gmibank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCountryPojo implements Serializable {
	private int id;
	private String name;
	private List<StatesPojo> states;

	public GetCountryPojo() {
	}
		//idli pojo çünkü get yapıyoruz
	public GetCountryPojo(int id, String name, List<StatesPojo> states) {
		this.id = id;
		this.name = name;
		this.states = states;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StatesPojo> getStates() {
		return states;
	}

	public void setStates(List<StatesPojo> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "CountryPojo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", states=" + states +
				'}';
	}
}