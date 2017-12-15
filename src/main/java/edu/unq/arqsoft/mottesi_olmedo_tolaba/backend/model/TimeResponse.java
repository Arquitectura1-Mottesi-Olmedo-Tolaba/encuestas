package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.JSONDateDeserialize;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.utils.JSONDateSerialize;

public class TimeResponse {

	@JsonSerialize(using = JSONDateSerialize.class)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	private Date reservationTime;

	@JsonSerialize(using = JSONDateSerialize.class)
	@JsonDeserialize(using = JSONDateDeserialize.class)
	private Date responseTime;

	public TimeResponse(Date reservationTime, Date responseTime) {
		this.setReservationTime(reservationTime);
		this.setResponseTime(responseTime);
	}

	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}

	public Date getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}

	public Date attentionTime() {
		return new Date();
	}

}
