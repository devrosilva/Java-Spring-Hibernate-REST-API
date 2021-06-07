package orange.talents.restapi.challenge.dto;

import java.io.Serializable;

public class FipeApi implements Serializable{
	
	private static final long serialVersionUID = 522317954451875201L;
	
	private FipeApi[] anos;
	private FipeApi[] modelos;
	
	private String nome;
	private String codigo;
	
	//These variable weren't being set properly with private modifiers
	public String Valor;
	public String Marca;
	public String Modelo;
	public String Combustivel;
	public String CodigoFipe;
	public String MesReferencia;
	public String SiglaCombustivel;
	public Integer AnoModelo;
	public Integer TipoVeiculo;
	
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
		return Valor;
	}

	public void setValor(String valor) {
		Valor = valor;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(String combustivel) {
		Combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return CodigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		CodigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return MesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		MesReferencia = mesReferencia;
	}

	public String getSiglaCombustivel() {
		return SiglaCombustivel;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		SiglaCombustivel = siglaCombustivel;
	}

	public Integer getAnoModelo() {
		return AnoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		AnoModelo = anoModelo;
	}

	public Integer getTipoVeiculo() {
		return TipoVeiculo;
	}

	public void setTipoVeiculo(Integer tipoVeiculo) {
		TipoVeiculo = tipoVeiculo;
	}
}
