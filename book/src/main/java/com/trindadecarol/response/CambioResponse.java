package com.trindadecarol.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class CambioResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionFactor;
	private Double convertedValue;
	private String enviroment;
	
	
	public CambioResponse() {}


	public CambioResponse(Long id, String from, String to, BigDecimal conversionFactor, Double convertedValue,
			String enviroment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionFactor;
		this.convertedValue = convertedValue;
		this.enviroment = enviroment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}


	public void setConversionFactor(BigDecimal conversionFactor) {
		this.conversionFactor = conversionFactor;
	}


	public Double getConvertedValue() {
		return convertedValue;
	}


	public void setConvertedValue(Double convertedValue) {
		this.convertedValue = convertedValue;
	}


	public String getEnviroment() {
		return enviroment;
	}


	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}


	@Override
	public int hashCode() {
		return Objects.hash(conversionFactor, convertedValue, enviroment, from, id, to);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CambioResponse other = (CambioResponse) obj;
		return Objects.equals(conversionFactor, other.conversionFactor)
				&& Objects.equals(convertedValue, other.convertedValue) && Objects.equals(enviroment, other.enviroment)
				&& Objects.equals(from, other.from) && Objects.equals(id, other.id) && Objects.equals(to, other.to);
	}


	
	

}
