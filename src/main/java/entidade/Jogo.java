/*
	 a) [1,0 pt] Criar uma classe chamada Jogo que deve possuir um id 
	(tipo Integer), uma variável chamada descricao (tipo String), 
	uma variável chamada dataCriacao (tipo Date) e mais dez variáveis do 
	tipo Integer (v1 até v10), com seus respectivos gets e sets. 
	
	 b) [1,0 pt] A classe criada no item “a” deve usar pelo menos
	  as seguintes Annotations: @Entity, @Column, @Temporal, @Id, e @GeneratedValue.
 */

package entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Jogo {

	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_de_criacao")
	private Date dataDeCriacao = new Date();
	private Integer v1;
	private Integer v2;
	private Integer v3;
	private Integer v4;
	private Integer v5;
	private Integer v6;
	private Integer v7;
	private Integer v8;
	private Integer v9;
	private Integer v10;
	@Transient
	private String pares;

	public void gerarNumerosAleatorios() {
		Random rd = new Random();

		v1 = rd.nextInt(30) + 1;
		v2 = rd.nextInt(30) + 1;
		v3 = rd.nextInt(30) + 1;
		v4 = rd.nextInt(30) + 1;
		v5 = rd.nextInt(30) + 1;
		v6 = rd.nextInt(30) + 1;
		v7 = rd.nextInt(30) + 1;
		v8 = rd.nextInt(30) + 1;
		v9 = rd.nextInt(30) + 1;
		v10 = rd.nextInt(30) + 1;

	}

	public void obterOsPares() {
		List<Integer> lista = new ArrayList<Integer>();
		Integer[] numeros = { v1, v2, v3, v4, v5, v6, v7, v8, v9, v10 };
		String pares = "";

		for (Integer n : numeros) {
			if (n % 2 == 0) {
				lista.add(n);
			}
		}

		for (Integer l : lista) {
			pares += l + ", ";
		}

		this.pares = pares;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getV1() {
		return v1;
	}

	public void setV1(Integer v1) {
		this.v1 = v1;
	}

	public Integer getV2() {
		return v2;
	}

	public void setV2(Integer v2) {
		this.v2 = v2;
	}

	public Integer getV3() {
		return v3;
	}

	public void setV3(Integer v3) {
		this.v3 = v3;
	}

	public Integer getV4() {
		return v4;
	}

	public void setV4(Integer v4) {
		this.v4 = v4;
	}

	public Integer getV5() {
		return v5;
	}

	public void setV5(Integer v5) {
		this.v5 = v5;
	}

	public Integer getV6() {
		return v6;
	}

	public void setV6(Integer v6) {
		this.v6 = v6;
	}

	public Integer getV7() {
		return v7;
	}

	public void setV7(Integer v7) {
		this.v7 = v7;
	}

	public Integer getV8() {
		return v8;
	}

	public void setV8(Integer v8) {
		this.v8 = v8;
	}

	public Integer getV9() {
		return v9;
	}

	public void setV9(Integer v9) {
		this.v9 = v9;
	}

	public Integer getV10() {
		return v10;
	}

	public void setV10(Integer v10) {
		this.v10 = v10;
	}

	public String getPares() {

		return pares;
	}

	public void setPares(String pares) {
		this.pares = pares;
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
		Jogo other = (Jogo) obj;
		return Objects.equals(id, other.id);
	}

}
