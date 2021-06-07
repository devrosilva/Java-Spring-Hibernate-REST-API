package orange.talents.restapi.challenge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;

public class FipeApi implements Serializable{
	
	private static final long serialVersionUID = 522317954451875201L;
	
	private FipeApi[] anos;
	private FipeApi[] modelos;
	
	private String nome;
	private String codigo;
	
	/*
	Variables sent by the third part API with the first letter in uppercase.
	I used @JsonAlias to avoid problems with Getters and Setters being unable to
	set properties properly
	*/
	@JsonAlias("Valor")
	private String valor;
	@JsonAlias("Marca")
	private String marca;
	@JsonAlias("Modelo")
	private String modelo;
	@JsonAlias("Combustivel")
	private String combustivel;
	@JsonAlias("CodigoFipe")
	private String codigoFipe;
	@JsonAlias("MesReferencia")
	private String mesReferencia;
	@JsonAlias("SiglaCombustivel")
	private String siglaCombustivel;
	@JsonAlias("AnoModelo")
	private Integer anoModelo;
	@JsonAlias("TipoVeiculo")
	private Integer tipoVeiculo;
	
	public FipeApi() {
		super();
	}

	public FipeApi[] getAnos() {
		return anos;
	}

	public void setAnos(FipeApi[] anos) {
		this.anos = anos;
	}

	public FipeApi[] getModelos() {
		return modelos;
	}

	public void setModelos(FipeApi[] modelos) {
		this.modelos = modelos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public Integer getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(Integer tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
}

