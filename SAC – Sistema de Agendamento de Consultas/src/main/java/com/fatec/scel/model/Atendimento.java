package com.fatec.scel.model;
import javax.persistence.*;

@Entity
public class Atendimento {
	private Long id;
	private String cpfPaciente;
	private String crmMedico;
	private String dataConsulta;
	private String horaConsulta;
	private String tipoAtendimento;

	public Atendimento() {
		
	}
	
	public Atendimento(String cpfPaciente, String crmMedico, String dataConsulta, String horaConsulta, String tipoAtendimento) {
		this.cpfPaciente = cpfPaciente;
		this.crmMedico = crmMedico;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.tipoAtendimento = tipoAtendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCrmMedico() {
		return crmMedico;
	}

	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}

	public String getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(String horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public String getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

}