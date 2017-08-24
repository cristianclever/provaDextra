package br.com.fservice.to;

import java.io.Serializable;

public class BaseEntity implements Serializable{
	
	long id;
	
	String descricao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
