package modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Vendedor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private Date aniversario;
	private Double salaroBase;
	
	private Departamento departamento;
	
	public Vendedor() {
	}

	public Vendedor(Integer id, String nome, String email, Date aniversario, Double salaroBase,
			Departamento departamento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.aniversario = aniversario;
		this.salaroBase = salaroBase;
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public Double getSalaroBase() {
		return salaroBase;
	}

	public void setSalaroBase(Double salaroBase) {
		this.salaroBase = salaroBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", aniversario=" + aniversario
				+ ", salaroBase=" + salaroBase + ", departamento=" + departamento + "]";
	}
	
}
